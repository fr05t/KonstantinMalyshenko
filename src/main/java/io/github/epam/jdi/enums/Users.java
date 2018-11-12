package io.github.epam.jdi.enums;

public enum Users {
    PITER_CHAILOVSKII("PITER CHAILOVSKII", "epam", "1234");

    String username;
    String login;
    String password;

    Users(String username, String login, String password) {
        this.username = username;
        this.login = login;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        // TODO The greatest example of enum usage. Could you pleas explain the idea if this ????
        return login;
    }
}
