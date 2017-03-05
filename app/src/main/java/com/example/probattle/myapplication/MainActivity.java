package com.example.probattle.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    Random random ;
    final  int min = 100;
    final int max = 1000;
    String val;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();
        db = new DBHandler(MainActivity.this, "", null, 2);
        db.Insert("Google",String.valueOf(random.nextInt((max - min) + 1) + min), String.valueOf(new Date().getTime()));
        db.Insert("Facebook",String.valueOf(random.nextInt((max - min) + 1) + min),String.valueOf(new Date().getTime()));
        db.Insert("Amazon",String.valueOf(random.nextInt(100)),String.valueOf(new Date().getTime()));
        db.Insert("FetchSky",String.valueOf(random.nextInt(100)),String.valueOf(new Date().getTime()));
        db.Insert("Microsoft",String.valueOf(random.nextInt()),String.valueOf(new Date().getTime()));
        //db = new DBHandler(MainActivity.this, "", null, 2);
        db.Insert("Google",String.valueOf(random.nextInt(100)), String.valueOf(new Date().getTime()));
        db.Insert("Facebook",String.valueOf(random.nextInt(100)),String.valueOf(new Date().getTime()));
        db.Insert("Amazon",String.valueOf(random.nextInt(100)),String.valueOf(new Date().getTime()));
        db.Insert("FetchSky",String.valueOf(random.nextInt(100)),String.valueOf(new Date().getTime()));
        db.Insert("Microsoft",String.valueOf(random.nextInt(100)),String.valueOf(new Date().getTime()));

       /* Thread my = new Thread(){
            @Override
            public void run() {
                try {
                    db = new DBHandler(MainActivity.this, "", null, 2);
                    db.Insert("Google",String.valueOf(random.nextInt()), String.valueOf(new Date().getTime()));
                    db.Insert("Facebook",String.valueOf(random.nextInt()),String.valueOf(new Date().getTime()));
                    db.Insert("Amazon",String.valueOf(random.nextInt()),String.valueOf(new Date().getTime()));
                    db.Insert("FetchSky",String.valueOf(random.nextInt()),String.valueOf(new Date().getTime()));
                    db.Insert("Microsoft",String.valueOf(random.nextInt()),String.valueOf(new Date().getTime()));
                    sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };*/
        //my.start();





        Intent i = new Intent(getApplicationContext(), Front.class);
        startActivity(i);
    }
}
