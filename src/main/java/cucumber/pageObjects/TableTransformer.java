package cucumber.pageObjects;

import cucumber.CustomObjects;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;
import java.util.Map;

public class TableTransformer implements TypeRegistryConfigurer  {
    public Locale locale() {
        return Locale.ENGLISH;
    }

    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(CustomObjects.class,
                        (Map<String, String> row) -> {
                            String number = row.get("Number");
                            String user = row.get("User");
                            String description = row.get("Description");

                            return new CustomObjects(number, user, description);
                        }
                )
        );
    }
}
