package hw1.tests;

import hw1.CommonConditions;
import hw1.DataProviderForCalc;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CalculatorCosTest extends CommonConditions {

    @Test(dataProvider = "CorrectIntTestData",
            dataProviderClass = DataProviderForCalc.class, enabled = false)
    public void testCos(double angle) {
        double expected = Math.cos(angle);
        /*
        Cos method is incorrect in Calculator.class!!!
         */
        assertThat(calculator.cos(angle), equalTo(expected));
    }
}