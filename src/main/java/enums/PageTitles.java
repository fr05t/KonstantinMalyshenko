package enums;

public enum PageTitles {

    HOME_PAGE("Home Page");

    private String title;

    PageTitles(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

}
