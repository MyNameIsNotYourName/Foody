package hcmute.truongtrangiahung.foody.Models;

public class DB_QuanAn {
    private int idQuanAn;
    private String tenQuanAn;
    private String diaChi;

    public int getIdQuanAn() {
        return idQuanAn;
    }

    public void setIdQuanAn(int idQuanAn) {
        this.idQuanAn = idQuanAn;
    }

    public String getTenQuanAn() {
        return tenQuanAn;
    }

    public void setTenQuanAn(String tenQuanAn) {
        this.tenQuanAn = tenQuanAn;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public DB_QuanAn() {
    }

    public DB_QuanAn(int idQuanAn, String tenQuanAn, String diaChi) {
        this.idQuanAn = idQuanAn;
        this.tenQuanAn = tenQuanAn;
        this.diaChi = diaChi;
    }
}
