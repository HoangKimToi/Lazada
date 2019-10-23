package com.t3h.lazada.Presenter.KhuyenMai;

import com.t3h.lazada.Activity.TrangChu.ViewKhuyenMai;
import com.t3h.lazada.Models.KhuyenMai.ModelKhuyenMai;
import com.t3h.lazada.Models.Objectclass.KhuyenMai;

import java.util.List;

public class PreKhuyenMai implements PresenterKhuyenMai{
    private ViewKhuyenMai viewKhuyenMai;
    private ModelKhuyenMai modelKhuyenMai;
    public PreKhuyenMai(ViewKhuyenMai viewKhuyenMai){
        this.viewKhuyenMai = viewKhuyenMai;
        modelKhuyenMai = new ModelKhuyenMai();
    }
    @Override
    public void LayDanhSachKhuyenMai() {
        List<KhuyenMai> khuyenMaiList = modelKhuyenMai.LaySPKhuyenMai("LayDanhSachKhuyenMai","DANHSACHKHUYENMAI");
        if (khuyenMaiList.size() >0 ){
            viewKhuyenMai.HienThiDanhSachKM(khuyenMaiList);
        }
    }
}
