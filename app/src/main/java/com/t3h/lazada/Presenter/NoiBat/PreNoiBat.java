package com.t3h.lazada.Presenter.NoiBat;

import com.t3h.lazada.Activity.TrangChu.ViewNoiBat;
import com.t3h.lazada.Models.NoiBat.ModelNoiBat;
import com.t3h.lazada.Models.Objectclass.SanPham;

import java.util.List;

public class PreNoiBat implements PresentNoiBat{
    private ViewNoiBat viewNoiBat;
    private ModelNoiBat modelNoiBat;
    public PreNoiBat(ViewNoiBat viewNoiBat){
        this.viewNoiBat = viewNoiBat;
        modelNoiBat = new ModelNoiBat();
    }

    @Override
    public void LayDanhSachNoiBat(int limit) {
        List<SanPham> sanPhamList = modelNoiBat.LaySPNoiBat("LayDanhSachNoiBat","DANHSACHNOIBAT",limit);
        if (sanPhamList.size() > 0 ){
            viewNoiBat.HienThiSPNoiBat(sanPhamList);
        }
    }
}
