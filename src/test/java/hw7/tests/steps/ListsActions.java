package hw7.tests.steps;

import beans.CardIn;
import beans.ListOfBoard;
import hw7.data.ApiEndpoints;
import io.qameta.allure.Step;
import io.restassured.http.Method;

import java.util.List;

import static hw7.service.TrelloInteractionApi.*;

public class ListsActions {

    @Step("Creating new list with concrete name on board by ID")
    public static ListOfBoard createNewList(String name, String idBoard) {
        return getResponseList(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setEndpoint(ApiEndpoints.LISTS)
                        .setKeyAndToken()
                        .setNameParam(name)
                        .setBoardIdParam(idBoard)
                        .buildRequest()
                        .sendRequest()
        );
    }

    @Step("Getting one particular list's JSON")
    public static ListOfBoard getList(String idList) {
        return getResponseList(
                requestBuilder()
                        .setMethod(Method.GET)
                        .setEndpoint(ApiEndpoints.LISTS)
                        .setEntityIdForUri(idList)
                        .setKeyAndToken()
                        .buildRequest()
                        .sendRequest()
        );
    }

    @Step("Getting all cards in list by his ID")
    public static List<CardIn> getCardsFromList(String idList) {
        return getCardsOfList(
                requestBuilder()
                        .setMethod(Method.GET)
                        .setEndpoint(ApiEndpoints.LISTS)
                        .setEntityIdForUri(idList + "/")
                        .setAdditionalEndpoint(ApiEndpoints.CARDS)
                        .setKeyAndToken()
                        .buildRequest()
                        .sendRequest()
        );
    }
}