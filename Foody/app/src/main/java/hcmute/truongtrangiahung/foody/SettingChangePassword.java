package hcmute.truongtrangiahung.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hcmute.truongtrangiahung.foody.Models.Database;
import hcmute.truongtrangiahung.foody.Models.LoginState;

public class SettingChangePassword extends AppCompatActivity {
    private EditText edtPassword, edtNewPassword, edtConfirmNewPassword;
    private Button btnConfirm;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_change_password);
        SetId();
        Event();
    }

    private void Event() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeData();
            }
        });
    }

    private void ChangeData() {
        String oldPass = edtPassword.getText().toString().trim();
        String newPass = edtNewPassword.getText().toString().trim();
        String confirmNewPass = edtConfirmNewPassword.getText().toString().trim();

        if(CheckValid(oldPass, newPass, confirmNewPass))
        {
            database.QueryData("UPDATE User SET matKhau = '"+newPass+"' WHERE taiKhoan = '"+ LoginState.username +"'");
            Toast.makeText(SettingChangePassword.this, "Thay đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private boolean CheckValid(String oldPass, String newPass, String confirmNewPass) {
        if(oldPass.equals(""))
        {
            Toast.makeText(SettingChangePassword.this, "Nhập mật khẩu", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(newPass.equals("")){
            Toast.makeText(SettingChangePassword.this, "Nhập mật khẩu mới", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(confirmNewPass.equals(""))
        {
            Toast.makeText(SettingChangePassword.this, "Nhập lại mật khẩu mới", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!newPass.equals(confirmNewPass))
        {
            Toast.makeText(SettingChangePassword.this, "Nhập lại sai", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void SetId() {
        edtPassword = findViewById(R.id.edtPassword);
        edtNewPassword = findViewById(R.id.edtNewPassword);
        edtConfirmNewPassword = findViewById(R.id.edtConfirmNewPassword);
        btnConfirm = findViewById(R.id.btnLuuThayDoi);

        database = new Database(this, "product.sql", null, 1);
    }

    public void Back(View view) {
        finish();
    }
}