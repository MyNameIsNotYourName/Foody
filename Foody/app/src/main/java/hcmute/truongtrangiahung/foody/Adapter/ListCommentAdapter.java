package hcmute.truongtrangiahung.foody.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import hcmute.truongtrangiahung.foody.R;

public class ListCommentAdapter extends BaseAdapter {
    private Context context;
    private int[] avatar;
    private String[] ten;
    private String[] binhLuan;

    @Override
    public int getCount() {
        return avatar.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public ListCommentAdapter() {
    }

    public ListCommentAdapter(Context context, int[] avatar, String[] ten, String[] binhLuan) {
        this.context = context;
        this.avatar = avatar;
        this.ten = ten;
        this.binhLuan = binhLuan;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.layout_comment, null);

        ImageView imageView = view.findViewById(R.id.imgCommentAvatar);
        TextView txtTen = view.findViewById(R.id.txtNameAccount);
        TextView txtCmt = view.findViewById(R.id.txtCommentContent);

        imageView.setImageResource(avatar[i]);
        txtTen.setText(ten[i]);
        txtCmt.setText(binhLuan[i]);

        return view;
    }
}
