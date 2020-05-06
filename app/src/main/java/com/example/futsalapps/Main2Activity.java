package com.example.futsalapps;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Main2Activity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private String currentdate, strDate;
    public String period, nama, jam;
    public String[] values;
    TextView tvTime;
    EditText etnama;
    Button btnsatu, btndua, btntiga, btnnext;

    public Main2Activity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        tvTime = findViewById(R.id.textTime);
        etnama = findViewById(R.id.textName);
        Button btnDate = findViewById(R.id.btnDate);
        Button btnTime = findViewById(R.id.btnTime);
        btnnext = findViewById(R.id.btn_next);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datepicker = new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Main2Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        jam = selectedHour + ":" + selectedMinute;
                        tvTime.setText(jam);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nama = String.valueOf(etnama.getText());
                Intent confirmintent = new Intent(Main2Activity.this, confirm_book.class);
                confirmintent.putExtra("nama",nama);
                confirmintent.putExtra("jam", jam);
                confirmintent.putExtra("tanggal", currentdate);
                confirmintent.putExtra("period", period);
                startActivity(confirmintent);
            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE/dd/MMMM/yyyy");
        currentdate = sdf.format(calendar.getTime());

        values = currentdate.split("/",0);
        for (int i = 0; i < values.length; i++){
            Log.v("CHECK_DATE", values[i]);
        }

        strDate = values[0] +"\n" + values[1] + " " + values[2] + " " + values[3];
        TextView tv = findViewById(R.id.textDate);
        tv.setText(strDate);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = view.isClickable();
        btnsatu = findViewById(R.id.btnSatu);
        btndua = findViewById(R.id.btnDua);
        btntiga = findViewById(R.id.btnTiga);
        period = "";
        switch (view.getId()){
            case R.id.btnSatu:
                if(checked)
                    period = "One Hour";
                Log.v("Btn_Period", period);
                btnsatu.setBackground(getResources().getDrawable(R.drawable.bg_btnclicked));
                btndua.setBackground(getResources().getDrawable(R.drawable.bg_button));
                btntiga.setBackground(getResources().getDrawable(R.drawable.bg_button));
                break;
            case  R.id.btnDua:
                if (checked)
                    period = "Two Hours";
                Log.v("Btn_Period", period);
                btndua.setBackground(getResources().getDrawable(R.drawable.bg_btnclicked));
                btnsatu.setBackground(getResources().getDrawable(R.drawable.bg_button));
                btntiga.setBackground(getResources().getDrawable(R.drawable.bg_button));
                break;
            case R.id.btnTiga:
                if (checked)
                    period = "Three Hours";
                btntiga.setBackground(getResources().getDrawable(R.drawable.bg_btnclicked));
                btnsatu.setBackground(getResources().getDrawable(R.drawable.bg_button));
                btndua.setBackground(getResources().getDrawable(R.drawable.bg_button));
                Log.v("Btn_Period", period);
                break;
        }

    }
}
