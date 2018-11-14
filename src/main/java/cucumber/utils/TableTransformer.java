package cucumber.utils;

import cucumber.CustomObjects;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;
import java.util.Map;

public class TableTransformer implements TypeRegistryConfigurer {
    public Locale locale() {
        return Locale.ENGLISH;
    }

    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(CustomObjects.class,
                        (Map<String, String> row) -> {
                            Integer product = Integer.parseInt(row.get("Number"));
                            String currency = row.get("User");
                            String price = row.get("Description"));

                            return new CustomObjects(product, price, currency);
                        }
                )
        );
    }
}
