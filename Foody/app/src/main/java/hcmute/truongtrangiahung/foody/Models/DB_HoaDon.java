package hcmute.truongtrangiahung.foody.Models;

import java.util.Date;

public class DB_HoaDon {
    private int idHoaDon;
    private String ngayLap;
    private String tongTien;
    private int trangThai;

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public int isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }



    public DB_HoaDon(int idHoaDon, String ngayLap, String tongTien, int trangThai) {
        this.idHoaDon = idHoaDon;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public DB_HoaDon() {
    }
}
