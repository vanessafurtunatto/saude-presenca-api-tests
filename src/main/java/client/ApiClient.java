package client;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiClient {

    public RequestSpecification config(String url) {

        LogConfig logConfig = LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);

        RestAssuredConfig config = RestAssuredConfig.config().logConfig(logConfig);

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .setConfig(config);

        return requestSpecBuilder.build().redirects().follow(true);

    }
}
