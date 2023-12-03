package person;

import actions.PersonAction;
import com.google.gson.Gson;
import dto.AuthDTO;
import dto.LoginDTO;
import dto.PersonDTO;
import dto.PersonPhoneDTO;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonTest extends PersonAction {
    Dotenv dotenv = Dotenv.load();
    Gson gson = new Gson();
    String UserName = dotenv.get("USERNAME");
    String PassWord = dotenv.get("PASSWORD");
    LoginDTO loginDTO = new LoginDTO(UserName,PassWord);
    PersonPhoneDTO personPhoneDTO = null;
    PersonDTO personDTO = null;
    AuthDTO authDTO = new AuthDTO();
    String token;
    @BeforeEach
    public void GetTokenTest() {
        String parsePayload = gson.toJson(loginDTO);
        token = GetToken(parsePayload, "").path("token").toString();
        authDTO.setToken(token);

    }
    @Test
    @DisplayName("Create Person with success")
    public void CreatePersonTest() {
        int expectedStatusCode = HttpStatus.SC_OK;
        personPhoneDTO = new PersonPhoneDTO(0,"2023-10-21T23:23:39.111Z", "2023-10-22T23:23:39.111Z","2023-10-23T23:23:39.111Z", "123", "231", "123");
        personDTO = new PersonDTO(0,
                "2023-10-21T23:23:39.111Z",
                "2023-10-22T23:23:39.111Z",
                "2023-10-23T23:23:39.111Z",
                "1234567",
                "Test","83996403963", personPhoneDTO
        );


        String parsePayload = gson.toJson(personDTO);

        Response createHealthUnitResponse = CreatePerson(parsePayload, authDTO.getToken());

        assertEquals(expectedStatusCode, createHealthUnitResponse.statusCode());
    }

    @Test
    @DisplayName("Update Person with success")
    public void UpdatePersonTest() {
        int expectedStatusCode = HttpStatus.SC_OK;
        personPhoneDTO = new PersonPhoneDTO(0,"2023-10-21T23:23:39.111Z", "2023-10-22T23:23:39.111Z","2023-10-23T23:23:39.111Z", "123", "231", "123");
        personDTO = new PersonDTO(0,
                "2023-10-21T23:23:39.111Z",
                "2023-10-22T23:23:39.111Z",
                "2023-10-23T23:23:39.111Z",
                "1234567",
                "Test","83996403963", personPhoneDTO
        );


        String parsePayload = gson.toJson(personDTO);

        Response updatePersonResponse = UpdatePerson(parsePayload, authDTO.getToken());

        assertEquals(expectedStatusCode, updatePersonResponse.statusCode());
    }
    @Test
    @DisplayName("Consult All Persons")
    public void ConsultAllPersonTest() {
        int expectedStatusCode = HttpStatus.SC_OK;

        Response consultAllHealthUnitResponse = ConsultAllPerson(authDTO.getToken());

        assertEquals(expectedStatusCode, consultAllHealthUnitResponse.statusCode());

        assertNotNull(consultAllHealthUnitResponse);
    }

    @Test
    @DisplayName("Delete Person")
    public void DeletePersonTest() {
        int expectedStatusCode = HttpStatus.SC_OK;

        Response deletePersonResponse = DeletePerson(authDTO.getToken());

        assertEquals(expectedStatusCode, deletePersonResponse.statusCode());

        assertNotNull(deletePersonResponse);
    }
}
