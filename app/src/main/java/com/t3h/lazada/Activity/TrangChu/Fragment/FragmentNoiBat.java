package com.t3h.lazada.Activity.TrangChu.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.lazada.Activity.TrangChu.ViewNoiBat;
import com.t3h.lazada.Adapter.SanPhamNoiBatAdapter;
import com.t3h.lazada.Models.Objectclass.SanPham;
import com.t3h.lazada.Presenter.NoiBat.PreNoiBat;
import com.t3h.lazada.Presenter.NoiBat.PresentNoiBat;
import com.t3h.lazada.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentNoiBat extends Fragment implements ViewNoiBat {
    private SanPhamNoiBatAdapter adapter;
    private List<SanPham> data;
    private RecyclerView lvNoiBat;
    private View view;
    private PreNoiBat preNoiBat;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_noi_bat,container,false);
        iniView();
        return view;
    }

    private void iniView() {
        lvNoiBat = view.findViewById(R.id.lv_noibat);
        preNoiBat = new PreNoiBat(this);
        preNoiBat.LayDanhSachNoiBat(0);
    }

    @Override
    public void HienThiSPNoiBat(List<SanPham> sanPhams) {
        data = sanPhams;
        adapter = new SanPhamNoiBatAdapter(getActivity(),data);
        lvNoiBat.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
