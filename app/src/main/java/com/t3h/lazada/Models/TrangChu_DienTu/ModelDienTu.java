package com.t3h.lazada.Models.TrangChu_DienTu;

import com.t3h.lazada.Activity.TrangChu.TrangChuActivity;
import com.t3h.lazada.Connect.DowdloadJSON;
import com.t3h.lazada.Models.Objectclass.SanPham;
import com.t3h.lazada.Models.Objectclass.ThuongHieu;
import com.t3h.lazada.Models.TrangChu.XulyJSONMenu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelDienTu {
    public List<SanPham> LayDanhSachSanPhamTop(String tenHam,String tenChuoiJson){
        List<SanPham> sanPhamList = new ArrayList<>();
        List<HashMap<String,String>> attrs = new ArrayList<>();
        String dataJSON = "";
        String duongdan = TrangChuActivity.SERVER_NAME;
        HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham",tenHam);

        attrs.add(hsHam);
        DowdloadJSON dowdloadJSON = new DowdloadJSON(duongdan,attrs);
        dowdloadJSON.execute();
        try {
            dataJSON = dowdloadJSON.get();
            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray JSONdanhsachSPTOP = jsonObject.getJSONArray(tenChuoiJson);
            int dem = JSONdanhsachSPTOP.length();
            for (int i = 0; i < dem; i++) {
                SanPham sanPham = new SanPham();
                JSONObject object = JSONdanhsachSPTOP.getJSONObject(i);
                sanPham.setMASP(object.getInt("MASP"));
                sanPham.setTENSANPHAM(object.getString("TENSP"));
                sanPham.setGIA(object.getInt("GIATIEN"));
                sanPham.setANHLON(object.getString("HINHSP"));
                sanPhamList.add(sanPham);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sanPhamList;
    }
    public List<ThuongHieu> LayDanhSachThuongHieuLon(String tenHam,String tenChuoiJson){
        List<ThuongHieu> thuongHieuList = new ArrayList<>();
        List<HashMap<String,String>> attrs = new ArrayList<>();
        String dataJSON = "";
        String duongdan = TrangChuActivity.SERVER_NAME;
        HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham",tenHam);

        attrs.add(hsHam);
        DowdloadJSON dowdloadJSON = new DowdloadJSON(duongdan,attrs);
        dowdloadJSON.execute();
        try {
            dataJSON = dowdloadJSON.get();
            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray JSONdanhsachthuonghieu = jsonObject.getJSONArray(tenChuoiJson);
            int dem = JSONdanhsachthuonghieu.length();
            for (int i = 0; i < dem; i++) {
                ThuongHieu thuongHieu = new ThuongHieu();
                JSONObject object = JSONdanhsachthuonghieu.getJSONObject(i);
                thuongHieu.setMATHUONGHIEU(object.getInt("MASP"));
                thuongHieu.setTENTHUONGHIEU(object.getString("TENSP"));
                thuongHieu.setHINHTHUONGHIEU(object.getString("HINHSP"));
                thuongHieuList.add(thuongHieu);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return thuongHieuList;
    }
}
