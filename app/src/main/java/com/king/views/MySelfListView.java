package com.king.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by DJ on 2016/11/17.
 */

public class MySelfListView extends ListView {
    public MySelfListView(Context context) {
        super(context);
    }

    public MySelfListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySelfListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
