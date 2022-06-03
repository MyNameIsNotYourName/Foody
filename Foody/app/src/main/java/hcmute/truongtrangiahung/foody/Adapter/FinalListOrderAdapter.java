package hcmute.truongtrangiahung.foody.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hcmute.truongtrangiahung.foody.Models.OrderListItem;
import hcmute.truongtrangiahung.foody.R;

public class FinalListOrderAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<OrderListItem> arrayList;

    @Override
    public int getCount() {
        return arrayList.size();
    }

    public FinalListOrderAdapter() {
    }


    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public FinalListOrderAdapter(Context context, ArrayList<OrderListItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.layout_final_list_order, null);

        ImageView imageView = view.findViewById(R.id.imgSanPham);
        TextView txtTenSP = view.findViewById(R.id.txtTenSanPham);
        TextView txtSoLuongSSP = view.findViewById(R.id.txtSoLuongSanPham);
        TextView txtTongTien = view.findViewById(R.id.txtGiaSanPham);

        OrderListItem item = arrayList.get(i);

        imageView.setImageResource(item.getHinh());
        txtTenSP.setText(item.getTenSanPham());
        txtSoLuongSSP.setText(String.valueOf(item.getSoLuongSanPham()));
        txtTongTien.setText(String.valueOf(item.getGiaSanPham()));

        return view;
    }
}
