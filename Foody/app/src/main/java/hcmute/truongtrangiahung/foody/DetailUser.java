package hcmute.truongtrangiahung.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hcmute.truongtrangiahung.foody.Models.Database;
import hcmute.truongtrangiahung.foody.Models.LoginState;

public class DetailUser extends AppCompatActivity {
    private ImageView imgBack;
    private TextView txtTitle, txtTen, txtSDT, txtEmail, txtDiaChi;
    private ImageView imgAvatar;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);
        SetID();
        LoadData();
        Action();
    }

    private void LoadData() {
        Cursor dataUser = database.GetData("SELECT * FROM User WHERE taiKhoan = '"+ LoginState.username +"'");
        while (dataUser.moveToNext()){
            String email = dataUser.getString(2);
            String sdt = dataUser.getString(3);
            String ten = dataUser.getString(4);
            String diaChi = dataUser.getString(5);
            int avatar = dataUser.getInt(6);

            txtEmail.setText(email);
            txtSDT.setText(sdt);
            txtTen.setText(ten);
            txtTitle.setText(ten);
            txtDiaChi.setText(diaChi);
            imgAvatar.setImageResource(avatar);
        }
    }

    private void Action() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void SetID() {
        imgBack = findViewById(R.id.imgBack);
        imgAvatar = findViewById(R.id.imgAvatar);
        txtTitle = findViewById(R.id.txtNameAccount);
        txtTen = findViewById(R.id.txtName);
        txtDiaChi = findViewById(R.id.txtAddress);
        txtEmail = findViewById(R.id.txtEmail);
        txtSDT = findViewById(R.id.txtSDT);

        database = new Database(this, "product.sql", null, 1);
    }
}