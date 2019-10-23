package com.t3h.lazada.Activity.ThanhToan;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.t3h.lazada.Activity.TrangChu.TrangChuActivity;
import com.t3h.lazada.Models.Objectclass.ChiTietHoaDon;
import com.t3h.lazada.Models.Objectclass.HoaDon;
import com.t3h.lazada.Models.Objectclass.SanPham;
import com.t3h.lazada.Presenter.ThanhToan.PreThanhToan;
import com.t3h.lazada.R;

import java.util.ArrayList;
import java.util.List;

public class ThanhToanActivity extends AppCompatActivity implements View.OnClickListener,ViewThanhToan {
    private Toolbar toolbar;
    private EditText editTen,editDiachi,editSoDT;
    private ImageButton imShip,imVisa;
    private Button btnThanhToan;
    private CheckBox cbDieuKhoan;
    private PreThanhToan preThanhToan;
    private List<ChiTietHoaDon> chiTietHoaDonList;
    private TextView tvVisa,tvShip;
    private int phuongthuc = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanhtoan);
        iniView();
    }

    private void iniView() {
        toolbar = findViewById(R.id.toolBar_thanhtoan);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        editTen = findViewById(R.id.edit_tennguoinhan);
        editDiachi = findViewById(R.id.edit_diachinguoinhan);
        editSoDT = findViewById(R.id.edit_sodt_nguoinhan);
        imShip = findViewById(R.id.imBtn_ship);
        imVisa = findViewById(R.id.imBtn_visa);
        cbDieuKhoan = findViewById(R.id.cb_dieukhoan);
        btnThanhToan = findViewById(R.id.btn_thanhtoan);
        tvShip = findViewById(R.id.tv_ship);
        tvVisa = findViewById(R.id.tv_visa);
        preThanhToan = new PreThanhToan(this,this);
        preThanhToan.LayDanhSachSPTrongGioHang();
        btnThanhToan.setOnClickListener(this);
        imShip.setOnClickListener(this);
        imVisa.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_thanhtoan:
                String tennguoinhan = editTen.getText().toString();
                String sodt = editSoDT.getText().toString();
                String diachi = editDiachi.getText().toString();
                if (tennguoinhan.trim().length() >0 && sodt.trim().length() > 0 && diachi.trim().length()>0){
                    if (cbDieuKhoan.isChecked()){
                        HoaDon hoaDon = new HoaDon();
                        hoaDon.setTenNguoiNhan(tennguoinhan);
                        hoaDon.setSoDT(sodt);
                        hoaDon.setDiaChi(diachi);
                        hoaDon.setChuyenKhoan(phuongthuc);
                        hoaDon.setChiTietHoaDonList(chiTietHoaDonList);
                        preThanhToan.ThemHoaDon(hoaDon);
                    }else {
                        Toast.makeText(this,"Bạn chưa chọn ô điều khoản",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this,"Bạn chưa nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.imBtn_ship:
                ChonPhuongThuc(tvShip,tvVisa);
                phuongthuc = 0;
                break;
            case R.id.imBtn_visa:
                ChonPhuongThuc(tvVisa,tvShip);
                phuongthuc = 1;
                break;
        }
    }
    private void ChonPhuongThuc(TextView chon,TextView huy){
        chon.setTextColor(Color.RED);
        huy.setTextColor(Color.GRAY);
    }

    @Override
    public void ThanhToanThanhCong() {
        Toast.makeText(this,"Thanh cong",Toast.LENGTH_SHORT).show();
        Intent ITrangchu = new Intent(this, TrangChuActivity.class);
        startActivity(ITrangchu);
        finish();
    }

    @Override
    public void ThanhToanThatBai() {
        Toast.makeText(this,"That bai",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LayDanhSachSPTrongGioHang(List<SanPham> sanPhams) {
        chiTietHoaDonList = new ArrayList<>();
        for (int i = 0; i < sanPhams.size(); i++) {
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            chiTietHoaDon.setMASP(sanPhams.get(i).getMASP());
            chiTietHoaDon.setSOLUONG(sanPhams.get(i).getSOLUONG());
            chiTietHoaDonList.add(chiTietHoaDon);
        }
    }
}
