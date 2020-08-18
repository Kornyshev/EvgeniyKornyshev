package hw4.tests.steps;

import hw4.data.SelectColor;
import hw4.pages.AbstractPage;
import hw4.pages.DifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSteps {

    @Step(value = "Checking that the Main title is correct")
    public static void checkThatMainTitleIsCorrect(AbstractPage page, String expected) {
        assertEquals(page.getTitle(), expected);
    }

    @Step(value = "Checking that all UI elements are displayed")
    public static void checkThatAllUiElementsAreExist(DifferentElementsPage page) {
        SoftAssert softly = new SoftAssert();
        for (WebElement el : page.getAllElements()) {
            softly.assertTrue(el.isDisplayed());
        }
        softly.assertAll();
    }

    @Step(value = "Checking that Log area is exist")
    public static void checkThatLogAreaIsExist(DifferentElementsPage page) {
        assertTrue(page.logAreaIsDisplayed());
    }

    @Step(value = "Checking that Navigation bar is exist")
    public static void checkThatNavbarIsExist(DifferentElementsPage page) {
        assertTrue(page.navigationBarIsDisplayed());
    }

    @Step(value = "Checking that Water and Wind checkboxes are selected")
    public static void checkWaterAndWindAreChecked(DifferentElementsPage page) {
        SoftAssert softly = new SoftAssert();
        softly.assertTrue(page.components.waterIsChecked());
        softly.assertTrue(page.components.windIsChecked());
        softly.assertAll();
    }

    @Step(value = "Checking that Water and Wind checkboxes are unselected")
    public static void checkWaterAndWindAreUnchecked(DifferentElementsPage page) {
        SoftAssert softly = new SoftAssert();
        softly.assertFalse(page.components.waterIsChecked());
        softly.assertFalse(page.components.windIsChecked());
        softly.assertAll();
    }

    @Step(value = "Click on Water and Wind checkboxes")
    public static void clickWaterAndWindCheckboxes(DifferentElementsPage page) {
        page.components.clickWaterCheckbox();
        page.components.clickWindCheckbox();
    }

    @Step(value = "Checking that Logs have records about checkbox selecting in proper order")
    public static void checkLogsAboutWaterWindChecking(
            DifferentElementsPage page, String water, String wind) {
        SoftAssert softly = new SoftAssert();
        softly.assertTrue(page.components
                .getActualLogs().get(0).getText().contains(wind));
        softly.assertTrue(page.components
                .getActualLogs().get(1).getText().contains(water));
        softly.assertAll();
    }

    @Step(value = "Checking that Logs have records about checkbox unselecting in proper order")
    public static void checkLogsAboutWaterWindUnchecking(
            DifferentElementsPage page, String water, String wind) {
        SoftAssert softly = new SoftAssert();
        softly.assertTrue(page.components
                .getActualLogs().get(0).getText().contains(wind));
        softly.assertTrue(page.components
                .getActualLogs().get(1).getText().contains(water));
        softly.assertAll();
    }

    @Step(value = "Click on Selen radio button")
    public static void clickSelenRadioButton(DifferentElementsPage page) {
        page.components.setSelenRadio();
    }

    @Step(value = "Checking that Selen radio button is selected")
    public static void checkThatSelenRadioIsSelected(DifferentElementsPage page) {
        assertTrue(page.components.selenRadioIsChecked());
    }

    @Step(value = "Checking that Logs have records about radio button selecting in proper order")
    public static void checkLogsAboutSelenRadioSelection(DifferentElementsPage page, String log) {
        assertTrue(page.components
                .getActualLogs().get(0).getText().contains(log));
    }

    @Step(value = "Select Yellow color in dropdown")
    public static void selectYellowInDropdown(DifferentElementsPage page) {
        page.components.selectColor(SelectColor.YELLOW);
    }

    @Step(value = "Checking that Yellow color in dropdown was selected")
    public static void checkThatYellowWasSelected(DifferentElementsPage page) {
        assertEquals(page.components.getFirstSelectedColor(), "Yellow");
    }

    @Step(value = "Checking that Logs have records about color dropdown selecting in proper order")
    public static void checkLogsAboutYellowSelection(DifferentElementsPage page, String color) {
        assertTrue(page.components
                .getActualLogs().get(0).getText().contains(color));
    }
}