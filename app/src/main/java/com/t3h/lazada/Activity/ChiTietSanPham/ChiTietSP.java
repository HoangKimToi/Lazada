package com.t3h.lazada.Activity.ChiTietSanPham;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.t3h.lazada.Activity.DangNhap.DangNhap;
import com.t3h.lazada.Activity.DanhGia.ThemDanhGiaActivity;
import com.t3h.lazada.Activity.GioHang.GioHangActivity;
import com.t3h.lazada.Activity.ThanhToan.ThanhToanActivity;
import com.t3h.lazada.Activity.TrangChu.Fragment.FragmentSlideDetail;
import com.t3h.lazada.Activity.TrangChu.TrangChuActivity;
import com.t3h.lazada.Activity.TrangChu.ViewDetailSanPham;
import com.t3h.lazada.Activity.TrangChu.ViewXuLyMenu;
import com.t3h.lazada.Adapter.ShowDanhGiaAdapter;
import com.t3h.lazada.Adapter.ViewSliderAdapter;
import com.t3h.lazada.Models.DangNhap.ModelsDangNhap;
import com.t3h.lazada.Models.Objectclass.ChiTietKhuyenMai;
import com.t3h.lazada.Models.Objectclass.ChiTietSanPham;
import com.t3h.lazada.Models.Objectclass.DanhGia;
import com.t3h.lazada.Models.Objectclass.LoaiSanPham;
import com.t3h.lazada.Models.Objectclass.SanPham;
import com.t3h.lazada.Presenter.ChiTietSP.PreDetailSanPham;
import com.t3h.lazada.Presenter.TrangChu.PreXuLyMenu;
import com.t3h.lazada.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ChiTietSP extends AppCompatActivity implements ViewDetailSanPham, ViewPager.OnPageChangeListener, View.OnClickListener, ViewXuLyMenu, GoogleApiClient.OnConnectionFailedListener {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private PreDetailSanPham preDetailSanPham;
    private TextView[] tvDots;
    private LinearLayout lvDots,lnThongSoKyThuat;
    private RatingBar ratingBar;
    private List<Fragment> fragments;
    private TextView tvTenSP,tvGiaTien,tvTenNhanVien,tvThongTinChiTiet,tvVietDanhGia,tvGioHang,tvGiamGia;
    private ImageView imXemThem;
    private ImageButton imBtnCart;
    private Button btnMuaNgay;
    private boolean kiemTraXemThem = false;
    private int masp;
    private List<DanhGia> danhGias;
    private RecyclerView lvDanhGiaChiTiet;
    private ShowDanhGiaAdapter adapter;
    private SanPham sanPhamGioHang;
    private boolean onPause = false;
    private float sosao = 0;
    private PreXuLyMenu preXuLyMenu;
    private AccessToken accessToken;
    private Menu menu;
    private ModelsDangNhap modelsDangNhap;
    private MenuItem itemNameUserLogin;
    private MenuItem menuItemDangXuat;
    private GoogleApiClient googleApiClient;
    private GoogleSignInResult googleSignInResult;
    private String userName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_sanpham);
        iniView();
    }

    private void iniView() {
        toolbar = findViewById(R.id.toolBar_chitiet);
        toolbar.setTitle("Chi tiết sản phẩm");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        viewPager = findViewById(R.id.viewpager_slideShow);
        lvDots = findViewById(R.id.lv_dot);
        lnThongSoKyThuat = findViewById(R.id.lnThongSoKyThuat);
        tvTenSP = findViewById(R.id.tv_tensanpham);
        tvGiaTien = findViewById(R.id.tv_giatien);
        tvTenNhanVien = findViewById(R.id.tv_tennhanvien);
        tvThongTinChiTiet = findViewById(R.id.tv_thongtin_chitiet);
        tvVietDanhGia = findViewById(R.id.tv_vietdanhgia);
        lvDanhGiaChiTiet = findViewById(R.id.lv_danhgia);
        ratingBar = findViewById(R.id.rb_danggia);
        imBtnCart = findViewById(R.id.imBtn_add_to_cart);
        btnMuaNgay = findViewById(R.id.btn_muangay_chitietsp);
        tvGiamGia = findViewById(R.id.tv_giamgia_chitietsp);
        btnMuaNgay.setOnClickListener(this);
        imBtnCart.setOnClickListener(this);
        tvVietDanhGia.setOnClickListener(this);
        imXemThem = findViewById(R.id.im_xemthemchitiet);
        int masp = getIntent().getIntExtra("masp",0);
        preDetailSanPham = new PreDetailSanPham(this);
        preDetailSanPham.LayChiTietSanPham(masp);
        preDetailSanPham.LayDanhSachDanhGiaCuaSP(masp,0);


        preXuLyMenu = new PreXuLyMenu(this);
        modelsDangNhap = new ModelsDangNhap();
        preXuLyMenu.layDanhSachMenu();
        googleApiClient = modelsDangNhap.layGoogleApiClient(this,this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trang_chu,menu);
        this.menu = menu;
        itemNameUserLogin = menu.findItem(R.id.itDangNhap);
        menuItemDangXuat = menu.findItem(R.id.itDangXuat);
        MenuItem itemGioHang = menu.findItem(R.id.itGioHang);
        View GiaoDienGioHang = MenuItemCompat.getActionView(itemGioHang);
        tvGioHang = GiaoDienGioHang.findViewById(R.id.tv_cart_soluong);
        tvGioHang.setText(String.valueOf(preDetailSanPham.DemGioHang(this)));

        GiaoDienGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreDetailSanPham preDetailSanPham1 = new PreDetailSanPham();
                if (preDetailSanPham1.DemGioHang(ChiTietSP.this) > 0){
                    Intent IGioHang = new Intent(ChiTietSP.this, GioHangActivity.class);
                    startActivity(IGioHang);
                }else {
                    Toast.makeText(ChiTietSP.this,"Bạn không có sản phẩm trong giỏ hàng.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        accessToken = preXuLyMenu.layTokenUserFacebook();
        googleSignInResult = modelsDangNhap.layThongTinLoginGG(googleApiClient);
        if (accessToken != null) {
            GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject object, GraphResponse response) {
                    try {
                        userName = object.getString("name");
                        itemNameUserLogin.setTitle(userName);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            Bundle parameter = new Bundle();
            parameter.putString("fields", "name");
            request.setParameters(parameter);
            request.executeAsync();
        }
        if (googleSignInResult != null){
            itemNameUserLogin.setTitle(googleSignInResult.getSignInAccount().getDisplayName());
        }
        String tennv = modelsDangNhap.LayCachedDangNhap(this);
        if (!tennv.equals("")){
            itemNameUserLogin.setTitle(tennv);
        }
        if (accessToken != null || googleSignInResult != null || !tennv.equals("")){
            menuItemDangXuat.setVisible(true);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.itDangNhap:
                if (accessToken == null && googleSignInResult == null && modelsDangNhap.LayCachedDangNhap(this).equals("")) {
                    Intent iDangNhap = new Intent(this, DangNhap.class);
                    startActivity(iDangNhap);
                }
                break;
            case R.id.itDangXuat:
                if (accessToken!=null){
                    LoginManager.getInstance().logOut();
                    this.menu.clear();
                    this.onCreateOptionsMenu(this.menu);
                }
                if (googleSignInResult != null){
                    Auth.GoogleSignInApi.signOut(googleApiClient);
                    this.menu.clear();
                    this.onCreateOptionsMenu(this.menu);
                }
                if (!modelsDangNhap.LayCachedDangNhap(this).equals(null)){
                    modelsDangNhap.CapNhatCached(this,"");
                    this.menu.clear();
                    this.onCreateOptionsMenu(this.menu);
                }
                break;
        }
        return true;
    }

    @Override
    public void HienChiTietSanPham(final SanPham sanPham) {
        masp = sanPham.getMASP();
        sanPhamGioHang = sanPham;
        sanPhamGioHang.setSOLUONGTONKHO(sanPham.getSOLUONG());
        ChiTietKhuyenMai chiTietKhuyenMai = sanPham.getChiTietKhuyenMai();
        int giatien = sanPham.getGIA();
        if (chiTietKhuyenMai != null){
            int phamtramkm = chiTietKhuyenMai.getPHANTRAMKM();

            if (phamtramkm != 0 ){
                NumberFormat format = new DecimalFormat("###,###");
                String gia = format.format(giatien);
                tvGiamGia.setVisibility(View.VISIBLE);
                tvGiamGia.setPaintFlags(tvGiamGia.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                tvGiamGia.setText(gia + " VNĐ");
                giatien = giatien*phamtramkm/100;
            }
        }
        tvTenSP.setText(sanPham.getTENSANPHAM());
        NumberFormat format = new DecimalFormat("###,###");
        String gia = format.format(giatien);
        tvGiaTien.setText(gia + " VNĐ");
        tvTenNhanVien.setText(sanPham.getTENNHANVIEN());
//        tvThongTinChiTiet.setText(Html.fromHtml(sanPham.getTHONGTIN().substring(0,100)));
        if (sanPham.getTHONGTIN().length() < 100){
            imXemThem.setVisibility(View.GONE);
        }else {
            imXemThem.setVisibility(View.VISIBLE);
            imXemThem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    kiemTraXemThem = !kiemTraXemThem;
                    if (kiemTraXemThem){
                        //Mở chi tiết
                        tvThongTinChiTiet.setText(Html.fromHtml(sanPham.getTHONGTIN()));
                        imXemThem.setImageDrawable(getImageChiTiet(R.drawable.ic_keyboard_arrow_up));
                        lnThongSoKyThuat.setVisibility(View.VISIBLE);
                        HienThiThongSoKyThuat(sanPham);
                    }else {
                        //Đóng chi tiết
                        tvThongTinChiTiet.setText(Html.fromHtml(sanPham.getTHONGTIN().substring(0,100)));
                        imXemThem.setImageDrawable(getImageChiTiet(R.drawable.ic_keyboard_arrow_down));
                        lnThongSoKyThuat.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
    private void HienThiThongSoKyThuat(SanPham sanPham){
        List<ChiTietSanPham> chiTietSanPhamList = sanPham.getChiTietSanPhamList();
        lnThongSoKyThuat.removeAllViews();
        TextView tieuDe = new TextView(this);
        tieuDe.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tieuDe.setText("Thông số kỹ thuật");
        tieuDe.setTextSize(16);
        lnThongSoKyThuat.addView(tieuDe);
        for (int i = 0; i < chiTietSanPhamList.size(); i++) {
            LinearLayout layout = new LinearLayout(this);
            layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.setOrientation(LinearLayout.HORIZONTAL);

            TextView tenThongSo = new TextView(this);
            tenThongSo.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1.0f));
            tenThongSo.setText(chiTietSanPhamList.get(i).getTenchitiet());
            TextView GiaTriThongSo = new TextView(this);
            GiaTriThongSo.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1.0f));
            GiaTriThongSo.setText(chiTietSanPhamList.get(i).getGiatri());
            layout.addView(tenThongSo);
            layout.addView(GiaTriThongSo);

            lnThongSoKyThuat.addView(layout);
        }
    }
    private Drawable getImageChiTiet(int IDDrawable){
        Drawable drawable;
        if (Build.VERSION.SDK_INT > 21){
            drawable = ContextCompat.getDrawable(this,IDDrawable);
        }else {
            drawable = getResources().getDrawable(IDDrawable);
        }
        return drawable;
    }

    @Override
    public void HienThiSlideSanPham(String[] linkHinhSP) {
        fragments = new ArrayList<>();
        for (int i = 0; i < linkHinhSP.length; i++) {
            FragmentSlideDetail slideDetail = new FragmentSlideDetail();
            Bundle bundle = new Bundle();
            bundle.putString("linkHinh",TrangChuActivity.SERVER + linkHinhSP[i]);
            slideDetail.setArguments(bundle);
            fragments.add(slideDetail);
        }
        ViewSliderAdapter adapter = new ViewSliderAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        ThemDotSlider(0);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void HienThiDanhGia(List<DanhGia> danhGiaList) {
        danhGias = danhGiaList;
        adapter  = new ShowDanhGiaAdapter(this,danhGias,3);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        lvDanhGiaChiTiet.setLayoutManager(manager);
        lvDanhGiaChiTiet.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        float tong = 0;
        for (int i = 0; i < danhGias.size(); i++) {
            tong += danhGias.get(i).getSOSAO();
            sosao = tong/danhGias.size();
        }
        ratingBar.setRating(sosao);
    }

    @Override
    public void ThemGioHangThanhCong() {
        Toast.makeText(this,"Add To Cart Success",Toast.LENGTH_SHORT).show();
        tvGioHang.setText(String.valueOf(preDetailSanPham.DemGioHang(this)));
    }

    @Override
    public void ThemGioHangThatBai() {
        Toast.makeText(this,"Add To Cart Fail",Toast.LENGTH_SHORT).show();
    }

    private void ThemDotSlider(int vitriHienTai){
        tvDots = new TextView[fragments.size()];
        lvDots.removeAllViews();
        for (int i = 0; i < fragments.size(); i++) {
            tvDots[i] = new TextView(this);
            tvDots[i].setText(Html.fromHtml("&#8226;"));
            tvDots[i].setTextSize(40);
            tvDots[i].setTextColor(getIDColor(R.color.colorSliderInActive));
            lvDots.addView(tvDots[i]);
        }
        tvDots[vitriHienTai].setTextColor(getIDColor(R.color.colorFacebook));
    }
    private int getIDColor(int IDcolor){
        int color = 0;
        if (Build.VERSION.SDK_INT > 21){
            color = ContextCompat.getColor(this,IDcolor);
        }else {
            color = getResources().getColor(IDcolor);
        }
        return color;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        ThemDotSlider(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_vietdanhgia:
                Intent iThemDanhGia = new Intent(this, ThemDanhGiaActivity.class);
                iThemDanhGia.putExtra("masp",masp);
                startActivity(iThemDanhGia);
                break;
            case R.id.imBtn_add_to_cart:
                Fragment fragment = fragments.get(0);
                View view1 = fragment.getView();
                ImageView imageView = view1.findViewById(R.id.im_hinhSlide);
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
                byte[] hinhSPCart = outputStream.toByteArray();
                sanPhamGioHang.setHinhGioHang(hinhSPCart);
                sanPhamGioHang.setSOLUONG(1);
                preDetailSanPham.ThemGioHang(sanPhamGioHang,this);
                break;
            case R.id.btn_muangay_chitietsp:
                Fragment fragment1 = fragments.get(0);
                View view2 = fragment1.getView();
                ImageView hinh = view2.findViewById(R.id.im_hinhSlide);
                Bitmap bitMap = ((BitmapDrawable) hinh.getDrawable()).getBitmap();
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                bitMap.compress(Bitmap.CompressFormat.PNG,100,output);
                byte[] hinhSP = output.toByteArray();
                sanPhamGioHang.setHinhGioHang(hinhSP);
                sanPhamGioHang.setSOLUONG(1);
                preDetailSanPham.ThemGioHang(sanPhamGioHang,this);
                Intent IMuaNgay = new Intent(this, ThanhToanActivity.class);
                startActivity(IMuaNgay);
                finish();
                break;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (onPause){
            PreDetailSanPham preDetailSanPham = new PreDetailSanPham();
            tvGioHang.setText(String.valueOf(preDetailSanPham.DemGioHang(this)));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        onPause = true;
    }

    @Override
    public void hienThiDanhSachLoaiSanPham(List<LoaiSanPham> loaiSanPhamList) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
