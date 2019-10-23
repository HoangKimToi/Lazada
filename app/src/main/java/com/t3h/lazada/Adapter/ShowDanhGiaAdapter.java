package com.t3h.lazada.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.lazada.Models.Objectclass.DanhGia;
import com.t3h.lazada.R;

import java.util.List;

public class ShowDanhGiaAdapter extends RecyclerView.Adapter<ShowDanhGiaAdapter.ViewHolder> {
    private List<DanhGia> danhGiaList;
    private int limit;
    private Context context;
    public ShowDanhGiaAdapter(Context context,List<DanhGia> danhGiaList, int limit){
        this.context = context;
        this.danhGiaList = danhGiaList;
        this.limit = limit;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_item_danhgia_chitiet,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(danhGiaList.get(position));
    }

    @Override
    public int getItemCount() {
        int dong = 0;
        if (danhGiaList.size()<limit){
            dong =  danhGiaList.size();
        }else {
            if (limit != 0){
                dong = limit;
            }else {
                dong = danhGiaList.size();
            }
        }
        return dong;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTieuDe,tvNoiDung,tvDanhGiaBoi;
        private RatingBar ratingBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDanhGiaBoi = itemView.findViewById(R.id.tv_nguoidang_danhgia);
            tvTieuDe = itemView.findViewById(R.id.tv_tieude_danhgia);
            tvNoiDung = itemView.findViewById(R.id.tv_noidung_danhgia);
            ratingBar = itemView.findViewById(R.id.rb_show_danhgia);
        }
        public void bindData(DanhGia danhGia){
            tvTieuDe.setText(danhGia.getTIEUDE());
            tvNoiDung.setText(danhGia.getNOIDUNG());
            tvDanhGiaBoi.setText("Được đánh giá bỏi : " + danhGia.getMADANHGIA() + " ngày :" + danhGia.getNGAYDANHGIA());
            ratingBar.setRating(danhGia.getSOSAO());
        }
    }
}
