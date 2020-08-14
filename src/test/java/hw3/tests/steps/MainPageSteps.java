package hw3.tests.steps;

import hw3.pages.AbstractPage;
import hw3.pages.LoggedInMainPage;
import hw3.pages.MainPage;
import hw3.service.UserCreator;

import static org.testng.Assert.assertEquals;

public class MainPageSteps {

    public static void checkThatMainTitleIsCorrect(AbstractPage page, String expected) {
        assertEquals(page.getTitle(), expected);
    }

    public static LoggedInMainPage loginAsTestUser(MainPage page) {
        return page.loginAs(UserCreator.createFromPropertiesFile());
    }

    public static void checkThatUserLoggedInCorrectly(LoggedInMainPage page, String expected) {
        assertEquals(page.getUserName(), expected);
    }
}