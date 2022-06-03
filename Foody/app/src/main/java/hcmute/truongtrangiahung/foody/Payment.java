package hcmute.truongtrangiahung.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import hcmute.truongtrangiahung.foody.Adapter.FinalListOrderAdapter;
import hcmute.truongtrangiahung.foody.Adapter.ListOrderAdapter;
import hcmute.truongtrangiahung.foody.Models.Database;
import hcmute.truongtrangiahung.foody.Models.LoginState;
import hcmute.truongtrangiahung.foody.Models.OrderList;
import hcmute.truongtrangiahung.foody.Models.OrderListItem;

public class Payment extends AppCompatActivity {

    private Button btnDatHang;
    private ImageView imgBack;
    private GridView gridView;
    private TextView txtDiaChi, txtTongTien;

    private FinalListOrderAdapter adapter;
    private ArrayList<OrderListItem> listItems;
    private Database database;

    private int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        SetID();
        LoadData();
        Action();
    }

    private void Action() {
        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!LoginState.onLogin)
                {
                    Intent intent = new Intent(Payment.this, SignIn.class);
                    startActivity(intent);
                }
                else {
                    SetData();
                    Intent intent = new Intent(Payment.this, PaymentSuccess.class);
                    startActivity(intent);
                }
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void SetData() {
        Date date = new Date();
        int max = -1;
        //System.out.println("Haha "+ date.toString());
        database.QueryData("INSERT INTO HoaDon VALUES (null, '"+date+"', '"+String.valueOf(sum+10000)+"', 0)");

        Cursor dataHoaDon = database.GetData("SELECT MAX(idHoaDon) FROM HoaDon");
        while (dataHoaDon.moveToNext())
        {
            max = dataHoaDon.getInt(0);
        }

        for(int i = 0; i < OrderList.orderlist.size(); i++){
            database.QueryData("INSERT INTO ChiTietHoaDon VALUES ('"+max+"', '"+OrderList.orderlist.get(i)+"', '"+OrderList.soLuong.get(i)+"')");
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
                int gia = Integer.parseInt(dataMonAn.getString(7)) * OrderList.soLuong.get(i);
                monAn.setGiaSanPham(String.valueOf(gia));
                monAn.setSoLuongSanPham(OrderList.soLuong.get(i));
                listItems.add(monAn);

                sum += gia;
            }
        }
        adapter.notifyDataSetChanged();

        Cursor dataUser = database.GetData("SELECT diaChi FROM User WHERE taiKhoan = '"+ LoginState.username +"'");
        while (dataUser.moveToNext()){
            String diaChi = dataUser.getString(0);
            txtDiaChi.setText(diaChi);
        }
        String finalSum = sum + 10000 + " VNĐ";
        txtTongTien.setText(String.valueOf(finalSum));
    }

    private void SetID(){
        btnDatHang = findViewById(R.id.btnDatHang);
        imgBack = findViewById(R.id.imgBack);
        gridView = findViewById(R.id.gridTongSanPham);
        txtDiaChi = findViewById(R.id.txtDiaChi);
        txtTongTien = findViewById(R.id.txtTongTien);

        listItems = new ArrayList<>();
        adapter = new FinalListOrderAdapter(this, listItems);
        gridView.setAdapter(adapter);

        database = new Database(this, "product.sql", null, 1);
    }
}