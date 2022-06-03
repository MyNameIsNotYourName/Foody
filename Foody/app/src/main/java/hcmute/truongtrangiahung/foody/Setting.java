package hcmute.truongtrangiahung.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.Toast;

import hcmute.truongtrangiahung.foody.Models.LoginState;

public class Setting extends AppCompatActivity {
    TableRow info, changePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        SetID();
        Exec();
    }

    private void Exec() {

    }

    private void SetID() {
        info = findViewById(R.id.tableRowInfo);
        changePass = findViewById(R.id.tableRowChangePassword);
    }

    public void Back(View view) {
        finish();
    }

    public void IntoInfoAccount(View view) {
        if(LoginState.onLogin)
        {
            Intent intent = new Intent(this, SettingInfoAccount.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Bạn cần phải đăng nhập", Toast.LENGTH_SHORT).show();
        }

    }

    public void IntoChangePassword(View view) {
        if(LoginState.onLogin)
        {
            Intent intent = new Intent(this, SettingChangePassword.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Bạn cần phải đăng nhập", Toast.LENGTH_SHORT).show();
        }
    }
}