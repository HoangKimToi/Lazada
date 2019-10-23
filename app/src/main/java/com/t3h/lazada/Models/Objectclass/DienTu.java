package com.t3h.lazada.Models.Objectclass;

import java.util.List;

public class DienTu {
    private List<ThuongHieu> thuongHieus;
    private List<SanPham> sanPhams;
    private String tenDienTu,tenTopDienTu;
    private Boolean thuonghieu;

    public Boolean getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(Boolean thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public String getTenDienTu() {
        return tenDienTu;
    }

    public void setTenDienTu(String tenDienTu) {
        this.tenDienTu = tenDienTu;
    }

    public String getTenTopDienTu() {
        return tenTopDienTu;
    }

    public void setTenTopDienTu(String tenTopDienTu) {
        this.tenTopDienTu = tenTopDienTu;
    }

    public List<ThuongHieu> getThuongHieus() {
        return thuongHieus;
    }

    public void setThuongHieus(List<ThuongHieu> thuongHieus) {
        this.thuongHieus = thuongHieus;
    }

    public List<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(List<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }
}
