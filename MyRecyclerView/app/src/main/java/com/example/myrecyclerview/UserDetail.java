package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class UserDetail extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("User ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ImageView ivPhoto = findViewById(R.id.iv_photo);
        TextView tv_name = findViewById(R.id.tv_name);
        TextView tv_username = findViewById(R.id.tv_userName);
        TextView tv_sports = findViewById(R.id.tv_sports);
        TextView tv_medals = findViewById(R.id.tv_medals);
        TextView tv_followers = findViewById(R.id.tv_followers);
        TextView tv_following = findViewById(R.id.tv_following);
        TextView tv_location = findViewById(R.id.tv_location);

        tv_name.setText(getIntent().getStringExtra("Name"));
        tv_username.setText(getIntent().getStringExtra("UserName"));
        tv_followers.setText("Followers : " + getIntent().getStringExtra("Followers"));
        tv_following.setText("Following : " + getIntent().getStringExtra("Following"));
        tv_medals.setText("Medals : " + getIntent().getStringExtra("Medals"));
        tv_sports.setText("Sports   : " + getIntent().getStringExtra("Sports"));
        tv_location.setText("Location  : " + getIntent().getStringExtra("Location"));

        Glide.with(getApplicationContext())
                .load(getIntent().getIntExtra("photo", 0))
                .into(ivPhoto);


    }
}