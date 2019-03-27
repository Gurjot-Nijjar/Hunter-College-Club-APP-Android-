package com.example.gurjotsinghnijjar.gurjotsclubapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class activity_listdata extends AppCompatActivity {
    private ArrayList<String> results = new ArrayList<String>();
    TextView listdata;
    TextView info;
    private String tableName = DatabaseHelper.tableName;
    private SQLiteDatabase newDB;
    String input;
    Button button2;
    Button button3;
    String email;
    String Date_ = "2011-09-01";
    String Event;
    long startTime, endTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);
        listdata = findViewById(R.id.listdata);
        info = findViewById(R.id.info);
        Intent intent = getIntent();
        String recievedName = intent.getStringExtra("name");
        input = recievedName;
        listdata.setText(recievedName);
        openAndQueryDatabase();
        String[] stringarray = results.toArray(new String[0]);
        info.setText(stringarray[1]);
        email = stringarray[2];
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        Date_ =  stringarray[4];
        Event = stringarray[3];
        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Date_);
            startTime = date.getTime();
        }
        catch(Exception e){}




        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();

                Intent intent2 = new Intent(Intent.ACTION_EDIT);
                intent2.setType("vnd.android.cursor.item/event");
                intent2.putExtra("beginTime", startTime);
                intent2.putExtra("allDay", true);
                intent2.putExtra("rrule", "FREQ=YEARLY");
                intent2.putExtra("endTime", endTime);
                intent2.putExtra("title", Event);
                startActivity(intent2);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent1 = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null));

                intent1.putExtra(Intent.EXTRA_SUBJECT, "I am interested in this club, tell me more?");
                intent1.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(intent1, "Send email..."));

            }
        });
    }

    private void openAndQueryDatabase(){
        try {
            DatabaseHelper dbHelper = new DatabaseHelper(this.getApplicationContext());
            newDB = dbHelper.getWritableDatabase();
            Cursor c = newDB.rawQuery("SELECT Club_Name,Club_Information,Club_Email,Event_Title,Event_Date FROM " +
                    tableName + " WHERE Club_Name = " + "\"" + input + "\"" , null);

            if (c != null ) {
                if (c.moveToFirst()) {
                    do {
                        String clubName = c.getString(c.getColumnIndex("Club_Name"));
                        String clubInformation = c.getString(c.getColumnIndex("Club_Information"));
                        String clubEmail = c.getString(c.getColumnIndex("Club_Email"));
                        String EventTitle = c.getString(c.getColumnIndex("Event_Title"));
                        String EventDate = c.getString(c.getColumnIndex("Event_Date"));

                        results.add(clubName);
                        results.add(clubInformation);
                        results.add(clubEmail);
                        results.add(EventTitle);
                        results.add(EventDate);

                    }while (c.moveToNext());
                }
            }
        } catch (SQLiteException se ) {
            Log.e(getClass().getSimpleName(), "Could not create or Open the database");
        } finally {
            if (newDB != null)
                newDB.execSQL("DELETE FROM " + tableName);
            newDB.close();
        }

    }



}
