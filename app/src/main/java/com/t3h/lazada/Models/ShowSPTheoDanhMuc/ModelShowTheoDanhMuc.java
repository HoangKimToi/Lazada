package com.t3h.lazada.Models.ShowSPTheoDanhMuc;

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

public class ModelShowTheoDanhMuc {
    public List<SanPham> LaySPTheoMaDanhMuc(int masp,String tenHam,String tenChuoiJson,int limit){
        List<SanPham> sanPhamList = new ArrayList<>();
        List<HashMap<String,String>> attrs = new ArrayList<>();
        String dataJSON = "";
        String duongdan = TrangChuActivity.SERVER_NAME;
        HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham",tenHam);
        HashMap<String,String> hsLoaiSP = new HashMap<>();
        hsLoaiSP.put("maloaisp",String.valueOf(masp));
        HashMap<String,String> hsLimit = new HashMap<>();
        hsLimit.put("limit",String.valueOf(limit));

        attrs.add(hsLimit);
        attrs.add(hsLoaiSP);
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
