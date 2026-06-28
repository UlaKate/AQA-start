package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

public class ShopTestsApi {
     /*
1. Make request (POST) to https://demoqa.com/Account/v1/GenerateToken  with body {"userName":"003","password":"Qaz_123!"}
2. Get response
  {"token": "string",
  "expires": "2026-06-28T17:29:51.730Z",
  "status": "Success",
  "result": "User authorized successfully."}
3. Check "token" is "string" and status code 200
  */

    @Test
    void successLoginTest(){
        String authData = "{\"userName\":\"003\",\"password\":\"Qaz_123!\"}";
        given()
                .body(authData)
                .contentType(JSON)
                .log().uri()
        .when()
                .post("https://demoqa.com/Account/v1/GenerateToken")
        .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("result",is("User authorized successfully."));
    }

    @Test
    void unSuccessLoginTest(){
        String authData = "";
        given()
                .body(authData)
                .contentType(JSON)
                .log().uri()
        .when()
                .post("https://demoqa.com/Account/v1/GenerateToken")
        .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("message",is("UserName and Password required."));
    }
}
