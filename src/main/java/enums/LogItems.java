package enums;

public enum LogItems {
    METAL("metal"), COLORS("Colors"), TRUE("true"), FALSE("false"), FROM("From"), TO("To");

    private String value;

    LogItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
