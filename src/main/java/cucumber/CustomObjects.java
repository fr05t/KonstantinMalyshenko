package cucumber;

public class CustomObjects {

    private String number;
    private String user;
    private String description;

    public CustomObjects(String number, String user, String description) {

        this.description = description;
        this.number = number;
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return user + " " + description;
    }
}
