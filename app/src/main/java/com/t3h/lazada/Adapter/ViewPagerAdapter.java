package com.t3h.lazada.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.t3h.lazada.Activity.TrangChu.Fragment.FragmentDienTu;
import com.t3h.lazada.Activity.TrangChu.Fragment.FragmentDoiSong;
import com.t3h.lazada.Activity.TrangChu.Fragment.FragmentKhuyenMai;
import com.t3h.lazada.Activity.TrangChu.Fragment.FragmentLamDep;
import com.t3h.lazada.Activity.TrangChu.Fragment.FragmentMeVaBe;
import com.t3h.lazada.Activity.TrangChu.Fragment.FragmentNoiBat;
import com.t3h.lazada.Activity.TrangChu.Fragment.FragmentTheThao;
import com.t3h.lazada.Activity.TrangChu.Fragment.FragmentThoiTrang;
import com.t3h.lazada.Activity.TrangChu.Fragment.FragmentThuongHieu;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleFragment = new ArrayList<>();
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragmentList.add(new FragmentNoiBat());
        fragmentList.add(new FragmentKhuyenMai());
        fragmentList.add(new FragmentDienTu());

        titleFragment.add("Nổi bật");
        titleFragment.add("Khuyễn mãi");
        titleFragment.add("Điện tử");

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }
}
