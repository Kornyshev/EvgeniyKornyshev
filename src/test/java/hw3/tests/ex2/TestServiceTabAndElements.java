package hw3.tests.ex2;

import hw3.data.SelectColor;
import hw3.data.TestData;
import hw3.pages.DifferentElementsPage;
import hw3.tests.CommonTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestServiceTabAndElements extends CommonTest {

    DifferentElementsPage elementsPage;

    @Test(priority = 10)
    public void testServiceDropdownInHeader() {
        //5. Click on Service subcategory in the header and
        //check that drop down contains options
        SoftAssert softly = new SoftAssert();
        for (WebElement el : loggedInMainPage.getServiceHeaderDropdown()) {
            softly.assertTrue(el.isDisplayed());
        }
        softly.assertAll();
    }

    @Test(priority = 11)
    public void testServiceDropdownInSidebar() {
        //6. Click on Service subcategory in the left section
        //and check that drop down contains options
        SoftAssert softly = new SoftAssert();
        for (WebElement el : loggedInMainPage.getServiceSidebarDropdown()) {
            softly.assertTrue(el.isDisplayed());
        }
        softly.assertAll();
    }

    @Test(priority = 12)
    public void testDifferentElementsPageIsOpened() {
        //7. Open through the header menu Service - Different Elements Page
        elementsPage = loggedInMainPage.clickDiffElementsPageLink();
        assertThat(elementsPage.getTitle(),
                equalTo(DIFF_ELEM_PAGE_TITLE));
    }

    @Test(priority = 13)
    public void testAllElementsAreDisplayed() {
        //8. Check interface on Different elements page, it
        //contains all needed elements
        SoftAssert softly = new SoftAssert();
        for (WebElement el : elementsPage.getAllElements()) {
            softly.assertTrue(el.isDisplayed());
        }
        softly.assertAll();
    }

    @Test(priority = 14)
    public void testLogAreaIsDisplayed() {
        //9. Assert that there is Right Section
        assertTrue(elementsPage.logAreaIsDisplayed());
    }

    @Test(priority = 15)
    public void testNavigationBarIsDisplayed() {
        //10. Assert that there is Left Section
        assertTrue(elementsPage.navigationBarIsDisplayed());
    }

    @Test(priority = 16)
    public void testWaterAndWindAreChecked() {
        //11. Select checkboxes
        SoftAssert softly = new SoftAssert();
        softly.assertFalse(elementsPage.components.waterIsChecked());
        softly.assertFalse(elementsPage.components.windIsChecked());
        elementsPage.components.clickWaterCheckbox();
        elementsPage.components.clickWindCheckbox();
        softly.assertTrue(elementsPage.components.waterIsChecked());
        softly.assertTrue(elementsPage.components.windIsChecked());
        softly.assertAll();
    }

    @Test(priority = 17, dataProvider = "WaterWindAreChecked",
            dataProviderClass = TestData.class)
    public void testWaterWindCheckingInLogs(String water, String wind) {
        //12. Assert that for each checkbox there is an
        //individual log row and value is corresponded to
        //the status of checkbox.
        SoftAssert softly = new SoftAssert();
        softly.assertTrue(elementsPage.components
                .getActualLogs().get(0).getText().contains(wind));
        softly.assertTrue(elementsPage.components
                .getActualLogs().get(1).getText().contains(water));
        softly.assertAll();
    }

    @Test(priority = 18)
    public void testSelenRadioIsChecked() {
        //13. Select radio
        elementsPage.components.setSelenRadio();
        assertTrue(elementsPage.components.selenRadioIsChecked());
    }

    @Test(priority = 19, dataProvider = "SelenRadioIsChecked",
            dataProviderClass = TestData.class)
    public void testSelenCheckingInLogs(String selen) {
        //14. Assert that for radiobutton there is a log row and
        //value is corresponded to the status of
        //radiobutton.
        assertTrue(elementsPage.components
                .getActualLogs().get(0).getText().contains(selen));
    }

    @Test(priority = 20)
    public void testYellowColorIsSelected() {
        //15. Select in dropdown
        elementsPage.components.selectColor(SelectColor.YELLOW);
        assertEquals(elementsPage.components.getFirstSelectedColor(), "Yellow");
    }

    @Test(priority = 21, dataProvider = "YellowIsChecked",
            dataProviderClass = TestData.class)
    public void testColorSelectionInLogs(String yellow) {
        //16. Assert that for dropdown there is a log row and
        //value is corresponded to the selected value.
        assertTrue(elementsPage.components
                .getActualLogs().get(0).getText().contains(yellow));
    }

    @Test(priority = 22)
    public void testWaterAndWindUnchecking() {
        //17. Unselect and assert checkboxes
        SoftAssert softly = new SoftAssert();
        softly.assertTrue(elementsPage.components.waterIsChecked());
        softly.assertTrue(elementsPage.components.windIsChecked());
        elementsPage.components.clickWaterCheckbox();
        elementsPage.components.clickWindCheckbox();
        softly.assertFalse(elementsPage.components.waterIsChecked());
        softly.assertFalse(elementsPage.components.windIsChecked());
        softly.assertAll();
    }

    @Test(priority = 23, dataProvider = "WaterWindAreUnchecked",
            dataProviderClass = TestData.class)
    public void testWaterAndWindUncheckingInLogs(String water, String wind) {
        //18. Assert that for each checkbox there is an
        //individual log row and value is corresponded to
        //the status of checkbox.
        SoftAssert softly = new SoftAssert();
        softly.assertTrue(elementsPage.components
                .getActualLogs().get(0).getText().contains(wind));
        softly.assertTrue(elementsPage.components
                .getActualLogs().get(1).getText().contains(water));
        softly.assertAll();
    }
}