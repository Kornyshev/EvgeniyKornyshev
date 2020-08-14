package hw4.tests.steps;

import hw4.pages.DifferentElementsPage;
import hw4.pages.LoggedInMainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertTrue;

public class LoggedMainPageSteps {

    @Step
    public static void checkThatLinksInHeaderAreExist(LoggedInMainPage page, List<String> expect) {
        SoftAssert softly = new SoftAssert();
        List<WebElement> links = page.allMainLinks();
        softly.assertEquals(links.size(), 4);
        for (WebElement link : links) {
            softly.assertTrue(link.isDisplayed());
        }
        softly.assertEquals(links.get(0).getText(), expect.get(0));
        softly.assertEquals(links.get(1).getText(), expect.get(1));
        softly.assertEquals(links.get(2).getText(), expect.get(2));
        softly.assertEquals(links.get(3).getText(), expect.get(3));
        softly.assertAll();
    }

    @Step
    public static void checkThatBenefitImagesAreExist(LoggedInMainPage page) {
        SoftAssert softly = new SoftAssert();
        for (WebElement image : page.getBenefitImages()) {
            softly.assertTrue(image.isDisplayed());
        }
        softly.assertAll();
    }

    @Step
    public static void checkThatTextsBelowImagesAreExist(
            LoggedInMainPage page, List<String> expected) {
        List<WebElement> actualTexts = page.getBenefitText();
        SoftAssert softly = new SoftAssert();
        softly.assertEquals(actualTexts.get(0).getText(), expected.get(0));
        softly.assertEquals(actualTexts.get(1).getText(), expected.get(1));
        softly.assertEquals(actualTexts.get(2).getText(), expected.get(2));
        softly.assertEquals(actualTexts.get(3).getText(), expected.get(3));
        softly.assertAll();
    }

    @Step
    public static void checkMainTitleAndTextNearThat(
            LoggedInMainPage page, String title, String text) {
        SoftAssert softly = new SoftAssert();
        softly.assertEquals(page.getMainTitleText(), title);
        softly.assertEquals(page.getTextBelowMainTitle(), text);
        softly.assertAll();
    }

    @Step
    public static void checkIFramesQuantityOnPage(LoggedInMainPage page) {
        assertThat(page.allIFramesOnPage().size(), is(4));
    }

    @Step
    public static void checkLogoInFrameExist(WebDriver driver, LoggedInMainPage page) {
        assertTrue(driver.findElement(page.epamLogoInFrame).isDisplayed());
    }

    @Step
    public static void checkThatJdiGitHubLinkIsCorrect(
            LoggedInMainPage page, String text, String link) {
        WebElement jdiGitHub = page.getJdiGitHubLink();
        SoftAssert softly = new SoftAssert();
        //13. Assert a text of the sub header
        softly.assertEquals(jdiGitHub.getText(), text);

        //14. Assert that JDI GITHUB is a link and has a proper URL
        softly.assertEquals(jdiGitHub.getAttribute("href"), link);
        softly.assertAll();
    }

    @Step
    public static void checkThatSidebarIsExist(LoggedInMainPage page) {
        assertTrue(page.sidebarIsDisplayed());
    }

    @Step
    public static void checkThatFooterIsExist(LoggedInMainPage page) {
        assertTrue(page.footerIsDisplayed());
    }

    @Step
    public static void checkServiceDropdownInHeader(LoggedInMainPage page) {
        SoftAssert softly = new SoftAssert();
        for (WebElement el : page.getServiceHeaderDropdown()) {
            softly.assertTrue(el.isDisplayed());
        }
        softly.assertAll();
    }

    @Step
    public static void checkServiceDropdownInSidebar(LoggedInMainPage page) {
        SoftAssert softly = new SoftAssert();
        for (WebElement el : page.getServiceSidebarDropdown()) {
            softly.assertTrue(el.isDisplayed());
        }
        softly.assertAll();
    }

    @Step
    public static DifferentElementsPage navigateToDiffElementsUsingHeader(LoggedInMainPage page) {
        return page.clickDiffElementsPageLink();
    }
}