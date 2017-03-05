package com.example.probattle.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Market extends AppCompatActivity {

    DBHandler db;
    ArrayList<String> get;
    LinearLayout gogle;
    LinearLayout fb;
    LinearLayout ama;
    LinearLayout fs;
    LinearLayout mic;
    TextView ga, gb, fa, ftb, aa, ab, ma, mb, fsa, fsb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        get = new ArrayList<>();
        db  = new DBHandler(this, "Stock.db", null, 2);

        ga = (TextView) findViewById(R.id.priceTxt);
        gb = (TextView) findViewById(R.id.changeTxt);

        aa= (TextView) findViewById(R.id.priceTxta);
        ab = (TextView) findViewById(R.id.changeTxta);

        fa = (TextView) findViewById(R.id.priceTxtf);
        ftb = (TextView) findViewById(R.id.changeTxtf);

        fsa = (TextView) findViewById(R.id.priceTxtfe);
        fsb = (TextView) findViewById(R.id.changeTxtfe);

        ma = (TextView) findViewById(R.id.priceTxtm);
        mb = (TextView) findViewById(R.id.changeTxtm);


        gogle = (LinearLayout) findViewById(R.id.google);
        fb = (LinearLayout) findViewById(R.id.fb);
        ama = (LinearLayout) findViewById(R.id.amazon);
        fs = (LinearLayout) findViewById(R.id.fetch);
        mic = (LinearLayout) findViewById(R.id.microsoft);

         get = db.getVal("Google");
        ga.setText(get.get(0));
        m1(gb, Integer.parseInt(get.get(0)) - Integer.parseInt(get.get(1)));

        get = db.getVal("Facebook");
        fa.setText(get.get(0));
        m1(ftb, Integer.parseInt(get.get(0)) - Integer.parseInt(get.get(1)));

        get = db.getVal("Amazon");
        aa.setText(get.get(0));
        m1(ab, Integer.parseInt(get.get(0)) - Integer.parseInt(get.get(1)));

        get = db.getVal("FetchSky");
        fsa.setText(get.get(0));
        m1(fsb, Integer.parseInt(get.get(0)) - Integer.parseInt(get.get(1)));

        get = db.getVal("Microsoft");
        ma.setText(get.get(0));
        m1(mb, Integer.parseInt(get.get(0)) - 1500);


        gogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Detail.class);
                startActivity(i);
            }
        });

    }
    public void m1(TextView tv, int id){
        tv.setText(id+"");
        if(id>0) {
            tv.setTextColor(Color.GREEN);
        }

        else
        {
            tv.setTextColor(Color.RED);
        }

    }
}
