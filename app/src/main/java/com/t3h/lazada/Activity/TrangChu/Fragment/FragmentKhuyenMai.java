package com.t3h.lazada.Activity.TrangChu.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.t3h.lazada.Activity.TrangChu.ViewKhuyenMai;
import com.t3h.lazada.Adapter.AdapterDanhSachKhuyenMai;
import com.t3h.lazada.Models.Objectclass.KhuyenMai;
import com.t3h.lazada.Presenter.KhuyenMai.PreKhuyenMai;
import com.t3h.lazada.R;

import java.util.List;

public class FragmentKhuyenMai extends Fragment implements ViewKhuyenMai {
    private View view;
    private LinearLayout lnHinhKM;
    private RecyclerView lv_KM;
    private AdapterDanhSachKhuyenMai adapterKM;
    private PreKhuyenMai preKhuyenMai;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_khuyen_mai,container,false);
        iniView();
        return view;
    }

    private void iniView() {
        lnHinhKM = view.findViewById(R.id.ln_hinhkhuyenmai);
        lv_KM = view.findViewById(R.id.lv_danhsachkhuyenmai);
        preKhuyenMai = new PreKhuyenMai(this);
        preKhuyenMai.LayDanhSachKhuyenMai();

    }

    @Override
    public void HienThiDanhSachKM(List<KhuyenMai> khuyenMais) {
        int demHinh = khuyenMais.size();
        if (demHinh > 5){
            demHinh = 5;
        }else {
            demHinh = khuyenMais.size();
        }
        lnHinhKM.removeAllViews();
        for (int i = 0; i < demHinh; i++) {
            ImageView image = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200);
            layoutParams.setMargins(0,10,0,10);
            image.setLayoutParams(layoutParams);
            image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            Picasso.get().load(khuyenMais.get(i).getHINHKM()).resize(820,200).into(image);
            lnHinhKM.addView(image);
        }
        adapterKM = new AdapterDanhSachKhuyenMai(getContext(),khuyenMais);
        lv_KM.setAdapter(adapterKM);
        adapterKM.notifyDataSetChanged();
    }
}
