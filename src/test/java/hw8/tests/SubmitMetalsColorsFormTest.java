package hw8.tests;

import com.epam.jdi.light.elements.common.UIElement;
import hw8.data.TestData;
import hw8.data.UserContainer;
import hw8.data.beans.DataBean;
import hw8.data.entities.User;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static hw8.pages.JdiSite.*;
import static hw8.tests.steps.Steps.shouldBeLoggedOut;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class SubmitMetalsColorsFormTest implements CommonConditions {

    public static final String METALS_COLORS = "Metals & Colors";
    public static final int EXPECTED_LOG_SIZE = 7;
    public static final int EXPECTED_RESULTS_SIZE = 5;
    private DataBean dataBean;

    public SubmitMetalsColorsFormTest(DataBean dataBean) {
        this.dataBean = dataBean;
    }

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
        metalsColorsPage.logsList
                .assertThat().size(EXPECTED_LOG_SIZE);
        metalsColorsPage.resultsList
                .assertThat().size(EXPECTED_RESULTS_SIZE);
    }

    @Test(priority = 5,dependsOnMethods = "testMetalColorFormSubmitted",
            dataProvider = "Results", dataProviderClass = TestData.class)
    public void testResultSectionData(
            String summary, String elements, String color, String metal, String vegetables) {
        List<String> results = metalsColorsPage
                .resultsList
                .stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
        assertThat(results.get(0), equalToIgnoringCase(summary
                + (dataBean.getSummary()[0] + dataBean.getSummary()[1])));
        assertThat(results.get(1),
                equalToIgnoringCase(elements + dataBean.getElementsInOneString()));
        assertThat(results.get(2),
                equalToIgnoringCase(color + dataBean.getColor()));
        assertThat(results.get(3),
                equalToIgnoringCase(metal + dataBean.getMetals()));
        assertThat(results.get(4),
                equalToIgnoringCase(vegetables + dataBean.getVegetablesInOneString()));
    }
}