package io.github.epam.jdi.entities;

import com.epam.commons.DataClass;

public class UserCredentials extends DataClass {
    public String name;
    public String password;

    public UserCredentials(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
