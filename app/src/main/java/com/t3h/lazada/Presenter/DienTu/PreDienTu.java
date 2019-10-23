package com.t3h.lazada.Presenter.DienTu;

import android.content.Context;

import com.t3h.lazada.Activity.TrangChu.ViewDienTu;
import com.t3h.lazada.Models.Objectclass.DienTu;
import com.t3h.lazada.Models.Objectclass.SanPham;
import com.t3h.lazada.Models.Objectclass.ThuongHieu;
import com.t3h.lazada.Models.TrangChu_DienTu.ModelDienTu;
import com.t3h.lazada.Untils.DialogUntil;

import java.util.ArrayList;
import java.util.List;

public class PreDienTu implements IPresenterDienTu{
    private ViewDienTu viewDienTu;
    private ModelDienTu modelDienTu;
    private Context context;
    public PreDienTu(ViewDienTu viewDienTu,Context context){
        this.context = context;
        this.viewDienTu = viewDienTu;
        modelDienTu = new ModelDienTu();
    }
    @Override
    public void LayDanhSachDienTu() {
        DialogUntil.ShowDialog(context);
        List<DienTu> dienTuList = new ArrayList<>();
        List<ThuongHieu> thuongHieus = modelDienTu.LayDanhSachThuongHieuLon("LayDanhSachThuongHieuLon","DANHSACHTHUONGHIEU");
        List<SanPham> sanPhams = modelDienTu.LayDanhSachSanPhamTop("LayDanhSachTopDTVaMayTinhBang","DanhSachTopDTVaMayTinhBang");

        DienTu dienTu = new DienTu();
        dienTu.setSanPhams(sanPhams);
        dienTu.setThuongHieus(thuongHieus);
        dienTu.setTenDienTu("Danh sách thương hiệu lớn");
        dienTu.setTenTopDienTu("Top điện thoại và máy tính bảng");
        dienTu.setThuonghieu(true);
        dienTuList.add(dienTu);

        List<SanPham> topPhukienList = modelDienTu.LayDanhSachSanPhamTop("LayDanhSachTopPhuKien","LayDanhSachTopPhuKien");
        List<ThuongHieu> phukienList = modelDienTu.LayDanhSachThuongHieuLon("LayDanhSachPhuKien","LayDanhSachPhuKien");

        DienTu dienTu1 = new DienTu();
        dienTu1.setSanPhams(topPhukienList);
        dienTu1.setThuongHieus(phukienList);
        dienTu1.setTenDienTu("Phụ kiện");
        dienTu1.setTenTopDienTu("Top Phụ kiện");
        dienTu1.setThuonghieu(false);
        dienTuList.add(dienTu1);

        List<SanPham> topTienIchList = modelDienTu.LayDanhSachSanPhamTop("LayDanhSachTopTienIch","LayDanhSachTopTienIch");
        List<ThuongHieu> TienIchList = modelDienTu.LayDanhSachThuongHieuLon("LayDanhSachTienIch","LayDanhSachTienIch");

        DienTu dienTu2 = new DienTu();
        dienTu2.setSanPhams(topTienIchList);
        dienTu2.setThuongHieus(TienIchList);
        dienTu2.setThuonghieu(false);
        dienTu2.setTenDienTu("Tiện ích");
        dienTu2.setTenTopDienTu("Top tiện ích");
        dienTuList.add(dienTu2);

        if (dienTuList.size() > 0 ){
            DialogUntil.dissmissProgress();
            viewDienTu.HienThiDanhSachDienTu(dienTuList);
        }
    }

}
