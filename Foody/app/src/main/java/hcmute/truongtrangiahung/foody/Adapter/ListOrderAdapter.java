package hcmute.truongtrangiahung.foody.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hcmute.truongtrangiahung.foody.Models.DB_MonAn;
import hcmute.truongtrangiahung.foody.Models.Database;
import hcmute.truongtrangiahung.foody.Models.OrderList;
import hcmute.truongtrangiahung.foody.Models.OrderListItem;
import hcmute.truongtrangiahung.foody.R;

public class ListOrderAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<OrderListItem> arrayList;

    @Override
    public int getCount() {
        return arrayList.size();
    }

    public ListOrderAdapter(Context context, ArrayList<OrderListItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
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
        view = inflater.inflate(R.layout.list_order_component, null);

        TextView txtTenSanPham = view.findViewById(R.id.txtTenSanPham);
        TextView txtGiaSanPham = view.findViewById(R.id.txtGiaSanPham);
        ImageView imgSanPham = view.findViewById(R.id.imgSanPham);
        TextView txtGiam = view.findViewById(R.id.txtGiam);
        TextView txtTang = view.findViewById(R.id.txtTang);
        TextView txtSoLuong = view.findViewById(R.id.txtSoLuongSanPham);

        OrderListItem item = arrayList.get(i);

        int giaGoc = Integer.parseInt(item.getGiaSanPham());
        int giaTemp = giaGoc * OrderList.soLuong.get(i);
        String gia = giaTemp + " VND";
        item.setSoLuongSanPham(OrderList.soLuong.get(i));
        final int[] soLuong = {item.getSoLuongSanPham()};

        txtGiaSanPham.setText(gia);
        txtTenSanPham.setText(item.getTenSanPham());
        imgSanPham.setImageResource(item.getHinh());
        txtSoLuong.setText(String.valueOf(item.getSoLuongSanPham()));

        //Event
        txtGiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println("haha " + soLuong[0]);
                if(soLuong[0] > 0)
                {
                    soLuong[0] = soLuong[0] - 1;

                    //int gia = soLuong[0] * Integer.parseInt(item.getGiaSanPham());
                    int gia = soLuong[0] * giaGoc;
                    //item.setGiaSanPham(String.valueOf(gia));

                    String show = String.valueOf(gia + " VND");
                    txtGiaSanPham.setText(show);
                    txtSoLuong.setText(String.valueOf(soLuong[0]));
                    OrderList.soLuong.set(i, soLuong[0]);
                    item.setGiaSanPham(String.valueOf(gia));
                }
            }
        });

        txtTang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(soLuong[0] >= 0)
                {
                    soLuong[0] = soLuong[0] + 1;

                    //int gia = soLuong[0] * Integer.parseInt(item.getGiaSanPham());
                    //item.setGiaSanPham(String.valueOf(gia));
                    int gia = soLuong[0] * giaGoc;

                    String show = String.valueOf(gia + " VND");
                    txtGiaSanPham.setText(show);
                    txtSoLuong.setText(String.valueOf(soLuong[0]));
                    OrderList.soLuong.set(i, soLuong[0]);
                    item.setGiaSanPham(String.valueOf(gia));
                }
            }
        });


        return view;
    }

}
