package hcmute.truongtrangiahung.foody;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import hcmute.truongtrangiahung.foody.Adapter.ListAccountItem;
import hcmute.truongtrangiahung.foody.Models.Database;
import hcmute.truongtrangiahung.foody.Models.LoginState;
import hcmute.truongtrangiahung.foody.Models.DB_User;

public class Fragment_Account extends Fragment {
    private GridView gridAccountComponent;
    private View layout_account;
    private TextView txtNumOfOrder, txtNameAccount;
    private ImageView imgAvatar;
    private Database database;
    private final DB_User DBUser = new DB_User();
    private View view;

    private ListAccountItem adapter;
    private int[] hinh = {R.drawable.cart, R.drawable.invoice, R.drawable.setting, R.drawable.log_out};
    private String[] ten = {"Giỏ hàng", "Hóa đơn", "Cài đặt", "Đăng xuất"};


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account, container, false);

        SetID(view);
        SetDatabase(view);
        CheckUser(view);
        Exec(view);

        return view;
    }


    private void CheckUser(View view) {
        database = new Database(view.getContext(), "product.sql", null, 1);
        Cursor dataUser = database.GetData("SELECT * FROM User WHERE taikhoan = '"+LoginState.username+"'");
        while (dataUser.moveToNext()){
            DBUser.setUsername(dataUser.getString(0));
            DBUser.setPassword(dataUser.getString(1));
            DBUser.setEmail(dataUser.getString(2));
            DBUser.setPhoneNumber(dataUser.getString(3));
            DBUser.setName(dataUser.getString(4));
            DBUser.setAddress(dataUser.getString(5));
            DBUser.setAvatar(dataUser.getInt(6));
        }

        if(DBUser.getUsername() == null)
        {
            imgAvatar.setImageResource( R.drawable.null_user);
            String text = "Đăng nhập";
            txtNameAccount.setText(text);
            LoginState.onLogin = false;
        }
        else {
            imgAvatar.setImageResource(DBUser.getAvatar());
            txtNameAccount.setText(DBUser.getName());
            LoginState.onLogin = true;
        }
    }


    private void SetDatabase(View view) {
        database = new Database(view.getContext(), "product.sql", null, 1);

        //database.QueryData("DELETE FROM User WHERE taiKhoan != ''");
        //database.QueryData("INSERT INTO User VALUES ('Hung', '1', '', '', 'Hung', 'Trai Dat','"+R.drawable.avatar+"')");

    }

    private void Exec(View view) {
        adapter = new ListAccountItem(view.getContext(), hinh, ten);
        gridAccountComponent.setAdapter(adapter);

        layout_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(LoginState.onLogin)
                {
                    Intent intent = new Intent(view.getContext(), DetailUser.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(view.getContext(), SignIn.class);
                    startActivity(intent);
                }

            }
        });


        gridAccountComponent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent intent = new Intent(view.getContext(), ListOrder.class);
                    startActivity(intent);
                }
                if(i == 3){
                    LoginState.username = null;
                    LoginState.onLogin = false;
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                }
                if(i == 2){
                    Intent intent = new Intent(view.getContext(), Setting.class);
                    startActivity(intent);
                }
            }
        });

        //SetVisibilityOfNumOfOrder();


    }

    private void SetVisibilityOfNumOfOrder() {
        if(ten[0].equals("Giỏ hàng"))
       {
//            View view = adapter.getView(0, gridAccountComponent, null);
//            TextView textView = view.findViewById(R.id.txtNumOfOrder);
//            textView.setVisibility(View.VISIBLE);
//            adapter.notifyDataSetChanged();
            System.out.println("1234");

            adapter.setVisibilityNumOfOrder();
        }
        else {
            System.out.println("5678");
        }
    }

    private void SetID(View view) {
        gridAccountComponent = view.findViewById(R.id.gridAccountComponent);
        layout_account = view.findViewById(R.id.layout_account);
        txtNumOfOrder = view.findViewById(R.id.txtNumOfOrder);
        txtNameAccount = view.findViewById(R.id.txtNameAccount);
        imgAvatar = view.findViewById(R.id.imgAvatar);
    }

}
