package com.stepyen.xframedemo;

import android.graphics.Color;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.Gravity;
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
            View view = View.inflate(holder.getContext(), R.layout.view_other_error, null);
            view.findViewById(R.id.btn_error).setOnClickListener(v -> {
                convertView.post(holder.getRetryTask());
            });

            return view;
        }
        return super.getView(holder, convertView, status);
    }
}
