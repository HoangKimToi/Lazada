package com.t3h.lazada.Activity.DangNhap;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.t3h.lazada.Adapter.DangNhapAdapter;
import com.t3h.lazada.R;

public class DangNhap extends AppCompatActivity {
    private TabLayout tabDangNhap;
    private ViewPager viewPagerDangNhap;
    private DangNhapAdapter adapter;
    private Toolbar toolbarDangNhap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        initView();
    }

    private void initView() {
        tabDangNhap = findViewById(R.id.tab_dangnhap);
        viewPagerDangNhap = findViewById(R.id.viewpager_dangnhap);
        toolbarDangNhap = findViewById(R.id.toolBar_dangNhap);
        toolbarDangNhap.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbarDangNhap);
        toolbarDangNhap.setNavigationIcon(R.drawable.ic_arrow_white);
        toolbarDangNhap.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        adapter = new DangNhapAdapter(getSupportFragmentManager());
        viewPagerDangNhap.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        tabDangNhap.setupWithViewPager(viewPagerDangNhap);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
