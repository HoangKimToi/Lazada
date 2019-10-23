package com.t3h.lazada.Presenter.ShowSPTheoDanhMuc;

import android.view.View;
import android.widget.ProgressBar;

import com.t3h.lazada.Activity.TrangChu.HienThiSPTheoDanhMuc;
import com.t3h.lazada.Models.Objectclass.SanPham;
import com.t3h.lazada.Models.ShowSPTheoDanhMuc.ModelShowTheoDanhMuc;

import java.util.ArrayList;
import java.util.List;

public class PreShowTheoDanhMuc implements IPresenterShowTheoDanhMuc {
    private HienThiSPTheoDanhMuc hienThiSPTheoDanhMuc;
    private ModelShowTheoDanhMuc modelShowTheoDanhMuc;
    public PreShowTheoDanhMuc(HienThiSPTheoDanhMuc hienThiSPTheoDanhMuc){
        this.hienThiSPTheoDanhMuc=hienThiSPTheoDanhMuc;
        modelShowTheoDanhMuc = new ModelShowTheoDanhMuc();
    }
    @Override
    public void LayDanhSachSPTheoMaLoai(int maloai,boolean kiemtra) {
        List<SanPham> sanPhamList = new ArrayList<>();
        if (kiemtra){
            sanPhamList = modelShowTheoDanhMuc.LaySPTheoMaDanhMuc(maloai,"LayDanhSachSPTheoMaLoaiThuongHieu","DANHSACHSANPHAM",0);
        }else {
            sanPhamList = modelShowTheoDanhMuc.LaySPTheoMaDanhMuc(maloai,"LayDanhSachSPTheoMaLoaiDanhMuc","DANHSACHSANPHAM",0);
        }
        if (sanPhamList.size() > 0 ){
            hienThiSPTheoDanhMuc.HienThiDanhSachSP(sanPhamList);
        }else {
            hienThiSPTheoDanhMuc.LoiHienThiDanhSachSP();
        }
    }
    public List<SanPham> LayDanhSachSPTheoMaLoaiLoadMore(int maloai, boolean kiemtra, int limit, ProgressBar progressBar){
        progressBar.setVisibility(View.VISIBLE);
        List<SanPham> sanPhamList = new ArrayList<>();
        if (kiemtra){
            sanPhamList = modelShowTheoDanhMuc.LaySPTheoMaDanhMuc(maloai,"LayDanhSachSPTheoMaLoaiThuongHieu","DANHSACHSANPHAM",limit);
        }else {
            sanPhamList = modelShowTheoDanhMuc.LaySPTheoMaDanhMuc(maloai,"LayDanhSachSPTheoMaLoaiDanhMuc","DANHSACHSANPHAM",limit);
        }
        if (sanPhamList.size() != 0 ){
            progressBar.setVisibility(View.GONE);
        }
        return sanPhamList;
    }
}
