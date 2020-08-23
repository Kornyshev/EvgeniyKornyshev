package hw5.pages;

import hw5.pages.composites.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class AbstractPage {

    protected WebDriver driver;
    protected HeaderMenu headerMenu;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        headerMenu = new HeaderMenu(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}