package hw8.data;

import com.google.gson.Gson;
import hw8.data.beans.DataBean;
import hw8.data.beans.DataContainer;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class TestDataProvider {

    @DataProvider(name = "MetalsAndColors")
    public Object[][] getData() {
        return testDataBeans()
                .stream()
                .map(bean -> new DataBean[]{bean})
                .toArray(Object[][]::new);
    }

    public static List<DataBean> testDataBeans() {
        String file = null;
        try {
            file = FileUtils.readFileToString(
                    new File("src/test/resources/hw8/metalsColorsDataSet.json"),
                    StandardCharsets.UTF_8);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        DataContainer bean = new Gson().fromJson(file, DataContainer.class);
        return Arrays.asList(bean.data_1, bean.data_2, bean.data_3, bean.data_4, bean.data_5);
    }
}