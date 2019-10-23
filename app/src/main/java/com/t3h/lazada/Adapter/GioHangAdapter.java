package com.t3h.lazada.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.t3h.lazada.Models.GioHang.ModelGioHang;
import com.t3h.lazada.Models.Objectclass.SanPham;
import com.t3h.lazada.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.ViewHolder> {
    private Context context;
    private List<SanPham> sanPhams;
    private ModelGioHang modelGioHang;
    private int tong;
    public GioHangAdapter(Context context, List<SanPham> sanPhams){
        this.context = context;
        this.sanPhams = sanPhams;
        modelGioHang = new ModelGioHang();
        modelGioHang.MoKetNoiSQL(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_list_giohang,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.BindData(sanPhams.get(position));
        holder.imXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModelGioHang modelGioHang = new ModelGioHang();
                modelGioHang.MoKetNoiSQL(context);
                modelGioHang.XoaSPGioHang(sanPhams.get(position).getMASP());
                sanPhams.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.imTang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soluong = Integer.parseInt(holder.tvSoLuong.getText().toString());
                int soluongtonkho = sanPhams.get(position).getSOLUONGTONKHO();
                if (soluong<soluongtonkho){
                    soluong ++;
                }else {
                    Toast.makeText(context,"Bạn mua quá số lượng có trong kho",Toast.LENGTH_SHORT).show();
                }
                modelGioHang.CapNhatSoLuong(sanPhams.get(position).getMASP(),soluong);
                tong = sanPhams.get(position).getGIA()*soluong;
                NumberFormat format = new DecimalFormat("###,###");
                holder.tvGia.setText(format.format(tong) + " VNĐ");
                holder.tvSoLuong.setText(String.valueOf(soluong));
            }
        });
        holder.imGiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soluong = Integer.parseInt(holder.tvSoLuong.getText().toString());
                if (soluong>1){
                    soluong--;
                }
                modelGioHang.CapNhatSoLuong(sanPhams.get(position).getMASP(),soluong);
                tong = sanPhams.get(position).getGIA()*soluong;
                NumberFormat format = new DecimalFormat("###,###");
                holder.tvGia.setText(format.format(tong) + " VNĐ");
                holder.tvSoLuong.setText(String.valueOf(soluong));
            }
        });
    }

    @Override
    public int getItemCount() {
        return sanPhams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTen,tvGia,tvSoLuong;
        private ImageView imHinhGioHang,imXoa;
        private ImageButton imTang,imGiam;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTen = itemView.findViewById(R.id.tv_tieude_giohang);
            tvGia = itemView.findViewById(R.id.tv_gia_giohang);
            imHinhGioHang = itemView.findViewById(R.id.im_hinhgiohang);
            imXoa = itemView.findViewById(R.id.im_Xoa_giohang);
            tvSoLuong = itemView.findViewById(R.id.tv_soluong_sp_giohang);
            imTang = itemView.findViewById(R.id.tang_soluong_giohang);
            imGiam = itemView.findViewById(R.id.im_giam_soluong_giohang);
        }
        public void BindData(SanPham sanPham){
            tvTen.setText(sanPham.getTENSANPHAM());
            tong = sanPham.getGIA()*sanPham.getSOLUONG();
            NumberFormat format = new DecimalFormat("###,###");
            tvGia.setText(format.format(tong) + " VNĐ");
            byte[] hinhsp = sanPham.getHinhGioHang();
            Bitmap bitmapGioHang = BitmapFactory.decodeByteArray(hinhsp,0,hinhsp.length);
            imHinhGioHang.setImageBitmap(bitmapGioHang);
            tvSoLuong.setText(String.valueOf(sanPham.getSOLUONG()));
        }
    }
}
