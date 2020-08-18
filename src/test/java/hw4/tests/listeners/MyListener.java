package hw4.tests.listeners;

import hw4.tests.CommonTest;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        File srcFile = ((TakesScreenshot) CommonTest.driver).getScreenshotAs(OutputType.FILE);
        try {
            Allure.addAttachment("Something wrong with test on this page",
                    new FileInputStream(srcFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}