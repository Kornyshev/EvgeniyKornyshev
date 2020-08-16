package hw3.tests.steps;

import hw3.data.SelectColor;
import hw3.pages.AbstractPage;
import hw3.pages.DifferentElementsPage;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSteps {

    public static void checkThatMainTitleIsCorrect(AbstractPage page, String expected) {
        assertEquals(page.getTitle(), expected);
    }

    public static void checkThatAllUiElementsAreExist(DifferentElementsPage page) {
        SoftAssert softly = new SoftAssert();
        for (WebElement el : page.getAllElements()) {
            softly.assertTrue(el.isDisplayed());
        }
        softly.assertAll();
    }

    public static void checkThatLogAreaIsExist(DifferentElementsPage page) {
        assertTrue(page.logAreaIsDisplayed());
    }

    public static void checkThatNavbarIsExist(DifferentElementsPage page) {
        assertTrue(page.navigationBarIsDisplayed());
    }

    public static void checkWaterAndWindAreChecked(DifferentElementsPage page) {
        SoftAssert softly = new SoftAssert();
        softly.assertTrue(page.components.waterIsChecked());
        softly.assertTrue(page.components.windIsChecked());
        softly.assertAll();
    }

    public static void checkWaterAndWindAreUnchecked(DifferentElementsPage page) {
        SoftAssert softly = new SoftAssert();
        softly.assertFalse(page.components.waterIsChecked());
        softly.assertFalse(page.components.windIsChecked());
        softly.assertAll();
    }

    public static void clickWaterAndWindCheckboxes(DifferentElementsPage page) {
        page.components.clickWaterCheckbox();
        page.components.clickWindCheckbox();
    }

    public static void checkLogsAboutWaterWindChecking(
            DifferentElementsPage page, String water, String wind) {
        SoftAssert softly = new SoftAssert();
        softly.assertTrue(page.components
                .getActualLogs().get(0).getText().contains(wind));
        softly.assertTrue(page.components
                .getActualLogs().get(1).getText().contains(water));
        softly.assertAll();
    }

    public static void checkLogsAboutWaterWindUnchecking(
            DifferentElementsPage page, String water, String wind) {
        SoftAssert softly = new SoftAssert();
        softly.assertTrue(page.components
                .getActualLogs().get(0).getText().contains(wind));
        softly.assertTrue(page.components
                .getActualLogs().get(1).getText().contains(water));
        softly.assertAll();
    }

    public static void clickSelenRadioButton(DifferentElementsPage page) {
        page.components.setSelenRadio();
    }

    public static void checkThatSelenRadioIsSelected(DifferentElementsPage page) {
        assertTrue(page.components.selenRadioIsChecked());
    }

    public static void checkLogsAboutSelenRadioSelection(DifferentElementsPage page, String log) {
        assertTrue(page.components
                .getActualLogs().get(0).getText().contains(log));
    }

    public static void selectYellowInDropdown(DifferentElementsPage page) {
        page.components.selectColor(SelectColor.YELLOW);
    }

    public static void checkThatYellowWasSelected(DifferentElementsPage page) {
        assertEquals(page.components.getFirstSelectedColor(), "Yellow");
    }

    public static void checkLogsAboutYellowSelection(DifferentElementsPage page, String color) {
        assertTrue(page.components
                .getActualLogs().get(0).getText().contains(color));
    }
}