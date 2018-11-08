package io.github.epam.jdi.enums;

public enum Users {
    PITER_CHAILOVSKII("PITER CHAILOVSKII");

    String username;

    Users(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
