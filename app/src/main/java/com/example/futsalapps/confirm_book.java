package com.example.futsalapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class confirm_book extends AppCompatActivity {
    String nama, tanggal, jam, period;
    TextView tvnama, tvtanggal, tvjam, tvperiod;
    Button btnfinis;

    private String dbadd_timestamp;
    DatabaseHelper dbhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_book);

        tvnama = findViewById(R.id.setnama);
        tvtanggal = findViewById(R.id.settanggal);
        tvjam = findViewById(R.id.setjam);
        tvperiod = findViewById(R.id.setperiod);
        btnfinis = findViewById(R.id.btnFinish);

        dbhelper = new DatabaseHelper(this);

        nama = getIntent().getStringExtra("nama");
        tanggal = getIntent().getStringExtra("tanggal");
        jam = getIntent().getStringExtra("jam");
        period = getIntent().getStringExtra("period");

        tvnama.setText(nama);
        tvtanggal.setText(tanggal);
        tvjam.setText(jam);
        tvperiod.setText(period);

        btnfinis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getData();
                Intent intentmenu = new Intent(confirm_book.this, MainActivity.class);
                startActivity(intentmenu);
            }
        });
    }

    private void getData() {

        dbadd_timestamp = "" + System.currentTimeMillis();

        long id =dbhelper.insertInfo(
                ""+nama,
                ""+tanggal,
                ""+jam,
                ""+period,
                ""+dbadd_timestamp
        );

        Toast.makeText(getApplicationContext(),"Jangan Lupa Bahagia \n" +
                "id : "+id+" \nName : "+nama, Toast.LENGTH_SHORT).show();

    }
}
