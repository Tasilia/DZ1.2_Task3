package ru.netology;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {
    @Test
    public void testStatus() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body("[{\"id\": 0, \"name\": \"Tolya\", \"isRegistered\": true}, " +
                        "{\"id\": 1, \"name\": \"Anna\", \"isRegistered\": false}]")
                // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(201)
        ;
    }

    @Test
    public void testSize() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body("[{\"id\": 0, \"name\": \"Tolya\", \"isRegistered\": true}, " +
                        "{\"id\": 1, \"name\": \"Anna\", \"isRegistered\": false}]")
                // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .body("data", hasSize(2))
        ;
    }

    @Test
    public void testId() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body("[{\"id\": 0, \"name\": \"Tolya\", \"isRegistered\": true}, " +
                        "{\"id\": 1, \"name\": \"Anna\", \"isRegistered\": false}]")
                // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .body("data[0].id", equalTo(0))
                .body("data[1].id", equalTo(1))
        ;
    }

    @Test
    public void testName() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body("[{\"id\": 0, \"name\": \"Tolya\", \"isRegistered\": true}, " +
                        "{\"id\": 1, \"name\": \"Anna\", \"isRegistered\": false}]")
                // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .body("data[0].name", equalTo("Tolya"))
                .body("data[1].name", equalTo("Anna"))
        ;
    }

    @Test
    public void testIsRegistered() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body("[{\"id\": 0, \"name\": \"Tolya\", \"isRegistered\": true}, " +
                        "{\"id\": 1, \"name\": \"Anna\", \"isRegistered\": false}]")
                // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .body("data[0].isRegistered", equalTo(true))
                .body("data[1].isRegistered", equalTo(false))
        ;
    }
}