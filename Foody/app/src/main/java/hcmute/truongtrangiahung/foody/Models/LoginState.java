package hcmute.truongtrangiahung.foody.Models;

public class LoginState {
    public static String username = "";
    public static boolean onLogin = false;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        LoginState.username = username;
    }
}
