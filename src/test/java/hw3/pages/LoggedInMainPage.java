package hw3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoggedInMainPage extends AbstractPage {

    public LoggedInMainPage(WebDriver driver) {
        super(driver);
    }

    public By epamLogoInFrame = By.cssSelector("img#epam-logo");

    @FindBy(css = "span#user-name")
    private WebElement currentUserName;

    @FindBy(css = "div.benefit-icon")
    private List<WebElement> benefitImages;

    @FindBy(css = "span.benefit-txt")
    private List<WebElement> benefitText;

    @FindBy(css = "h3.main-title.text-center")
    private WebElement mainTitle;

    @FindBy(css = "p.main-txt.text-center")
    private WebElement textBelowMainTitle;

    @FindBy(tagName = "iframe")
    private List<WebElement> allIFramesOnPage;

    @FindBy(css = "iframe#second_frame")
    private WebElement secondIFrame;

    @FindBy(css = "h3.text-center a")
    private WebElement jdiGitHubLink;

    @FindBy(css = "div[name='navigation-sidebar']")
    private WebElement navigationSidebar;

    @FindBy(css = "div.footer-content.overflow")
    private WebElement footer;

    @FindBy(xpath = "//li[@class='menu-title']/a")
    private WebElement serviceLinkInSidebar;

    @FindBy(css = "li[index='3'] ul.sub li")
    private List<WebElement> serviceSidebarDropdown;

    public List<WebElement> getServiceSidebarDropdown() {
        serviceLinkInSidebar.click();
        return serviceSidebarDropdown;
    }

    public String getUserName() {
        return currentUserName.getText();
    }

    public List<WebElement> getServiceHeaderDropdown() {
        return headerMenu.getServiceHeaderDropdown();
    }

    public List<WebElement> getBenefitImages() {
        return benefitImages;
    }

    public List<WebElement> getBenefitText() {
        return benefitText;
    }

    public List<WebElement> allIFramesOnPage() {
        return allIFramesOnPage;
    }

    public WebElement getSpecificIFrame() {
        return secondIFrame;
    }

    public String getMainTitleText() {
        return mainTitle.getText();
    }

    public String getTextBelowMainTitle() {
        return textBelowMainTitle.getText();
    }

    public WebElement getJdiGitHubLink() {
        return jdiGitHubLink;
    }

    public List<WebElement> allMainLinks() {
        return headerMenu.allMainLinks();
    }

    public DifferentElementsPage clickDiffElementsPageLink() {
        return headerMenu.clickDifferentElementsPageLink();
    }

    public boolean sidebarIsDisplayed() {
        return navigationSidebar.isDisplayed();
    }

    public boolean footerIsDisplayed() {
        return footer.isDisplayed();
    }
}