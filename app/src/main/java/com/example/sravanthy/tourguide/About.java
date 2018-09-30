package com.example.sravanthy.tourguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

/**
 * Created by sandeep on 11/22/2016.
 */
public class About extends BaseActivityWithDrawer {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.about, getFrame());
    }

    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }
}

