package enums;

public enum PageTitles {

    HOME_PAGE("Home Page"),
    DIFFERENT_ELEMENTS("Different Elements"),
    DATES("Dates");

    private String title;

    PageTitles(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

}
