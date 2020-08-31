package hw7.service;

import beans.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hw7.data.ApiEndpoints;
import hw7.data.ApiParameters;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.lessThan;

public class TrelloInteractionApi {

    /*
    Parts of URI
     */
    private final Method method;
    public static String baseUri = ApiParameters.basePath();
    private final ApiEndpoints endpoint;
    private final String entityId;
    private final String additionalEndpoint;

    private static long requestNumber = 0L;

    private final Map<String, String> parameters;

    private TrelloInteractionApi(
            Method method, ApiEndpoints endpoint, String entityId,
            String additionalEndpoint, Map<String, String> parameters) {
        this.method = method;
        this.endpoint = endpoint;
        this.entityId = entityId;
        this.additionalEndpoint = additionalEndpoint;
        this.parameters = parameters;
    }

    public static ApiBuilder requestBuilder() {
        return new ApiBuilder();
    }

    public static class ApiBuilder {

        /*
        Parts of URI
         */
        private Method method = Method.GET;
        private ApiEndpoints endpoint;
        private String idForUri = "";
        private String additionEndpoint = "";

        private final Map<String, String> parameters = new HashMap<>();

        public ApiBuilder setMethod(Method method) {
            this.method = method;
            return this;
        }

        public ApiBuilder setEndpoint(ApiEndpoints endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public ApiBuilder setEntityIdForUri(String idForUri) {
            this.idForUri = idForUri;
            return this;
        }

        public ApiBuilder setAdditionalEndpoint(ApiEndpoints endpoint) {
            additionEndpoint = endpoint.value();
            return this;
        }

        public ApiBuilder setKeyAndToken() {
            parameters.put("key", ApiParameters.trelloKey());
            parameters.put("token", ApiParameters.trelloToken());
            return this;
        }

        public ApiBuilder setNameParam(String name) {
            parameters.put("name", name);
            return this;
        }

        public ApiBuilder setDescParam(String desc) {
            parameters.put("desc", desc);
            return this;
        }

        public ApiBuilder setBoardIdParam(String id) {
            parameters.put("idBoard", id);
            return this;
        }

        public ApiBuilder setListIdParam(String id) {
            parameters.put("idList", id);
            return this;
        }

        public TrelloInteractionApi buildRequest() {
            return new TrelloInteractionApi(method, endpoint,
                    idForUri, additionEndpoint, parameters);
        }
    }

    public Response sendRequest() {
        return RestAssured
                .given()
                .spec(requestSpecification())
                .queryParams(parameters)
                .log().everything()
                .request(method, baseUri + endpoint.value() + entityId + additionalEndpoint)
                .then()
                .assertThat()
                .spec(goodResponse())
                .extract().response();
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .addHeader("Content-Type", "text/html; charset=UTF-8")
                .addQueryParam("requestNumber", ++requestNumber)
                .addFilter(new AllureRestAssured())
                .build();
    }

    public static TrelloBoard getResponseBoard(Response response) {
        return new Gson().fromJson(response.asString().trim(),
                new TypeToken<TrelloBoard>() {
                }.getType());
    }

    public static List<CardIn> getCardsOfList(Response response) {
        return new Gson().fromJson(response.asString().trim(),
                new TypeToken<List<CardIn>>() {
                }.getType());
    }

    public static TrelloBoardWithUpdates getResponseBoardWithUpdates(Response response) {
        return new Gson().fromJson(response.asString().trim(),
                new TypeToken<TrelloBoardWithUpdates>() {
                }.getType());
    }

    public static ListOfBoard getResponseList(Response response) {
        return new Gson().fromJson(response.asString().trim(),
                new TypeToken<ListOfBoard>() {
                }.getType());
    }

    public static TrelloCard getOneCreatedCard(Response response) {
        return new Gson().fromJson(response.asString().trim(),
                new TypeToken<TrelloCard>() {
                }.getType());
    }

    public static ResponseSpecification goodResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(10000L))
                .build();
    }
}