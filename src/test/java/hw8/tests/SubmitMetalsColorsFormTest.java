package hw8.tests;

import hw8.data.TestDataProvider;
import hw8.data.UserContainer;
import hw8.data.beans.DataBean;
import hw8.data.entities.User;
import org.testng.annotations.Test;

import static hw8.pages.JdiSite.*;
import static hw8.tests.steps.AssertionSteps.checkThatFormSubmittedCorrectly;
import static hw8.tests.steps.AssertionSteps.checkingThatResultsAfterSubmittingAreCorrect;
import static hw8.tests.steps.Steps.shouldBeLoggedIn;
import static hw8.tests.steps.Steps.shouldBeLoggedOut;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class SubmitMetalsColorsFormTest implements CommonConditions {

    public static final String METALS_COLORS = "Metals & Colors";

    @Test(priority = 0)
    public void testThatWeAreOnMainPage() {
        shouldBeLoggedOut();
        mainPage.checkOpened();
    }

    @Test(priority = 1)
    public void testLoginAsTestUser() {
        User testUser = UserContainer.ROMAN;
        userIcon.click();
        loginForm.loginAs(testUser);
        userName.is().text(equalToIgnoringCase(testUser.getFullName()));
    }

    @Test(priority = 2, dataProvider = "MetalsAndColors",
            dataProviderClass = TestDataProvider.class)
    public void testMetalsColorsPageOpening(DataBean dataBean) {
        shouldBeLoggedIn();
        mainPage.checkOpened();

        headerMenu.clickOnParticularMenuItem(METALS_COLORS);
        metalsColorsPage.checkOpened();

        metalsColorsPage.form.fill(dataBean);
        metalsColorsPage.form.check(dataBean);

        metalsColorsPage.form.submit();
        checkThatFormSubmittedCorrectly(metalsColorsPage, dataBean);

        checkingThatResultsAfterSubmittingAreCorrect(metalsColorsPage, dataBean);

        mainPage.open();
    }
}