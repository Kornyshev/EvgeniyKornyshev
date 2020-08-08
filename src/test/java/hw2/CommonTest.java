package hw2;

import hw2.data.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CommonTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate()
                .to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Test
    public void testMainPageTitle() {
        //2. Assert Browser title
        assertThat(driver.getTitle(), equalTo("Home Page"));
    }

    @Test(priority = 1, dataProvider = "TestUserData",
            dataProviderClass = TestData.class)
    public void testMainPageLoggedIn(String userName, String pass) {
        //3. Perform login
        driver.findElement(By.cssSelector("div.profile-photo")).click();
        driver.findElement(By.cssSelector("input#name")).sendKeys(userName);
        driver.findElement(By.cssSelector("input#password")).sendKeys(pass);
        driver.findElement(By.cssSelector("button#login-button")).click();

        //4. Assert User name in the left-top side of
        //screen that user is loggined
        String actualUserName = driver.findElement(
                By.cssSelector("span#user-name")).getText();
        assertThat(actualUserName, equalTo("ROMAN IOVLEV"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}