package com.ubclaunchpad.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Intent receiveData = AnswerActivity.this.getIntent();

        String result = receiveData.getStringExtra("Answer");
        String firstInput = receiveData.getStringExtra("First");
        String secondInput = receiveData.getStringExtra("Second");

        TextView answer = (TextView)findViewById(R.id.answer);
        TextView process = (TextView)findViewById(R.id.process);

        answer.setText(result);
        process.setText("= "+ firstInput + secondInput);

    }

}
