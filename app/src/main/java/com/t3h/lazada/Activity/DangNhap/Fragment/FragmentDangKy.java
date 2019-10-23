package com.t3h.lazada.Activity.DangNhap.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.t3h.lazada.Activity.DangNhap.DangKy;
import com.t3h.lazada.Models.Objectclass.NhanVien;
import com.t3h.lazada.Presenter.DangKy.PreDangKy;
import com.t3h.lazada.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FragmentDangKy extends Fragment implements DangKy, View.OnClickListener, View.OnFocusChangeListener {
    private View view;
    private PreDangKy preDangKy;
    private Button btnDangKy;
    private EditText editHoTen,editEmail,editMatKhau,editNhapLaiMatKhau;
    private SwitchCompat addEmailDocQuyen;
    private TextInputLayout input_editHoTen,input_editEmail,input_editMatKhau,input_editLayLaiMatKhau;
    private Boolean KiemTraThongTin = false;

    private String emaildocquyen  = "";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dangky,container,false);
        iniView();
        return view;
    }

    private void iniView() {
        btnDangKy = view.findViewById(R.id.btn_dangky);
        editHoTen = view.findViewById(R.id.edit_HoTen);
        editMatKhau = view.findViewById(R.id.edit_password);
        editEmail = view.findViewById(R.id.edit_email);
        editNhapLaiMatKhau = view.findViewById(R.id.edit_NhapLaiPass);
        addEmailDocQuyen = view.findViewById(R.id.sw_emailDocQuyen);
        input_editHoTen = view.findViewById(R.id.input_editHoTen);
        input_editMatKhau = view.findViewById(R.id.input_editPassword);
        input_editEmail = view.findViewById(R.id.input_editEmail);
        input_editLayLaiMatKhau = view.findViewById(R.id.input_editNhapLaiPass);
        preDangKy = new PreDangKy(this);
        btnDangKy.setOnClickListener(this);
        editHoTen.setOnFocusChangeListener(this);
        editEmail.setOnFocusChangeListener(this);
        editMatKhau.setOnFocusChangeListener(this);
        editNhapLaiMatKhau.setOnFocusChangeListener(this);
    }

    @Override
    public void DangKyThanhCong() {
        Toast.makeText(getActivity(),"Đăng ký thành công",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void DangKyThatBai() {
        Toast.makeText(getActivity(),"Đăng ký thất bại",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_dangky:
                setBtnDangKy();
                break;
        }
    }
    private void setBtnDangKy(){
        String hoten  = editHoTen.getText().toString();
        String email  = editEmail.getText().toString();
        String matkhau  = editMatKhau.getText().toString();
        addEmailDocQuyen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                emaildocquyen = b +"";
            }
        });
        if (KiemTraThongTin){
            NhanVien nhanVien = new NhanVien();
            nhanVien.setTenNV(hoten);
            nhanVien.setTenDN(email);
            nhanVien.setMatKhau(matkhau);
            nhanVien.setEmailDocQuyen(emaildocquyen);
            nhanVien.setMaLoaiNV(2);
            preDangKy.ThucHienDangKy(nhanVien);
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()){
            case R.id.edit_HoTen:
                if (!b){
                    String chuoi = ((EditText)view).getText().toString();
                    if (chuoi.trim().equals("") || chuoi.equals(null)){
                        input_editHoTen.setErrorEnabled(true);
                        input_editHoTen.setError("Bạn chưa nhận mục này.");
                        KiemTraThongTin = false;
                    }else {
                        input_editHoTen.setErrorEnabled(false);
                        input_editHoTen.setError("");
                        KiemTraThongTin = true;
                    }
                }
                break;
            case R.id.edit_email:
                if (!b){
                    String chuoi = ((EditText)view).getText().toString();
                    if (chuoi.trim().equals("") || chuoi.equals(null)){
                        input_editEmail.setErrorEnabled(true);
                        input_editEmail.setError("Bạn chưa nhận mục này.");
                        KiemTraThongTin = false;
                    }else {
                        boolean ktEmail = Patterns.EMAIL_ADDRESS.matcher(chuoi).matches();
                        if (!ktEmail){
                            input_editEmail.setErrorEnabled(true);
                            input_editEmail.setError("Đây không phải địa chỉ email.");
                            KiemTraThongTin = false;
                        }else {
                            input_editEmail.setErrorEnabled(false);
                            input_editEmail.setError("");
                            KiemTraThongTin = true;
                        }
                    }
                }
                break;
            case R.id.edit_password:
                if (!b){
                    String MATCHER_PATTREN = "((?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{6,20})";
                    String arr = ((EditText)view).getText().toString();
                    Pattern pattern = Pattern.compile(MATCHER_PATTREN);
                    Matcher matcher = pattern.matcher(arr);
                    if (!matcher.matches()){
                        input_editMatKhau.setErrorEnabled(true);
                        input_editMatKhau.setError("Mật khẩu phải ít nhất 6 ký tự và 1 chữ hoa,Số.");
                        KiemTraThongTin = false;
                    }else {
                        input_editMatKhau.setErrorEnabled(false);
                        input_editMatKhau.setError("");
                        KiemTraThongTin = true;
                    }
                }
                break;
            case R.id.edit_NhapLaiPass:
                if (!b){
                    String chuoi = ((EditText)view).getText().toString();
                    String matkhau = editMatKhau.getText().toString();
                    if (!chuoi.equals(matkhau)){
                        input_editLayLaiMatKhau.setErrorEnabled(true);
                        input_editLayLaiMatKhau.setError("Mật khẩu không đúng.");
                        KiemTraThongTin = false;
                    }else {
                        input_editLayLaiMatKhau.setErrorEnabled(false);
                        input_editLayLaiMatKhau.setError("");
                        KiemTraThongTin = true;
                    }
                }
                break;
        }
    }
}
