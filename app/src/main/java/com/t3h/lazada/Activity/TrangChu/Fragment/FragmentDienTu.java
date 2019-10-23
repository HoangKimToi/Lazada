package com.t3h.lazada.Activity.TrangChu.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.lazada.Activity.TrangChu.ViewDienTu;
import com.t3h.lazada.Adapter.AdapterDienTu;
import com.t3h.lazada.Models.Objectclass.DienTu;
import com.t3h.lazada.Presenter.DienTu.PreDienTu;
import com.t3h.lazada.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentDienTu extends Fragment implements ViewDienTu {
    private View view;
    private RecyclerView lvDienTu;
    private List<DienTu> dienTus;
    private PreDienTu preDienTu;
    private AdapterDienTu adapterDienTu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dien_tu,container,false);
        iniView();
        return view;
    }

    private void iniView() {
        lvDienTu = view.findViewById(R.id.lv_dien_tu);
        preDienTu = new PreDienTu(this,getContext());
        dienTus = new ArrayList<>();
        preDienTu.LayDanhSachDienTu();
    }

    @Override
    public void HienThiDanhSachDienTu(List<DienTu> dienTuList) {

        dienTus = dienTuList;
        adapterDienTu = new AdapterDienTu(getContext(),dienTus);
        lvDienTu.setAdapter(adapterDienTu);
        adapterDienTu.notifyDataSetChanged();

    }
}
