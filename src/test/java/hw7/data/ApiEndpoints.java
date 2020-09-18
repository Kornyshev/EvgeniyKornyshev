package hw7.data;

import static hw7.data.ApiParameters.*;

public enum ApiEndpoints {
    BOARDS(boards()),
    LISTS(lists()),
    CARDS(cards());

    private final String value;

    ApiEndpoints(String boards) {
        this.value = boards;
    }

    public String value() {
        return value;
    }
}