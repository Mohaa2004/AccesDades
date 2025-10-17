package model;
import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String user;
    private String password;
    private int dinero;

    public User(String name, String user, String password, int dinero) {
        this.name = name;
        this.user = user;
        this.password = password;
        this.dinero = dinero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
}
