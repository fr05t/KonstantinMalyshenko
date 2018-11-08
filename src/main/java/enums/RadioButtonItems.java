package enums;

public enum RadioButtonItems {
    GOLD("Gold"), SILER("Silver"), BRONZE("Bronze"), SELEN("Selen");

    private String element;

    RadioButtonItems(String element) {
        this.element = element;
    }

    public String getElement() {
        return this.element;
    }
}
