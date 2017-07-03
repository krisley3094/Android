package com.itbank.intent03;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (ImageView)findViewById(R.id.result);
        if(checkSelfPermission(Manifest.permission.CAMERA)
                                == PackageManager.PERMISSION_DENIED){
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 9999);

        }
    }

    public void photo(View view){
        if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
            return;
        }

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 9999);

//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//        intent.setType("image/*");
//        startActivityForResult(Intent.createChooser(intent, "선택"), 9999);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //이미지 꺼내는 코드
        Bundle bundle = data.getExtras();
        Bitmap image = (Bitmap)bundle.get("data");
        image = rotateImage(image, 90);
        result.setImageBitmap(image);
    }

    //이미지 회전 메소드
    private Bitmap rotateImage(Bitmap bitmap, float angle){
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        Bitmap nBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return nBitmap;
    }
}










