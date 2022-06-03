package hcmute.truongtrangiahung.foody.Models;

public class DB_BinhLuan {
    private int commentID;
    private int productID;
    private String userID;
    private String content;

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DB_BinhLuan() {
    }

    public DB_BinhLuan(int commentID, int productID, String userID, String content) {
        this.commentID = commentID;
        this.productID = productID;
        this.userID = userID;
        this.content = content;
    }
}
