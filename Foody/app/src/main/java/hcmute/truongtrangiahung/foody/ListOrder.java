package hcmute.truongtrangiahung.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import hcmute.truongtrangiahung.foody.Adapter.ListOrderAdapter;
import hcmute.truongtrangiahung.foody.Models.DB_MonAn;
import hcmute.truongtrangiahung.foody.Models.Database;
import hcmute.truongtrangiahung.foody.Models.OrderList;
import hcmute.truongtrangiahung.foody.Models.OrderListItem;

public class ListOrder extends AppCompatActivity {
    private Button btnDatHang;
    private ImageView imgBack;
    private TextView  txtXoaSanPham, txtGiam, txtTang;
    private ListView listView;

    private Database database;
    private ListOrderAdapter adapter;
    private ArrayList<OrderListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);
        SetID();
        Action();
    }

    private void Action() {
        listItems = new ArrayList<>();
        adapter = new ListOrderAdapter(this, listItems);
        listView.setAdapter(adapter);
        LoadData();

        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetPrice();
                Intent intent = new Intent(ListOrder.this, Payment.class);
                startActivity(intent);
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void SetPrice() {
        for(int i = 0; i < OrderList.orderlist.size(); i++){
            int gia = OrderList.soLuong.get(i) *  Integer.parseInt(listItems.get(i).getGiaSanPham());
            listItems.get(i).setGiaSanPham(String.valueOf(gia));
        }
    }

    private void LoadData() {
        for(int i = 0; i < OrderList.orderlist.size(); i++)
        {
            Cursor dataMonAn = database.GetData("SELECT * FROM MonAn WHERE idMonAn = '"+OrderList.orderlist.get(i)+"'");
            while (dataMonAn.moveToNext()){
                OrderListItem monAn = new OrderListItem();
                monAn.setTenSanPham(dataMonAn.getString(3));
                monAn.setHinh(dataMonAn.getInt(2));
                monAn.setGiaSanPham(dataMonAn.getString(7));
                listItems.add(monAn);
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void SetID(){
        btnDatHang = findViewById(R.id.btnDatHang);
        imgBack = findViewById(R.id.imgBack);
        txtXoaSanPham  = findViewById(R.id.txtXoaSanPham);
        listView = findViewById(R.id.listListOrder);

        database = new Database(this, "product.sql", null, 1);
    }
}