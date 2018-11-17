package enums.mobile;

public enum SelectProperties {
    ANDROID_WEB("src\\test\\resources\\mobile\\web\\web.properties"), ANDROID_NATIVE("src\\test\\resources\\mobile\\hw2.properties");

    private String proFile;

    SelectProperties(String proFile) {
        this.proFile = proFile;
    }

    public String getProFile() {
        return proFile;
    }
}
