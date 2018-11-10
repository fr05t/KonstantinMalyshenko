package io.github.epam.jdi.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.epam.jdi.jsonobjects.MetalsColorsDataSet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

import static io.github.epam.jdi.enums.Path.JSON_PATH;

public class JsonParser {

    public Object[][] returnSet() {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(JSON_PATH.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader jsonReader = new BufferedReader(new InputStreamReader(fileInputStream));

        Type listType = new TypeToken<Map<String, MetalsColorsDataSet>>() {
        }.getType();
        Map<String, MetalsColorsDataSet> dataSetMap = new Gson().fromJson(jsonReader, listType);

        Object[][] data = new Object[dataSetMap.size()][2];
        int i = 0;
        for (Map.Entry<String, MetalsColorsDataSet> elm : dataSetMap.entrySet()) {
            data[i][0] = elm.getKey();
            System.out.println("" + elm.getValue());

            data[i][1] = elm.getValue();
            System.out.println("value" + elm.getValue());
            i++;
        }
        return data;
    }

}
