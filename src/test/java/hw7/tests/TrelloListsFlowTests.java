package hw7.tests;

import beans.ListOfBoard;
import hw7.data.TestData;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static hw7.service.CommonContext.putListIdInContextList;
import static hw7.tests.steps.ListsActions.createNewList;
import static hw7.tests.steps.ListsActions.getList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class TrelloListsFlowTests extends AbstractTest {

    @Test(priority = 1, dataProvider = "boardsIDs", dataProviderClass = TestData.class)
    @Description("Creating some lists for every board using IDs from Context")
    public void testCreatingFewListsForBoard(String id) {
        for (int i = 0; i < 3; i++) {
            String name = id + "---" + i;
            ListOfBoard list = createNewList(name, id);
            putListIdInContextList(list.getId());
            assertThat("Assertion actual created list's name with given param",
                    list.getName(), equalTo(name));
        }
    }

    @Test(priority = 2, dataProvider = "listsIDs", dataProviderClass = TestData.class)
    @Description("Checking that we just able to get every list by ID")
    public void testGettingEveryCreatedList(String id) {
        assertThat("Assert that we could get every list by ID",
                getList(id).getId().length(), greaterThan(0));
    }
}