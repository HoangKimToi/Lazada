package com.t3h.lazada.Activity.TrangChu.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;
import com.t3h.lazada.R;

public class FragmentSlideDetail extends Fragment {
    private View view;
    private ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_slider_detail_sp,container,false);
        iniView();
        return view;
    }

    private void iniView() {
        Bundle bundle = getArguments();
        String linkHinh = bundle.getString("linkHinh");
        imageView = view.findViewById(R.id.im_hinhSlide);
        Picasso.get().load(linkHinh).into(imageView);
    }
}
