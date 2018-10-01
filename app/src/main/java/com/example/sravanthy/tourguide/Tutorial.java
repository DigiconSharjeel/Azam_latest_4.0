package com.example.sravanthy.tourguide;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Tutorial extends AppCompatActivity {



    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);




    }


    public void next_button(View view) {
        Intent intent = new Intent(Tutorial.this,MainActivity.class);
        startActivity(intent);
    }
}
