package com.t3h.lazada.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.t3h.lazada.Activity.ShowSPTheoDanhMuc.HienThiTheoDanhMuc;
import com.t3h.lazada.Models.Objectclass.ThuongHieu;
import com.t3h.lazada.R;

import java.util.List;

public class AdapterThuongHIeuLon extends RecyclerView.Adapter<AdapterThuongHIeuLon.ViewHolder> {
    private Context context;
    private List<ThuongHieu> data;
    private LayoutInflater inflater;
    private Boolean kiemtra;
    public AdapterThuongHIeuLon(Context context,List<ThuongHieu> data,Boolean kiemtra){
        this.context = context;
        this.data = data;
        this.kiemtra=kiemtra;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_item_dientu_thuonghieulon,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.bindData(data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                HienThiTheoDanhMuc hienThiTheoDanhMuc = new HienThiTheoDanhMuc();
                Bundle bundle = new Bundle();
                bundle.putInt("MALOAI",data.get(position).getMATHUONGHIEU());
                bundle.putBoolean("KIEMTRA",kiemtra);
                bundle.putString("TENLOAI",data.get(position).getTENTHUONGHIEU());

                hienThiTheoDanhMuc.setArguments(bundle);
                transaction.addToBackStack("TrangChuActivity");
                transaction.replace(R.id.add_fragment,hienThiTheoDanhMuc);
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView inImage;
        private TextView tvTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            inImage = itemView.findViewById(R.id.im_hinhdientu_thuonghieu);
            tvTitle = itemView.findViewById(R.id.tv_tieude_dientu_thuonghieu);
        }
        public void bindData(ThuongHieu thuongHieu){
            tvTitle.setText(thuongHieu.getTENTHUONGHIEU());
            Picasso.get().load(thuongHieu.getHINHTHUONGHIEU())
                    .resize(90,90)
                    .into(inImage);
        }
    }
}
