package com.t3h.lazada.Models.KhuyenMai;

import com.t3h.lazada.Activity.TrangChu.TrangChuActivity;
import com.t3h.lazada.Connect.DowdloadJSON;
import com.t3h.lazada.Models.Objectclass.ChiTietKhuyenMai;
import com.t3h.lazada.Models.Objectclass.KhuyenMai;
import com.t3h.lazada.Models.Objectclass.SanPham;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelKhuyenMai {
    public List<KhuyenMai> LaySPKhuyenMai(String tenHam,String tenMang){
        List<KhuyenMai> khuyenMaiList = new ArrayList<>();
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
            JSONArray JSONdanhsachKM = jsonObject.getJSONArray(tenMang);
            int dem = JSONdanhsachKM.length();
            for (int i = 0; i < dem; i++) {
                JSONObject object = JSONdanhsachKM.getJSONObject(i);
                KhuyenMai khuyenMai = new KhuyenMai();
                khuyenMai.setMAKM(object.getInt("MAKM"));
                khuyenMai.setTENLOAISP(object.getString("TENLOAISP"));
                khuyenMai.setTENKM(object.getString("TENKM"));
                khuyenMai.setHINHKM(TrangChuActivity.SERVER + object.getString("HINHKHUYENMAI"));

                List<SanPham> sanPhamList = new ArrayList<>();
                JSONArray arrayDANHKM = object.getJSONArray("DANHSACHSPKHUYENMAI");
                int demsp = arrayDANHKM.length();
                for (int j = 0; j < demsp; j++) {
                    JSONObject objectKM = arrayDANHKM.getJSONObject(j);
                    SanPham sanPham = new SanPham();
                    sanPham.setMASP(objectKM.getInt("MASP"));
                    sanPham.setTENSANPHAM(objectKM.getString("TENSP"));
                    sanPham.setGIA(objectKM.getInt("GIA"));
                    sanPham.setANHLON(TrangChuActivity.SERVER + objectKM.getString("ANHLON"));
                    sanPham.setANHNHO(TrangChuActivity.SERVER + objectKM.getString("ANHNHO"));
                    ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai();
                    chiTietKhuyenMai.setPHANTRAMKM(objectKM.getInt("PHANTRAMKM"));
                    sanPham.setChiTietKhuyenMai(chiTietKhuyenMai);
                    sanPhamList.add(sanPham);
                }
                khuyenMai.setDANHSACHSPKM(sanPhamList);
                khuyenMaiList.add(khuyenMai);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return khuyenMaiList;
    }
}
