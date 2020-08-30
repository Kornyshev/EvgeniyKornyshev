package hw7.tests;

import beans.TrelloBoardWithUpdates;
import hw7.data.TestData;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static hw7.tests.steps.BoardsActions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class TrelloBoardsDeeperFlowTest extends AbstractTest {

    public static final String TEST_DESCRIPTION = "Some simple description for boards";

    @Test(priority = 1, dataProvider = "boardsIDs", dataProviderClass = TestData.class)
    @Description("Checking that we just able to get every board by ID")
    public void testGettingEachCreatedBoard(String id) {
        assertThat("Assertion just received board ID's length, that is greater than zero",
                getBoardByID(id).getId().length(), greaterThan(0));
    }

    @Test(priority = 2, dataProvider = "boardsIDs", dataProviderClass = TestData.class)
    @Description("Checking that we can change name of every board")
    public void testBoardsNamesUpdating(String id) {
        String oldName = getBoardByID(id).getName();
        String newName = oldName + "-UPDATED";
        TrelloBoardWithUpdates board = updateBoardNameByID(id, newName);
        assertThat("Assert that created board's name is equal to expected param",
                board.getName(), equalTo(newName));
    }

    @Test(priority = 2, dataProvider = "boardsIDs", dataProviderClass = TestData.class)
    @Description("Checking that we can change name of every board")
    public void testBoardsDescriptionsUpdating(String id) {
        TrelloBoardWithUpdates board = updateBoardDescriptionByID(id, TEST_DESCRIPTION);
        assertThat("Assert that created board's description is equal to expected param",
                board.getDesc(), equalTo(TEST_DESCRIPTION));
    }
}