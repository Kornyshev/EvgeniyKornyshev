package hw3.tests.ex1;

import hw3.data.TestData;
import hw3.tests.CommonTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertTrue;

public class TestContentOnMainPage extends CommonTest {

    String parentPageHandle;

    @Test(priority = 10)
    public void testPageTitle() {
        //5. Assert Browser title
        assertThat(loggedInMainPage.getTitle(), equalTo(EXPECTED_MAIN_TITLE));
    }

    @Test(priority = 11, dataProvider = "ExpectedLinksText",
            dataProviderClass = TestData.class)
    public void testLinksInHeaderMenu(
            String home, String contact, String service, String metals) {
        //6. Assert that there are 4 items on the header
        //section are displayed and they have proper
        //texts
        SoftAssert softly = new SoftAssert();
        List<WebElement> links = loggedInMainPage.allMainLinks();
        softly.assertEquals(links.size(), 4);
        for (WebElement link : links) {
            softly.assertTrue(link.isDisplayed());
        }
        softly.assertEquals(links.get(0).getText(), home);
        softly.assertEquals(links.get(1).getText(), contact);
        softly.assertEquals(links.get(2).getText(), service);
        softly.assertEquals(links.get(3).getText(), metals);
        softly.assertAll();
    }

    @Test(priority = 12)
    public void testBenefitImagesAreDisplayed() {
        //7 Assert that there are 4 images on the Index
        //Page and they are displayed
        SoftAssert softly = new SoftAssert();
        for (WebElement image : loggedInMainPage.getBenefitImages()) {
            softly.assertTrue(image.isDisplayed());
        }
        softly.assertAll();
    }

    @Test(priority = 13, dataProvider = "ExpectedTextBelowImages",
            dataProviderClass = TestData.class)
    public void testTextBelowImages(
            String t1, String t2, String t3, String t4) {
        //8. Assert that there are 4 texts on the Index
        //Page under icons and they have proper text
        List<WebElement> texts = loggedInMainPage.getBenefitText();
        SoftAssert softly = new SoftAssert();
        softly.assertEquals(texts.get(0).getText(), t1);
        softly.assertEquals(texts.get(1).getText(), t2);
        softly.assertEquals(texts.get(2).getText(), t3);
        softly.assertEquals(texts.get(3).getText(), t4);
        softly.assertAll();
    }

    @Test(priority = 14, dataProvider = "ExpectedMainTitles",
            dataProviderClass = TestData.class)
    public void testMainTitlesText(String expectedTitle, String expectedText) {
        //9. Assert a text of the main headers
        SoftAssert softly = new SoftAssert();
        softly.assertEquals(loggedInMainPage.getMainTitleText(),
                expectedTitle);
        softly.assertEquals(loggedInMainPage.getTextBelowMainTitle(),
                expectedText);
        softly.assertAll();
    }

    @Test(priority = 15)
    public void testIFramesAreExist() {
        //10. Assert that there is the iframe in the center of page
        assertThat(loggedInMainPage.allIFramesOnPage().size(), is(4));
        parentPageHandle = driver.getWindowHandle();
    }

    @Test(priority = 16)
    public void testEpamLogoInFrameExists() {
        //11. Switch to the iframe and check that there is
        //Epam logo in the left top conner of iframe
        driver.switchTo().frame(loggedInMainPage.getSpecificIFrame());
        assertTrue(driver.findElement(loggedInMainPage.epamLogoInFrame).isDisplayed());
        driver.switchTo().parentFrame();
    }

    @Test(priority = 17)
    public void testFocusOnOriginalWindow() {
        //12. Switch to original window back
        assertThat(driver.getWindowHandle(), equalTo(parentPageHandle));
    }

    @Test(priority = 18, dataProvider = "ExpectedJdiTextAndLink",
            dataProviderClass = TestData.class)
    public void testJdiGitHubLink(String expectedText, String expectedLink) {
        WebElement jdiGitHub = loggedInMainPage.getJdiGitHubLink();
        SoftAssert softly = new SoftAssert();
        //13. Assert a text of the sub header
        softly.assertEquals(jdiGitHub.getText(), expectedText);

        //14. Assert that JDI GITHUB is a link and has a proper URL
        softly.assertEquals(jdiGitHub.getAttribute("href"), expectedLink);
        softly.assertAll();
    }

    @Test(priority = 19)
    public void testSidebarIsExist() {
        //15. Assert that there is Left Section
        assertTrue(loggedInMainPage.sidebarIsDisplayed());
    }

    @Test(priority = 20)
    public void testFooterIsExist() {
        //16. Assert that there is Footer
        assertTrue(loggedInMainPage.footerIsDisplayed());
    }
}