package com.itbank.broadcastreceiver03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view){
        EditText input = (EditText)findViewById(R.id.input);

        Intent intent = new Intent("com.itbank.broadcast.MESSAGE");
        intent.putExtra("text", input.getText().toString());
        sendBroadcast(intent);
    }
}
