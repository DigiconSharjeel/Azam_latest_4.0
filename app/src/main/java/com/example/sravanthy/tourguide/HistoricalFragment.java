package com.example.sravanthy.tourguide;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sandeep on 11/22/2016.
 */
public class HistoricalFragment extends BaseActivityWithDrawer {

    private static final String TAG = HistoricalFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: " );
        LayoutInflater.from(this).inflate(R.layout.historical_fragment, getFrame());

    }

    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }
}
