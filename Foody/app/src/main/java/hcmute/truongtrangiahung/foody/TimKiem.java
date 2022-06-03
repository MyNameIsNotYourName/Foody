package hcmute.truongtrangiahung.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import hcmute.truongtrangiahung.foody.Adapter.ListRelativeFoodAdapter;
import hcmute.truongtrangiahung.foody.Models.DB_MonAn;
import hcmute.truongtrangiahung.foody.Models.Database;

public class TimKiem extends AppCompatActivity {
    private ImageView imgBack;
    private EditText edtTimKiem;
    private GridView gridView;
    private ListRelativeFoodAdapter adapter;
    private ArrayList<DB_MonAn> arrayList;

    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        SetID();
        Event();
    }

    private void Event() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                LoadData();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               LoadData();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                LoadData();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), DetailProduct.class);
                intent.putExtra("productID", arrayList.get(i).getProductID());
                intent.putExtra("idQuanAn", arrayList.get(i).getIdQuanAn());
                startActivity(intent);
            }
        });
    }

    private void LoadData() {
        String tenMonAn = edtTimKiem.getText().toString();
        arrayList.clear();
        if(!tenMonAn.equals(""))
        {
            Cursor data = database.GetData("SELECT * FROM MonAn WHERE tenMonAn LIKE '%"+tenMonAn+"%'");
            while (data.moveToNext())
            {
                DB_MonAn monAn = new DB_MonAn();
                monAn.setProductID(data.getInt(0));
                monAn.setIdQuanAn(data.getInt(1));
                monAn.setPhoto(data.getInt(2));
                monAn.setTitle(data.getString(3));

                arrayList.add(monAn);
            }
            adapter.notifyDataSetChanged();
        }
    }

    private void SetID() {
        imgBack = findViewById(R.id.imgBack);
        edtTimKiem = findViewById(R.id.edtTimKiem);
        gridView = findViewById(R.id.listMonAn);

        arrayList = new ArrayList<>();
        adapter = new ListRelativeFoodAdapter(this, arrayList);
        gridView.setAdapter(adapter);

        database = new Database(this, "product.sql", null, 1);
    }
}