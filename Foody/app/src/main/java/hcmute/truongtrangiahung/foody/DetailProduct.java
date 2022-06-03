package hcmute.truongtrangiahung.foody;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import hcmute.truongtrangiahung.foody.Adapter.ListChooseAdapter;
import hcmute.truongtrangiahung.foody.Adapter.ListRelativeFoodAdapter;
import hcmute.truongtrangiahung.foody.Models.Database;
import hcmute.truongtrangiahung.foody.Models.OrderList;
import hcmute.truongtrangiahung.foody.Models.DB_MonAn;

public class DetailProduct extends AppCompatActivity {
    private Database database;

    private GridView gridView, gridMonAnLienQuan;
    private ImageView imgBack, imgSanPham;
    private TextView txtSoCmt, txtTopTitle, txtTitle, txtDescription, txtThoiGianMoCua;
    private final DB_MonAn DBMonAn = new DB_MonAn();

    View layout;

    private int[] hinh = {R.drawable.location, R.drawable.chat, R.drawable.bookmark, R.drawable.share};
    private String[] ten = {"Check-in", "Bình luận", "Lưu", "Chia sẻ"};
    private int[] avatar = {R.drawable.avatar, R.drawable.avatar};
    private String[] tenAvatar = {"Gia Hưng", "Trương Hưng"};
    private String[] cmt = {"Ngon", "Ok."};

    private int idQuanAn, productID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail_product);
        SetID();
        GetIntent();
        Execute();
    }

    private void GetIntent() {
        Intent intent = getIntent();
        productID = intent.getIntExtra("productID", -1);
        idQuanAn = intent.getIntExtra("idQuanAn", -1);
        System.out.println("ID: " + productID);
        SetUpDatabase(productID);
    }

    private void SetUpDatabase(int productID) {
        database = new Database(this, "product.sql", null, 1);
        GetSanPhamList(productID);
    }

    private void GetSanPhamList(int productID) {
        Cursor dataSanPham = database.GetData("SELECT * FROM MonAn WHERE idMonAn = '"+productID+"'");

        SetSanPhamValue(dataSanPham);
        SetSanPhamView();
    }

    private void SetSanPhamView() {
        Cursor data = database.GetData("SELECT tenQuanAn FROM QuanAn WHERE idQuanAn = '"+DBMonAn.getIdQuanAn()+"'");
        while (data.moveToNext()){
            String ten = data.getString(0);
            txtTopTitle.setText(ten);
        }

        imgSanPham.setImageResource(DBMonAn.getPhoto());
        txtTitle.setText(DBMonAn.getTitle());
        txtDescription.setText(DBMonAn.getDescription());
        String opentime = DBMonAn.getOpenTime() + " - " + DBMonAn.getCloseTime();
        txtThoiGianMoCua.setText(opentime);
    }

    private void SetSanPhamValue(Cursor dataSanPham) {
        int productID = -1;
        String title = "";
        String description = "";
        String openTime = "";
        String closeTime = "";
        String price = "";
        int idQuanAn = -1;
        int photo = -1;

        while (dataSanPham.moveToNext()) {
            productID = dataSanPham.getInt(0);
            idQuanAn = dataSanPham.getInt(1);
            title = dataSanPham.getString(3);
            description = dataSanPham.getString(4);
            openTime = dataSanPham.getString(5);
            closeTime = dataSanPham.getString(6);
            price = dataSanPham.getString(7);
            photo = dataSanPham.getInt(2);

            DBMonAn.setProductID(productID);
            DBMonAn.setIdQuanAn(idQuanAn);
            DBMonAn.setTitle(title);
            DBMonAn.setDescription(description);
            DBMonAn.setOpenTime(openTime);
            DBMonAn.setCloseTime(closeTime);
            DBMonAn.setPrice(price);
            DBMonAn.setPhoto(photo);

            break;
        }


    }

    private void Execute() {
        ListChooseAdapter listChooseAdapter = new ListChooseAdapter(this, hinh, ten);
        gridView.setAdapter(listChooseAdapter);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idQuanAn = DBMonAn.getIdQuanAn();
                if(OrderList.orderlist.size() == 0) //Dat lan dau
                {
                    OrderList.orderlist.add(DBMonAn.getProductID());
                    OrderList.soLuong.add(1);
                    OrderList.idQuanAn = DBMonAn.getIdQuanAn();
                }
                else if(idQuanAn == OrderList.idQuanAn) //Dat trung quan an
                {
                    OrderList.orderlist.add(DBMonAn.getProductID());
                    CheckSoLuong();
                }
                else {  //Dat khac quan an
                    OrderList.orderlist.clear();
                    OrderList.soLuong.clear();

                    OrderList.orderlist.add(DBMonAn.getProductID());
                    OrderList.soLuong.add(1);
                    OrderList.idQuanAn = DBMonAn.getIdQuanAn();
                }


                Toast.makeText(DetailProduct.this, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
            }
        });

       SetUpCommentView();
       SetUpRelativeProductView();
    }

    private void CheckSoLuong() {
        int pos = -1;
        int count = 0;
        int l = OrderList.orderlist.size();
        for(int i = 1; i < l ; i++){
            for (int j = 0; j < i; j++){
                if(OrderList.orderlist.get(j).equals(OrderList.orderlist.get(i)))
                {
                    count++;
                    pos = j;
                }
            }
        }
        if(pos != -1)
        {
            OrderList.orderlist.remove(l-1);
            OrderList.soLuong.set(pos, OrderList.soLuong.get(pos) + count);
        }
        else
        {
            OrderList.soLuong.add(1);
        }
    }

    private void SetUpCommentView() {
        LinearLayout frameLayout = findViewById(R.id.frameComment);

        for(int i = 0; i < avatar.length; i++)
        {
            View view = View.inflate(this, R.layout.layout_comment, null);
            ImageView imageView = view.findViewById(R.id.imgCommentAvatar);
            TextView txtTen = view.findViewById(R.id.txtNameAccount);
            TextView txtCmt = view.findViewById(R.id.txtCommentContent);

            imageView.setImageResource(avatar[i]);
            txtTen.setText(tenAvatar[i]);
            txtCmt.setText(cmt[i]);

            frameLayout.addView(view);
        }

        String sSoCmnt = avatar.length + " Bình luận";
        txtSoCmt.setText(sSoCmnt);
    }

    private void SetUpRelativeProductView(){
        Cursor dataMonAnLienQuan = database.GetData("SELECT * FROM MonAn WHERE idQuanAn = '"+idQuanAn+"' AND idMonAn != '"+productID+"'");

        ArrayList<DB_MonAn> arrayList = new ArrayList<>();

        while (dataMonAnLienQuan.moveToNext()){
            DB_MonAn dbMonAn = new DB_MonAn();
            dbMonAn.setProductID(dataMonAnLienQuan.getInt(0));
            dbMonAn.setIdQuanAn(dataMonAnLienQuan.getInt(1));
            dbMonAn.setPhoto(dataMonAnLienQuan.getInt(2));
            dbMonAn.setTitle(dataMonAnLienQuan.getString(3));

            arrayList.add(dbMonAn);
        }

        ListRelativeFoodAdapter adapter = new ListRelativeFoodAdapter(this, arrayList);
        gridMonAnLienQuan.setAdapter(adapter);

        gridMonAnLienQuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), DetailProduct.class);
                intent.putExtra("productID", arrayList.get(i).getProductID());
                intent.putExtra("idQuanAn", arrayList.get(i).getIdQuanAn());
                startActivity(intent);
            }
        });
    }

    private void SetID() {
        gridView = findViewById(R.id.grid_list_choose);
        gridMonAnLienQuan = findViewById(R.id.gridMonAnLienQuan);
        imgBack = findViewById(R.id.imgBack);
        layout = findViewById(R.id.layoutButtonOrder);
        txtSoCmt = findViewById(R.id.txtSoLuotBinhLuan);

        imgSanPham = findViewById(R.id.imgSanPham);
        txtTopTitle = findViewById(R.id.txtTopTitle);
        txtTitle = findViewById(R.id.txtTitle);
        txtDescription = findViewById(R.id.txtDescription);
        txtThoiGianMoCua = findViewById(R.id.txtThoiGianMoCua);
    }
}
