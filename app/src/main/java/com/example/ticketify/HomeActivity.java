package com.example.ticketify;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ScrollView;


public class HomeActivity extends AppCompatActivity {
    HorizontalScrollView scrollview;
    ImageButton homebutton;
    int var = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homebutton = findViewById(R.id.homebutton);
        scrollview = (findViewById(R.id.horizontalScrollView));


        recursive();

        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,HomeActivity.class));
            }
        });
    }

        public void recursive () {
            var = 0;
            new CountDownTimer(15300, 3) {


                public void onTick(long millisUntilFinished) {

                    scrollview.scrollTo(var, 0); // from zero to 2000
                    var += 1;
                }

                public void onFinish() {
                    scrollview.fullScroll(ScrollView.FOCUS_LEFT);
                    recursive();
                }


            }.start();
        }


}