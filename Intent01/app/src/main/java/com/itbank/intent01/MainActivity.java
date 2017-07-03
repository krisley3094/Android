package com.itbank.intent01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //전화를 거는 화면으로 이동시키는 메소드
    public void call(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    public void emergency(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:119"));
        startActivity(intent);
    }

    public void browser(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.google.com"));
        startActivity(intent);
    }

    public void map(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:37.5555,127.5555"));
        startActivity(intent);
    }

    public void searchMap(View view){
        TextView search = (TextView)findViewById(R.id.search);
        String key = search.getText().toString();
        //key에 들어있는 공백(띄어쓰기)을 +로 변경한 뒤 설정해주어야 한다
        key = key.replace(" ","+");

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q="+key));
        startActivity(intent);
    }

    public void checkWifi(View view){
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_WIFI_SETTINGS);
        startActivity(intent);
    }

    public void myPermission(View view){
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
    }
}









