package actions;

import client.ApiClient;
import enums.ConfigEnum;
import helpers.DefaultActions;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HealthUnitAction extends DefaultActions {
    ApiClient apiClient = new ApiClient();
    RequestSpecification baseConfig = apiClient.config(ConfigEnum.BASE_URL.getUrl());
   public Response GetToken(String payload, String token) {
        return MethodPost(payload, "", baseConfig, "/User/login");

    }
    public Response CreateHealthUnit(String payload, String token) {
            return MethodPost(payload, String.valueOf(token), baseConfig, "/HealthUnit");
    }
    public Response ConsultAllHealthUnit(String token) {
        return MethodGet(String.valueOf(token), baseConfig, "/HealthUnit");
    }
}

