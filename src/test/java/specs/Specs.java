/**package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.with;



public class Specs {
    public static RequestSpecification request = with()
            .baseUri()
            .basePath("/api")
            .log().all()
            .log().uri()
            .contentType(ContentType.JSON);
    public static ResponseSpecification responseSucces = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
    public static ResponseSpecification responseNotFound = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .build();
    public static ResponseSpecification responseCreate = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();
    public static ResponseSpecification responseDelete = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .build();
    public static ResponseSpecification responseUnsuccesLogin = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .build();
}

**/