package tests;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.hasItem;


public class VacanciesTests {


    @Test
    void listVacanciesTestCheckListOfUsersByGroovy() {
        given()
                .log().uri()
                .log().body()
                .spec(requestSpecification)
                .when()
                .get("https://spb.hh.ru/shards/vacancies_of_the_day")
                .then()
                .log().status()
                .log().body()
                .body("data.findAll{it.user =~/.*?@hh.ru/}.user.flatten()",
                        hasItem("[]"));

    }
}
/**
    public class UserList {
        public void checkListOfUsersByGroovy() {
            // @formatter:off
            given()
                    .spec(request)
                    .when()
                    .get("/users")
                    .then()
                    .log().body()
                    .body("data.findAll{it.user =~/.*?@reqres.in/}.user.flatten()",
                            hasItem("id"));


        }
    }
}



    @Test
    void listSingleUserTest() {

        given()
                .spec(request)
                .when()
                .get("/users/2")
                .then()
                .spec(responseSucces)
                .body("data.first_name", is("Janet"));
    }

    @Test
    void createUserTest() {
        String body = "{ \"name\": \"morpheus\", " +
                "\"job\": \"leader\" }";
        given()
                .spec(request)
                .body(body)
                .when()
                .post("/api/users")
                .then()
                .spec(responseCreate)
                .body("name", is("morpheus"));
    }

    @Test
    void loginUnsuccesfullTest() {
        String body = "{ \"email\": \"peter@klaven\" }";
        given()
                .spec(request)
                .body(body)
                .when()
                .post("/login")
                .then()
                .spec(responseUnsuccesLogin)
                .body("error", is("Missing password"));
    }

    @Test
    void deleteUserTest() {
        given()
                .when()
                .delete("https://reqres.in/api/users2")
                .then()
                .spec(responseDelete);
    }

    @Test
    void singleUserWithModel() {
        UserData data = given()
                .spec(request)
                .when()
                .get("/users/2")
                .then()
                .spec(responseSucces)
                .log().body()
                .extract().as(UserData.class);

        assertEquals(2, data.getUser().getId());
    }

    @Test
    void singleUserWithLombok() {
        UserData data =  given()
                .spec(request)
                .when()
                .get("/users/2")
                .then()
                .spec(responseSucces)
                .log().body()
                .extract().as(UserData.class);
        assertEquals(2, data.getUser().getId());
    }

    @Test
    void UsersWithLombok() {
        BodyData data =  given()
                .spec(request)
                .when()
                .get("/users/2")
                .then()
                .spec(responseSucces)
                .log().body()
                .extract().as(BodyData.class);
        assertEquals(null, data.getBody().getUserData());
    }
}
**/