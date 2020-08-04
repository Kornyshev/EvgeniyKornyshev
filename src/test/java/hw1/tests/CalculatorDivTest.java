package hw1.tests;

import hw1.CommonConditions;
import hw1.DataProviderForCalc;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CalculatorDivTest extends CommonConditions {

    @Test(dataProvider = "CorrectIntTestData",
            dataProviderClass = DataProviderForCalc.class)
    public void testDivLongValues(long x, long y) {
        long expected = x / y;
        assertThat(calculator.div(x, y), equalTo(expected));
    }

    @Test(dataProvider = "CorrectDoubleTestData",
            dataProviderClass = DataProviderForCalc.class)
    public void testDivDoubleValues(double x, double y) {
        double expected = x / y;
        assertThat(calculator.div(x, y), equalTo(expected));
    }

    @Test(dataProvider = "IncorrectDataForDiv",
            dataProviderClass = DataProviderForCalc.class,
            expectedExceptions = NumberFormatException.class)
    public void testNegativeDivScenarios(long x, long y) {
        calculator.div(x, y);
    }
}