package cucumber;

public class CustomObjects {

    private int number;
    private String user;
    private String description;

    public CustomObjects(int number, String user, String description) {

        this.description = description;
        this.number = number;
        this.user = user;
    }

    public int getNumber() {
        return number;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }
}
