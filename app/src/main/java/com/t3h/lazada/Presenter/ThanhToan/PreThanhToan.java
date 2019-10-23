package com.t3h.lazada.Presenter.ThanhToan;

import android.content.Context;

import com.t3h.lazada.Activity.ThanhToan.ViewThanhToan;
import com.t3h.lazada.Models.GioHang.ModelGioHang;
import com.t3h.lazada.Models.Objectclass.HoaDon;
import com.t3h.lazada.Models.Objectclass.SanPham;
import com.t3h.lazada.Models.ThanhToan.ModelThanhToan;

import java.util.List;

public class PreThanhToan implements PresenterThanhToan {
    private ViewThanhToan viewThanhToan;
    private ModelThanhToan modelThanhToan;
    private ModelGioHang modelGioHang;
    private List<SanPham> sanPhamList;
    private Context context;
    public PreThanhToan(ViewThanhToan viewThanhToan,Context context){
        this.context = context;
        this.viewThanhToan = viewThanhToan;
        modelThanhToan = new ModelThanhToan();
        modelGioHang = new ModelGioHang();
        modelGioHang.MoKetNoiSQL(context);
    }
    @Override
    public void ThemHoaDon(HoaDon hoaDon) {
        boolean kiemtra = modelThanhToan.ThemHoaDon(hoaDon);
        if (kiemtra){
            viewThanhToan.ThanhToanThanhCong();
            int dem = sanPhamList.size();
            for (int i = 0; i < dem; i++) {
                modelGioHang.XoaSPGioHang(sanPhamList.get(i).getMASP());
            }
        }else {
            viewThanhToan.ThanhToanThatBai();
        }
    }

    @Override
    public void LayDanhSachSPTrongGioHang() {
        sanPhamList = modelGioHang.LayDanhSachGioHang();
        viewThanhToan.LayDanhSachSPTrongGioHang(sanPhamList);
    }

}
