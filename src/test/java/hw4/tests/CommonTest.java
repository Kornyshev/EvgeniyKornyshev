package hw4.tests;

import hw4.data.TestData;
import hw4.driver.DriverFactory;
import hw4.pages.LoggedInMainPage;
import hw4.pages.MainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw4.tests.steps.MainPageSteps.*;

@Feature(value = "Test Login on the site as TestUser")
public class CommonTest {

    protected LoggedInMainPage loggedInMainPage;
    protected MainPage mainPage;
    public static WebDriver driver;
    //protected WebDriver driver;
    protected static final String EXPECTED_MAIN_TITLE = "Home Page";
    protected static final String DIFF_ELEM_PAGE_TITLE = " WRONG!!! Different Elements";

    @BeforeClass
    public void setUp(ITestContext context) {
        driver = DriverFactory.create();
        mainPage = new MainPage(driver);
        mainPage.openPage();
    }

    @BeforeMethod
    public void beforeMethod(ITestContext context) {
    }

    @Story(value = "Checking that we are on the proper page")
    @Test(priority = 1, alwaysRun = true)
    public void testPageTitle() {
        //2. Assert Browser title
        checkThatMainTitleIsCorrect(mainPage, EXPECTED_MAIN_TITLE);
    }

    @Story(value = "Exact test of login process and assertion after that one")
    @Test(priority = 2, dataProvider = "ExpectedUsername",
            dataProviderClass = TestData.class, alwaysRun = true)
    public void testLogin(String expectedUsername) {
        //3. Perform login
        loggedInMainPage = loginAsTestUser(mainPage);

        //4. Assert User name in the left-top side of
        //screen that user is loggined
        checkThatUserLoggedInCorrectly(loggedInMainPage, expectedUsername);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}