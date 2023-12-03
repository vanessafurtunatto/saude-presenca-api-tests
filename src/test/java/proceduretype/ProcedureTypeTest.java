package proceduretype;

import actions.ProcedureTypeAction;
import com.google.gson.Gson;
import dto.*;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProcedureTypeTest extends ProcedureTypeAction {
    Dotenv dotenv = Dotenv.load();
    Gson gson = new Gson();
    String UserName = dotenv.get("USERNAME");
    String PassWord = dotenv.get("PASSWORD");
    LoginDTO loginDTO = new LoginDTO(UserName, PassWord);
    ProcedureTypeDTO procedureTypeDTO = null;
    AuthDTO authDTO = new AuthDTO();
    String token;

    @BeforeEach
    public void GetTokenTest() {
        String parsePayload = gson.toJson(loginDTO);
        token = GetToken(parsePayload, "").path("token").toString();
        authDTO.setToken(token);
    }

    @Test
    @DisplayName("Create Procedure Type with success")
    public void CreateProcedureTest() {
        int expectedStatusCode = HttpStatus.SC_OK;
        procedureTypeDTO = new ProcedureTypeDTO(
                9,
                "2023-10-21T23:23:39.111Z",
                "2023-10-21T23:23:39.111Z",
                "2023-10-21T23:23:39.111Z",
                "Test");

        String parsePayload = gson.toJson(procedureTypeDTO);

        Response createProcedureTypeResponse = CreateProcedureType(parsePayload, authDTO.getToken());

        assertEquals(expectedStatusCode, createProcedureTypeResponse.statusCode());
    }

    @Test
    @DisplayName("Update Procedure Type with success")
    public void UpdateProcedureTest() {
        int expectedStatusCode = HttpStatus.SC_OK;
        procedureTypeDTO = new ProcedureTypeDTO(
                0,
                "2023-10-21T23:23:39.111Z",
                "2023-10-21T23:23:39.111Z",
                "2023-10-21T23:23:39.111Z",
                "Test");


        String parsePayload = gson.toJson(procedureTypeDTO);

        Response updateProcedureTypeResponse = UpdateProcedureType(parsePayload, authDTO.getToken());

        assertEquals(expectedStatusCode, updateProcedureTypeResponse.statusCode());
    }
    @Test
    @DisplayName("Consult All Procedure Type")
    public void ConsultAllProcedureTypeTest() {
        int expectedStatusCode = HttpStatus.SC_OK;

        Response consultAllProcedureTypeResponse = ConsultAllProcedureType(authDTO.getToken());

        assertEquals(expectedStatusCode, consultAllProcedureTypeResponse.statusCode());

        assertNotNull(consultAllProcedureTypeResponse);
    }

    @Test
    @DisplayName("Delete Procedure Type")
    public void DeletePersonTest() {
        int expectedStatusCode = HttpStatus.SC_OK;

        Response deleteProcedureTypeResponse = DeleteProcedureType(authDTO.getToken());

        assertEquals(expectedStatusCode, deleteProcedureTypeResponse .statusCode());

        assertNotNull(deleteProcedureTypeResponse);
    }
}