package com.example.number_guessing_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class First_page extends AppCompatActivity {
    public static int FIRST_PAGE_SCREEN_DURATION=4000;
    Animation top_anim,bottom_anim;
    ImageView img_image;
    TextView txt_text1,txt_text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        findId();
        adding_animtion();
        applying_Animation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(First_page.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },FIRST_PAGE_SCREEN_DURATION);
    }

    private void applying_Animation() {
        img_image.setAnimation(top_anim);
        txt_text1.setAnimation(bottom_anim);
        txt_text2.setAnimation(bottom_anim);
    }

    private void adding_animtion() {
        top_anim= AnimationUtils.loadAnimation(First_page.this,R.anim.top_anim);
        bottom_anim= AnimationUtils.loadAnimation(First_page.this,R.anim.bottom_anim);

    }

    private void findId() {
        img_image=findViewById(R.id.img_image);
        txt_text1=findViewById(R.id.txv_text1);
        txt_text2=findViewById(R.id.txv_text2);
    }
}