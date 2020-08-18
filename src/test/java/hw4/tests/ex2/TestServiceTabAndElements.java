package hw4.tests.ex2;

import hw4.data.TestData;
import hw4.pages.DifferentElementsPage;
import hw4.tests.CommonTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static hw4.tests.steps.DifferentElementsPageSteps.*;
import static hw4.tests.steps.LoggedMainPageSteps.*;

@Feature(value = "Test a few scenarios of interactions with UI "
        + "on Main and Different Elements pages")
public class TestServiceTabAndElements extends CommonTest {

    DifferentElementsPage elementsPage;

    @Story(value = "Check that Service dropdown is correctly displayed")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(priority = 10, alwaysRun = true)
    public void testServiceDropdownInHeader() {
        //5. Click on Service subcategory in the header and
        //check that drop down contains options
        checkServiceDropdownInHeader(loggedInMainPage);
    }

    @Story(value = "Check that Service dropdown is correctly displayed")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(priority = 11, alwaysRun = true)
    public void testServiceDropdownInSidebar() {
        //6. Click on Service subcategory in the left section
        //and check that drop down contains options
        checkServiceDropdownInSidebar(loggedInMainPage);
    }

    @Story(value = "Check that Different Elements page could be opened")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test(priority = 12, alwaysRun = true)
    public void testDifferentElementsPageIsOpened() {
        //7. Open through the header menu Service - Different Elements Page
        elementsPage = navigateToDiffElementsUsingHeader(loggedInMainPage);
        checkThatMainTitleIsCorrect(elementsPage, DIFF_ELEM_PAGE_TITLE);
    }

    @Story(value = "Check all elements on the page are displayed")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 13, alwaysRun = true)
    public void testAllElementsAreDisplayed() {
        //8. Check interface on Different elements page, it
        //contains all needed elements
        checkThatAllUiElementsAreExist(elementsPage);
    }

    @Story(value = "Check all elements on the page are displayed")
    @Severity(value = SeverityLevel.MINOR)
    @Test(priority = 14, alwaysRun = true)
    public void testLogAreaIsDisplayed() {
        //9. Assert that there is Right Section
        checkThatLogAreaIsExist(elementsPage);
    }

    @Story(value = "Check all elements on the page are displayed")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 15, alwaysRun = true)
    public void testNavigationBarIsDisplayed() {
        //10. Assert that there is Left Section
        checkThatNavbarIsExist(elementsPage);
    }

    @Story(value = "Check interaction with checkboxes in direct way")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 16, alwaysRun = true)
    public void testWaterAndWindAreChecked() {
        //11. Select checkboxes
        checkWaterAndWindAreUnchecked(elementsPage);
        clickWaterAndWindCheckboxes(elementsPage);
        checkWaterAndWindAreChecked(elementsPage);
    }

    @Story(value = "Check interaction with checkboxes in direct way")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 17, dataProvider = "WaterWindAreChecked",
            dataProviderClass = TestData.class, alwaysRun = true,
            dependsOnMethods = {"testWaterAndWindAreChecked"})
    public void testWaterWindCheckingInLogs(String water, String wind) {
        //12. Assert that for each checkbox there is an
        //individual log row and value is corresponded to
        //the status of checkbox.
        checkLogsAboutWaterWindChecking(elementsPage, water, wind);
    }

    @Story(value = "Check interaction with radio button")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 18, alwaysRun = true)
    public void testSelenRadioIsChecked() {
        //13. Select radio
        clickSelenRadioButton(elementsPage);
        checkThatSelenRadioIsSelected(elementsPage);
    }

    @Story(value = "Check interaction with radio button")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 19, dataProvider = "SelenRadioIsChecked",
            dataProviderClass = TestData.class, alwaysRun = true,
            dependsOnMethods = {"testSelenRadioIsChecked"})
    public void testSelenCheckingInLogs(String selen) {
        //14. Assert that for radiobutton there is a log row and
        //value is corresponded to the status of
        //radiobutton.
        checkLogsAboutSelenRadioSelection(elementsPage, selen);
    }

    @Story(value = "Check interaction with select dropdown")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 20, alwaysRun = true)
    public void testYellowColorIsSelected() {
        //15. Select in dropdown
        selectYellowInDropdown(elementsPage);
        checkThatYellowWasSelected(elementsPage);
    }

    @Story(value = "Check interaction with select dropdown")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 21, dataProvider = "YellowIsChecked",
            dataProviderClass = TestData.class, alwaysRun = true,
            dependsOnMethods = {"testYellowColorIsSelected"})
    public void testColorSelectionInLogs(String yellow) {
        //16. Assert that for dropdown there is a log row and
        //value is corresponded to the selected value.
        checkLogsAboutYellowSelection(elementsPage, yellow);
    }

    @Story(value = "Check interaction with checkboxes in opposite way")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 22, alwaysRun = true)
    public void testWaterAndWindUnchecking() {
        //17. Unselect and assert checkboxes
        checkWaterAndWindAreChecked(elementsPage);
        clickWaterAndWindCheckboxes(elementsPage);
        checkWaterAndWindAreUnchecked(elementsPage);
    }

    @Story(value = "Check interaction with checkboxes in opposite way")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 23, dataProvider = "WaterWindAreUnchecked",
            dataProviderClass = TestData.class, alwaysRun = true,
            dependsOnMethods = {"testWaterAndWindUnchecking"})
    public void testWaterAndWindUncheckingInLogs(String water, String wind) {
        //18. Assert that for each checkbox there is an
        //individual log row and value is corresponded to
        //the status of checkbox.
        checkLogsAboutWaterWindUnchecking(elementsPage, water, wind);
    }
}