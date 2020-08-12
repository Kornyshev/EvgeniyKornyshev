package hw3.pages.components;

import hw3.pages.DifferentElementsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HeaderMenu {

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private final WebDriver driver;

    @FindBy(xpath = "//a[text()='Home']")
    private WebElement homeLink;

    @FindBy(xpath = "//a[text()='Contact form']")
    private WebElement contactFormLink;

    @FindBy(xpath = "//a[contains(text(), 'Service')]")
    private WebElement serviceLink;

    @FindBy(css = "ul.dropdown-menu li")
    private List<WebElement> serviceHeaderDropdown;

    @FindBy(xpath = "//a[contains(text(), 'Different elements')]")
    private WebElement differentElementsPageLink;

    @FindBy(xpath = "//a[text()='Metals & Colors']")
    private WebElement metalsColorsLink;

    public List<WebElement> allMainLinks() {
        return Stream
                .of(homeLink, contactFormLink, serviceLink, metalsColorsLink)
                .collect(Collectors.toList());
    }

    public List<WebElement> getServiceHeaderDropdown() {
        serviceLink.click();
        return serviceHeaderDropdown;
    }

    public DifferentElementsPage clickDifferentElementsPageLink() {
        serviceLink.click();
        differentElementsPageLink.click();
        return new DifferentElementsPage(driver);
    }

    public void clickServiceOnSidebar() {
        serviceLink.click();
    }
}