package hcmute.truongtrangiahung.foody.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import hcmute.truongtrangiahung.foody.R;

public class ListChooseAdapter extends BaseAdapter {
    private Context context;
    private int[] hinh;
    private String[] ten;

    public ListChooseAdapter() {
    }

    public ListChooseAdapter(Context context, int[] hinh, String[] ten) {
        this.context = context;
        this.hinh = hinh;
        this.ten = ten;
    }

    @Override
    public int getCount() {
        return ten.length;
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
        view = inflater.inflate(R.layout.layout_choose, null);

        ImageView imageView = view.findViewById(R.id.imgIconChoose);
        TextView textView = view.findViewById(R.id.txtNameOfChoose);

        imageView.setImageResource(hinh[i]);
        textView.setText(ten[i]);

        return view;
    }
}
