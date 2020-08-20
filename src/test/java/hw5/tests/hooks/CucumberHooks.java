package hw5.tests.hooks;

import hw5.context.Context;
import hw5.driver.DriverCreator;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void setUp() {
        Context
                .getInstance()
                .setDriver(DriverCreator.create());
    }

    @After
    public void tearDown() {
        Context
                .getInstance()
                .getDriver()
                .quit();
    }
}