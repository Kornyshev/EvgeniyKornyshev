package hw8.data;

import hw8.data.beans.DataBean;
import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(parallel = true, name = "MetalsAndColors")
    public Object[][] getData() {
        return JsonParser.testDataBeans()
                .stream()
                .map(bean -> new DataBean[]{bean})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "Results")
    public Object[][] getResultsStrings() {
        return new Object[][] {
                {"Summary: ", "Elements: ", "Color: ", "Metal: ", "Vegetables: "}
        };
    }
}