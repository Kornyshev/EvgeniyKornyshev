package hw8.tests;

import hw8.data.UserContainer;
import hw8.data.entities.User;
import org.testng.annotations.Test;

import static hw8.pages.JdiSite.*;
import static hw8.tests.steps.Steps.shouldBeLoggedIn;
import static hw8.tests.steps.Steps.shouldBeLoggedOut;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class SubmitContactFormTest implements CommonConditions {

    @Test(priority = 0)
    public void testHomePageOpening() {
        mainPage.checkOpened();
    }

    @Test(priority = 1)
    public void testLoggedInHomePage() {
        shouldBeLoggedOut();
        User testUser = UserContainer.ROMAN;
        userIcon.click();
        loginForm.loginAs(testUser);
        userName.is().text(equalToIgnoringCase(testUser.getFullName()));
    }

    @Test(priority = 2)
    public void testLoggingOut() {
        shouldBeLoggedIn();
        logoutButton.click();
        userName.is().hidden();
    }
}