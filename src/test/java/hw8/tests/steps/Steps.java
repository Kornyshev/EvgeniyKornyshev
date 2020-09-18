package hw8.tests.steps;

import com.epam.jdi.light.elements.composite.WebPage;
import hw8.data.UserContainer;
import io.qameta.allure.Step;

import static hw8.pages.JdiSite.*;

public class Steps {

    public static void onSite() {
        if (!WebPage.getUrl().contains("https://jdi-testing.github.io/jdi-light")) {
            mainPage.open();
        }
    }

    @Step("Checking that we aren't logged in and if we are - log out and hide login form")
    public static void shouldBeLoggedOut() {
        onSite();
        if (userName.isDisplayed()) {
            if (!logoutButton.isDisplayed()) {
                userIcon.click();
            }
            logoutButton.click();
        }
        if (loginForm.isDisplayed()) {
            userIcon.click();
        }
    }

    @Step("Checking that we are logged in and we aren't - click on UserIcon and submit LoginForm")
    public static void shouldBeLoggedIn() {
        onSite();
        if (!userName.isDisplayed()) {
            if (!loginForm.isDisplayed()) {
                userIcon.click();
            }
            loginForm.submit(UserContainer.ROMAN);
        }
    }
}