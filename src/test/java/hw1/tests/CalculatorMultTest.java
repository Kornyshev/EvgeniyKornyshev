package hw1.tests;

import hw1.CommonConditions;
import hw1.DataProviderForCalc;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CalculatorMultTest extends CommonConditions {

    @Test(dataProvider = "CorrectIntTestData", dataProviderClass = DataProviderForCalc.class)
    public void testMultLongValues(long x, long y) {
        long expected = x * y;
        assertThat(calculator.mult(x, y), equalTo(expected));
    }

    @Test(dataProvider = "CorrectDoubleTestData", dataProviderClass = DataProviderForCalc.class)
    public void testMultDoubleValues(double x, double y) {
        double expected = Math.floor(x * y);
        assertThat(calculator.mult(x, y), equalTo(expected));
    }
}