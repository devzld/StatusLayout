package com.zld.statuslayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private RelativeLayout rlContainer;
    private LinearLayout llContent;
    private StatusLayoutManager mStatusLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlContainer = findViewById(R.id.rl_container);
        llContent = findViewById(R.id.ll_content);
        mStatusLayoutManager = generateStatusLayout(rlContainer, llContent, new OnRetryListener() {
            @Override
            public void onRetry() {
                Toast.makeText(MainActivity.this, "你点击了重试", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_show_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_loading:
                mStatusLayoutManager.showLoading();
                break;
            case R.id.menu_content:
                mStatusLayoutManager.showContent();
                break;
            case R.id.menu_empty:
                mStatusLayoutManager.showEmptyData();
                break;
            case R.id.menu_network_error:
                mStatusLayoutManager.showNetWorkError();
                break;
            case R.id.menu_error:
                mStatusLayoutManager.showError();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
