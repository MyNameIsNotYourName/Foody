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

        // T???o b???ng
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


        // Th??m d??? li???u Qu??n ??n
        /*
        database.QueryData("INSERT INTO QuanAn VALUES (null, 'Qu??n ??n c?? M?????i', 'S??? 494, T??ng Nh??n Ph?? A, Qu???n 9, Th??nh ph??? H??? Ch?? Minh')");
        database.QueryData("INSERT INTO QuanAn VALUES (null, 'G??nh H??o Q.9', '524 ??. L?? V??n Vi???t, Long Th???nh M???, Th??? ?????c, Th??nh ph??? H??? Ch?? Minh')");
        database.QueryData("INSERT INTO QuanAn VALUES (null, 'Qu??n ??n Ngon', 'No. 2 Ng?? ?????c K???, B???n Ngh??, Qu???n 1, Th??nh ph??? H??? Ch?? Minh')");
        database.QueryData("INSERT INTO QuanAn VALUES (null, 'S??i G??n X??a v?? Nay', '37 Nguy???n Trung Tr???c, Ph?????ng B???n Th??nh, Qu???n 1, Th??nh ph??? H??? Ch?? Minh')");
        database.QueryData("INSERT INTO QuanAn VALUES (null, 'Hanuri Korean Fast Food', ' 284 Nguy???n ????nh Chi???u, Ph?????ng 6, Qu???n 3, Th??nh ph??? H??? Ch?? Minh')");
        */

        // Th??m d??? li???u Mon An
        /*
        database.QueryData("INSERT INTO MonAn VALUES (null, 1, '"+R.drawable.food_bun_dau+"', 'B??n ?????u m???m t??m', " +
                "'M???m t??m th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '7:00', '21:00', 30000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 2, '"+R.drawable.food_banh_sau_rieng+"', 'B??nh s???u ri??ng', " +
                "'B??nh s???u ri??ng th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '8:00', '18:00', 10000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 3, '"+R.drawable.food_banh_xeo+"', 'B??nh x??o', " +
                "'B??nh x??o th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '7:00', '21:00', 15000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 4, '"+R.drawable.food_bun_cua+"', 'B??n cua', " +
                "'B??n cua th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '8:00', '21:00', 25000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 5, '"+R.drawable.food_com_duong_chau+"', 'C??m d????ng ch??u', " +
                "'C??m d????ng ch??u th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '9:00', '19:00', 25000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 1, '"+R.drawable.food_tra_sua+"', 'Tr?? s???a', " +
                "'Tr?? s???a th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '7:00', '20:00', 30000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 2, '"+R.drawable.food_com_suon+"', 'C??m s?????n', " +
                "'C??m s?????n th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n',  '8:00', '18:00', 25000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 3, '"+R.drawable.food_ga_ran+"', 'G?? r??n', " +
                "'G?? r??n th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '9:00', '21:00', 25000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 4, '"+R.drawable.food_khoai_lang_lac_pho_mai+"', 'Khoai lang l???c ph?? mai', " +
                "'Khoai lang l???c ph?? mai th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '7:00', '20:00', 15000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 5, '"+R.drawable.food_tra_sua+"', '???c ngon b?? ch??y', " +
                "'???c ngon b?? ch??y th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '8:00', '18:00', 37000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 1, '"+R.drawable.food_ga_xoi_mo+"', 'G?? x???i m???', " +
                "'G?? x???i m??? th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '9:00', '21:00', 25000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 2, '"+R.drawable.food_muc_xao_sa_te+"', 'M???c x??o sa t???', " +
                "'M???c x??o sa t??? th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '7:00', '19:00', 43000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 3, '"+R.drawable.food_pho_bo+"', 'Ph??? b??', " +
                "'Ph??? b?? th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '8:00', '18:00', 40000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 4, '"+R.drawable.food_pizza+"', 'Pizza', " +
                "'Pizza th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '8:00', '18:00', 34000)");
        database.QueryData("INSERT INTO MonAn VALUES (null, 5, '"+R.drawable.food_tom_chien_xu+"', 'T??m chi??n x??', " +
                "'T??m chi??n x?? th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', '7:00', '20:00', 22000)");
        */

        /*
        database.QueryData("INSERT INTO SanPham VALUES (null, 'T??m chi??n x??', 'T??m chi??n th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', " +
                " '7:00', '20:00', null, 22000, '"+R.drawable.food_tom_chien_xu+"')");
        database.QueryData("INSERT INTO SanPham VALUES (null, 'S??p cua', 'S??p cua th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', " +
                " '8:00', '22:00', null, 15000, '"+R.drawable.food_sup_cua+"')");
        database.QueryData("INSERT INTO SanPham VALUES (null, 'S?????n n?????ng', 'S?????n n?????ng th??m ngon m???i b???n ??n nha, t??i ????y kh??ng ch??? b???n n???a gi??? t??i ??n li???n', " +
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
