package com.t3h.lazada.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.t3h.lazada.Activity.ShowSPTheoDanhMuc.HienThiTheoDanhMuc;
import com.t3h.lazada.Models.Objectclass.LoaiSanPham;
import com.t3h.lazada.Models.TrangChu.XulyJSONMenu;
import com.t3h.lazada.R;

import java.util.List;

public class ExpandAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<LoaiSanPham> loaiSanPhamList;
    private LayoutInflater inflater;
    private ViewHolderMenu viewHolderMenu;
    public ExpandAdapter(Context context,List<LoaiSanPham> loaiSanPhamList){
        this.context=context;
        this.loaiSanPhamList=loaiSanPhamList;
        XulyJSONMenu xulyJSONMenu = new XulyJSONMenu();
        int count = loaiSanPhamList.size();
        for (int i = 0; i < count; i++) {
            int maloaisp = loaiSanPhamList.get(i).getMALOAISP();
            loaiSanPhamList.get(i).setListCon(xulyJSONMenu.LayDanhSachLoaiSPTheoMaLoai(maloaisp));
        }
    }
    @Override
    public int getGroupCount() {
        return loaiSanPhamList.size();
    }

    @Override
    public int getChildrenCount(int vitriGroupCha) {
        if (loaiSanPhamList.get(vitriGroupCha).getListCon().size()!=0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public Object getGroup(int vitriGroupCha) {
        return loaiSanPhamList.get(vitriGroupCha);
    }

    @Override
    public Object getChild(int vitriGroupCha, int vitriGroupCon) {
        return loaiSanPhamList.get(vitriGroupCha).getListCon().get(vitriGroupCon);
    }

    @Override
    public long getGroupId(int vitriGroupCha) {
        return loaiSanPhamList.get(vitriGroupCha).getMALOAISP();
    }

    @Override
    public long getChildId(int vitriGroupCha, int vitriGroupCon) {
        return loaiSanPhamList.get(vitriGroupCha).getListCon().get(vitriGroupCon).getMALOAISP();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
    public class ViewHolderMenu{
        private TextView tvTenLoaiSP;
        private ImageView imImageMenu;

    }

    @Override
    public View getGroupView(final int vitriGroupCha, boolean isExpanded, View view, ViewGroup viewGroup) {
        View viewGroupCha = view;
        if (viewGroupCha == null){
            viewHolderMenu = new ViewHolderMenu();
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewGroupCha = inflater.inflate(R.layout.custom_layout_menu_cha,viewGroup,false);
            viewHolderMenu.tvTenLoaiSP = viewGroupCha.findViewById(R.id.tv_tenloaisp);
            viewHolderMenu.imImageMenu = viewGroupCha.findViewById(R.id.im_menuPlus);
            viewGroupCha.setTag(viewHolderMenu);
        }else{
            viewHolderMenu = (ViewHolderMenu) viewGroupCha.getTag();
        }
        viewHolderMenu.tvTenLoaiSP.setText(loaiSanPhamList.get(vitriGroupCha).getTENLOAISP());
        int demListMenuCon = loaiSanPhamList.get(vitriGroupCha).getListCon().size();
        if (demListMenuCon > 0){
            viewHolderMenu.imImageMenu.setVisibility(View.VISIBLE);
        }else {
            viewHolderMenu.imImageMenu.setVisibility(View.INVISIBLE);
        }
        if (isExpanded){
            viewHolderMenu.imImageMenu.setImageResource(R.drawable.ic_remove_black);
        }else {
            viewHolderMenu.imImageMenu.setImageResource(R.drawable.ic_add_black);
        }
        viewGroupCha.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Log.d("maloaisp",loaiSanPhamList.get(vitriGroupCha).getTENLOAISP() + " - " + loaiSanPhamList.get(vitriGroupCha).getMALOAISP());
                FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                HienThiTheoDanhMuc hienThiTheoDanhMuc = new HienThiTheoDanhMuc();
                Bundle bundle = new Bundle();
                bundle.putInt("MALOAI",loaiSanPhamList.get(vitriGroupCha).getMALOAISP());
                bundle.putBoolean("KIEMTRA",false);
                bundle.putString("TENLOAI",loaiSanPhamList.get(vitriGroupCha).getTENLOAISP());

                hienThiTheoDanhMuc.setArguments(bundle);
                transaction.addToBackStack("TrangChuActivity");
                transaction.replace(R.id.add_fragment,hienThiTheoDanhMuc);
                transaction.commit();
                return false;
            }
        });
        return viewGroupCha;
    }

    @Override
    public View getChildView(int vitriGroupCha, int vitriGroupCon, boolean isExpanded, View view, ViewGroup viewGroup) {
        SecondExpanded secondExpanded = new SecondExpanded(context);
        ExpandAdapter adapter = new ExpandAdapter(context,loaiSanPhamList.get(vitriGroupCha).getListCon());
        secondExpanded.setAdapter(adapter);
        secondExpanded.setGroupIndicator(null);
        secondExpanded.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        notifyDataSetChanged();
        return secondExpanded;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
    public class SecondExpanded extends ExpandableListView{

        public SecondExpanded(Context context) {
            super(context);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int with = size.x;
            int height = size.y;
            Log.d("size",with + "-" +height);
//            widthMeasureSpec = MeasureSpec.makeMeasureSpec(with,MeasureSpec.AT_MOST);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
