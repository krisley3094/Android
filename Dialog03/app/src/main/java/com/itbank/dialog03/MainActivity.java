package com.itbank.dialog03;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //이벤트 처리 메소드
    public void chooseColor(View view){
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, R.layout.support_simple_spinner_dropdown_item);
        adapter.add("빨강");
        adapter.add("주황");
        adapter.add("노랑");
        adapter.add("초록");
        adapter.add("파랑");
        adapter.add("남색");
        adapter.add("보라");


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(getApplicationContext(), "i = "+i, Toast.LENGTH_SHORT).show();
                String data = adapter.getItem(i);
                TextView colorResult = (TextView)findViewById(R.id.colorResult);
                colorResult.setText("선택한 색상 = "+data);
            }
        });

        builder.create().show();


    }
}






