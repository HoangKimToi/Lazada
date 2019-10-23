package com.t3h.lazada.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.util.Log;
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
import java.util.List;

public class AdapterTopDienThoai extends RecyclerView.Adapter<AdapterTopDienThoai.ViewHolder> {
    private Context context;
    private List<SanPham> sanPhams;
    private int layout;
    private ItemClickListener listener;
    public AdapterTopDienThoai(Context context,int layout,List<SanPham> sanPhams){
        this.context = context;
        this.sanPhams = sanPhams;
        this.layout = layout;
    }

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.bindData(sanPhams.get(position));
        holder.cardView.setTag(sanPhams.get(position).getMASP());
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
        return sanPhams == null ? 0 : sanPhams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imImage;
        private TextView tvTitle,tvGia,tvGiamGia;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_tieude_dientu_topdt);
            tvGia = itemView.findViewById(R.id.tv_dientu_gia);
            imImage = itemView.findViewById(R.id.im_topdienthoai);
            tvGiamGia = itemView.findViewById(R.id.tv_dientu_giamgia);
            cardView = itemView.findViewById(R.id.cardView);
        }
        public void bindData(SanPham sanPham){
            tvTitle.setText(sanPham.getTENSANPHAM());

            ChiTietKhuyenMai chiTietKhuyenMai = sanPham.getChiTietKhuyenMai();
            int giatien = sanPham.getGIA();
            if (chiTietKhuyenMai != null){
                int phamtramkm = chiTietKhuyenMai.getPHANTRAMKM();
                if (phamtramkm >0){
                    NumberFormat format = new DecimalFormat("###,###");
                    String gia = format.format(giatien);
                    tvGiamGia.setVisibility(View.VISIBLE);
                    tvGiamGia.setPaintFlags(tvGiamGia.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    tvGiamGia.setText(gia + " VNĐ");

                    giatien = giatien*phamtramkm/100;
                }
            }

            NumberFormat format = new DecimalFormat("###,###");
            String gia = format.format(giatien);
            tvGia.setText(gia + " VNĐ");
            Picasso.get().load(sanPham.getANHLON())
                    .resize(140,140)
                    .centerInside()
                    .into(imImage);
        }
    }
    public interface ItemClickListener{
        void ItemOnClick(int position);
    }
}
