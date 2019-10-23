package com.t3h.lazada.Models.NoiBat;

import com.t3h.lazada.Activity.TrangChu.TrangChuActivity;
import com.t3h.lazada.Connect.DowdloadJSON;
import com.t3h.lazada.Models.Objectclass.ChiTietKhuyenMai;
import com.t3h.lazada.Models.Objectclass.SanPham;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelNoiBat {
    public List<SanPham> LaySPNoiBat(String tenHam, String tenChuoiJson, int limit){
        List<SanPham> sanPhamList = new ArrayList<>();
        List<HashMap<String,String>> attrs = new ArrayList<>();
        String dataJSON = "";
        String duongdan = TrangChuActivity.SERVER_NAME;
        HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham",tenHam);

        HashMap<String,String> hsLimit = new HashMap<>();
        hsLimit.put("limit",String.valueOf(limit));

        attrs.add(hsHam);

        attrs.add(hsLimit);
        DowdloadJSON dowdloadJSON = new DowdloadJSON(duongdan,attrs);
        dowdloadJSON.execute();
        try {
            dataJSON = dowdloadJSON.get();
            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray JSONNOIBAT = jsonObject.getJSONArray(tenChuoiJson);
            int dem = JSONNOIBAT.length();
            for (int i = 0; i < dem; i++) {
                SanPham sanPham = new SanPham();
                JSONObject object = JSONNOIBAT.getJSONObject(i);
                sanPham.setMASP(object.getInt("MASP"));
                sanPham.setTENSANPHAM(object.getString("TENSP"));
                sanPham.setGIA(object.getInt("GIATIEN"));
                sanPham.setANHLON(TrangChuActivity.SERVER + object.getString("HINHSP"));
                sanPham.setANHNHO(TrangChuActivity.SERVER + object.getString("HINHSPNHO"));
                sanPham.setMANV(object.getInt("MANV"));
                ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai();
                chiTietKhuyenMai.setPHANTRAMKM(object.getInt("PHANTRAMKM"));
                sanPham.setChiTietKhuyenMai(chiTietKhuyenMai);
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
}
