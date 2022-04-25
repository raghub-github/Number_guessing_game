package com.example.number_guessing_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class result_page extends AppCompatActivity {
    TextView txt_result;
    Button btn_submit;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        findId();
        Bundle bundle = null; getIntent().getExtras();
        if (bundle!=null){
            result=bundle.getInt("result");
            txt_result.setText(String.valueOf("you got the result in "+result+ "guesses"));

        }
        btn_submit.setOnClickListener(v -> {
            Intent intent=new Intent(result_page.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void findId() {
        txt_result=findViewById(R.id.txt_result);
        btn_submit=findViewById(R.id.btn_submit);
    }
}