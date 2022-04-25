package com.example.number_guessing_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txv_text2;
    Button btn_btn1,btn_btn2;
    EditText edt_edit1;
    int guess;
    int random;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        generateRandomNumber();
        guessingValue();
    }


    private void guessingValue() {
        btn_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (random!=guess){
                    guess=Integer.valueOf(edt_edit1.getText().toString().trim());
                    count++;
                    validation();
                }
            }
        });
    }

    private boolean validation() {
        if (guess>random){
            Toast.makeText(MainActivity.this,"Lower Number Please",Toast.LENGTH_LONG).show();
            return false;
        }else if(guess<random){
            Toast.makeText(MainActivity.this,"Higher Number Please",Toast.LENGTH_LONG).show();
            return false;
        }else {
            btn_btn1.setVisibility(View.GONE);
            txv_text2.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this,"Correct !! You got it in  "+ count +"guesses!",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(MainActivity.this,result_page.class);
            intent.putExtra("result",count);
            return true;

        }
    }

    private void generateRandomNumber() {
        btn_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random=(int) (Math.random()*100)+1;
                txv_text2.setText(String.valueOf(random));
                Toast.makeText(MainActivity.this,"Random number generated !! now guess bellow",Toast.LENGTH_LONG).show();
            }
        });
    }


    private void findId() {
        txv_text2=findViewById(R.id.txv_text2);
        btn_btn1=findViewById(R.id.btn_btn1);
        btn_btn2=findViewById(R.id.btn_btn2);
        edt_edit1=findViewById(R.id.edt_edit1);
    }
}