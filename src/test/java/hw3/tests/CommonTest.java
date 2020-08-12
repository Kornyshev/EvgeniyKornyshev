package hw3.tests;

import hw3.data.TestData;
import hw3.driver.DriverFactory;
import hw3.model.User;
import hw3.pages.LoggedInMainPage;
import hw3.pages.MainPage;
import hw3.service.UserCreator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CommonTest {

    protected LoggedInMainPage loggedInMainPage;
    protected MainPage mainPage;
    protected WebDriver driver;
    protected static final String EXPECTED_MAIN_TITLE = "Home Page";
    protected static final String DIFF_ELEM_PAGE_TITLE = "Different Elements";

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.create();
        mainPage = new MainPage(driver);
        mainPage.openPage();
    }

    @Test
    public void testPageTitle() {
        //2. Assert Browser title
        assertThat(mainPage.getTitle(), equalTo(EXPECTED_MAIN_TITLE));
    }

    @Test(dataProvider = "ExpectedUsername",
            dataProviderClass = TestData.class)
    public void testLogin(String expectedUsername) {
        //3. Perform login
        User testUser = UserCreator.createFromPropertiesFile();
        loggedInMainPage = mainPage.loginAs(testUser);
        String actualUsername = loggedInMainPage.getUserName();

        //4. Assert User name in the left-top side of
        //screen that user is loggined
        assertThat(actualUsername, equalTo(expectedUsername));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}