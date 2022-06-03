package hcmute.truongtrangiahung.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import hcmute.truongtrangiahung.foody.Models.Database;
import hcmute.truongtrangiahung.foody.Models.LoginState;
import hcmute.truongtrangiahung.foody.Models.OrderList;

public class SignIn extends AppCompatActivity {
    private ImageView imgBack;
    private Button btnRegister, btnLogin;
    private EditText edtUsername, edtPassword;
    private Database database;
    private String checkValid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        SetID();
        Action();
    }

    private void Action() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, Register.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                if(username.equals("") || password.equals("")){
                    Toast.makeText(SignIn.this, "Điền vào chỗ trống", Toast.LENGTH_SHORT).show();
                }
                else {
                    CheckValidUser(username, password);
                }
            }
        });
    }

    private void CheckValidUser(String username, String password) {
        Cursor dataUser = database.GetData("SELECT * FROM User WHERE taiKhoan = '"+username+"' AND matKhau = '"+password+"'");

        while (dataUser.moveToNext()){
           checkValid  = dataUser.getString(0);
        }

        if(checkValid == null){
            Toast.makeText(SignIn.this, "Thông tin sai", Toast.LENGTH_SHORT).show();
        }
        else {
            LoginState.username = checkValid;
            LoginState.onLogin = true;
            Intent intent = new Intent(SignIn.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(SignIn.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            finish();
        }
    }



    private void SetID(){
        imgBack = findViewById(R.id.imgBack);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        database = new Database(this, "product.sql", null, 1);
    }
}