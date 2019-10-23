package com.t3h.lazada.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.lazada.Models.Objectclass.DienTu;
import com.t3h.lazada.R;

import java.util.List;

public class AdapterDienTu extends RecyclerView.Adapter<AdapterDienTu.ViewHolderDienTu> {
    private List<DienTu> dienTuList;
    private Context context;
    public AdapterDienTu(Context context, List<DienTu> dienTuList){
        this.context = context;
        this.dienTuList=dienTuList;
    }
    @NonNull
    @Override
    public ViewHolderDienTu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_item_dien_tu,parent,false);
        return new ViewHolderDienTu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDienTu holder, int position) {
        holder.bindData(dienTuList.get(position));
    }

    @Override
    public int getItemCount() {
        return dienTuList.size();
    }

    public class ViewHolderDienTu extends RecyclerView.ViewHolder{
        private ImageView imKhuyenMai;
        private RecyclerView lv_ThuongHieu,lv_TopSP;
        private TextView tvTen,tvTop;
        public ViewHolderDienTu(@NonNull View itemView) {
            super(itemView);
            lv_ThuongHieu = itemView.findViewById(R.id.lv_dientu_thuonghieulon);
            lv_TopSP = itemView.findViewById(R.id.lv_dientu_Topdienthoai);
            imKhuyenMai = itemView.findViewById(R.id.im_KhuyenMai_DienTu);
            tvTen = itemView.findViewById(R.id.tv_dientu_thuonghieulon);
            tvTop = itemView.findViewById(R.id.tv_top_dienThoaivaMaytinhBang);
        }
        public void bindData(DienTu dienTu){
            AdapterThuongHIeuLon adapterThuongHIeuLon = new AdapterThuongHIeuLon(context,dienTu.getThuongHieus(),dienTu.getThuonghieu());
            RecyclerView.LayoutManager manager = new GridLayoutManager(context,3,RecyclerView.HORIZONTAL,false);
            lv_ThuongHieu.setLayoutManager(manager);
            lv_ThuongHieu.setAdapter(adapterThuongHIeuLon);
            adapterThuongHIeuLon.notifyDataSetChanged();

            AdapterTopDienThoai adapterTopDienThoai = new AdapterTopDienThoai(context,R.layout.custom_item_dientu_topdienthoai,dienTu.getSanPhams());
            RecyclerView.LayoutManager managerTop = new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
            lv_TopSP.setLayoutManager(managerTop);
            lv_TopSP.setAdapter(adapterTopDienThoai);
            adapterTopDienThoai.notifyDataSetChanged();

            tvTen.setText(dienTu.getTenDienTu());
            tvTop.setText(dienTu.getTenTopDienTu());
        }
    }
}
