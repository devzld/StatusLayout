package com.zld.statuslayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lingdong on 2018/1/11.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public StatusLayoutManager generateStatusLayout(ViewGroup parenView, View contentView, OnRetryListener onRetryListener){
        return StatusLayoutManager.newBuilder(this, parenView)
                .contentView(contentView)
                .loadingView(R.layout.layout_loading_view)
                .emptyDataView(R.layout.layout_empty_view)
                .netWorkErrorView(R.layout.layout_network_error_view)
                .errorView(R.layout.layout_error_view)
                .retryViewId(R.id.btn_retry)
                .onRetryListener(onRetryListener)
                .build();
    }
}
