package io.github.epam.jdi.utils;

import com.google.gson.Gson;
import io.github.epam.jdi.jsonobjects.DataSets;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import static io.github.epam.jdi.enums.Path.JSON_PATH;

public class JsonParser {

    public static DataSets dataSets;

    public Object[][] returnSet() {
        Gson gson = new Gson();

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(JSON_PATH.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader jsonReader = new BufferedReader(new InputStreamReader(fileInputStream));
        dataSets = gson.fromJson(jsonReader, DataSets.class);

        return dataSets.getAllData();
    }

}
