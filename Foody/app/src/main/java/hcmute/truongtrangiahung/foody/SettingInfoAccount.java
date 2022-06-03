package hcmute.truongtrangiahung.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import hcmute.truongtrangiahung.foody.Models.Database;
import hcmute.truongtrangiahung.foody.Models.LoginState;

public class SettingInfoAccount extends AppCompatActivity {
    private EditText edtEmail, edtSDT, edtTen, edtDiaChi;
    private ImageView imgAvatar;
    private Button btnLuuThayDoi;

    private Database database;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_info_account);
        SetID();
        LoadData();
        Event();
    }

    private void Event() {
        btnLuuThayDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString().trim();
                String sdt = edtSDT.getText().toString().trim();
                String ten = edtTen.getText().toString().trim();
                String diaChi = edtDiaChi.getText().toString().trim();

                database.QueryData("UPDATE User SET email = '"+email+"', sdt = '"+sdt+"', " +
                        "ten = '"+ten+"', diaChi = '"+diaChi+"' WHERE taiKhoan = '"+LoginState.username+"'");
                Toast.makeText(SettingInfoAccount.this, "Lưu thay đổi thành công", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


    private void LoadData() {
        Cursor dataUser = database.GetData("SELECT * FROM User WHERE taiKhoan = '"+ LoginState.username +"'");
        while (dataUser.moveToNext()){
            String email = dataUser.getString(2);
            String sdt = dataUser.getString(3);
            String ten = dataUser.getString(4);
            String diaChi = dataUser.getString(5);
            int avatar = dataUser.getInt(6);

            edtEmail.setText(email);
            edtSDT.setText(sdt);
            edtTen.setText(ten);
            edtDiaChi.setText(diaChi);
            imgAvatar.setImageResource(avatar);
        }
    }

    private void SetID() {
        edtEmail = findViewById(R.id.edtEmail);
        edtSDT = findViewById(R.id.edtSDT);
        edtTen = findViewById(R.id.edtTen);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        imgAvatar = findViewById(R.id.imgAvatar);
        btnLuuThayDoi = findViewById(R.id.btnLuuThayDoi);

        database = new Database(this, "product.sql", null, 1);
    }

    public void Back(View view) {
        finish();
    }
}