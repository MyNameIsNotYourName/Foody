package hcmute.truongtrangiahung.foody.Models;

public class DB_ChiTietHoaDon {
    private int hinh;
    private int idHoaDon;
    private int idMonAn;
    private int soLuong;
    private String gia;
    private String ten;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public DB_ChiTietHoaDon(int hinh, int idHoaDon, int idMonAn, int soLuong, String gia) {
        this.hinh = hinh;
        this.idHoaDon = idHoaDon;
        this.idMonAn = idMonAn;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public DB_ChiTietHoaDon() {
    }
    public DB_ChiTietHoaDon(int hinh, int idHoaDon, int idMonAn, int soLuong) {
        this.hinh = hinh;
        this.idHoaDon = idHoaDon;
        this.idMonAn = idMonAn;
        this.soLuong = soLuong;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
    public DB_ChiTietHoaDon(int idHoaDon, int idMonAn, int soLuong) {
        this.idHoaDon = idHoaDon;
        this.idMonAn = idMonAn;
        this.soLuong = soLuong;
    }
}
