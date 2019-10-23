package com.t3h.lazada.Activity.TimKiem;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.lazada.Adapter.AdapterTopDienThoai;
import com.t3h.lazada.Models.Objectclass.ILoadMore;
import com.t3h.lazada.Models.Objectclass.LoadMoreScroll;
import com.t3h.lazada.Models.Objectclass.SanPham;
import com.t3h.lazada.Presenter.TimKiem.PreTimKiem;
import com.t3h.lazada.R;
import com.t3h.lazada.Untils.DialogUntil;

import java.util.List;

public class TimKiemActivity extends AppCompatActivity implements ViewTimKiem, ILoadMore, SearchView.OnQueryTextListener {
    private Toolbar toolbar;
    private RecyclerView lvTimKiem;
    private PreTimKiem preTimKiem;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timkiem);
        iniView();
    }

    private void iniView() {
        toolbar = findViewById(R.id.toolBar_timkiem);
        lvTimKiem = findViewById(R.id.lv_timkiem);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        preTimKiem = new PreTimKiem(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timkiem,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.itSearch).getActionView();
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void TimKiemThanhCong(List<SanPham> sanPhams) {
        DialogUntil.dissmissProgress();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        AdapterTopDienThoai adapterTopDienThoai = new AdapterTopDienThoai(this,R.layout.custom_item_list_dientu_topdienthoai,sanPhams);
        lvTimKiem.setAdapter(adapterTopDienThoai);
        adapterTopDienThoai.notifyDataSetChanged();
        lvTimKiem.addOnScrollListener(new LoadMoreScroll(manager,this));
    }

    @Override
    public void TimKiemThatBai() {
        DialogUntil.dissmissProgress();
        Toast.makeText(this,"Không tìm thấy sản phẩm",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoadMore(int tongitem) {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        DialogUntil.ShowDialog(this);
        preTimKiem.TimKiemSPTheoTenSP(query,0);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
