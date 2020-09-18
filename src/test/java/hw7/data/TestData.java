package hw7.data;

import hw7.service.CommonContext;
import org.assertj.core.util.Arrays;
import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "boardsNames")
    public Object[][] getTestBoardsNames() {
        return new Object[][]{
                {"First test board"},
                {"Just second test board"},
                {"One more name for test board"}
        };
    }

    @DataProvider(name = "boardsIDs")
    public Object[][] getBoardsIDs() {
        return CommonContext.getBoardsIDs()
                .stream()
                .map(Arrays::array)
                .toArray(String[][]::new);
    }

    @DataProvider(name = "listsIDs")
    public Object[][] getListsIDs() {
        return CommonContext.getListsIDs()
                .stream()
                .map(Arrays::array)
                .toArray(String[][]::new);
    }

    @DataProvider(name = "cardsIDs")
    public Object[][] getCardsIDs() {
        return CommonContext.getCardsIDs()
                .stream()
                .map(Arrays::array)
                .toArray(String[][]::new);
    }
}
