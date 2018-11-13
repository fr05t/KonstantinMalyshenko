package enums;

public enum Users {

    PITER_CHALOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String username;

    Users(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String toString() {
        return username;
    }
}
