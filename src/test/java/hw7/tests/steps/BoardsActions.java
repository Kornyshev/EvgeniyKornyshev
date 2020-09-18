package hw7.tests.steps;

import beans.ConfirmationThatBoardDeleted;
import beans.TrelloBoard;
import beans.TrelloBoardWithUpdates;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hw7.data.ApiEndpoints;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static hw7.service.TrelloInteractionApi.*;

public class BoardsActions {

    @Step("Creating simple empty board with given name")
    public static TrelloBoard createNewBoardWithName(String name) {
        return getResponseBoard(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setEndpoint(ApiEndpoints.BOARDS)
                        .setKeyAndToken()
                        .setNameParam(name)
                        .buildRequest()
                        .sendRequest()
        );
    }

    @Step("Getting board by concrete ID")
    public static TrelloBoardWithUpdates getBoardByID(String id) {
        return getResponseBoardWithUpdates(
                requestBuilder()
                        .setMethod(Method.GET)
                        .setEndpoint(ApiEndpoints.BOARDS)
                        .setEntityIdForUri(id)
                        .setKeyAndToken()
                        .buildRequest()
                        .sendRequest()
        );
    }

    @Step("Deleting board by ID")
    public static ConfirmationThatBoardDeleted deleteBoardByID(String id) {
        Response response = requestBuilder()
                .setMethod(Method.DELETE)
                .setEndpoint(ApiEndpoints.BOARDS)
                .setEntityIdForUri(id)
                .setKeyAndToken()
                .buildRequest()
                .sendRequest();
        return new Gson().fromJson(response.asString().trim(),
                new TypeToken<ConfirmationThatBoardDeleted>() {
                }.getType());
    }

    @Step("Update name of board by ID")
    public static TrelloBoardWithUpdates updateBoardNameByID(String id, String newName) {
        return getResponseBoardWithUpdates(
                requestBuilder()
                        .setMethod(Method.PUT)
                        .setEndpoint(ApiEndpoints.BOARDS)
                        .setEntityIdForUri(id)
                        .setKeyAndToken()
                        .setNameParam(newName)
                        .buildRequest()
                        .sendRequest()
        );
    }

    @Step("Update description of board by ID")
    public static TrelloBoardWithUpdates updateBoardDescriptionByID(
            String id, String newDesc) {
        return getResponseBoardWithUpdates(
                requestBuilder()
                        .setMethod(Method.PUT)
                        .setEndpoint(ApiEndpoints.BOARDS)
                        .setEntityIdForUri(id)
                        .setKeyAndToken()
                        .setDescParam(newDesc)
                        .buildRequest()
                        .sendRequest()
        );
    }
}