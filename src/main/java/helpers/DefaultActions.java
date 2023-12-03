package helpers;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class DefaultActions {
    private Map<String, ?> headers;

    public Response MethodGet(String token, RequestSpecification rspec, String endpoint) {
        return given()
                .header("Authorization", String.format("Bearer %s", token))
                .spec(rspec)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public Response MethodPost(String payload, String token, RequestSpecification rspec, String endpoint) {
        return given()
                .header("Authorization", String.format("Bearer %s", token))
                .spec(rspec)
                .body(payload)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public Response MethodPut(String payload, String token, RequestSpecification rspec, String endpoint) {
        return given()
                .header("Authorization", String.format("Bearer %s", token))
                .spec(rspec)
                .body(payload)
                .log().all()
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public Response MethodDelete(String token, RequestSpecification rspec, String endpoint) {
        return given()
                .header("Authorization", String.format("Bearer %s", token))
                .spec(rspec)
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
}
