package com.t3h.lazada.Presenter.ChiTietSP;

import android.content.Context;

import com.t3h.lazada.Models.Objectclass.SanPham;

public interface PresenterDetailSP {
    void LayChiTietSanPham(int masp);
    void LayDanhSachDanhGiaCuaSP(int masp,int limit);
    void ThemGioHang(SanPham sanPham, Context context);
}
