package hw3.pages;

import hw3.pages.components.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected HeaderMenu headerMenu;
    protected WebDriver driver;

    @FindBy(css = "div[name='navigation-sidebar']")
    private WebElement navigationSidebar;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        headerMenu = new HeaderMenu(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean navigationBarIsDisplayed() {
        return navigationSidebar.isDisplayed();
    }
}
