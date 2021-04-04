package com.example.ticketify;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Spinner SecurityQuestions = (Spinner) findViewById(R.id.question);


        ArrayAdapter<String> questions = new ArrayAdapter<String>(ChangePasswordActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.questions));
        questions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SecurityQuestions.setAdapter(questions);


    }



    }

