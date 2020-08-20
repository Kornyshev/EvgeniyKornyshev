package hw5.pages;

import org.openqa.selenium.WebDriver;

public class LoggedInMainPage extends AbstractPage {

    public LoggedInMainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnHeaderMenuLink(String link) {
        headerMenu.clickOnHeaderMenuLink(link);
    }
}