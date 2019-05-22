package com.stepyen.xframedemo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.billy.android.loading.Gloading;

/**
 * date：2019/4/15
 * author：stepyen
 * description：
 */
public class GlobalAdapter implements Gloading.Adapter {

    @Override
    public View getView(Gloading.Holder holder, View convertView, int status) {

        GloadingStatusView loadingStatusView = null;
        //reuse the old view, if possible
        if (convertView != null && convertView instanceof GloadingStatusView) {
            loadingStatusView = (GloadingStatusView) convertView;
        }
        if (loadingStatusView == null) {
            loadingStatusView = new GloadingStatusView(holder.getContext(), holder.getRetryTask());
        }
        loadingStatusView.setStatus(status);

        return loadingStatusView;
    }

}
