package com.itbank.activity03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ObjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);

        Intent receive = getIntent();
        Car c = (Car)receive.getSerializableExtra("car");

        TextView result = (TextView)findViewById(R.id.result);
        result.setText(c.toString());
    }
}
