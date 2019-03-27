package com.example.gurjotsinghnijjar.gurjotsclubapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.app.ListActivity;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Other_Activity extends ListActivity {

    private ArrayList<String> results = new ArrayList<String>();
    private String tableName = DatabaseHelper.tableName;
    private SQLiteDatabase newDB;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openAndQueryDatabase();
        TextView tView = new TextView(this);
        tView.setText("This is the lists of all the clubs in Hunter College. Click for additional information. ");
        getListView().addHeaderView(tView);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, results));
        getListView().setTextFilterEnabled(true);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Other_Activity.this,activity_listdata.class);
                String[] stringarray = results.toArray(new String[0]);

                intent.putExtra("name", stringarray[i-1]);
                startActivity(intent);
            }
        });
    }
   /* private void displayResultList() {
        TextView tView = new TextView(this);
        tView.setText("This is the lists of all the clubs in Hunter College. Click for additional information. ");
        getListView().addHeaderView(tView);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, results));
        getListView().setTextFilterEnabled(true);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Other_Activity.this,activity_listdata.class);
                String[] stringarray = results.toArray(new String[0]);
                intent.putExtra("name", "orange");
            }
        });

    }*/
    private void openAndQueryDatabase() {
        try {
            DatabaseHelper dbHelper = new DatabaseHelper(this.getApplicationContext());
            newDB = dbHelper.getWritableDatabase();
            Cursor c = newDB.rawQuery("SELECT Club_Name FROM " +
                    tableName, null);

            if (c != null ) {
                if (c.moveToFirst()) {
                    do {
                        String clubName = c.getString(c.getColumnIndex("Club_Name"));

                        results.add(clubName);
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


    /*private ArrayAdapter<String> adapter;
    private ArrayList<String> data = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_);
        DatabaseHelper dba = new DatabaseHelper(this);
        dba.CreateTable();
        SQLiteDatabase db = dba.getWritableDatabase();
        Cursor todoCursor = db.rawQuery("SELECT CLUB_NAME FROM Clubs", null);
        if (todoCursor != null)

        {
            if(todoCursor.moveToFirst())
            {
                do
                {
                    String clubs = todoCursor.getString(todoCursor.getColumnIndex("CLUB_NAME"));
                    data.add(clubs);
                }
                while (todoCursor.moveToNext());
            }

        }
        TextView textView = new TextView(this);
        textView.setText("These are the clubs");
        getListView().addHeaderView(textView);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));
        getListView().setTextFilterEnabled(true);
        View = (ListView) findViewById(R.id.ListView01);
        todoCursor
        data = new ArrayList<String>();

        // 1. This part is similar to the ArrayAdapter we saw earlier. We create an array of fruits to be shown in a list
        String[] fruits = new String[]{"Apple", "Avocado", "Banana",
                "Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
                "Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple"};

        //2. We add the above list to the ArrayList object. We do this extra step because we want to be able to delete objects.
        Collections.addAll(data, fruits);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data);

        //3. Set the adaptor for the list view
        lView.setAdapter(adapter);
*/









}


