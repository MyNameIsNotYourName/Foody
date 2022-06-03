package hcmute.truongtrangiahung.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import hcmute.truongtrangiahung.foody.Adapter.ListChiTietHoaDonAdapter;
import hcmute.truongtrangiahung.foody.Models.DB_ChiTietHoaDon;
import hcmute.truongtrangiahung.foody.Models.Database;

public class ChiTietHoaDon extends AppCompatActivity {
    private ListView listView;
    private ListChiTietHoaDonAdapter adapter;
    private ArrayList<DB_ChiTietHoaDon> arrayList;
    private Database database;
    private ImageView imgBack;

    private int idHoaDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_hoa_don);

        Intent intent = getIntent();
        idHoaDon = intent.getIntExtra("idHoaDon", -1);

        SetId();
        LoadData();
        Event();
    }

    private void Event() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void LoadData() {
        Cursor dataHoaDon = database.GetData("SELECT hinhAnh, tenMonAn, soLuong, gia FROM MonAn INNER JOIN ChiTietHoaDon " +
                "ON MonAn.idMonAn = ChiTietHoaDon.idMonAn WHERE idHoaDon = '"+idHoaDon+"' ");
        while (dataHoaDon.moveToNext()){
            DB_ChiTietHoaDon chiTietHoaDon = new DB_ChiTietHoaDon();
            chiTietHoaDon.setHinh(dataHoaDon.getInt(0));
            chiTietHoaDon.setTen(dataHoaDon.getString(1));
            chiTietHoaDon.setSoLuong(dataHoaDon.getInt(2));
            int gia = dataHoaDon.getInt(2) * dataHoaDon.getInt(3);
            chiTietHoaDon.setGia(String.valueOf(gia));

            arrayList.add(chiTietHoaDon);
        }
        adapter.notifyDataSetChanged();
    }

    private void SetId() {
        database = new Database(this, "product.sql", null, 1);
        listView = findViewById(R.id.listChiTietHoaDon);
        arrayList = new ArrayList<>();
        adapter = new ListChiTietHoaDonAdapter(this, arrayList);
        listView.setAdapter(adapter);

        imgBack = findViewById(R.id.imgBack);
    }
}