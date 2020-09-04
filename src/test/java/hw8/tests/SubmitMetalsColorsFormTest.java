package hw8.tests;

import hw8.data.JsonParser;
import hw8.data.UserContainer;
import hw8.data.beans.DataBean;
import hw8.data.entities.User;
import org.testng.annotations.Test;

import static hw8.pages.JdiSite.*;
import static hw8.tests.steps.Steps.shouldBeLoggedOut;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class SubmitMetalsColorsFormTest implements CommonConditions {

    public static final String METALS_COLORS = "Metals & Colors";
    private DataBean dataBean = JsonParser.testDataBeans().get(2);

//    public SubmitMetalsColorsFormTest(DataBean dataBean) {
//        this.dataBean = dataBean;
//    }

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

    @Test(priority = 2)
    public void testMetalsColorsPageOpening() {
        headerMenu.clickOnParticularMenuItem(METALS_COLORS);
        metalsColorsPage.checkOpened();
    }

    @Test(priority = 3)
    public void testMetalColorFormIsFilled() {
        metalsColorsPage.form.fill(dataBean);
        metalsColorsPage.form.check(dataBean);
    }

    @Test(priority = 4)
    public void testMetalColorFormSubmitted() {
        metalsColorsPage.form.submit();
    }

    @Test(priority = 5)
    public void testResultSectionData() {

    }
}