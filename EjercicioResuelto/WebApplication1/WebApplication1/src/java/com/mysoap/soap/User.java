package com.mysoap.soap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private static List<User> users = new ArrayList<>(Arrays.asList(
            new User("Rosa", "Marfil"),
            new User("Pepito", "Grillo"),
            new User("Manuela", "Río")));

    private String name;
    private String username;

    public User() {
        super();
    }

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", username=" + username + "]";
    }
}
