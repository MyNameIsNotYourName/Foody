package hcmute.truongtrangiahung.foody.Models;

public class DB_LuuQuanAn {
    private int idQuanAn;
    private int idUser;

    public int getIdQuanAn() {
        return idQuanAn;
    }

    public void setIdQuanAn(int idQuanAn) {
        this.idQuanAn = idQuanAn;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public DB_LuuQuanAn() {
    }

    public DB_LuuQuanAn(int idQuanAn, int idUser) {
        this.idQuanAn = idQuanAn;
        this.idUser = idUser;
    }
}
