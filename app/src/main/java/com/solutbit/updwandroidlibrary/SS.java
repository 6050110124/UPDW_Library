package com.solutbit.updwandroidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SS extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    ImageView ss_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ss);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
                finish();
            }
        },SPLASH_TIME_OUT);

        ss_logo = findViewById(R.id.ss_logo);
        ss_logo.setAlpha(0f);
        ss_logo.setTranslationY(50);
        ss_logo.animate().alpha(1f).translationYBy(-50).setDuration(800);
    }
}
