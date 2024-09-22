package tests.resstassured;

import config.ConfigApi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.AuthRequest;
import org.junit.jupiter.api.BeforeAll;

import static config.Endpoints.AUTH_LOGIN;
import static io.restassured.RestAssured.given;

public class BaseTest {
    public static String TOKEN;

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://x-clients-be.onrender.com/";

        AuthRequest authRequest = new AuthRequest()
                .setUsername(ConfigApi.getApiUser())
                .setPassword(ConfigApi.getApiPassword());

        TOKEN = given()
                .contentType(ContentType.JSON)
                .body(authRequest)
                .when()
                .post(AUTH_LOGIN.getPath())
                .then()
                .statusCode(201)
                .extract().path("userToken");
    }
}
