package com.example.sravanthy.tourguide;

/**
 * Created by sandeep on 8/28/2017.
 */

import android.content.Context;
import android.util.AttributeSet;

public class SliderMenuItemView extends AbstractSliderMenuItemView {

    public SliderMenuItemView(Context context) {
        super(context);
    }

    public SliderMenuItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.view_drawer_item;
    }
}
