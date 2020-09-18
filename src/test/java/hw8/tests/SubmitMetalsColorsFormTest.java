package hw8.tests;

import hw8.data.TestDataProvider;
import hw8.data.beans.MetalsAndColorsData;
import org.testng.annotations.Test;

import static hw8.pages.JdiSite.*;
import static hw8.tests.steps.AssertionSteps.checkThatFormSubmittedCorrectly;
import static hw8.tests.steps.AssertionSteps.checkingThatResultsAfterSubmittingAreCorrect;
import static hw8.tests.steps.Steps.shouldBeLoggedIn;

public class SubmitMetalsColorsFormTest implements CommonConditions {

    public static final String METALS_COLORS = "Metals & Colors";

    @Test(dataProvider = "MetalsAndColors", dataProviderClass = TestDataProvider.class)
    public void testMetalsColorsPageOpening(MetalsAndColorsData metalsAndColorsData) {
        shouldBeLoggedIn();
        mainPage.checkOpened();

        headerMenu.clickOnParticularMenuItem(METALS_COLORS);
        metalsColorsPage.checkOpened();

        metalsColorsPage.form.fill(metalsAndColorsData);
        metalsColorsPage.form.check(metalsAndColorsData);

        metalsColorsPage.form.submit();
        checkThatFormSubmittedCorrectly(metalsColorsPage, metalsAndColorsData);

        checkingThatResultsAfterSubmittingAreCorrect(metalsColorsPage, metalsAndColorsData);

        mainPage.open();
    }
}