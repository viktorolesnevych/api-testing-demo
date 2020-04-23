package POJOs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class User {
    public String name;
    public String username;
    public String phone;
    public String email;
    public String address;

    public User(){}

    public User(String name, String username, String phone, String email, String address) {
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
