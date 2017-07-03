package com.itbank.intent02;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);

        //현재의 승인 여부를 확인해보자......
        int check = checkSelfPermission(Manifest.permission.CALL_PHONE);
        //사용자에게 권한 요청을 설명할 필요가 있는지 검사(거절한 적이 있는가 검사)
        boolean should = shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE);

        String text = "checkSelfPermission() 결과 = "+check+"\n";
        text += "승인 상태일 경우의 값 = "+ PackageManager.PERMISSION_GRANTED+"\n";
        text += "거절 상태일 경우의 값 = "+ PackageManager.PERMISSION_DENIED+"\n";
        text += "shouldShow~~~() 결과 = "+should+"\n";
        result.setText(text);


        //6.0 이후의 권한 요청 코드
        if(check != PackageManager.PERMISSION_GRANTED){
            if(should){
                //권한에 대해서 요청할 방법이 없기 때문에 안내창을 띄워 설정페이지로 이동
            }
            else {
                requestPermissions(new String[]{
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 9876);
            }
        }
    }

    //사용자가 권한을 승인했는지 거절했는지 알 수 있는 결과 메소드(재정의)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //request : 요청 보낼때 적은 번호
        //permissions : 요청을 보낸 권한
        //grantResults : 허가된 권한의 정보

        if(grantResults.length > 0){
            StringBuffer buffer = new StringBuffer();
            for(int i=0; i<grantResults.length; i++){
                buffer.append(permissions[i]+" 처리 결과 : "+grantResults[i]+"\n");
            }
            result.append(buffer.toString());
        }

        //최종적으로 거절된 권한이 있다면 이름들을 모아서 사용자에게 알려주고, 설정하도록 이동
        if(grantResults.length > 0){
            StringBuffer buffer = new StringBuffer();
            int count = 0;
            for(int i=0; i<grantResults.length; i++){
                if(grantResults[i] == PackageManager.PERMISSION_DENIED){
                    buffer.append(permissions[i]+"\n");
                    count++;
                }
            }

            //거절된 권한이 한개도 없다면 여기까지만 실행하고 종료하라
            if(count == 0) return;

            buffer.append("앱을 이용하려면 위의 권한이 필수적으로 필요합니다.\n");
            buffer.append("설정으로 이동하셔서 권한을 직접 허락해 주십시오");

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("권한 허용 안내");
            builder.setMessage(buffer.toString());
            builder.setCancelable(false);
            builder.setPositiveButton("이동", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                }
            });
            builder.create().show();
        }


    }

    public void call(View view){
        try{
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:01036869564"));
            startActivity(intent);
        }catch(SecurityException e){
            Toast.makeText(getApplicationContext(), "전화 걸기 오류", Toast.LENGTH_SHORT).show();
            e.printStackTrace();//오류 추적 로그
        }
    }
}









