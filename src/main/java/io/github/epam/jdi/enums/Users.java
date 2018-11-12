package io.github.epam.jdi.enums;

import io.github.epam.jdi.entities.User;

public enum Users {
    PITER_CHAILOVSKII("PITER CHAILOVSKII");

    String username;

    Users(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public User getLoginPassword() {
        // TODO The greatest example of enum usage. Could you pleas explain the idea if this ????
        return new User();
    }
}
