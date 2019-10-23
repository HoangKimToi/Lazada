package com.t3h.lazada.Presenter.DangKy;

import com.t3h.lazada.Activity.DangNhap.DangKy;
import com.t3h.lazada.Models.DangNhap.ModelDangKy;
import com.t3h.lazada.Models.Objectclass.NhanVien;

public class PreDangKy implements iPresenterDangKy{
    private DangKy dangKy;
    private ModelDangKy modelDangKy;
    public PreDangKy(DangKy dangKy){
        this.dangKy =dangKy;
        this.modelDangKy = new ModelDangKy();
    }
    @Override
    public void ThucHienDangKy(NhanVien nhanVien) {
        boolean kiemtra = modelDangKy.DangKyThanhVien(nhanVien);
        if (kiemtra){
            dangKy.DangKyThanhCong();
        }else {
            dangKy.DangKyThatBai();
        }
    }
}
