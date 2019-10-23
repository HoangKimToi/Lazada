package com.t3h.lazada.Models.GioHang;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.t3h.lazada.Models.Objectclass.SanPham;

import java.util.ArrayList;
import java.util.List;

public class ModelGioHang {
    private SQLiteDatabase database;
    public void MoKetNoiSQL(Context context){
        DataSanPham dataSanPham = new DataSanPham(context);
        database = dataSanPham.getWritableDatabase();
    }
    public boolean ThemGioHang(SanPham sanPham){
        ContentValues values = new ContentValues();
        values.put(DataSanPham.TB_GioHang_MASP,sanPham.getMASP());
        values.put(DataSanPham.TB_GioHang_TENSP,sanPham.getTENSANPHAM());
        values.put(DataSanPham.TB_GioHang_GIATIEN,sanPham.getGIA());
        values.put(DataSanPham.TB_GioHang_HINHANH,sanPham.getHinhGioHang());
        values.put(DataSanPham.TB_GioHang_SOLUONG,sanPham.getSOLUONG());
        values.put(DataSanPham.TB_GioHang_SOLUONG_TONKHO,sanPham.getSOLUONGTONKHO());

        long id = database.insert(DataSanPham.TB_GioHang,null,values);
        if (id>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean CapNhatSoLuong(int masp,int soluong){
        ContentValues values = new ContentValues();
        values.put(DataSanPham.TB_GioHang_SOLUONG,soluong);
        int id = database.update(DataSanPham.TB_GioHang,values,DataSanPham.TB_GioHang_MASP + "="+masp,null);
        if (id>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean XoaSPGioHang(int masp){
        int kiemtra = database.delete(DataSanPham.TB_GioHang,DataSanPham.TB_GioHang_MASP + "=" + masp,null);
        if (kiemtra>0){
            return true;
        }else {
            return false;
        }
    }
    public List<SanPham> LayDanhSachGioHang(){
        List<SanPham> sanPhams = new ArrayList<>();
        String truyvan = "SELECT * FROM " + DataSanPham.TB_GioHang;
        Cursor cursor = database.rawQuery(truyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int masp = cursor.getInt(cursor.getColumnIndex(DataSanPham.TB_GioHang_MASP));
            String tensp = cursor.getString(cursor.getColumnIndex(DataSanPham.TB_GioHang_TENSP));
            int giatien = cursor.getInt(cursor.getColumnIndex(DataSanPham.TB_GioHang_GIATIEN));
            int soluong = cursor.getInt(cursor.getColumnIndex(DataSanPham.TB_GioHang_SOLUONG));
            int soluongtonkho = cursor.getInt(cursor.getColumnIndex(DataSanPham.TB_GioHang_SOLUONG_TONKHO));
            byte[] hinhanh = cursor.getBlob(cursor.getColumnIndex(DataSanPham.TB_GioHang_HINHANH));

            SanPham sanPham = new SanPham();
            sanPham.setMASP(masp);
            sanPham.setTENSANPHAM(tensp);
            sanPham.setGIA(giatien);
            sanPham.setHinhGioHang(hinhanh);
            sanPham.setSOLUONG(soluong);
            sanPham.setSOLUONGTONKHO(soluongtonkho);
            sanPhams.add(sanPham);
            cursor.moveToNext();
        }
        return sanPhams;
    }
}
