package com.stepyen.xframedemo.adapter;

import android.view.View;

import com.billy.android.loading.Gloading;
import com.stepyen.xframedemo.R;
import com.stepyen.xframedemo.adapter.GlobalAdapter;

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
                view.post(holder.getRetryTask());
            });

            return view;
        }
        return super.getView(holder, convertView, status);
    }
}
