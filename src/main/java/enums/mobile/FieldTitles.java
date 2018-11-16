package enums.mobile;

public enum FieldTitles {
    CONTACT_PHONE("Contact Phone"), CONTACT_NAME("Contact Name");

    private String name;

    FieldTitles(String name) {
        this.name = name;
    }

    public String getTitle() {
        return name;
    }
}
