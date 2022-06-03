package hcmute.truongtrangiahung.foody.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hcmute.truongtrangiahung.foody.Models.DB_MonAn;
import hcmute.truongtrangiahung.foody.R;

public class ListItemAdapter extends BaseAdapter {
    private Context context;
//    private int[] hinhSanPham;
//    private String type = "Delivery";
//    private String[] tenSanPham;
//    private String[] motaSanPham;
    private ArrayList<DB_MonAn> DBMonAnArrayList;

    public ListItemAdapter() {
    }

//    public ListItemAdapter(Context context, int[] hinhSanPham, String type, String[] tenSanPham, String[] motaSanPham) {
//        this.context = context;
//        this.hinhSanPham = hinhSanPham;
//        this.type = type;
//        this.tenSanPham = tenSanPham;
//        this.motaSanPham = motaSanPham;
//    }

    public ListItemAdapter(Context context, ArrayList<DB_MonAn> DBMonAnArrayList) {
        this.context = context;
        this.DBMonAnArrayList = DBMonAnArrayList;
    }

    @Override
    public int getCount() {
        return DBMonAnArrayList.size();
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
        view = inflater.inflate(R.layout.custom_component, null);

        ImageView imgSanPham = view.findViewById(R.id.imgSanPham);
        TextView txtType = view.findViewById(R.id.txtType);
        TextView txtTenSanPham = view.findViewById(R.id.txtTitle);
        TextView txtMoTa = view.findViewById(R.id.txtDescription);

        DB_MonAn DBMonAn = DBMonAnArrayList.get(i);

        imgSanPham.setImageResource(DBMonAn.getPhoto());
        txtType.setText("Delivery");


        String title = DBMonAn.getTitle();

        if(title.length() > 17)
        {
            title = title.substring(0, 17);
            title = title + "...";
            txtTenSanPham.setText(title);
        }
        else
            txtTenSanPham.setText(DBMonAn.getTitle());

        String description = DBMonAn.getDescription();

        if(description.length() > 73)
        {
            description = description.substring(0, 73);
            description = description + "...";
            txtMoTa.setText(description);
        }
        else
            txtMoTa.setText(DBMonAn.getDescription());

        return view;
    }
}
