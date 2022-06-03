package hcmute.truongtrangiahung.foody.Models;

public class DB_MonAn {
    private int productID;
    private int idQuanAn;
    private String title;
    private String description;
    private String openTime;
    private String closeTime;
    private String price;
    private int photo;

    public DB_MonAn(int productID, String title, String description, int photo) {
        this.productID = productID;
        this.title = title;
        this.description = description;
        this.photo = photo;
    }

    public DB_MonAn(int productID, String title, String description, String openTime, String closeTime, String price, int photo) {
        this.productID = productID;
        this.title = title;
        this.description = description;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.price = price;
        this.photo = photo;
    }

    public DB_MonAn(int productID, String title, String description, int photo, int idQuanAn) {
        this.productID = productID;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.idQuanAn = idQuanAn;
    }

    public DB_MonAn(int hinh, String title) {
        this.photo = hinh;
        this.title = title;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public DB_MonAn() {
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getIdQuanAn() {
        return idQuanAn;
    }

    public void setIdQuanAn(int idQuanAn) {
        this.idQuanAn = idQuanAn;
    }
}
