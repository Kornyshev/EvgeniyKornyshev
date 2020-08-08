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
        //5. Assert Browser title
        assertThat(driver.getTitle(), equalTo("Home Page"));
    }

    @Test(priority = 3)
    public void testHeaderLinksText() {
        //6. Assert that there are 4 items on the header
        //section are displayed and they have proper
        //texts
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

    @Test(priority = 4)
    public void testFourImagesAndTextBelowThem() {
        //7. Assert that there are 4 images on the Index
        //Page and they are displayed
        final List<WebElement> imagesOnMainPage = driver.findElements(
                By.cssSelector("div.benefit-icon"));
        for (WebElement image : imagesOnMainPage) {
            assertTrue(image.isDisplayed());
        }
    }

    @Test(priority = 5, dataProvider = "ExpectedTextBelowImages",
            dataProviderClass = TestData.class)
    public void testTextsBelowImages(
            String s1, String s2, String s3, String s4) {
        //8. Assert that there are 4 texts on the Index
        //Page under icons and they have proper text
        final List<WebElement> textsBelowImages = driver.findElements(
                By.cssSelector("span.benefit-txt"));
        assertThat(textsBelowImages.size(), is(4));
        assertThat(textsBelowImages.get(0).getText(), equalTo(s1));
        assertThat(textsBelowImages.get(1).getText(), equalTo(s2));
        assertThat(textsBelowImages.get(2).getText(), equalTo(s3));
        assertThat(textsBelowImages.get(3).getText(), equalTo(s4));
    }

    @Test(priority = 6, dataProvider = "ExpectedTextOfMainCenterTitles",
            dataProviderClass = TestData.class)
    public void testMainHeadersOnThePage(
            String expectedTitle, String expectedText) {
        //9. Assert a text of the main headers
        final WebElement mainTitle = driver.findElement(
                By.cssSelector("h3.main-title.text-center"));
        final WebElement textBelowTitle = driver.findElement(
                By.cssSelector("p.main-txt.text-center"));
        assertThat(mainTitle.getText(), equalTo(expectedTitle));
        assertThat(textBelowTitle.getText(), equalTo(expectedText));
    }

    @Test(priority = 7)
    public void testFramesAreExistAndLogoInFrame() {
        //10. Assert that there is the iframe in the center of page
        windowHandle = driver.getWindowHandle();
        assertThat(driver.findElements(By.tagName("iframe")).size(), is(4));

        //11. Switch to the iframe and check that there is
        //Epam logo in the left top conner of iframe
        driver.switchTo().frame("second_frame");
        assertTrue(driver.findElement(
                By.cssSelector("img#epam-logo")).isDisplayed());
        driver.switchTo().parentFrame();
    }

    @Test(priority = 8)
    public void testFocusOnOriginalWindow() {
        //12. Switch to original window back
        assertThat(driver.getWindowHandle(), equalTo(windowHandle));
    }

    @Test(priority = 9)
    public void testTextAndLinkOfSubHeader() {
        final WebElement jdiGitHubLink = driver.findElement(
                By.cssSelector("h3.text-center a"));
        String expectedUrl = "https://github.com/epam/JDI";

        //13. Assert a text of the sub header
        assertThat(jdiGitHubLink.getText(), equalTo("JDI GITHUB"));

        //14. Assert that JDI GITHUB is a link and has a proper URL
        assertThat(jdiGitHubLink.getAttribute("href"),
                equalTo(expectedUrl));
    }

    @Test(priority = 10)
    public void testLeftSectionAndFooterAreExist() {
        final WebElement leftSection = driver.findElement(
                By.cssSelector("div[name='navigation-sidebar']"));
        final WebElement footer = driver.findElement(
                By.cssSelector("div.footer-content.overflow"));

        //15. Assert that there is Left Section
        assertTrue(leftSection.isDisplayed());

        //16. Assert that there is Footer
        assertTrue(footer.isDisplayed());
    }
}