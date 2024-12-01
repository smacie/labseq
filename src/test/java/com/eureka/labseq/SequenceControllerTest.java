package com.eureka.labseq;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class SequenceControllerTest {
    @Test
    void testUpService() {
        given()
          .when().get("http://localhost:8080/labseq/v1/1")
          .then()
             .statusCode(is(HttpStatus.OK.value()));
    }

    @Test
    void testNegativeIndexHttpStatus() {
        given()
                .when().get("http://localhost:8080/labseq/v1/-1")
                .then()
                .statusCode(is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    void testSequenceValue0() {
        given()
                .when().get("http://localhost:8080/labseq/v1/0")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(is("0"));
    }

    @Test
    void testSequenceValue1() {
        given()
                .when().get("http://localhost:8080/labseq/v1/1")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(is("1"));
    }

    @Test
    void testSequenceValue2() {
        given()
                .when().get("http://localhost:8080/labseq/v1/2")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(is("0"));
    }

    @Test
    void testSequenceValue3() {
        given()
                .when().get("http://localhost:8080/labseq/v1/3")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(is("1"));
    }

}