package actions;

import client.ApiClient;
import enums.ConfigEnum;
import helpers.DefaultActions;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAction extends DefaultActions {
    ApiClient apiClient = new ApiClient();
    RequestSpecification baseConfig = apiClient.config(ConfigEnum.BASE_URL.getUrl());
    public Response CreateLogin(String payload) {
            return MethodPost(payload,"", baseConfig, "/User/login");
    }
}

