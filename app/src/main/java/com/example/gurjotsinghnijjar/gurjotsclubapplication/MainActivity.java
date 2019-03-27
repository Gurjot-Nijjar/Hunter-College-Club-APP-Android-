package com.example.gurjotsinghnijjar.gurjotsclubapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;

import com.example.gurjotsinghnijjar.gurjotsclubapplication.DatabaseHelper;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText text;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();


    }



    private void addListenerOnButton() {
        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent (MainActivity.this, Other_Activity.class);
                startActivity(intent);

            }
        });
        }

    }





