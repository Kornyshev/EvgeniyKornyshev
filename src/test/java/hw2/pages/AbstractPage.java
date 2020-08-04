package hw2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class AbstractPage {

    protected static final int WAIT_TIMEOUT = 30;
    protected WebDriver driver;

    public abstract AbstractPage openPage();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}