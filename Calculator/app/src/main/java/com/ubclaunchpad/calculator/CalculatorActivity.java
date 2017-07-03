package com.ubclaunchpad.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Double.parseDouble;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String TAG = CalculatorActivity.class.getSimpleName();

    private EditText firstInput;
    private EditText secondInput;
    private Button operation_add;
    private Button operation_sub;
    private Button operation_multi;
    private Button operation_div;

    //private double result = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        firstInput = (EditText)findViewById(R.id.firstInput);
        secondInput = (EditText)findViewById(R.id.secondInput);
        operation_add = (Button)findViewById(R.id.operation_add);
        operation_sub = (Button)findViewById(R.id.operation_sub);
        operation_multi = (Button)findViewById(R.id.operation_multi);
        operation_div = (Button)findViewById(R.id.operation_div);

        operation_add.setOnClickListener(this);
        operation_sub.setOnClickListener(this);
        operation_multi.setOnClickListener(this);
        operation_div.setOnClickListener(this);


    }

    /**
     * This implementation of the click listener is for the view found in res/layout/activity_calculator
     * The functions in general should grab the appropriate inputs, and if they are valid, computes the answer.
     * The answer should be displayed in a second activity labelled "AnswerActivity"
     * @param v
     */

    /*Intent intent = new Intent(getBaseContext(), SignoutActivity.class);
    intent.putExtra("EXTRA_SESSION_ID", sessionId);
    startActivity(intent);
    Access that intent on next activity

    String s = getIntent().getStringExtra("EXTRA_SESSION_ID");
    */


    @Override
    public void onClick(View v) {

        //Toast.makeText(getApplicationContext(),"onclick",Toast.LENGTH_SHORT).show();
        switch (v.getId())
        {
            case R.id.operation_add:
            {

                double inputFirst = parseDouble(firstInput.getText().toString());
                double inputSecond = parseDouble(secondInput.getText().toString());
                double result = inputFirst + inputSecond; // Adds the first and second inputs and stores the result

                Intent intent = new Intent(CalculatorActivity.this, AnswerActivity.class);  // Create intent for AnswerActivity.class

                Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();

                intent.putExtra("Answer", String.valueOf(result));      // Passes the result data to the intent
                intent.putExtra("First", String.valueOf(inputFirst)+" + ");   // Passes the first operand to the intent
                intent.putExtra("Second", String.valueOf(inputSecond)); // Passes the second operand to the intent
                startActivity(intent);  // Starts the AnswerActivity.class

                break;
            }
            case R.id.operation_sub:
            {
                double inputFirst = parseDouble(firstInput.getText().toString());
                double inputSecond = parseDouble(secondInput.getText().toString());
                double result = inputFirst - inputSecond; // Adds the first and second inputs and stores the result

                Intent intent = new Intent(CalculatorActivity.this, AnswerActivity.class);  // Create intent for AnswerActivity.class

                Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();

                intent.putExtra("Answer", String.valueOf(result));      // Passes the result data to the intent
                intent.putExtra("First", String.valueOf(inputFirst)+" - ");   // Passes the first operand to the intent
                intent.putExtra("Second", String.valueOf(inputSecond)); // Passes the second operand to the intent
                startActivity(intent);  // Starts the AnswerActivity.class

                break;
            }
            case R.id.operation_multi:
            {
                double inputFirst = parseDouble(firstInput.getText().toString());
                double inputSecond = parseDouble(secondInput.getText().toString());
                double result = inputFirst * inputSecond; // Adds the first and second inputs and stores the result

                Intent intent = new Intent(CalculatorActivity.this, AnswerActivity.class);  // Create intent for AnswerActivity.class

                Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();

                intent.putExtra("Answer", String.valueOf(result));      // Passes the result data to the intent
                intent.putExtra("First", String.valueOf(inputFirst)+" * ");   // Passes the first operand to the intent
                intent.putExtra("Second", String.valueOf(inputSecond)); // Passes the second operand to the intent
                startActivity(intent);  // Starts the AnswerActivity.class

                break;
            }
            case R.id.operation_div:
            {
                double inputFirst = parseDouble(firstInput.getText().toString());
                double inputSecond = parseDouble(secondInput.getText().toString());

                if(inputSecond == 0){
                    Toast.makeText(getApplicationContext(), "Error : Inappropriate Value", Toast.LENGTH_SHORT).show();
                    break;
                }

                double result = inputFirst / inputSecond; // Adds the first and second inputs and stores the result

                Intent intent = new Intent(CalculatorActivity.this, AnswerActivity.class);  // Create intent for AnswerActivity.class

                Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();

                intent.putExtra("Answer", String.valueOf(result));      // Passes the result data to the intent
                intent.putExtra("First", String.valueOf(inputFirst)+" ÷ ");   // Passes the first operand to the intent
                intent.putExtra("Second", String.valueOf(inputSecond)); // Passes the second operand to the intent
                startActivity(intent);  // Starts the AnswerActivity.class

                break;
            }
            //TODO any extra implmentations (optional)
            default:
            {
                Toast.makeText(this, "Click not implmented yet", Toast.LENGTH_LONG).show();
                Log.e(TAG, "View id: " + v.getId() + " click not implemented yet");
                break;
            }
        }
    }
}
