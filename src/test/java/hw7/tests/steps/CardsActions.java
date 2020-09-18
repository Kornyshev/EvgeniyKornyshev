package hw7.tests.steps;

import beans.TrelloCard;
import hw7.data.ApiEndpoints;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static hw7.service.TrelloInteractionApi.getOneCreatedCard;
import static hw7.service.TrelloInteractionApi.requestBuilder;

public class CardsActions {

    @Step("Creating the card")
    public static TrelloCard createOneCard(String name, String idList) {
        return getOneCreatedCard(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setEndpoint(ApiEndpoints.CARDS)
                        .setKeyAndToken()
                        .setNameParam(name)
                        .setListIdParam(idList)
                        .buildRequest()
                        .sendRequest()
        );
    }

    @Step("Deleting card by ID")
    public static Response deleteCardByID(String idCard) {
        return requestBuilder()
                .setMethod(Method.DELETE)
                .setEndpoint(ApiEndpoints.CARDS)
                .setEntityIdForUri(idCard)
                .setKeyAndToken()
                .buildRequest()
                .sendRequest();
    }
}