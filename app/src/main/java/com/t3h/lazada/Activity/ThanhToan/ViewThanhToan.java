package com.t3h.lazada.Activity.ThanhToan;

import com.t3h.lazada.Models.Objectclass.SanPham;

import java.util.List;

public interface ViewThanhToan {
    void ThanhToanThanhCong();
    void ThanhToanThatBai();
    void LayDanhSachSPTrongGioHang(List<SanPham> sanPhams);
}
