package com.example.taskrestapi.adapterMatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taskrestapi.R;
import com.squareup.picasso.Picasso;

public class DetailTeams extends AppCompatActivity {
    ImageView imageView;
    TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_teams);
        imageView = findViewById(R.id.img_logoDetail);
        tv1 = findViewById(R.id.tv_NamaClub);
        tv2 = findViewById(R.id.tv_detail);

        Picasso.get().load(getIntent().getStringExtra("gambar")).into(imageView);
        tv1.setText(getIntent().getStringExtra("namaClub"));
        tv2.setText(getIntent().getStringExtra("detail"));
    }
}
