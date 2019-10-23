package com.t3h.lazada.Models.Objectclass;

import java.util.List;

public class KhuyenMai {
    private int MAKM,MALOAISP;
    private String NGAYBATDAU,NGAYKETTHUC,HINHKM,TENLOAISP,TENKM;
    private List<SanPham> DANHSACHSPKM;

    public String getTENKM() {
        return TENKM;
    }

    public void setTENKM(String TENKM) {
        this.TENKM = TENKM;
    }

    public String getTENLOAISP() {
        return TENLOAISP;
    }

    public void setTENLOAISP(String TENLOAISP) {
        this.TENLOAISP = TENLOAISP;
    }

    public int getMAKM() {
        return MAKM;
    }

    public void setMAKM(int MAKM) {
        this.MAKM = MAKM;
    }

    public int getMALOAISP() {
        return MALOAISP;
    }

    public void setMALOAISP(int MALOAISP) {
        this.MALOAISP = MALOAISP;
    }

    public String getNGAYBATDAU() {
        return NGAYBATDAU;
    }

    public void setNGAYBATDAU(String NGAYBATDAU) {
        this.NGAYBATDAU = NGAYBATDAU;
    }

    public String getNGAYKETTHUC() {
        return NGAYKETTHUC;
    }

    public void setNGAYKETTHUC(String NGAYKETTHUC) {
        this.NGAYKETTHUC = NGAYKETTHUC;
    }

    public String getHINHKM() {
        return HINHKM;
    }

    public void setHINHKM(String HINHKM) {
        this.HINHKM = HINHKM;
    }

    public List<SanPham> getDANHSACHSPKM() {
        return DANHSACHSPKM;
    }

    public void setDANHSACHSPKM(List<SanPham> DANHSACHSPKM) {
        this.DANHSACHSPKM = DANHSACHSPKM;
    }
}
