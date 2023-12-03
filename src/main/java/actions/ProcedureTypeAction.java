package actions;

import client.ApiClient;
import enums.ConfigEnum;
import helpers.DefaultActions;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProcedureTypeAction extends DefaultActions {
    ApiClient apiClient = new ApiClient();
    RequestSpecification baseConfig = apiClient.config(ConfigEnum.BASE_URL.getUrl());
    public Response GetToken(String payload, String token) {
        return MethodPost(payload, "", baseConfig, "/User/login");
    }
    public Response CreateProcedureType(String payload, String token) {
        return MethodPost(payload, String.valueOf(token), baseConfig, "/ProcedureType");
    }
    public Response ConsultAllProcedureType(String token) {
        return MethodGet(String.valueOf(token), baseConfig, "/ProcedureType");
    }
    public Response UpdateProcedureType(String payload, String token) {
        return MethodPut(payload, String.valueOf(token), baseConfig, "/ProcedureType");
    }
    public Response DeleteProcedureType(String token) {
        return MethodDelete(String.valueOf(token), baseConfig, "/ProcedureType/9");
    }
}
