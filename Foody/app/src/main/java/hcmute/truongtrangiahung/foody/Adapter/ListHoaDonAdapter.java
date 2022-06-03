package hcmute.truongtrangiahung.foody.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hcmute.truongtrangiahung.foody.Models.DB_HoaDon;
import hcmute.truongtrangiahung.foody.R;

public class ListHoaDonAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DB_HoaDon> arrayList;

    public ListHoaDonAdapter(Context context, ArrayList<DB_HoaDon> arrayList) {
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
        view = inflater.inflate(R.layout.layout_hoa_don, null);

        TextView maHoaDon = view.findViewById(R.id.txtMaHoaDon);
        TextView ngayLap = view.findViewById(R.id.txtNgayLap);
        TextView tongTien = view.findViewById(R.id.txtTongTien);

        DB_HoaDon hoaDon = arrayList.get(i);

        maHoaDon.setText(String.valueOf(hoaDon.getIdHoaDon()));
        ngayLap.setText(String.valueOf(hoaDon.getNgayLap()));
        String sTongTien = hoaDon.getTongTien() + " VND";
        tongTien.setText(sTongTien);

        return view;
    }
}
