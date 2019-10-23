package com.t3h.lazada.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.t3h.lazada.Activity.ChiTietSanPham.ChiTietSP;
import com.t3h.lazada.Models.Objectclass.ChiTietKhuyenMai;
import com.t3h.lazada.Models.Objectclass.SanPham;
import com.t3h.lazada.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class SanPhamNoiBatAdapter extends RecyclerView.Adapter<SanPhamNoiBatAdapter.NoiBatHolder> {
    private Context context;
    private List<SanPham> data;
    public SanPhamNoiBatAdapter(Context context,List<SanPham> sanPhams){
        this.context = context;
        this.data = sanPhams;
    }


    @NonNull
    @Override
    public NoiBatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.custom_item_sanpham,parent,false);
        return new NoiBatHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoiBatHolder holder, int position) {
        holder.bindData(data.get(position));
        holder.cardView.setTag(data.get(position).getMASP());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iChitietsanpham = new Intent(context, ChiTietSP.class);
                iChitietsanpham.putExtra("masp",(int)v.getTag());
                context.startActivity(iChitietsanpham);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class NoiBatHolder extends RecyclerView.ViewHolder{
        private TextView NoiBat,tvgia,giamgia;
        private CardView cardView;
        private ImageView imNoiBat;

        public NoiBatHolder(@NonNull View itemView) {
            super(itemView);
            NoiBat = itemView.findViewById(R.id.tv_tieude_noibat);
            tvgia = itemView.findViewById(R.id.tv_noibat_gia);
            giamgia = itemView.findViewById(R.id.tv_noibat_giamgia);
            cardView = itemView.findViewById(R.id.cardView);
            imNoiBat = itemView.findViewById(R.id.im_noibat);
        }
        public void bindData(SanPham sanPham){
            NoiBat.setText(sanPham.getTENSANPHAM());
            ChiTietKhuyenMai chiTietKhuyenMai = sanPham.getChiTietKhuyenMai();
            int giatien = sanPham.getGIA();
            if (chiTietKhuyenMai != null){
                int phamtramkm = chiTietKhuyenMai.getPHANTRAMKM();
                if (phamtramkm >0){
                    NumberFormat format = new DecimalFormat("###,###");
                    String gia = format.format(giatien);
                    giamgia.setVisibility(View.VISIBLE);
                    giamgia.setPaintFlags(giamgia.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    giamgia.setText(gia + " VNĐ");

                    giatien = giatien*phamtramkm/100;
                }
            }

            NumberFormat format = new DecimalFormat("###,###");
            String gia = format.format(giatien);
            tvgia.setText(gia + " VNĐ");
            Picasso.get().load(sanPham.getANHLON())
                    .resize(140,140)
                    .centerInside()
                    .into(imNoiBat);
        }
    }
}
