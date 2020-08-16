package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CommonConditions {

    protected Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
    }
}