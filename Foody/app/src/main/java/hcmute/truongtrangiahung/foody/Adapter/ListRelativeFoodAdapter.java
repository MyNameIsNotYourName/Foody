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

public class ListRelativeFoodAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DB_MonAn> DBMonAnArrayList;

    @Override
    public int getCount() {
        return DBMonAnArrayList.size();
    }

    public ListRelativeFoodAdapter() {
    }

    public ListRelativeFoodAdapter(Context context, ArrayList<DB_MonAn> DBMonAnArrayList) {
        this.context = context;
        this.DBMonAnArrayList = DBMonAnArrayList;
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
        view = inflater.inflate(R.layout.layout_mon_an_lien_quan, null);

        ImageView imageView = view.findViewById(R.id.imgSanPham);
        TextView txtTitle = view.findViewById(R.id.txtTitle);

        DB_MonAn DBMonAn = DBMonAnArrayList.get(i);

        imageView.setImageResource(DBMonAn.getPhoto());
        txtTitle.setText(DBMonAn.getTitle());

        return view;
    }
}
