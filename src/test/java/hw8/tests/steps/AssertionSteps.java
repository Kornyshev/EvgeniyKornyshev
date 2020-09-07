package hw8.tests.steps;

import com.epam.jdi.light.elements.common.UIElement;
import hw8.data.beans.DataBean;
import hw8.pages.MetalsColorsPage;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

import static hw8.data.ResultsStringConstants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class AssertionSteps {

    public static final int EXPECTED_RESULTS_SIZE = 5;

    @Step("Checking that Metals and Colors form submitted successfully")
    public static void checkThatFormSubmittedCorrectly(
            MetalsColorsPage page, DataBean dataBean) {
        int expectedLogSize =
                dataBean.getSummary().length + dataBean.getElements().length + 3;
        /*
        I use number 3 in expectedLogSize because we should calculate all
        interactions with form and logs for each interaction (except Vegetables dropdown).
        So, we have 2 interaction from Summary[],
        Elements[] array's size and additionally for exactly one interaction with
        Color, Metal dropdowns and for Form submitting.
        So, us result - exactly three additional log strings.
         */
        page.logsList
                .assertThat().size(expectedLogSize);
        page.resultsList
                .assertThat().size(EXPECTED_RESULTS_SIZE);
    }

    @Step("Checking that Result area has correctly data after Form submitting")
    public static void checkingThatResultsAfterSubmittingAreCorrect(
            MetalsColorsPage page, DataBean dataBean) {
        List<String> results = page
                .resultsList
                .stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
        assertThat(results.get(0), equalToIgnoringCase(SUMMARY
                + (dataBean.getSummary()[0] + dataBean.getSummary()[1])));
        assertThat(results.get(1),
                equalToIgnoringCase(ELEMENTS + dataBean.getElementsInOneString()));
        assertThat(results.get(2),
                equalToIgnoringCase(COLOR + dataBean.getColor()));
        assertThat(results.get(3),
                equalToIgnoringCase(METAL + dataBean.getMetals()));
        assertThat(results.get(4),
                equalToIgnoringCase(VEGETABLES + dataBean.getVegetablesInOneString()));
    }
}