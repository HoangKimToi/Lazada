package com.t3h.lazada.Presenter.TrangChu;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.t3h.lazada.Activity.TrangChu.TrangChuActivity;
import com.t3h.lazada.Activity.TrangChu.ViewXuLyMenu;
import com.t3h.lazada.Connect.DowdloadJSON;
import com.t3h.lazada.Models.DangNhap.ModelsDangNhap;
import com.t3h.lazada.Models.Objectclass.LoaiSanPham;
import com.t3h.lazada.Models.TrangChu.XulyJSONMenu;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PreXuLyMenu implements IPresenterXuLyMenu{
    private ViewXuLyMenu viewXuLyMenu;

    public PreXuLyMenu(ViewXuLyMenu viewXuLyMenu){
        this.viewXuLyMenu=viewXuLyMenu;
    }
    @Override
    public void layDanhSachMenu() {
        List<LoaiSanPham> loaiSanPhamList;
        String dataJSON = "";
        List<HashMap<String,String>> attrs = new ArrayList<>();

        //Lấy bằng phương thức post
        String duongdan = TrangChuActivity.SERVER_NAME ;

        HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham","LayDanhSachMenu");

        HashMap<String,String> hsMaLoaiCha = new HashMap<>();
        hsMaLoaiCha.put("maloaicha","0");

        attrs.add(hsHam);
        attrs.add(hsMaLoaiCha);

        DowdloadJSON downloadJSON = new DowdloadJSON(duongdan,attrs);
        //end phương thức post
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();
            XulyJSONMenu xuLyJSONMenu = new XulyJSONMenu();
            loaiSanPhamList = xuLyJSONMenu.ParserJSONMenu(dataJSON);
            viewXuLyMenu.hienThiDanhSachLoaiSanPham(loaiSanPhamList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AccessToken layTokenUserFacebook() {
        AccessToken accessToken;
        ModelsDangNhap modelsDangNhap = new ModelsDangNhap();
        accessToken = modelsDangNhap.LayTokenFacebookHienTai();
        return accessToken;
    }

}
