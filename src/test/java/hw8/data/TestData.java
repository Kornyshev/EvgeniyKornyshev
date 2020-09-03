package hw8.data;

import hw8.data.beans.DataBean;
import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "MetalsAndColors")
    public Object[][] getData() {
        return JsonParser.testDataBeans()
                .stream()
                .map(bean -> new DataBean[]{bean})
                .toArray(Object[][]::new);
    }
}