package hw2.ex1;

import hw2.data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertTrue;

public class TestContentOnMainPage extends CommonTest {

    String windowHandle;

    @Test(priority = 20)
    public void testLoggedMainPageTitle() {
        //Assert browser title when we are logged in
        assertThat(driver.getTitle(), equalTo("Home Page"));
    }

    @Test(priority = 30)
    public void testHeaderLinksText() {
        //Finding all links from header
        WebElement homeLink = driver.findElement
                (By.xpath("//a[text()='Home']"));
        WebElement contactFormLink = driver.findElement
                (By.xpath("//a[text()='Contact form']"));
        WebElement serviceLink = driver.findElement
                (By.xpath("//a[contains(text(), 'Service')]"));
        WebElement metalsAndColorsLink = driver.findElement
                (By.xpath("//a[text()='Metals & Colors']"));

        //Assert their visibility
        assertTrue(homeLink.isDisplayed());
        assertTrue(contactFormLink.isDisplayed());
        assertTrue(serviceLink.isDisplayed());
        assertTrue(metalsAndColorsLink.isDisplayed());

        //Assert header's links texts
        assertThat(homeLink.getText(), equalTo("HOME"));
        assertThat(contactFormLink.getText(), equalTo("CONTACT FORM"));
        assertThat(serviceLink.getText(), equalTo("SERVICE"));
        assertThat(metalsAndColorsLink.getText(), equalTo("METALS & COLORS"));
    }

    @Test(priority = 40, dataProvider = "ExpectedTextBelowImages",
            dataProviderClass = TestData.class)
    public void testFourImagesAndTextBelowThem
            (String s1, String s2, String s3, String s4) {
        //Assert that all four images are displayed
        List<WebElement> imagesOnMainPage = driver.findElements(
                By.cssSelector("div.benefit-icon"));
        for (WebElement image : imagesOnMainPage) {
            assertTrue(image.isDisplayed());
        }

        //Asserting all texts below images
        List<WebElement> textsBelowImages = driver.findElements(
                By.cssSelector("span.benefit-txt"));
        assertThat(textsBelowImages.size(), is(4));
        assertThat(textsBelowImages.get(0).getText(), equalTo(s1));
        assertThat(textsBelowImages.get(1).getText(), equalTo(s2));
        assertThat(textsBelowImages.get(2).getText(), equalTo(s3));
        assertThat(textsBelowImages.get(3).getText(), equalTo(s4));
    }

    @Test(priority = 50, dataProvider = "ExpectedTextOfMainCenterTitles",
            dataProviderClass = TestData.class)
    public void testMainHeadersOnThePage
            (String expectedTitle, String expectedText) {
        //Assert Main center title and text below that one
        WebElement mainTitle = driver.findElement(
                By.cssSelector("h3.main-title.text-center"));
        WebElement textBelowTitle = driver.findElement(
                By.cssSelector("p.main-txt.text-center"));
        assertThat(mainTitle.getText(), equalTo(expectedTitle));
        assertThat(textBelowTitle.getText(), equalTo(expectedText));
    }

    @Test(priority = 60)
    public void testFramesAreExistAndLogoInFrame() {
        //Assert that there are four frames on the page
        windowHandle = driver.getWindowHandle();
        assertThat(driver.findElements(By.tagName("iframe")).size(), is(4));

        //Assert that the logo is exist in second frame
        driver.switchTo().frame("second_frame");
        assertTrue(driver.findElement(
                By.cssSelector("img#epam-logo")).isDisplayed());
        driver.switchTo().parentFrame();
    }

    @Test(priority = 70)
    public void testFocusOnOriginalWindow() {
        //Assert that current Window handle is equal to saved handle
        assertThat(driver.getWindowHandle(), equalTo(windowHandle));
    }

    @Test(priority = 80)
    public void testTextAndLinkOfSubHeader() {
        //Assert link on JDI GitHub
        WebElement jdiGitHubLink = driver.findElement(
                By.cssSelector("h3.text-center a"));
        String expectedUrl = "https://github.com/epam/JDI";
        assertThat(jdiGitHubLink.getText(), equalTo("JDI GITHUB"));
        assertThat(jdiGitHubLink.getAttribute("href"),
                equalTo(expectedUrl));
    }

    @Test(priority = 90)
    public void testLeftSectionAndFooterAreExist() {
        //Assert that left section and footer are displayed
        WebElement leftSection = driver.findElement(
                By.cssSelector("div[name='navigation-sidebar']"));
        WebElement footer = driver.findElement(
                By.cssSelector("div.footer-content.overflow"));
        assertTrue(leftSection.isDisplayed());
        assertTrue(footer.isDisplayed());
    }
}