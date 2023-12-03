package user;

import actions.LoginAction;
import com.google.gson.Gson;
import dto.LoginDTO;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest extends LoginAction {
    Dotenv dotenv = Dotenv.load();
    Gson gson = new Gson();
    String UserName = dotenv.get("USERNAME");
    String PassWord = dotenv.get("PASSWORD");
    LoginDTO loginDTO = new LoginDTO(UserName,PassWord);

    @Test
    @DisplayName("Login Success")
    public void LoginSuccessTest() {
        int expectedStatusCode = HttpStatus.SC_OK;

        String parsePayload = gson.toJson(loginDTO);

        Response loginResponse = CreateLogin(parsePayload);

        assertEquals(expectedStatusCode, loginResponse.statusCode());
    }
    @Test
    @DisplayName("Login Unauthorized")
    public void LoginUnauthorizedTest() {
        int expectedStatusCode = HttpStatus.SC_UNAUTHORIZED;

     loginDTO = new LoginDTO(
                "test",
                "test"
        );

        String parsePayload = gson.toJson(loginDTO);

        Response loginResponse = CreateLogin(parsePayload);

        assertEquals(expectedStatusCode, loginResponse.statusCode());
    }

    @Test
    @DisplayName("Login Empty")
    public void LoginEmptyTest() {
        int expectedStatusCode = HttpStatus.SC_BAD_REQUEST;

       loginDTO = new LoginDTO(
                "",
                ""
        );

        String parsePayload = gson.toJson(loginDTO);

        Response loginEmptyResponse = CreateLogin(parsePayload);

        String responseBody = loginEmptyResponse.getBody().asString();

        assertTrue(responseBody.contains("Username or Password must be not empty"));

        assertNotNull(loginEmptyResponse);
    }
}

