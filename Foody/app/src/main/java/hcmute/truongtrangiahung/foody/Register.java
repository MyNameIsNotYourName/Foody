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

public class Register extends AppCompatActivity {
    private ImageView imgBack;
    private EditText edtUsername, edtPassword, edtConfirmPassword;
    private Button btnRegister;
    private Database database;
    private String username, password, confirmPassword, existUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
                if(CheckValid())
                {
                    AddUser();
                }
            }
        });
    }

    private void AddUser() {
        database.QueryData("INSERT INTO User VALUES ('"+username+"', '"+password+"', '', '', '"+username+"', '', '"+R.drawable.null_user+"')");
        Toast.makeText(Register.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
        //database.QueryData("DELETE FROM User WHERE username = 'Hun'");
        finish();
    }

    private boolean CheckValid() {
        username = edtUsername.getText().toString();
        password = edtPassword.getText().toString();
        confirmPassword = edtConfirmPassword.getText().toString();

        if(username.equals("") || password.equals("") || confirmPassword.equals("")){
            Toast.makeText(Register.this, "Điền vào chỗ trống", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!password.equals(confirmPassword))
        {
            Toast.makeText(Register.this, "Nhập lại mật khẩu sai", Toast.LENGTH_SHORT).show();
            return false;
        }

        Cursor dataUser = database.GetData("SELECT * FROM User WHERE taiKhoan = '"+username+"'");
        while (dataUser.moveToNext()){
            existUser  = dataUser.getString(0);
        }
        if(existUser != null){
            Toast.makeText(Register.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void SetID(){
        imgBack = findViewById(R.id.imgBack);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        database = new Database(this, "product.sql", null, 1);
    }
}