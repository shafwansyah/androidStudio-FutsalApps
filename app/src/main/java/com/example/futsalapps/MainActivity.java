package com.example.futsalapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cvBuking = (CardView) findViewById(R.id.cvBooking);
        CardView cvJadwal = (CardView) findViewById(R.id.cvJadwal);
        cvBuking.setOnClickListener(this);
        cvJadwal.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cvBooking:
                Intent buking = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(buking);
                break;
            case R.id.cvJadwal:
                Intent jadwalintent = new Intent(MainActivity.this, jadwal_book.class);
                startActivity(jadwalintent);
                break;
        }
    }
}
