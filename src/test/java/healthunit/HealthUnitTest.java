package healthunit;

import actions.HealthUnitAction;
import com.google.gson.Gson;
import dto.AuthDTO;
import dto.HealthUnityDTO;
import dto.LoginDTO;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HealthUnitTest extends HealthUnitAction {
    Dotenv dotenv = Dotenv.load();
    Gson gson = new Gson();
    String UserName = dotenv.get("USERNAME");
    String PassWord = dotenv.get("PASSWORD");
    LoginDTO loginDTO = new LoginDTO(UserName,PassWord);
    HealthUnityDTO healthUnityDTO = new HealthUnityDTO("", "", "", "","","","","","");
    AuthDTO authDTO = new AuthDTO();
    String token;

    @BeforeEach
    public void GetTokenTest() {
        String parsePayload = gson.toJson(loginDTO);
        token = GetToken(parsePayload, "").path("token").toString();
        authDTO.setToken(token);
    }

    @Test
    @DisplayName("Create Unit with success")
    public void CreateHealthUnitTest() {
        int expectedStatusCode = HttpStatus.SC_OK;
        healthUnityDTO = new HealthUnityDTO(
                "123456",
                "Test automation",
                "Description Unidade Saúde Ibiribeira 2",
                "PE",
                "Recife",
                "Teste",
                "12",
                "Centro",
                "784564564");

        String parsePayload = gson.toJson(healthUnityDTO);
        Response createHealthUnitResponse = CreateHealthUnit(parsePayload, authDTO.getToken());
        assertEquals(expectedStatusCode, createHealthUnitResponse.statusCode());
    }
    @Test
    @DisplayName("Unauthorized Create HelthUnit")
    public void UnauthorizedCreateHealthUnitTest() {
        int expectedStatusCode = HttpStatus.SC_UNAUTHORIZED;
        healthUnityDTO = new HealthUnityDTO(
                "123456",
                "Test automation",
                "Description Unidade Saúde Ibiribeira 2",
                "PE",
                "Recife",
                "Teste",
                "12",
                "Centro",
                "784564564");

        String parsePayload = gson.toJson(healthUnityDTO);

        Response createHealthUnitResponse = CreateHealthUnit(parsePayload, "124");

        assertEquals(expectedStatusCode, createHealthUnitResponse.statusCode());
    }
    @Test
    @DisplayName("Consult All Helth Units")
    public void ConsultAllHealthUnitTest() {
        int expectedStatusCode = HttpStatus.SC_OK;

        Response consultAllHealthUnitResponse = ConsultAllHealthUnit(authDTO.getToken());

        assertEquals(expectedStatusCode, consultAllHealthUnitResponse.statusCode());

        assertNotNull(consultAllHealthUnitResponse);
    }
}
