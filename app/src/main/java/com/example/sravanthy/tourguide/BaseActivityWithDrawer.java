package com.example.sravanthy.tourguide;

/**
 * Created by sandeep on 8/28/2017.
 */


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseActivityWithDrawer extends AppCompatActivity {

    FrameLayout contentFrame;
    LinearLayout drawerView;
    DrawerLayout leftDrawer;
    //#3b4371 nav_color
    public static final String TAG = BaseActivityWithDrawer.class.getSimpleName();
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            Log.d(TAG, "Setting up action bar home button.");
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeButtonEnabled(true);
        } else {
            Log.d(TAG, "action bar is null");
        }
        setContentView(shouldEnableDrawer() ? R.layout.activity_base_with_drawer : R.layout.activity_base_without_drawer);

        contentFrame = (FrameLayout) findViewById(R.id.content_frame);
        final ImageView reverseTriangle = (ImageView) findViewById(R.id.reverseTriangleImage);
        final ImageView triangle = (ImageView) findViewById(R.id.triangleImage);

        reverseTriangle.setVisibility(View.VISIBLE);

        Log.d(TAG, "drawer enabled: " + shouldEnableDrawer());
        if (shouldEnableDrawer()) {
            drawerView = (LinearLayout) findViewById(R.id.drawer);
            leftDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

            mDrawerToggle = new ActionBarDrawerToggle(
                    BaseActivityWithDrawer.this,
                    leftDrawer,
                    R.string.app_name,
                    R.string.app_name
            ) {

                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);
                }
            };

            leftDrawer.setDrawerListener(mDrawerToggle);

            //Populate the drawer
            final List<SliderMenuItem> sliderMenuItems = new ArrayList<>();
            final SliderMenuItem item1 = new SliderMenuItem();
            item1.setId(1);
            item1.setTitle("HOME");
            item1.setIconImageId(R.drawable.ic_home);
            item1.setClickHandler(new SliderMenuItem.MenuItemClickHandler() {
                @Override
                public void handleMenuClick() {
                    startDrawerActivity(WebView.class);
                }
            });

            final SliderMenuItem item2 = new SliderMenuItem();
            item2.setId(2);
            item2.setTitle("CALL US");
            item2.setIconImageId(R.drawable.ic_call);
            item2.setClickHandler(new SliderMenuItem.MenuItemClickHandler() {
                @Override
                public void handleMenuClick() {
                    startDrawerActivity(CallActivity.class);
                }
            });

            final SliderMenuItem item3 = new SliderMenuItem();
            item3.setId(3);
            item3.setTitle("ABOUT");
            item3.setIconImageId(R.drawable.ic_info);
            item3.setClickHandler(new SliderMenuItem.MenuItemClickHandler() {
                @Override
                public void handleMenuClick() {
                    startDrawerActivity(About.class);
                }
            });

            sliderMenuItems.add(item1);
            sliderMenuItems.add(item2);
            sliderMenuItems.add(item3);
            for (SliderMenuItem item : sliderMenuItems) {
                SliderMenuItemView view = new SliderMenuItemView(this);
                view.setItem(item);
                drawerView.addView(view);
            }

            reverseTriangle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e(TAG, "onClick: ");
                    reverseTriangle.setVisibility(View.GONE);
                    triangle.setVisibility(View.VISIBLE);
                    drawerView.removeAllViews();

                    //Populate the drawer
                    final List<SliderMenuItem> sliderMenuItems = new ArrayList<>();
                    final SliderMenuItem item1 = new SliderMenuItem();
                    item1.setId(1);
                    item1.setTitle("check");
                    item1.setIconImageId(R.drawable.ic_home);
                    item1.setClickHandler(new SliderMenuItem.MenuItemClickHandler() {
                        @Override
                        public void handleMenuClick() {
                            startDrawerActivity(WebView.class);
                        }
                    });

                    final SliderMenuItem item2 = new SliderMenuItem();
                    item2.setId(2);
                    item2.setTitle("click");
                    item2.setIconImageId(R.drawable.ic_call);
                    item2.setClickHandler(new SliderMenuItem.MenuItemClickHandler() {
                        @Override
                        public void handleMenuClick() {
                            startDrawerActivity(CallActivity.class);
                        }
                    });

                    sliderMenuItems.add(item1);
                    sliderMenuItems.add(item2);
                    for (SliderMenuItem item : sliderMenuItems) {
                        SliderMenuItemView view1 = new SliderMenuItemView(BaseActivityWithDrawer.this);
                        view1.setItem(item);
                        drawerView.addView(view1);
                    }

                }
            });


            triangle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    triangle.setVisibility(View.GONE);
                    reverseTriangle.setVisibility(View.VISIBLE);
                    Log.e(TAG, "onClick5 ");
                    drawerView.removeAllViews();

                    final List<SliderMenuItem> sliderMenuItems = new ArrayList<>();
                    final SliderMenuItem item1 = new SliderMenuItem();
                    item1.setId(1);
                    item1.setTitle("HOME");
                    item1.setIconImageId(R.drawable.ic_home);
                    item1.setClickHandler(new SliderMenuItem.MenuItemClickHandler() {
                        @Override
                        public void handleMenuClick() {

                            startDrawerActivity(WebView.class);
                        }
                    });

                    final SliderMenuItem item2 = new SliderMenuItem();
                    item2.setId(2);
                    item2.setTitle("CALL US");
                    item2.setIconImageId(R.drawable.ic_call);
                    item2.setClickHandler(new SliderMenuItem.MenuItemClickHandler() {
                        @Override
                        public void handleMenuClick() {
                            startDrawerActivity(CallActivity.class);
                        }
                    });

                    final SliderMenuItem item3 = new SliderMenuItem();
                    item3.setId(3);
                    item3.setTitle("ABOUT");
                    item3.setIconImageId(R.drawable.ic_info);
                    item3.setClickHandler(new SliderMenuItem.MenuItemClickHandler() {
                        @Override
                        public void handleMenuClick() {
                            startDrawerActivity(About.class);
                        }
                    });

                    sliderMenuItems.add(item1);
                    sliderMenuItems.add(item2);
                    sliderMenuItems.add(item3);
                    for (SliderMenuItem item : sliderMenuItems) {
                        SliderMenuItemView view3 = new SliderMenuItemView(BaseActivityWithDrawer.this);
                        view3.setItem(item);
                        drawerView.addView(view3);
                    }
                }
            });


        }

    }

    private void startDrawerActivity(final Class activity) {
        leftDrawer.closeDrawer(GravityCompat.END);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(BaseActivityWithDrawer.this, activity));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        }, 200);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    public abstract boolean shouldEnableDrawer();

    public ViewGroup getFrame() {
        return contentFrame;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}