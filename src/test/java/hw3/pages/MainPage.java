package hw3.pages;

import hw3.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    public static final String HOMEPAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.profile-photo")
    private WebElement profileIcon;

    @FindBy(css = "input#name")
    private WebElement userNameField;

    @FindBy(css = "input#password")
    private WebElement passwordField;

    @FindBy(css = "button#login-button")
    private WebElement loginButton;

    public MainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public LoggedInMainPage loginAs(final User user) {
        profileIcon.click();
        userNameField.sendKeys(user.getUsername());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
        return new LoggedInMainPage(driver);
    }
}