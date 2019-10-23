package com.t3h.lazada.Presenter.GioHang;

import android.content.Context;

import com.t3h.lazada.Activity.GioHang.ViewGioHang;
import com.t3h.lazada.Models.GioHang.ModelGioHang;
import com.t3h.lazada.Models.Objectclass.SanPham;

import java.util.List;

public class PreGioHang implements IPresenterGioHang {
    private ModelGioHang modelGioHang;
    private ViewGioHang viewGioHang;
    public PreGioHang(ViewGioHang viewGioHang){
        this.viewGioHang = viewGioHang;
        modelGioHang = new ModelGioHang();
    }
    @Override
    public void LayDanhSachSanPhamTrongGioHang(Context context) {
        modelGioHang.MoKetNoiSQL(context);
        List<SanPham> sanPhamList = modelGioHang.LayDanhSachGioHang();
        if (sanPhamList.size()>0){
            viewGioHang.HinhThiDanhSachGioHang(sanPhamList);
        }
    }
}
