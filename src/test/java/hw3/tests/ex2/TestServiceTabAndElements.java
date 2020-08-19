package hw3.tests.ex2;

import hw3.data.TestData;
import hw3.pages.DifferentElementsPage;
import hw3.tests.CommonTest;
import org.testng.annotations.Test;

import static hw3.tests.steps.DifferentElementsPageSteps.*;
import static hw3.tests.steps.LoggedMainPageSteps.*;

public class TestServiceTabAndElements extends CommonTest {

    DifferentElementsPage elementsPage;

    @Test(priority = 10)
    public void testServiceDropdownInHeader() {
        //5. Click on Service subcategory in the header and
        //check that drop down contains options
        checkServiceDropdownInHeader(loggedInMainPage);
    }

    @Test(priority = 11)
    public void testServiceDropdownInSidebar() {
        //6. Click on Service subcategory in the left section
        //and check that drop down contains options
        checkServiceDropdownInSidebar(loggedInMainPage);
    }

    @Test(priority = 12)
    public void testDifferentElementsPageIsOpened() {
        //7. Open through the header menu Service - Different Elements Page
        elementsPage = navigateToDiffElementsUsingHeader(loggedInMainPage);
        checkThatMainTitleIsCorrect(elementsPage, DIFF_ELEM_PAGE_TITLE);
    }

    @Test(priority = 13)
    public void testAllElementsAreDisplayed() {
        //8. Check interface on Different elements page, it
        //contains all needed elements
        checkThatAllUiElementsAreExist(elementsPage);
    }

    @Test(priority = 14)
    public void testLogAreaIsDisplayed() {
        //9. Assert that there is Right Section
        checkThatLogAreaIsExist(elementsPage);
    }

    @Test(priority = 15)
    public void testNavigationBarIsDisplayed() {
        //10. Assert that there is Left Section
        checkThatNavbarIsExist(elementsPage);
    }

    @Test(priority = 16)
    public void testWaterAndWindAreChecked() {
        //11. Select checkboxes
        checkWaterAndWindAreUnchecked(elementsPage);
        clickWaterAndWindCheckboxes(elementsPage);
        checkWaterAndWindAreChecked(elementsPage);
    }

    @Test(priority = 17, dataProvider = "WaterWindAreChecked",
            dataProviderClass = TestData.class)
    public void testWaterWindCheckingInLogs(String water, String wind) {
        //12. Assert that for each checkbox there is an
        //individual log row and value is corresponded to
        //the status of checkbox.
        checkLogsAboutWaterWindChecking(elementsPage, water, wind);
    }

    @Test(priority = 18)
    public void testSelenRadioIsChecked() {
        //13. Select radio
        clickSelenRadioButton(elementsPage);
        checkThatSelenRadioIsSelected(elementsPage);
    }

    @Test(priority = 19, dataProvider = "SelenRadioIsChecked",
            dataProviderClass = TestData.class)
    public void testSelenCheckingInLogs(String selen) {
        //14. Assert that for radiobutton there is a log row and
        //value is corresponded to the status of
        //radiobutton.
        checkLogsAboutSelenRadioSelection(elementsPage, selen);
    }

    @Test(priority = 20)
    public void testYellowColorIsSelected() {
        //15. Select in dropdown
        selectYellowInDropdown(elementsPage);
        checkThatYellowWasSelected(elementsPage);
    }

    @Test(priority = 21, dataProvider = "YellowIsChecked",
            dataProviderClass = TestData.class)
    public void testColorSelectionInLogs(String yellow) {
        //16. Assert that for dropdown there is a log row and
        //value is corresponded to the selected value.
        checkLogsAboutYellowSelection(elementsPage, yellow);
    }

    @Test(priority = 22)
    public void testWaterAndWindUnchecking() {
        //17. Unselect and assert checkboxes
        checkWaterAndWindAreChecked(elementsPage);
        clickWaterAndWindCheckboxes(elementsPage);
        checkWaterAndWindAreUnchecked(elementsPage);
    }

    @Test(priority = 23, dataProvider = "WaterWindAreUnchecked",
            dataProviderClass = TestData.class)
    public void testWaterAndWindUncheckingInLogs(String water, String wind) {
        //18. Assert that for each checkbox there is an
        //individual log row and value is corresponded to
        //the status of checkbox.
        checkLogsAboutWaterWindUnchecking(elementsPage, water, wind);
    }
}