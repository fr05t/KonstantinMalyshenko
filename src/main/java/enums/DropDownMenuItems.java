package enums;

public enum DropDownMenuItems {
    RED("Red"), YELLOW("Yellow"), GREEN("Green"), BLUE("Blue");

    private String colorName;

    DropDownMenuItems(String colorName) {
        this.colorName = colorName;
    }

    public String getColor() {
        return colorName;
    }

}
