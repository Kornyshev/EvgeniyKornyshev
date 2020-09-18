package hw7.tests;

import beans.ConfirmationThatBoardDeleted;
import beans.TrelloBoard;
import hw7.data.TestData;
import io.qameta.allure.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static hw7.service.CommonContext.*;
import static hw7.tests.steps.BoardsActions.createNewBoardWithName;
import static hw7.tests.steps.BoardsActions.deleteBoardByID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

abstract class AbstractTest {

    @Test(priority = 0, dataProvider = "boardsNames", dataProviderClass = TestData.class)
    @Description("Creating boards using test data from Provider")
    public void testCreatingBoard(String name) {
        TrelloBoard board = createNewBoardWithName(name);
        putBoardIdInContextList(board.getId());
        assertThat("Checking that API created board with exact name as in TestData",
                board.getName(), equalTo(name));
    }

    @Test(priority = 100, dataProvider = "boardsIDs", dataProviderClass = TestData.class)
    @Description("Deleting all boards using list if IDs in Context class")
    public void testDeletingAllCreatedBoards(String id) {
        ConfirmationThatBoardDeleted confirmation = deleteBoardByID(id);
        assertThat("Checking that value in response JSON equals NULL",
                confirmation.getValue(), is(nullValue()));
    }

    @AfterClass
    public void tearDown() {
        getBoardsIDs().clear();
        getListsIDs().clear();
    }
}