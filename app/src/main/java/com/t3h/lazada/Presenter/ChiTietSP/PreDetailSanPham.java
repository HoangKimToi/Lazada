package com.t3h.lazada.Presenter.ChiTietSP;


import android.content.Context;

import com.t3h.lazada.Activity.TrangChu.ViewDetailSanPham;
import com.t3h.lazada.Models.ChiTietSanPham.ModelChiTietSP;
import com.t3h.lazada.Models.GioHang.ModelGioHang;
import com.t3h.lazada.Models.Objectclass.DanhGia;
import com.t3h.lazada.Models.Objectclass.SanPham;

import java.util.List;

public class PreDetailSanPham implements PresenterDetailSP {
    private ViewDetailSanPham detailSanPham;
    private ModelChiTietSP modelChiTietSP;
    private ModelGioHang modelGioHang;
    public PreDetailSanPham(){
        modelGioHang = new ModelGioHang();
    }
    public PreDetailSanPham(ViewDetailSanPham detailSanPham){
        this.detailSanPham = detailSanPham;
        modelChiTietSP = new ModelChiTietSP();
        modelGioHang = new ModelGioHang();
    }
    @Override
    public void LayChiTietSanPham(int masp) {
        SanPham sanPham = modelChiTietSP.LayChiTietSanPham("LayChiTietSanPhamTheoMaSP","LayChiTietSanPhamTheoMaSP",masp);
        if (sanPham.getMASP() > 0 ){
            String[] link = sanPham.getANHNHO().split(",");
            detailSanPham.HienThiSlideSanPham(link);
            detailSanPham.HienChiTietSanPham(sanPham);
        }
    }

    @Override
    public void LayDanhSachDanhGiaCuaSP(int masp, int limit) {
        List<DanhGia> danhGiaList = modelChiTietSP.LayDanhGiaCuaSanPham(masp,limit);
        if (danhGiaList.size()>0){
            detailSanPham.HienThiDanhGia(danhGiaList);
        }
    }

    @Override
    public void ThemGioHang(SanPham sanPham, Context context) {
        modelGioHang.MoKetNoiSQL(context);
        boolean kiemtra = modelGioHang.ThemGioHang(sanPham);
        if (kiemtra){
            detailSanPham.ThemGioHangThanhCong();
        }else {
            detailSanPham.ThemGioHangThatBai();
        }
    }
    public int DemGioHang(Context context){
        modelGioHang.MoKetNoiSQL(context);
        List<SanPham> sanPhams = modelGioHang.LayDanhSachGioHang();
        int dem = sanPhams.size();
        return dem;
    }
}
