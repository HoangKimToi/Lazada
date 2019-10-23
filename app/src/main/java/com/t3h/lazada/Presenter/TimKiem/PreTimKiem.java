package com.t3h.lazada.Presenter.TimKiem;

import com.t3h.lazada.Activity.TimKiem.ViewTimKiem;
import com.t3h.lazada.Models.Objectclass.SanPham;
import com.t3h.lazada.Models.TimKiem.ModelTimKiem;

import java.util.List;

public class PreTimKiem implements IPresenterTimKiem {
    private ViewTimKiem viewTimKiem;
    private ModelTimKiem modelTimKiem;
    public PreTimKiem(ViewTimKiem viewTimKiem){
        this.viewTimKiem = viewTimKiem;
        modelTimKiem = new ModelTimKiem();

    }
    @Override
    public void TimKiemSPTheoTenSP(String tensp, int limit) {
        List<SanPham> sanPhamList = modelTimKiem.LaySPTheoMaDanhMuc(tensp,"TimKiemSanPhamTheoTenSP","DANHSACHSANPHAM",limit);
        if (sanPhamList.size()>0){
            viewTimKiem.TimKiemThanhCong(sanPhamList);
        }else {
            viewTimKiem.TimKiemThatBai();
        }
    }
}
