package com.t3h.lazada.Activity.GioHang;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.lazada.Activity.ThanhToan.ThanhToanActivity;
import com.t3h.lazada.Adapter.GioHangAdapter;
import com.t3h.lazada.Models.Objectclass.SanPham;
import com.t3h.lazada.Presenter.GioHang.PreGioHang;
import com.t3h.lazada.R;

import java.util.List;

public class GioHangActivity extends AppCompatActivity implements ViewGioHang, View.OnClickListener {
    private RecyclerView lvGioHang;
    private GioHangAdapter adapter;
    private PreGioHang preGioHang;
    private Toolbar toolbar;
    private Button btnMuaNgay;
    private List<SanPham> phamList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);
        iniView();
    }

    private void iniView() {
        lvGioHang = findViewById(R.id.lv_giohang);
        toolbar = findViewById(R.id.toolBar_giohang);
        btnMuaNgay = findViewById(R.id.btn_muangay);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        preGioHang = new PreGioHang(this);
        preGioHang.LayDanhSachSanPhamTrongGioHang(this);
        btnMuaNgay.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void HinhThiDanhSachGioHang(List<SanPham> sanPhams) {
        phamList = sanPhams;
        adapter = new GioHangAdapter(this,phamList);
        lvGioHang.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_muangay:
                if (phamList.size() >0 ){
                    Intent iThanhToan = new Intent(this,ThanhToanActivity.class);
                    startActivity(iThanhToan);
                    finish();
                }else {
                    Toast.makeText(this,"Bạn không có sản phẩm trong giỏ hàng",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
