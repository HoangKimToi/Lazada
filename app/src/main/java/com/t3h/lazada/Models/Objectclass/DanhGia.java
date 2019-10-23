package com.t3h.lazada.Models.Objectclass;

import java.io.Serializable;

public class DanhGia implements Serializable {
    private String MADANHGIA,TENTHIETBI,TIEUDE,NOIDUNG,NGAYDANHGIA;
    private int MASP;
    private float SOSAO;

    public String getMADANHGIA() {
        return MADANHGIA;
    }

    public void setMADANHGIA(String MADANHGIA) {
        this.MADANHGIA = MADANHGIA;
    }

    public String getTENTHIETBI() {
        return TENTHIETBI;
    }

    public void setTENTHIETBI(String TENTHIETBI) {
        this.TENTHIETBI = TENTHIETBI;
    }

    public String getTIEUDE() {
        return TIEUDE;
    }

    public void setTIEUDE(String TIEUDE) {
        this.TIEUDE = TIEUDE;
    }

    public String getNOIDUNG() {
        return NOIDUNG;
    }

    public void setNOIDUNG(String NOIDUNG) {
        this.NOIDUNG = NOIDUNG;
    }

    public String getNGAYDANHGIA() {
        return NGAYDANHGIA;
    }

    public void setNGAYDANHGIA(String NGAYDANHGIA) {
        this.NGAYDANHGIA = NGAYDANHGIA;
    }

    public float getSOSAO() {
        return SOSAO;
    }

    public void setSOSAO(float SOSAO) {
        this.SOSAO = SOSAO;
    }

    public int getMASP() {
        return MASP;
    }

    public void setMASP(int MASP) {
        this.MASP = MASP;
    }
}
