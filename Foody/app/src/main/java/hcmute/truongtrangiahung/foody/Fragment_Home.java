package hcmute.truongtrangiahung.foody;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import hcmute.truongtrangiahung.foody.Adapter.ListItemAdapter;
import hcmute.truongtrangiahung.foody.Models.Database;
import hcmute.truongtrangiahung.foody.Models.DB_MonAn;

public class Fragment_Home extends Fragment {
    private Database database;
    private GridView gridView;
    private EditText editText;
    private TextView textView;

    private ArrayList<DB_MonAn> DBMonAnArrayList;
    private ListItemAdapter listItemAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        gridView = view.findViewById(R.id.grid_list_item);
        editText = view.findViewById(R.id.edtChuyenHuongTimKiem);
        textView = view.findViewById(R.id.txtTitle);

        DBMonAnArrayList = new ArrayList<>();
        listItemAdapter = new ListItemAdapter(view.getContext(), DBMonAnArrayList);
        gridView.setAdapter(listItemAdapter);

        SetDatabase(view);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), DetailProduct.class);
                intent.putExtra("productID", DBMonAnArrayList.get(i).getProductID());
                intent.putExtra("idQuanAn", DBMonAnArrayList.get(i).getIdQuanAn());
                startActivity(intent);
            }
        });

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TimKiem.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void SetDatabase(View view) {
        database = new Database(view.getContext(), "product.sql", null, 1);
//        database.QueryData("CREATE TABLE IF NOT EXISTS SanPham (productID INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR(200)," +
//                " description VARCHAR(200), openTime VARCHAR(10), closeTime VARCHAR(10), commentID INTEGER, price VARCHAR(20), photo INTEGER)");

        // Tạo bảng
        /*
        database.QueryData("CREATE TABLE IF NOT EXISTS QuanAn (idQuanAn INTEGER PRIMARY KEY AUTOINCREMENT, tenQuanAn VARCHAR(100)," +
                " diaChi VARCHAR(200))");
        database.QueryData("CREATE TABLE IF NOT EXISTS MonAn (idMonAn INTEGER PRIMARY KEY AUTOINCREMENT, idQuanAn INTEGER, hinhAnh INTEGER," +
                " tenMonAn VARCHAR(100), moTa VARCHAR(200), gioMoCua VARCHAR(10), gioDongCua VARCHAR(10), gia VARCHAR(20))");
        database.QueryData("CREATE TABLE IF NOT EXISTS BinhLuan (idBinhLuan INTEGER PRIMARY KEY AUTOINCREMENT, idMonAn INTEGER," +
                " taiKhoan VARCHAR(50), noiDung VARCHAR(100))");
        database.QueryData("CREATE TABLE IF NOT EXISTS User (taiKhoan VARCHAR(50) PRIMARY KEY, matKhau VARCHAR(50)," +
                " email VARCHAR(50), sdt VARCHAR(10), ten VARCHAR(50), diaChi VARCHAR(100), hinh INTEGER)");
        database.QueryData("CREATE TABLE IF NOT EXISTS HoaDon (idHoaDon INTEGER PRIMARY KEY AUTOINCREMENT, ngayLap DATETIME," +
                " tongTien VARCHAR(20), trangThai INTEGER)");
        database.QueryData("CREATE TABLE IF NOT EXISTS ChiTietHoaDon (idHoaDon INTEGER NOT NULL, idMonAn INTEGER NOT NULL, soLuong INTEGER, PRIMARY KEY (idHoaDon, idMonAn))");
        database.QueryData("CREATE TABLE IF NOT EXISTS LuuQuanAn (idQuanAn INTEGER NOT NULL, taiKhoan VARCHAR(50) NOT NULL, PRIMARY KEY (idQuanAn, taikhoan))");
        */


        // Thêm dữ liệu Quán ăn
        /*
        database.QueryData("INSERT INTO QuanAn VALUES (null, 'Quán ăn cô Mười', 'Số 494, Tăng Nhơn Phú A, Quận 9, Thành phố Hồ Chí Minh')");
        database.QueryData("INSERT INTO QuanAn VALUES (null, 'Gành Hào Q.9', '524 Đ. Lê Văn Việt, Long Thạnh Mỹ, Thủ Đức, Thành phố Hồ Chí Minh')");
        database.QueryData("INSERT INTO QuanAn VALUES (null, 'Quán ăn Ngon', 'No. 2 Ngô Đức Kế, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh')");
        database.QueryData("INSERT INTO QuanAn VALUES (null, 'Sài Gòn Xưa và Nay', '37 Nguyễn Trung Trực, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh')");
        database.QueryData("INSERT INTO QuanAn VALUES (null, 'Hanuri Korean Fast Food', ' 284 Nguyễn Đình Chiểu, Phường 6, Quận 3, Thành phố Hồ Chí Minh')");
        */

        // Thêm dữ liệu Mon An
        /*
        database.QueryData("INSERT INTO MonAn VALUES (null, 1, '"+R.drawable.food_bun_dau+"', 'Bún đậu mắm tôm', " +
                "'Mắm tôm thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '7:00', '21:00', 30000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 2, '"+R.drawable.food_banh_sau_rieng+"', 'Bánh sầu riêng', " +
                "'Bánh sầu riêng thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '8:00', '18:00', 10000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 3, '"+R.drawable.food_banh_xeo+"', 'Bánh xèo', " +
                "'Bánh xèo thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '7:00', '21:00', 15000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 4, '"+R.drawable.food_bun_cua+"', 'Bún cua', " +
                "'Bún cua thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '8:00', '21:00', 25000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 5, '"+R.drawable.food_com_duong_chau+"', 'Cơm dương châu', " +
                "'Cơm dương châu thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '9:00', '19:00', 25000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 1, '"+R.drawable.food_tra_sua+"', 'Trà sữa', " +
                "'Trà sữa thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '7:00', '20:00', 30000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 2, '"+R.drawable.food_com_suon+"', 'Cơm sườn', " +
                "'Cơm sườn thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền',  '8:00', '18:00', 25000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 3, '"+R.drawable.food_ga_ran+"', 'Gà rán', " +
                "'Gà rán thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '9:00', '21:00', 25000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 4, '"+R.drawable.food_khoai_lang_lac_pho_mai+"', 'Khoai lang lắc phô mai', " +
                "'Khoai lang lắc phô mai thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '7:00', '20:00', 15000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 5, '"+R.drawable.food_tra_sua+"', 'Ốc ngon bá cháy', " +
                "'Ốc ngon bá cháy thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '8:00', '18:00', 37000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 1, '"+R.drawable.food_ga_xoi_mo+"', 'Gà xối mỡ', " +
                "'Gà xối mỡ thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '9:00', '21:00', 25000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 2, '"+R.drawable.food_muc_xao_sa_te+"', 'Mực xào sa tế', " +
                "'Mực xào sa tế thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '7:00', '19:00', 43000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 3, '"+R.drawable.food_pho_bo+"', 'Phở bò', " +
                "'Phở bò thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '8:00', '18:00', 40000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 4, '"+R.drawable.food_pizza+"', 'Pizza', " +
                "'Pizza thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '8:00', '18:00', 34000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 5, '"+R.drawable.food_tom_chien_xu+"', 'Tôm chiên xù', " +
                "'Tôm chiên xù thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', '7:00', '20:00', 22000)");
        */

        /*
        database.QueryData("INSERT INTO SanPham VALUES (null, 'Tôm chiên xù', 'Tôm chiên thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', " +
                " '7:00', '20:00', null, 22000, '"+R.drawable.food_tom_chien_xu+"')");
        database.QueryData("INSERT INTO SanPham VALUES (null, 'Súp cua', 'Súp cua thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', " +
                " '8:00', '22:00', null, 15000, '"+R.drawable.food_sup_cua+"')");
        database.QueryData("INSERT INTO SanPham VALUES (null, 'Sườn nướng', 'Sườn nướng thơm ngon mời bạn ăn nha, tôi đây không chờ bạn nữa giờ tôi ăn liền', " +
                " '9:00', '21:00', null, 50000, '"+R.drawable.food_suon_nuong+"')");
         */


        //database.QueryData("DELETE FROM HoaDon WHERE idHoaDon != -1");
        //database.QueryData("DELETE FROM ChiTietHoaDon WHERE idHoaDon != -1");

        GetSanPhamList();
    }

    private void GetSanPhamList() {
        Cursor dataSanPham = database.GetData("SELECT idMonAn, tenMonAn, moTa, hinhAnh, MonAn.idQuanAn FROM QuanAn INNER JOIN MonAn ON QuanAn.idQuanAn = MonAn.idQuanAn");
        DBMonAnArrayList.clear();
        while (dataSanPham.moveToNext()){
            int productID = dataSanPham.getInt(0);
            String title = dataSanPham.getString(1);
            String description = dataSanPham.getString(2);
            //String openTime = dataSanPham.getString(3);
            //String closeTime = dataSanPham.getString(4);
            //int commentID = dataSanPham.getInt(5);
            //String price = dataSanPham.getString(6);
            int photo = dataSanPham.getInt(3);
            int idQuanAn = dataSanPham.getInt(4);
            DBMonAnArrayList.add(new DB_MonAn(productID, title, description, photo, idQuanAn));
        }
        listItemAdapter.notifyDataSetChanged();
    }
}
