package com.t3h.lazada.Activity.DanhGia;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.textfield.TextInputLayout;
import com.t3h.lazada.Activity.TrangChu.ViewXuLyMenu;
import com.t3h.lazada.Models.DangNhap.ModelsDangNhap;
import com.t3h.lazada.Models.DanhGia.ModelDanhGia;
import com.t3h.lazada.Models.Objectclass.DanhGia;
import com.t3h.lazada.Models.Objectclass.LoaiSanPham;
import com.t3h.lazada.Presenter.DanhGia.PreDanhGia;
import com.t3h.lazada.Presenter.TrangChu.PreXuLyMenu;
import com.t3h.lazada.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class ThemDanhGiaActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener, ViewDanhGia, View.OnClickListener, GoogleApiClient.OnConnectionFailedListener, ViewXuLyMenu {
    private TextInputLayout inputEditTieuDe, inputEditNoiDung;
    private EditText editTieuDe, editNoiDung;
    private RatingBar ratingBar;
    private Button btnThemDanhGia,btnHuy;
    private int masp = 0;
    private float sosao = 0;
    private PreDanhGia preDanhGia;
    private DanhGia danhGia;
    private ModelsDangNhap modelsDangNhap;
    private GoogleApiClient googleApiClient;
    private GoogleSignInResult googleSignInResult;
    private String tennv;
    private String name;
    private String tenfb;
    private String tengg;
    private AccessToken accessToken;
    private PreXuLyMenu preXuLyMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_them_danhgia);
        iniView();
    }

    private void iniView() {
        inputEditTieuDe = findViewById(R.id.input_editTieude);
        inputEditNoiDung = findViewById(R.id.input_editNoiDung);
        editTieuDe = findViewById(R.id.edit_tieude);
        editNoiDung = findViewById(R.id.edit_noidung);
        ratingBar = findViewById(R.id.rb_Themdanhgia);
        btnThemDanhGia = findViewById(R.id.btn_themDanhGia);
        btnHuy = findViewById(R.id.btn_HuyDanhGia);

        masp = getIntent().getIntExtra("masp", 0);
        preDanhGia = new PreDanhGia(this);
        ratingBar.setOnRatingBarChangeListener(this);
        btnThemDanhGia.setOnClickListener(this);
        btnHuy.setOnClickListener(this);
        modelsDangNhap = new ModelsDangNhap();
        googleApiClient = modelsDangNhap.layGoogleApiClient(this,this);

    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
        sosao = rating;
    }

    @Override
    public void DanhGiaThanhCong() {
        Toast.makeText(this, "Đánh giá thành công", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void DanhGiaThatBai() {
        Toast.makeText(this, "Bạn không thể đánh giá sản phẩm.", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_themDanhGia:
                //Login Thường
                tennv = modelsDangNhap.LayCachedDangNhap(this);
                //Login Google
                googleSignInResult = modelsDangNhap.layThongTinLoginGG(googleApiClient);
                //Login Facebook
                if (googleSignInResult != null){
                    tengg = googleSignInResult.getSignInAccount().getDisplayName();
                }else {
                    tengg = "";
                }
                if (!tennv.equals("")){
                    name = tennv;
                }
                if(!tengg.equals("")){
                    name = tengg;
                }
                if (name == null){
                    Toast.makeText(this,"Vui lòng đăng nhập",Toast.LENGTH_SHORT).show();
                    return;
                }
                String tenthietbi = Build.MODEL;
                String tieude = editTieuDe.getText().toString();
                String noidung = editNoiDung.getText().toString();
                if (tieude.trim().length() > 0){
                    inputEditTieuDe.setErrorEnabled(false);
                    inputEditTieuDe.setError("");
                }else {
                    inputEditTieuDe.setErrorEnabled(true);
                    inputEditTieuDe.setError("Bạn chưa nhập tiêu đề");
                }

                if (noidung.trim().length() > 0){
                    inputEditNoiDung.setErrorEnabled(false);
                    inputEditNoiDung.setError("");
                }else {
                    inputEditNoiDung.setErrorEnabled(true);
                    inputEditNoiDung.setError("Bạn chưa nhập Nội dung");
                }
                if (!inputEditTieuDe.isErrorEnabled() && !inputEditNoiDung.isErrorEnabled() && sosao > 0){
                    danhGia = new DanhGia();
                    danhGia.setMADANHGIA(name);
                    danhGia.setMASP(masp);
                    danhGia.setTENTHIETBI(tenthietbi);
                    danhGia.setTIEUDE(tieude);
                    danhGia.setNOIDUNG(noidung);
                    danhGia.setSOSAO(sosao);
                    preDanhGia.ThemDanhGia(danhGia);
                }
                break;
            case R.id.btn_HuyDanhGia:
                finish();
                break;
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void hienThiDanhSachLoaiSanPham(List<LoaiSanPham> loaiSanPhamList) {

    }
}
