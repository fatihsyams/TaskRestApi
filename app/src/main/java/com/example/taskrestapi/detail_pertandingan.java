package com.example.taskrestapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class detail_pertandingan extends AppCompatActivity {
    TextView tv, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pertandingan);
        tv = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        tv.setText(getIntent().getStringExtra("event"));
        tv2.setText(getIntent().getStringExtra("filename"));
    }
}
