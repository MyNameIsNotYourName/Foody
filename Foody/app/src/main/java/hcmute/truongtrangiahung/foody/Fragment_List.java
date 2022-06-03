package hcmute.truongtrangiahung.foody;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import java.util.ArrayList;

import hcmute.truongtrangiahung.foody.Adapter.ListHoaDonAdapter;
import hcmute.truongtrangiahung.foody.Models.DB_HoaDon;
import hcmute.truongtrangiahung.foody.Models.Database;

public class Fragment_List extends Fragment {
    private TabHost tabHost;

    private ListView listView;
    private Database database;
    private ListHoaDonAdapter adapter;
    private ArrayList<DB_HoaDon> arrayList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        AddTab(view);
        LichSuMuaHang(view);

        return view;
    }

    private void LichSuMuaHang(View view) {
        SetUp(view);
        LoadData();
        Event(view);
    }

    private void Event(View view) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), ChiTietHoaDon.class);
                intent.putExtra("idHoaDon", arrayList.get(i).getIdHoaDon());
                startActivity(intent);
            }
        });
    }

    private void LoadData() {
        System.out.println("Haha");
        Cursor dataHoaDon = database.GetData("SELECT * FROM HoaDon");
        while (dataHoaDon.moveToNext()){
            DB_HoaDon hoaDon = new DB_HoaDon();
            hoaDon.setIdHoaDon(dataHoaDon.getInt(0));
            hoaDon.setNgayLap(dataHoaDon.getString(1));
            hoaDon.setTongTien(dataHoaDon.getString(2));

            arrayList.add(hoaDon);
        }
        adapter.notifyDataSetChanged();
    }

    private void SetUp(View view) {
        listView = view.findViewById(R.id.listLichSuMuaHang);
        database = new Database(view.getContext(), "product.sql", null, 1);

        arrayList = new ArrayList<>();
        adapter = new ListHoaDonAdapter(view.getContext(), arrayList);
        listView.setAdapter(adapter);
    }


    private void AddTab(View view) {
        tabHost = view.findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setIndicator("Đơn hàng đang giao");
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setIndicator("Lịch sử mua hàng");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("t3");
        tab3.setIndicator("Đã lưu");
        tab3.setContent(R.id.tab3);
        tabHost.addTab(tab3);

        TabHost.TabSpec tab4 = tabHost.newTabSpec("t4");
        tab4.setIndicator("Bình luận");
        tab4.setContent(R.id.tab4);
        tabHost.addTab(tab4);
    }
}
