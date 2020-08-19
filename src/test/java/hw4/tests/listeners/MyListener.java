package hw4.tests.listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try (FileInputStream fis = new FileInputStream(srcFile)) {
            Allure.addAttachment("Something wrong with test on this page", fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}