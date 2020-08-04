package hw1;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderForCalc {

    @DataProvider(name = "CorrectIntTestData")
    public static Object[][] getCorrectIntData(Method method) {
        if (method.getName().equalsIgnoreCase("testSin")
                || method.getName().equalsIgnoreCase("testCos")) {
            return new Object[][]{
                    {30.0}, {45.0}, {90.0}
            };
        } else {
            return new Object[][]{
                    {10L, 20L},
                    {77L, 90L},
                    {45L, 60L}
            };
        }
    }

    @DataProvider(name = "CorrectDoubleTestData")
    public static Object[][] getCorrectDoubleData() {
        return new Object[][]{
                {455.897, 1235.89},
                {125.89, 587.236},
                {896.236, 452.23}
        };
    }

    @DataProvider(name = "IncorrectDataForDiv")
    public static Object[][] getIncorrectDataForDiv() {
        return new Object[][]{
                {125, 0},
                {7854, 0},
                {895, 0}
        };
    }
}