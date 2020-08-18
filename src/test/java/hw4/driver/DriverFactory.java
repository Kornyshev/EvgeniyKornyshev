package hw4.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver create() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(
                new ChromeOptions().addArguments("headless"));
        driver.manage().window().maximize();
        return driver;
    }
}