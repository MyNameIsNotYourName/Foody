package hcmute.truongtrangiahung.foody.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hcmute.truongtrangiahung.foody.ChiTietHoaDon;
import hcmute.truongtrangiahung.foody.Models.DB_ChiTietHoaDon;
import hcmute.truongtrangiahung.foody.R;

public class ListChiTietHoaDonAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DB_ChiTietHoaDon> arrayList;

    public ListChiTietHoaDonAdapter(Context context, ArrayList<DB_ChiTietHoaDon> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.layout_final_list_order, null);

        ImageView imageView = view.findViewById(R.id.imgSanPham);
        TextView textSoLuong = view.findViewById(R.id.txtSoLuongSanPham);
        TextView textTen = view.findViewById(R.id.txtTenSanPham);
        TextView txtGia = view.findViewById(R.id.txtGiaSanPham);

        DB_ChiTietHoaDon chiTietHoaDon = arrayList.get(i);

        imageView.setImageResource(chiTietHoaDon.getHinh());
        textSoLuong.setText(String.valueOf(chiTietHoaDon.getSoLuong()));
        txtGia.setText(String.valueOf(chiTietHoaDon.getGia()));
        textTen.setText(String.valueOf(chiTietHoaDon.getTen()));

        return view;
    }
}
