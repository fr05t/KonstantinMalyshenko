package io.github.epam.jdi.jsonobjects;

public class DataSets {

    // TODO Oh my...
    // TODO What are you going to do in case if we add one more data in the file ?
    public JsonSet data_1;
    public JsonSet data_2;
    public JsonSet data_3;
    public JsonSet data_4;
    public JsonSet data_5;

    public Object[][] getAllData() {
        return new Object[][]{{1, data_1}, {2, data_2}, {3, data_3}, {4, data_4}, {5, data_5}};
    }

}
