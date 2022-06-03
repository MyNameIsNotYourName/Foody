package hcmute.truongtrangiahung.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import hcmute.truongtrangiahung.foody.Models.Database;

public class PaymentSuccess extends AppCompatActivity {
    private Button btnVeTrangChu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);
        SetID();
        Action();
    }


    private void Action() {
        btnVeTrangChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void SetID(){
        btnVeTrangChu = findViewById(R.id.btnVeTrangChu);
    }
}