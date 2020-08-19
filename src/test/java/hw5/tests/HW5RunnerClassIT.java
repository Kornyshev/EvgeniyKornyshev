package hw5.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/hw5",
        glue = "src/test/java/hw5/steps",
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"})
public class HW5RunnerClassIT extends AbstractTestNGCucumberTests {
}