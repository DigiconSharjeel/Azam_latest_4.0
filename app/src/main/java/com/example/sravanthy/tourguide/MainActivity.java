package com.example.sravanthy.tourguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends BaseActivityWithDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater.from(this).inflate(R.layout.activity_main, getFrame());

        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(getTitle());
    }

    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }

}