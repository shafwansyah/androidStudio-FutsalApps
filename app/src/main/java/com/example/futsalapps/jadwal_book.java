package com.example.futsalapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class jadwal_book extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_book);

        recyclerView = findViewById(R.id.recyclerview);
        dbHelper = new DatabaseHelper(this);

        showRecord();
    }

    private void showRecord() {

        Adapter adapter = new Adapter(jadwal_book.this,dbHelper.getAllData(Constant.C_ADD_TIMESTAMP + " DESC"));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showRecord();
    }
}
