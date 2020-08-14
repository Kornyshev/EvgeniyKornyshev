package hw4.tests.ex1;

import hw4.data.TestData;
import hw4.tests.CommonTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.List;

import static hw4.tests.steps.LoggedMainPageSteps.*;
import static hw4.tests.steps.MainPageSteps.checkThatMainTitleIsCorrect;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Feature(value = "Test correctly presentation some elements on the Main Page")
public class TestContentOnMainPage extends CommonTest {

    String parentPageHandle;

    @Story(value = "Check page title")
    @Test(priority = 10)
    public void testPageTitle() {
        //5. Assert Browser title
        checkThatMainTitleIsCorrect(loggedInMainPage, EXPECTED_MAIN_TITLE);
    }

    @Story(value = "Check links in Header menu")
    @Test(priority = 11, dataProvider = "ExpectedLinksText", dataProviderClass = TestData.class)
    public void testLinksInHeaderMenu(List<String> expectedResult) {
        //6. Assert that there are 4 items on the header
        //section are displayed and they have proper
        //texts
        checkThatLinksInHeaderAreExist(loggedInMainPage, expectedResult);
    }

    @Story(value = "Check images and text on the Main page")
    @Test(priority = 12)
    public void testBenefitImagesAreDisplayed() {
        //7 Assert that there are 4 images on the Index
        //Page and they are displayed
        checkThatBenefitImagesAreExist(loggedInMainPage);
    }

    @Story(value = "Check images and text on the Main page")
    @Test(priority = 13, dataProvider = "ExpectedTextBelowImages",
            dataProviderClass = TestData.class)
    public void testTextBelowImages(List<String> expect) {
        //8. Assert that there are 4 texts on the Index
        //Page under icons and they have proper text
        checkThatTextsBelowImagesAreExist(loggedInMainPage, expect);
    }

    @Story(value = "Check images and text on the Main page")
    @Test(priority = 14, dataProvider = "ExpectedMainTitles", dataProviderClass = TestData.class)
    public void testMainTitlesText(String expectedTitle, String expectedText) {
        //9. Assert a text of the main headers
        checkMainTitleAndTextNearThat(loggedInMainPage, expectedTitle, expectedText);
    }

    @Story(value = "Check interaction with IFrame")
    @Test(priority = 15)
    public void testIFramesAreExist() {
        //10. Assert that there is the iframe in the center of page
        checkIFramesQuantityOnPage(loggedInMainPage);
        parentPageHandle = driver.getWindowHandle();
    }

    @Story(value = "Check interaction with IFrame")
    @Test(priority = 16)
    public void testEpamLogoInFrameExists() {
        //11. Switch to the iframe and check that there is
        //Epam logo in the left top conner of iframe
        driver.switchTo().frame(loggedInMainPage.getSpecificIFrame());
        checkLogoInFrameExist(driver, loggedInMainPage);
        driver.switchTo().parentFrame();
    }

    @Story(value = "Check interaction with IFrame")
    @Test(priority = 17)
    public void testFocusOnOriginalWindow() {
        //12. Switch to original window back
        assertThat(driver.getWindowHandle(), equalTo(parentPageHandle));
    }

    @Story(value = "Check JDI GitHub link")
    @Test(priority = 18, dataProvider = "ExpectedJdiTextAndLink",
            dataProviderClass = TestData.class)
    public void testJdiGitHubLink(String expectedText, String expectedLink) {
        //13. Assert a text of the sub header
        //14. Assert that JDI GITHUB is a link and has a proper URL
        checkThatJdiGitHubLinkIsCorrect(loggedInMainPage, expectedText, expectedLink);
    }

    @Story(value = "Check that Sidebar and Footer are exist")
    @Test(priority = 19)
    public void testSidebarIsExist() {
        //15. Assert that there is Left Section
        checkThatSidebarIsExist(loggedInMainPage);
    }

    @Story(value = "Check that Sidebar and Footer are exist")
    @Test(priority = 20)
    public void testFooterIsExist() {
        //16. Assert that there is Footer
        checkThatFooterIsExist(loggedInMainPage);
    }
}