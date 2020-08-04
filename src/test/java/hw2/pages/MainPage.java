package hw2.pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage{

    public static final String PAGE_URL = "";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }
}