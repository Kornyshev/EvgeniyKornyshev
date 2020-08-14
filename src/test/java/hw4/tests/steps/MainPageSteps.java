package hw4.tests.steps;

import hw4.pages.AbstractPage;
import hw4.pages.LoggedInMainPage;
import hw4.pages.MainPage;
import hw4.service.UserCreator;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class MainPageSteps {

    @Step(value = "Check that Main Title is correct")
    public static void checkThatMainTitleIsCorrect(AbstractPage page, String expected) {
        assertEquals(page.getTitle(), expected);
    }

    @Step(value = "Login step")
    public static LoggedInMainPage loginAsTestUser(MainPage page) {
        return page.loginAs(UserCreator.createFromPropertiesFile());
    }

    @Step(value = "Check that login was successful")
    public static void checkThatUserLoggedInCorrectly(LoggedInMainPage page, String expected) {
        assertEquals(page.getUserName(), expected);
    }
}