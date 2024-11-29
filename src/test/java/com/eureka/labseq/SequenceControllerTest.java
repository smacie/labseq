package com.eureka.labseq;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class SequenceControllerTest {
    @Test
    void testHelloEndpoint() {
        /*given()
          .when().get("http://localhost:8080/labseq/v1/1")
          .then()
             .statusCode(is(200));
             //.body(is("Hello Spring"));*/
    }

}