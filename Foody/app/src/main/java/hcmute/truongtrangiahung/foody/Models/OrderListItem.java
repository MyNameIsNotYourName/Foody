package hcmute.truongtrangiahung.foody.Models;

public class OrderListItem {
    private String giaSanPham;
    private String tenSanPham;
    private int soLuongSanPham;
    private int hinh;

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public OrderListItem(String giaSanPham, String tenSanPham, int soLuongSanPham, int hinh) {
        this.giaSanPham = giaSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuongSanPham = soLuongSanPham;
        this.hinh = hinh;
    }

    public String getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(String giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public OrderListItem() {
    }

    public OrderListItem(String giaSanPham, String tenSanPham, int soLuongSanPham) {
        this.giaSanPham = giaSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuongSanPham = soLuongSanPham;
    }
}
