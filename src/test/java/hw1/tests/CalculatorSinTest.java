package hw1.tests;

import hw1.CommonConditions;
import hw1.DataProviderForCalc;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CalculatorSinTest extends CommonConditions {

    @Test(dataProvider = "CorrectIntTestData",
            dataProviderClass = DataProviderForCalc.class)
    public void testSin(double angle) {
        double expected = Math.sin(angle);
        assertThat(calculator.sin(angle), equalTo(expected));
    }
}