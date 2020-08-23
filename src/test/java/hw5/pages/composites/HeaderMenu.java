package hw5.pages.composites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderMenu {

    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 li a")
    private List<WebElement> headerLinks;

    @FindBy(css = "span#user-name")
    private WebElement userName;

    public void clickOnHeaderMenuLink(String linkText) {
        for (WebElement link : headerLinks) {
            if (link.getText().trim().equalsIgnoreCase(linkText)) {
                link.click();
                break;
            }
        }
    }

    public String getUserName() {
        return userName.getText().trim();
    }
}