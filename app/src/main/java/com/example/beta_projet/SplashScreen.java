package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
public class SplashScreen extends AppCompatActivity {

    private final int SPLASH_SCREEN_TIMEOUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Redirection vers mainactivity

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //demarrer une page
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();

            }


        };
        //délai
        new Handler().postDelayed(runnable,SPLASH_SCREEN_TIMEOUT); //temps en ms


    }
}