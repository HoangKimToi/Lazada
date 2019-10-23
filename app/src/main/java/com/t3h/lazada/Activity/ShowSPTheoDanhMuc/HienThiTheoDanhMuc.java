package com.t3h.lazada.Activity.ShowSPTheoDanhMuc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.lazada.Activity.GioHang.GioHangActivity;
import com.t3h.lazada.Activity.TrangChu.HienThiSPTheoDanhMuc;
import com.t3h.lazada.Adapter.AdapterTopDienThoai;
import com.t3h.lazada.Models.Objectclass.ILoadMore;
import com.t3h.lazada.Models.Objectclass.LoadMoreScroll;
import com.t3h.lazada.Models.Objectclass.SanPham;
import com.t3h.lazada.Presenter.ChiTietSP.PreDetailSanPham;
import com.t3h.lazada.Presenter.ShowSPTheoDanhMuc.PreShowTheoDanhMuc;
import com.t3h.lazada.R;

import java.util.List;

public class HienThiTheoDanhMuc extends Fragment implements HienThiSPTheoDanhMuc, View.OnClickListener, ILoadMore {
    private RecyclerView lvSPDanhMuc;
    private Button btnDanhMuc;
    private boolean dangGrid = true;
    private RecyclerView.LayoutManager manager;
    private PreShowTheoDanhMuc preShowTheoDanhMuc;
    private int maloai;
    private boolean kiemtra;
    private AdapterTopDienThoai adapter;
    private Toolbar toolbar;
    private List<SanPham> sanPhamList;
    private ProgressBar progressBar;
    private View view;
    private TextView tvGioHang;
    private PreDetailSanPham preDetailSanPham;
    private boolean onPause = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_show_sp_danhmuc,container,false);
        setHasOptionsMenu(false);
        iniView();
        return view;
    }

    private void iniView() {
        progressBar = view.findViewById(R.id.progress_bar);
        lvSPDanhMuc = view.findViewById(R.id.lv_show_sp_danhmuc);
        btnDanhMuc = view.findViewById(R.id.btn_danhmuc);
        toolbar = view.findViewById(R.id.toolBar_sp_danhmuc);
        Bundle bundle = getArguments();
        maloai = bundle.getInt("MALOAI",0);
        String tenloai = bundle.getString("TENLOAI");
        kiemtra = bundle.getBoolean("KIEMTRA",false);
        preShowTheoDanhMuc = new PreShowTheoDanhMuc(this);
        preShowTheoDanhMuc.LayDanhSachSPTheoMaLoai(maloai,kiemtra);
        toolbar.setTitle(tenloai);
        toolbar.setTitleTextColor(Color.WHITE);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack("TrangChuActivity", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });
        btnDanhMuc.setOnClickListener(this);
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_trang_chu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void HienThiDanhSachSP(List<SanPham> sanPhams) {
        sanPhamList = sanPhams;
        if (dangGrid == true){
            manager = new GridLayoutManager(getContext(),2);
            adapter = new AdapterTopDienThoai(getContext(),R.layout.custom_item_dientu_topdienthoai,sanPhamList);
        }else {
            manager = new LinearLayoutManager(getContext());
            adapter = new AdapterTopDienThoai(getContext(),R.layout.custom_item_list_dientu_topdienthoai,sanPhamList);
        }
        lvSPDanhMuc.removeAllViews();
        lvSPDanhMuc.setLayoutManager(manager);
        lvSPDanhMuc.addOnScrollListener(new LoadMoreScroll(manager,this));
        lvSPDanhMuc.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void LoiHienThiDanhSachSP() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_danhmuc:
                dangGrid = !dangGrid;
                preShowTheoDanhMuc.LayDanhSachSPTheoMaLoai(maloai,kiemtra);
                break;
        }
    }

    @Override
    public void LoadMore(int tongitem) {
        List<SanPham> listLoadMore = preShowTheoDanhMuc.LayDanhSachSPTheoMaLoaiLoadMore(maloai,kiemtra,tongitem,progressBar);
        sanPhamList.addAll(listLoadMore);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
