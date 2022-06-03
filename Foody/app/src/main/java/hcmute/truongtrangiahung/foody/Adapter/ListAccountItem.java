package hcmute.truongtrangiahung.foody.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import hcmute.truongtrangiahung.foody.Models.OrderList;
import hcmute.truongtrangiahung.foody.R;

public class ListAccountItem extends BaseAdapter {
    private Context context;
    private int[] hinh;
    private String[] ten;

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

    public ListAccountItem() {
    }

    public ListAccountItem(Context context, int[] hinh, String[] ten) {
        this.context = context;
        this.hinh = hinh;
        this.ten = ten;
    }

    public void setVisibilityNumOfOrder(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_custom_account_component, null);


    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.layout_custom_account_component, null);

        ImageView imageView = view.findViewById(R.id.imgAccountComponent);
        TextView textView = view.findViewById(R.id.txtAccountComponent);

        imageView.setImageResource(hinh[i]);
        textView.setText(ten[i]);

        if(i == 0 && (OrderList.orderlist.size() > 0))
        {
            TextView num = view.findViewById(R.id.txtNumOfOrder);
            String numofOrder = String.valueOf(OrderList.orderlist.size());
            num.setText(numofOrder);
            num.setVisibility(View.VISIBLE);
        }

        return view;
    }
}
