package hw5.pages;

import hw5.context.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public static final String HOMEPAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

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

    public LoggedInMainPage loginAs(final User user) {
        new WebDriverWait(driver, 10)
                .until(visibilityOfElementLocated(By.cssSelector("div.profile-photo")));
        profileIcon.click();
        userNameField.sendKeys(user.getUsername());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
        return new LoggedInMainPage(driver);
    }
}