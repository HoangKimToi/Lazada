package com.t3h.lazada.Activity.TrangChu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.tabs.TabLayout;
import com.t3h.lazada.Activity.DangNhap.DangNhap;
import com.t3h.lazada.Activity.GioHang.GioHangActivity;
import com.t3h.lazada.Activity.TimKiem.TimKiemActivity;
import com.t3h.lazada.Adapter.ExpandAdapter;
import com.t3h.lazada.Adapter.ViewPagerAdapter;
import com.t3h.lazada.Models.DangNhap.ModelsDangNhap;
import com.t3h.lazada.Models.Objectclass.LoaiSanPham;
import com.t3h.lazada.Presenter.ChiTietSP.PreDetailSanPham;
import com.t3h.lazada.Presenter.TrangChu.PreXuLyMenu;
import com.t3h.lazada.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class TrangChuActivity extends AppCompatActivity implements ViewXuLyMenu, GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {
    public static final String SERVER_NAME = "http://192.168.43.160/lazada/loaisanpham.php";
    public static final String SERVER= "http://192.168.43.160/lazada";
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private TextView tvGioHang;
    private Button btnTimKiem;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ExpandableListView expandableListView;
    private PreXuLyMenu preXuLyMenu;
    private String userName;
    private AccessToken accessToken;
    private Menu menu;
    private ModelsDangNhap modelsDangNhap;
    private MenuItem itemNameUserLogin;
    private MenuItem menuItemDangXuat;
    private GoogleApiClient googleApiClient;
    private GoogleSignInResult googleSignInResult;
    private boolean onPause = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_trangchu);
        iniView();
    }

    private void iniView() {
        toolbar = findViewById(R.id.trangchu_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        btnTimKiem = findViewById(R.id.btn_timkiem);
        btnTimKiem.setOnClickListener(this);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        expandableListView = findViewById(R.id.epMenu);

        drawerLayout = findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();

        preXuLyMenu = new PreXuLyMenu(this);
        modelsDangNhap = new ModelsDangNhap();
        preXuLyMenu.layDanhSachMenu();
        googleApiClient = modelsDangNhap.layGoogleApiClient(this,this);

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trang_chu,menu);
        this.menu = menu;
        itemNameUserLogin = menu.findItem(R.id.itDangNhap);
        menuItemDangXuat = menu.findItem(R.id.itDangXuat);

        MenuItem itemGioHang = menu.findItem(R.id.itGioHang);
        View GiaoDienGioHang = MenuItemCompat.getActionView(itemGioHang);
        tvGioHang = GiaoDienGioHang.findViewById(R.id.tv_cart_soluong);
        PreDetailSanPham preDetailSanPham = new PreDetailSanPham();
        tvGioHang.setText(String.valueOf(preDetailSanPham.DemGioHang(this)));
        GiaoDienGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreDetailSanPham preDetailSanPham1 = new PreDetailSanPham();
                if (preDetailSanPham1.DemGioHang(TrangChuActivity.this) > 0){
                    Intent IGioHang = new Intent(TrangChuActivity.this, GioHangActivity.class);
                    startActivity(IGioHang);
                }else {
                    Toast.makeText(TrangChuActivity.this,"Bạn không có sản phẩm trong giỏ hàng.",Toast.LENGTH_SHORT).show();
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
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
    public void hienThiDanhSachLoaiSanPham(List<LoaiSanPham> loaiSanPhamList) {
        ExpandAdapter adapter = new ExpandAdapter(this,loaiSanPhamList);
        expandableListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_timkiem:
                Intent iTimKiem = new Intent(this, TimKiemActivity.class);
                startActivity(iTimKiem);
                break;
        }
    }
}
