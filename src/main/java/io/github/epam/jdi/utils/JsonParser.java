package io.github.epam.jdi.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.epam.jdi.jsonobjects.TestDataSet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

import static io.github.epam.jdi.enums.Path.JSON_PATH;

public class JsonParser {

    public Object[] returnSet() {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(JSON_PATH.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader jsonReader = new BufferedReader(new InputStreamReader(fileInputStream));

        Type listType = new TypeToken<Map<String, TestDataSet>>() {
        }.getType();
        Map<String, TestDataSet> dataSetMap = new Gson().fromJson(jsonReader, listType);

        // TODO Actually, you can return single dimension array

        return dataSetMap.values().toArray();
    }

}
