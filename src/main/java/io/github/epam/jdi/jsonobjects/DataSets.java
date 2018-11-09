package io.github.epam.jdi.jsonobjects;

public class DataSets {

    public PageParameters data_1;
    public PageParameters data_2;
    public PageParameters data_3;
    public PageParameters data_4;
    public PageParameters data_5;

    public Object[][] getAllData() {
        return new Object[][]{{1, data_1}, {2, data_2}, {3, data_3}, {4, data_4}, {5, data_5}};
    }

}
