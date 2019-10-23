package com.t3h.lazada.Activity.TrangChu;

import com.t3h.lazada.Models.Objectclass.DanhGia;
import com.t3h.lazada.Models.Objectclass.SanPham;

import java.util.List;

public interface ViewDetailSanPham {
    void HienChiTietSanPham(SanPham sanPham);
    void HienThiSlideSanPham(String[] linkHinhSP);
    void HienThiDanhGia(List<DanhGia> danhGiaList);
    void ThemGioHangThanhCong();
    void ThemGioHangThatBai();
}
