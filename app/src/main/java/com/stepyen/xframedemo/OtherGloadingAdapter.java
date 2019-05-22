package com.stepyen.xframedemo;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.billy.android.loading.Gloading;

/**
 * date：2019/5/22
 * author：stepyen
 * description：
 */
public class OtherGloadingAdapter extends GlobalAdapter {
    @Override
    public View getView(Gloading.Holder holder, View convertView, int status) {
        if (status == Gloading.STATUS_LOAD_FAILED) {
            FrameLayout frameLayout = new FrameLayout(holder.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            TextView tv = new TextView(holder.getContext());
            tv.setText("示范显示不同错误页面");
            frameLayout.addView(tv);
            return frameLayout;
        }
        return super.getView(holder, convertView, status);
    }
}
