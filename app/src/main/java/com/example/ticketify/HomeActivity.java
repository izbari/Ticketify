package com.example.ticketify;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    private ArrayList<discounts> discountList ;
    ImageButton searchButton;
    HorizontalScrollView scrollview;
    ImageButton homebutton;
    int var = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        discountList=new ArrayList<>();
        Resources res = getResources();
        String[] titles = res.getStringArray(R.array.title);
        String[] descriptions = res.getStringArray(R.array.subtitle);
        populateDiscountList(titles,descriptions);
        searchButton=findViewById(R.id.searchbutton);
        homebutton = findViewById(R.id.homebutton);
        scrollview = (findViewById(R.id.horizontalScrollView));

            recursive();
        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,HomeActivity.class));
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,discounts.class));
            }
        });
        DiscountAdapter discountadapter= new DiscountAdapter(getApplicationContext(),R.layout.discounts,discountList);
        ListView listView = findViewById(R.id.discountList);
        listView.setAdapter(discountadapter);
    }
    public void populateDiscountList(String[] title , String[] description)
    {
        discountList.add(new discounts(title[0],description[0],R.drawable.insta));
        discountList.add(new discounts(title[1],description[1],R.drawable.paraf));
        discountList.add(new discounts(title[2],description[2],R.drawable.burgerking));
        discountList.add(new discounts(title[3],description[3],R.drawable.vodafone));
        discountList.add(new discounts(title[4],description[4],R.drawable.wada));
        discountList.add(new discounts(title[5],description[5],R.drawable.koton));
        discountList.add(new discounts(title[6],description[6],R.drawable.hummel));

    }




        public void recursive () {
            var = 0;
            new CountDownTimer(10500, 3) {


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