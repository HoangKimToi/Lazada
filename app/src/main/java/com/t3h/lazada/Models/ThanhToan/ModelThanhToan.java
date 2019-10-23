package com.t3h.lazada.Models.ThanhToan;

import com.t3h.lazada.Activity.TrangChu.TrangChuActivity;
import com.t3h.lazada.Connect.DowdloadJSON;
import com.t3h.lazada.Models.Objectclass.ChiTietHoaDon;
import com.t3h.lazada.Models.Objectclass.HoaDon;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelThanhToan {
    public boolean ThemHoaDon(HoaDon hoaDon){
        boolean kiemtra = false;
        String duongdan = TrangChuActivity.SERVER_NAME;
        List<HashMap<String,String>> attrs = new ArrayList<>();
        HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham","ThemHoaDon");

        List<ChiTietHoaDon> chiTietHoaDonList = hoaDon.getChiTietHoaDonList();
        String chuoijson = "{\"DANHSACHSP\" :[ ";
        for (int i=0; i<chiTietHoaDonList.size();i++){
            chuoijson += "{";
            chuoijson += "\"masp\" : " + chiTietHoaDonList.get(i).getMASP() + ",";
            chuoijson += "\"soluong\" : " + chiTietHoaDonList.get(i).getSOLUONG();

            if(i==chiTietHoaDonList.size() -1 ){
                chuoijson += "}";
            }else{
                chuoijson += "},";
            }

        }
        chuoijson += "]}";
        HashMap<String,String> hsDanhSachSP = new HashMap<>();
        hsDanhSachSP.put("danhsachsanpham",chuoijson);
        HashMap<String,String> hsTenNguoiNhan = new HashMap<>();
        hsTenNguoiNhan.put("tennguoinhan",hoaDon.getTenNguoiNhan());
        HashMap<String,String> hsSoDT = new HashMap<>();
        hsSoDT.put("sodt",String.valueOf(hoaDon.getSoDT()));
        HashMap<String,String> hsDiaChi = new HashMap<>();
        hsDiaChi.put("diachi",hoaDon.getDiaChi());
        HashMap<String,String> hsChuyenKhoan = new HashMap<>();
        hsChuyenKhoan.put("chuyenkhoan",String.valueOf(hoaDon.getChuyenKhoan()));

        attrs.add(hsHam);
        attrs.add(hsDanhSachSP);
        attrs.add(hsTenNguoiNhan);
        attrs.add(hsSoDT);
        attrs.add(hsDiaChi);
        attrs.add(hsChuyenKhoan);

        DowdloadJSON dowdloadJSON = new DowdloadJSON(duongdan,attrs);
        dowdloadJSON.execute();
        try {
            String dulieuJSON = dowdloadJSON.get();
            JSONObject jsonObject = new JSONObject(dulieuJSON);
            String ketqua = jsonObject.getString("ketqua");
            if (ketqua.equals("true")){
                kiemtra =  true;
            }else{
                kiemtra =  false;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return kiemtra;
    }
}
