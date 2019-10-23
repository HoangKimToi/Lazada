package com.t3h.lazada.Presenter.DanhGia;

import com.t3h.lazada.Activity.DanhGia.ViewDanhGia;
import com.t3h.lazada.Models.DanhGia.ModelDanhGia;
import com.t3h.lazada.Models.Objectclass.DanhGia;

public class PreDanhGia implements IPresenterDanhGia{
    private ViewDanhGia viewDanhGia;
    private ModelDanhGia modelDanhGia;
    public PreDanhGia(ViewDanhGia viewDanhGia){
        this.viewDanhGia=viewDanhGia;
        modelDanhGia = new ModelDanhGia();
    }

    @Override
    public void ThemDanhGia(DanhGia danhGia) {
        boolean kiemtra = modelDanhGia.ThemDanhGia(danhGia);
        if (kiemtra){
            viewDanhGia.DanhGiaThanhCong();
        }else {
            viewDanhGia.DanhGiaThatBai();
        }
    }
}
