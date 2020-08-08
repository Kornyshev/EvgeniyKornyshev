package hw2.ex1;

import hw2.CommonTest;
import hw2.data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertTrue;

public class TestContentOnMainPage extends CommonTest {

    String windowHandle;

    @Test(priority = 2)
    public void testLoggedMainPageTitle() {
        //Assert browser title when we are logged in
        assertThat(driver.getTitle(), equalTo("Home Page"));
    }

    @Test(priority = 3)
    public void testHeaderLinksText() {
        //Finding all links from header
        final WebElement homeLink = driver.findElement(
                By.xpath("//a[text()='Home']"));
        final WebElement contactFormLink = driver.findElement(
                By.xpath("//a[text()='Contact form']"));
        final WebElement serviceLink = driver.findElement(
                By.xpath("//a[contains(text(), 'Service')]"));
        final WebElement metalsAndColorsLink = driver.findElement(
                By.xpath("//a[text()='Metals & Colors']"));

        //Assert their visibility
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homeLink.isDisplayed());
        softAssert.assertTrue(contactFormLink.isDisplayed());
        softAssert.assertTrue(serviceLink.isDisplayed());
        softAssert.assertTrue(metalsAndColorsLink.isDisplayed());

        //Assert header's links texts
        softAssert.assertEquals(homeLink.getText(), "HOME");
        softAssert.assertEquals(contactFormLink.getText(), "CONTACT FORM");
        softAssert.assertEquals(serviceLink.getText(), "SERVICE");
        softAssert.assertEquals(metalsAndColorsLink.getText(), "METALS & COLORS");
        softAssert.assertAll();
    }

    @Test(priority = 4, dataProvider = "ExpectedTextBelowImages",
            dataProviderClass = TestData.class)
    public void testFourImagesAndTextBelowThem(
            String s1, String s2, String s3, String s4) {
        //Assert that all four images are displayed
        final List<WebElement> imagesOnMainPage = driver.findElements(
                By.cssSelector("div.benefit-icon"));
        for (WebElement image : imagesOnMainPage) {
            assertTrue(image.isDisplayed());
        }

        //Asserting all texts below images
        final List<WebElement> textsBelowImages = driver.findElements(
                By.cssSelector("span.benefit-txt"));
        assertThat(textsBelowImages.size(), is(4));
        assertThat(textsBelowImages.get(0).getText(), equalTo(s1));
        assertThat(textsBelowImages.get(1).getText(), equalTo(s2));
        assertThat(textsBelowImages.get(2).getText(), equalTo(s3));
        assertThat(textsBelowImages.get(3).getText(), equalTo(s4));
    }

    @Test(priority = 5, dataProvider = "ExpectedTextOfMainCenterTitles",
            dataProviderClass = TestData.class)
    public void testMainHeadersOnThePage(
            String expectedTitle, String expectedText) {
        //Assert Main center title and text below that one
        final WebElement mainTitle = driver.findElement(
                By.cssSelector("h3.main-title.text-center"));
        final WebElement textBelowTitle = driver.findElement(
                By.cssSelector("p.main-txt.text-center"));
        assertThat(mainTitle.getText(), equalTo(expectedTitle));
        assertThat(textBelowTitle.getText(), equalTo(expectedText));
    }

    @Test(priority = 6)
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

    @Test(priority = 7)
    public void testFocusOnOriginalWindow() {
        //Assert that current Window handle is equal to saved handle
        assertThat(driver.getWindowHandle(), equalTo(windowHandle));
    }

    @Test(priority = 8)
    public void testTextAndLinkOfSubHeader() {
        //Assert link on JDI GitHub
        final WebElement jdiGitHubLink = driver.findElement(
                By.cssSelector("h3.text-center a"));
        String expectedUrl = "https://github.com/epam/JDI";
        assertThat(jdiGitHubLink.getText(), equalTo("JDI GITHUB"));
        assertThat(jdiGitHubLink.getAttribute("href"),
                equalTo(expectedUrl));
    }

    @Test(priority = 9)
    public void testLeftSectionAndFooterAreExist() {
        //Assert that left section and footer are displayed
        final WebElement leftSection = driver.findElement(
                By.cssSelector("div[name='navigation-sidebar']"));
        final WebElement footer = driver.findElement(
                By.cssSelector("div.footer-content.overflow"));
        assertTrue(leftSection.isDisplayed());
        assertTrue(footer.isDisplayed());
    }
}