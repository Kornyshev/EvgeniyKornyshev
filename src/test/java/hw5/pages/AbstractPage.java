package hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}