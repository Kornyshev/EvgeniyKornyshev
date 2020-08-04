package hw1.tests;

import hw1.CommonConditions;
import hw1.DataProviderForCalc;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CalculatorSubTest extends CommonConditions {

    @Test(dataProvider = "CorrectIntTestData",
            dataProviderClass = DataProviderForCalc.class)
    public void testSubLongValues(long x, long y) {
        long expected = x - y;
        assertThat(calculator.sub(x, y), equalTo(expected));
    }

    @Test(dataProvider = "CorrectDoubleTestData",
            dataProviderClass = DataProviderForCalc.class)
    public void testSubDoubleValues(double x, double y) {
        double expected = x - y;
        assertThat(calculator.sub(x, y), equalTo(expected));
    }
}