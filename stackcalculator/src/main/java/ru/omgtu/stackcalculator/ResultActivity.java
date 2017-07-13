package ru.omgtu.stackcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity
{

    TextView txt_Result;
    Button btn_Back;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txt_Result = (TextView) findViewById(R.id.txt_Result);
        btn_Back = (Button) findViewById(R.id.btn_Back);

        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        txt_Result.setText(result);

        btn_Back.setOnClickListener(OCL_btn_Back);
    }
    View.OnClickListener OCL_btn_Back = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };

}
