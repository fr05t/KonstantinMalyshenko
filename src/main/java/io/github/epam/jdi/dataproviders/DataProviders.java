package io.github.epam.jdi.dataproviders;

import io.github.epam.jdi.utils.JsonParser;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "jsonParser", parallel = false)
    public Object[] parseJsonFile() {
        return (new JsonParser()).returnSet();
    }
}
