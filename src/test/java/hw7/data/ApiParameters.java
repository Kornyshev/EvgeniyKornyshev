package hw7.data;


import java.util.ResourceBundle;

public class ApiParameters {

    private static final ResourceBundle trelloBundle = ResourceBundle.getBundle("hw7.Trello");

    public static String trelloKey() {
        return trelloBundle.getString("trello.key");
    }

    public static String trelloToken() {
        return trelloBundle.getString("trello.token");
    }

    public static String basePath() {
        return trelloBundle.getString("trello.basePath");
    }

    public static String boards() {
        return trelloBundle.getString("trello.boards");
    }

    public static String lists() {
        return trelloBundle.getString("trello.lists");
    }

    public static String cards() {
        return trelloBundle.getString("trello.cards");
    }
}