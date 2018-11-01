package enums;

public enum DropDownMenuItems {
    Red("Red"), Yellow("Yellow"), Grenn("Green"), Blue("Blue");

    private String colorName;

    DropDownMenuItems(String colorName) {
        this.colorName = colorName;
    }

    public String getColor() {
        return colorName;
    }

}
