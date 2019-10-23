package com.t3h.lazada.Models.DanhGia;

import com.t3h.lazada.Activity.TrangChu.TrangChuActivity;
import com.t3h.lazada.Connect.DowdloadJSON;
import com.t3h.lazada.Models.Objectclass.DanhGia;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelDanhGia {
    public boolean ThemDanhGia(DanhGia danhGia){
        Boolean kiemtra = false;
        String duongdan = TrangChuActivity.SERVER_NAME;
        List<HashMap<String,String>> attrs = new ArrayList<>();
        HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham","ThemDanhGia");
        HashMap<String,String> hsMaDG = new HashMap<>();
        hsMaDG.put("madg",danhGia.getMADANHGIA());
        HashMap<String,String> hsMaSP = new HashMap<>();
        hsMaSP.put("masp",String.valueOf(danhGia.getMASP()));
        HashMap<String,String> hsTenThietBi = new HashMap<>();
        hsTenThietBi.put("tenthietbi",danhGia.getTENTHIETBI());
        HashMap<String,String> hsTieuDe = new HashMap<>();
        hsTieuDe.put("tieude",danhGia.getTIEUDE());
        HashMap<String,String> hsNoiDung = new HashMap<>();
        hsNoiDung.put("noidung",danhGia.getNOIDUNG());
        HashMap<String,String> hsSoSao = new HashMap<>();
        hsSoSao.put("sosao",String.valueOf(danhGia.getSOSAO()));

        attrs.add(hsHam);
        attrs.add(hsMaDG);
        attrs.add(hsMaSP);
        attrs.add(hsTenThietBi);
        attrs.add(hsTieuDe);
        attrs.add(hsNoiDung);
        attrs.add(hsSoSao);

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
