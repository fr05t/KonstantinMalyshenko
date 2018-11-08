package io.github.epam.jdi.enums;

public enum Path {
    JSON_PATH("src\\main\\resources\\metalsColorsDataSet.json");

    String path;

    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
