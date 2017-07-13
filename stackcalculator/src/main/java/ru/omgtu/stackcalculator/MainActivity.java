package ru.omgtu.stackcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_plus;
    Button btn_minus;
    Button btn_multiplay;
    Button btn_divide;
    Button btn_equal;
    Button btn_point;
    Button btn_clearBack;
    Button btn_clearAll;

    double firstArgument;
    double secondArgument;
    double answer;

    int arithmeticExpression;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.txt_text);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiplay = (Button) findViewById(R.id.btn_multiplay);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_clearBack = (Button) findViewById(R.id.btn_clearBack);
        btn_clearAll = (Button) findViewById(R.id.btn_clearAll);


        View.OnClickListener OCL_btn_number = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                switch (view.getId())
                {
                    case R.id.btn_0 : text.setText(text.getText() + "0");break;
                    case R.id.btn_1 : text.setText(text.getText() + "1");break;
                    case R.id.btn_2 : text.setText(text.getText() + "2");break;
                    case R.id.btn_3 : text.setText(text.getText() + "3");break;
                    case R.id.btn_4 : text.setText(text.getText() + "4");break;
                    case R.id.btn_5 : text.setText(text.getText() + "5");break;
                    case R.id.btn_6 : text.setText(text.getText() + "6");break;
                    case R.id.btn_7 : text.setText(text.getText() + "7");break;
                    case R.id.btn_8 : text.setText(text.getText() + "8");break;
                    case R.id.btn_9 : text.setText(text.getText() + "9");break;
                }
            }
        };

        View.OnClickListener OCL_btn_operation = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(text.getText()=="")
                {
                    text.setText("0");

                }
                    firstArgument = Double.parseDouble((String) text.getText());
                    text.setText("");
                    arithmeticExpression = view.getId();
            }
        };

        View.OnClickListener OCL_btn_calculate = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(text.getText()=="")
                {
                   secondArgument = 0;
                }
                else
                {
                    secondArgument = Double.parseDouble((String) text.getText());
                }

                switch (arithmeticExpression)
                {
                    case R.id.btn_plus: answer = firstArgument + secondArgument;break;
                    case R.id.btn_minus: answer = firstArgument - secondArgument;break;
                    case R.id.btn_multiplay: answer = firstArgument * secondArgument;break;
                    case R.id.btn_divide:
                        if (secondArgument == 0)
                        {
                            Toast.makeText(getApplicationContext(),"Деление на 0", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        answer = firstArgument / secondArgument;break;
                    default: answer = 0;break;
                }
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("result",""+answer);
                startActivity(intent);
                //text.setText("" + answer);
            }
        };

        View.OnClickListener OCL_btn_clearLast = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(text.length()>1)
                {
                    String buf = (String) text.getText();
                    buf = buf.substring(0, buf.length() - 1);
                    text.setText(buf);
                }
                else text.setText("");
            }
        };

        View.OnClickListener OCL_btn_clearALL = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                text.setText("");
                firstArgument = 0;
                secondArgument = 0;
            }
        };

        View.OnClickListener OCL_btn_point = new View.OnClickListener()
        {
            @Override

            public void onClick(View view)
            {
                double forcheck;
                try
                {
                    text.setText(text.getText()+".");
                    forcheck = Double.parseDouble((String)text.getText());
                }
                catch (Exception exc)
                {
                    //ErrorSeconPoint
                    String buf = (String) text.getText();
                    buf = buf.substring(0, buf.length() - 1);
                    text.setText(buf);
                }


            }
        };

        btn_0.setOnClickListener(OCL_btn_number);
        btn_1.setOnClickListener(OCL_btn_number);
        btn_2.setOnClickListener(OCL_btn_number);
        btn_3.setOnClickListener(OCL_btn_number);
        btn_4.setOnClickListener(OCL_btn_number);
        btn_5.setOnClickListener(OCL_btn_number);
        btn_6.setOnClickListener(OCL_btn_number);
        btn_7.setOnClickListener(OCL_btn_number);
        btn_8.setOnClickListener(OCL_btn_number);
        btn_9.setOnClickListener(OCL_btn_number);

        btn_plus.setOnClickListener(OCL_btn_operation);
        btn_minus.setOnClickListener(OCL_btn_operation);
        btn_multiplay.setOnClickListener(OCL_btn_operation);
        btn_divide.setOnClickListener(OCL_btn_operation);

        btn_equal.setOnClickListener(OCL_btn_calculate);

        btn_clearBack.setOnClickListener(OCL_btn_clearLast);
        btn_clearAll.setOnClickListener(OCL_btn_clearALL);

        btn_point.setOnClickListener(OCL_btn_point);
    }
}
