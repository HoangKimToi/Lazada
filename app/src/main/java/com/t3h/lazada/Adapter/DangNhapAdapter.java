package com.t3h.lazada.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.t3h.lazada.Activity.DangNhap.Fragment.FragmentDangKy;
import com.t3h.lazada.Activity.DangNhap.Fragment.FragmentDangNhap;

public class DangNhapAdapter extends FragmentPagerAdapter {

    public DangNhapAdapter(@NonNull FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentDangNhap dangNhap = new FragmentDangNhap();
                return dangNhap;
            case 1:
                FragmentDangKy dangKy = new FragmentDangKy();
                return dangKy;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Đăng nhập";
            case 1:
                return "Đăng ký";
            default:
                return null;
        }
    }
}
