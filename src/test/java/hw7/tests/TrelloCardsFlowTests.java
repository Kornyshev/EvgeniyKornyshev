package hw7.tests;

import beans.ListOfBoard;
import beans.TrelloCard;
import hw7.data.TestData;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static hw7.service.CommonContext.putCardIdInContextList;
import static hw7.service.CommonContext.putListIdInContextList;
import static hw7.tests.steps.CardsActions.createOneCard;
import static hw7.tests.steps.CardsActions.deleteCardByID;
import static hw7.tests.steps.ListsActions.createNewList;
import static hw7.tests.steps.ListsActions.getCardsFromList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TrelloCardsFlowTests extends AbstractTest {

    private static final String TEST_CARD_NAME = "Do not forget buy smth or send smth... ";
    private static final int ENTITIES_COUNT = 3;

    @Test(priority = 1, dataProvider = "boardsIDs", dataProviderClass = TestData.class)
    @Description("Creating some lists for every board using IDs from Context")
    public void testCreatingFewListsForBoard(String id) {
        for (int i = 0; i < ENTITIES_COUNT; i++) {
            String name = id + "---" + i;
            ListOfBoard list = createNewList(name, id);
            putListIdInContextList(list.getId());
            assertThat("Assertion actual created list's name with given param",
                    list.getName(), equalTo(name));
        }
    }

    @Test(priority = 2, dataProvider = "listsIDs", dataProviderClass = TestData.class)
    public void testCreatingSomeCardsForEveryList(String id) {
        for (int i = 0; i < ENTITIES_COUNT; i++) {
            String name = TEST_CARD_NAME + i + "!!!";
            TrelloCard card = createOneCard(name, id);
            putCardIdInContextList(card.getId());
            assertThat("Assertion actual created card's name with given param",
                    card.getName(), equalTo(name));
        }
    }

    @Test(priority = 3, dataProvider = "listsIDs", dataProviderClass = TestData.class)
    public void testCardsQuantityInEachList(String id) {
        /*
        WRONG TEST
         */
        assertThat("Assert that every lists contains necessary quantity of cards",
                getCardsFromList(id).size(), equalTo(ENTITIES_COUNT + 1));
    }

    @Test(priority = 4, dataProvider = "cardsIDs", dataProviderClass = TestData.class)
    public void testDeletingEachCardFromListsByID(String id) {
        assertThat("Assert that we are able to delete each card from system",
                deleteCardByID(id).getStatusCode(), equalTo(HttpStatus.SC_OK));
    }
}