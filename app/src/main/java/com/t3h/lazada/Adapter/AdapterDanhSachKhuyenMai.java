package com.t3h.lazada.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.lazada.Models.Objectclass.KhuyenMai;
import com.t3h.lazada.R;

import java.util.List;

public class AdapterDanhSachKhuyenMai extends RecyclerView.Adapter<AdapterDanhSachKhuyenMai.ViewHolder> {
    private Context context;
    private List<KhuyenMai> khuyenMais;
    public AdapterDanhSachKhuyenMai(Context context, List<KhuyenMai> khuyenMais){
        this.context = context;
        this.khuyenMais = khuyenMais;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_item_danhsach_khuyenmai,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(khuyenMais.get(position));
    }

    @Override
    public int getItemCount() {
        return khuyenMais.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView lvItemKm;
        private TextView tvTieuDeKM;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lvItemKm = itemView.findViewById(R.id.lv_item_khuyenmai);
            tvTieuDeKM = itemView.findViewById(R.id.tv_tieude_km);
        }
        public void bindData(KhuyenMai khuyenMai){
            tvTieuDeKM.setText(khuyenMai.getTENKM());
            AdapterTopDienThoai adapterTopDienThoai = new AdapterTopDienThoai(context,R.layout.custom_item_dientu_topdienthoai,khuyenMai.getDANHSACHSPKM());
            RecyclerView.LayoutManager manager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
            lvItemKm.setLayoutManager(manager);
            lvItemKm.setAdapter(adapterTopDienThoai);
        }
    }
}
