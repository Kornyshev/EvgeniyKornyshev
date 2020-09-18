package hw7.service;

import java.util.ArrayList;
import java.util.List;

public class CommonContext {
    private static final List<String> boardsIDs = new ArrayList<>();
    private static final List<String> listsIDs = new ArrayList<>();
    private static final List<String> cardsIDs = new ArrayList<>();

    public static void putBoardIdInContextList(String id) {
        boardsIDs.add(id);
    }

    public static void putListIdInContextList(String id) {
        listsIDs.add(id);
    }

    public static void putCardIdInContextList(String id) {
        cardsIDs.add(id);
    }

    public static List<String> getCardsIDs() {
        return cardsIDs;
    }

    public static List<String> getListsIDs() {
        return listsIDs;
    }

    public static List<String> getBoardsIDs() {
        return boardsIDs;
    }
}