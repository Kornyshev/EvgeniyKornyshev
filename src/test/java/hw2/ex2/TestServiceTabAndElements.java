package hw2.ex2;

import hw2.CommonTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestServiceTabAndElements extends CommonTest {

    By locatorForAllCheckboxes = By.cssSelector("div.checkbox-row label");
    By logArea = By.cssSelector("ul.panel-body-list.logs li");
    By colorSelector = By.cssSelector("div.colors select");

    //Those locators are made by ChroPath, just for test purpose
    WebElement water;
    WebElement wind;
    By selenRadio = By.xpath("//div[3]//label[4]//input[1]");

    @Test(priority = 2)
    public void testServiceLinkInHeader() {
        driver.findElement(By.xpath("//a[contains(text(), 'Service')]"))
                .click();

        //5. Click on Service subcategory in the header and
        //check that drop down contains options
        SoftAssert softAssert = new SoftAssert();
        final List<WebElement> dropdown = driver.findElements(
                By.cssSelector("ul.dropdown-menu li"));
        assertThat(dropdown.size(), is(9));
        for (WebElement element : dropdown) {
            softAssert.assertTrue(element.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void testServiceLinkInLeftNavBar() {
        driver.findElement(By.xpath("//li[@class='menu-title']"
                + "/a/span[contains(text(), 'Service')]")).click();

        //6. Click on Service subcategory in the left section
        //and check that drop down contains options
        SoftAssert softAssert = new SoftAssert();
        final List<WebElement> sideBarDropdown = driver.findElements(
                By.cssSelector("li[index='3'] ul.sub li"));
        assertThat(sideBarDropdown.size(), is(9));
        for (WebElement element : sideBarDropdown) {
            softAssert.assertTrue(element.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void testDifferentElementsPageOpening() {
        driver.findElement(By.xpath("//a[contains(text(), 'Service')]"))
                .click();
        driver.findElement(By.xpath("//a[contains(text(), "
                + "'Different elements')]")).click();

        //7. Open through the header menu Service  - Different Elements Page
        assertThat(driver.getTitle(), equalTo("Different Elements"));
    }

    @Test(priority = 5)
    public void testAllElementsAreExist() {
        final List<WebElement> checkboxes = driver.findElements(
                locatorForAllCheckboxes);

        //8. Check interface on Different elements page, it
        //contains all needed elements
        SoftAssert softAssert = new SoftAssert();
        for (WebElement checkbox : checkboxes) {
            softAssert.assertTrue(checkbox.isDisplayed());
        }
        softAssert.assertTrue(driver.findElement(colorSelector).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector(
                "button[name='Default Button']")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector(
                "input[value='Button']")).isDisplayed());
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void testLeftAndRightSectionAreExists() {
        //9. Assert that there is Right Section
        assertTrue(driver.findElement(By.cssSelector(
                "ul.panel-body-list.logs")).isDisplayed());

        //10. Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector(
                "ul.sidebar-menu")).isDisplayed());
    }

    @Test(priority = 7)
    public void testWaterWindCheckboxesAndLogForThem() {
        //11. Select checkboxes
        water = driver.findElement(By.xpath(
                "//div//div//div//div[2]//label[1]//input[1]"));
        wind = driver.findElement(By.xpath(
                "//div//div//div//div[2]//label[3]//input[1]"));
        water.click();
        wind.click();
        assertTrue(water.isSelected());
        assertTrue(wind.isSelected());

        //12. Assert that for each checkbox there is an
        //individual log row and value is corresponded to
        //the status of checkbox.
        List<WebElement> logs = driver.findElements(logArea);
        assertThat(logs.size(), is(2));
        assertTrue(logs.get(0).getText().contains(
                "Wind: condition changed to true"));
        assertTrue(logs.get(1).getText().contains(
                "Water: condition changed to true"));
    }

    @Test(priority = 8)
    public void testSelenRadioAndLogForThisOne() {
        //13. Select radio
        final WebElement selen = driver.findElement(selenRadio);
        selen.click();
        assertTrue(selen.isSelected());

        //14. Assert that for radiobutton there is a log row and
        //value is corresponded to the status of
        //radiobutton.
        List<WebElement> logs = driver.findElements(logArea);
        assertTrue(logs.get(0).getText().contains(
                "metal: value changed to Selen"));
    }

    @Test(priority = 9)
    public void testYellowDropdownAndLofForThisOne() {
        //15. Select in dropdown
        Select colors = new Select(driver.findElement(colorSelector));
        colors.selectByVisibleText("Yellow");

        //16. Assert that for dropdown there is a log row and
        //value is corresponded to the selected value.
        List<WebElement> logs = driver.findElements(logArea);
        assertTrue(logs.get(0).getText().contains(
                "Colors: value changed to Yellow"));
    }

    @Test(priority = 10)
    public void testUnselectCheckboxesAndLogForThatAction() {
        //17. Unselect and assert checkboxes
        water.click();
        wind.click();
        assertFalse(water.isSelected());
        assertFalse(wind.isSelected());

        //18. Assert that for each checkbox there is an
        //individual log row and value is corresponded to
        //the status of checkbox.
        List<WebElement> logs = driver.findElements(logArea);
        assertThat(logs.size(), is(6));
        assertTrue(logs.get(0).getText().contains(
                "Wind: condition changed to false"));
        assertTrue(logs.get(1).getText().contains(
                "Water: condition changed to false"));
    }
}