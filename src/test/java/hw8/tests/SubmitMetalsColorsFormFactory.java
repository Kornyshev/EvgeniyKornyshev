package hw8.tests;

import hw8.data.TestData;
import hw8.data.beans.DataBean;
import org.testng.annotations.Factory;

public class SubmitMetalsColorsFormFactory {

    @Factory(dataProvider = "MetalsAndColors", dataProviderClass = TestData.class)
    public Object[] createInstances(DataBean bean) {
        return new Object[] {new SubmitMetalsColorsFormTest(bean)};
    }
}