package com.mindflur.JiraApi;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.given;

public class JiraApiTest {
    public static void main(String[] args) {
        RestAssured.baseURI="http://localhost:8282/";
        //login
        SessionFilter session=new SessionFilter();
        String response=given().header("Content-Type","application/json").
                body("{ \"username\": \"sushma\", \"password\": \"Sush@2211\" }").log().all().filter(session)
                .when().post("/rest/auth/1/session").then().log().all()
                .extract().response().asString();
        //Add comment
        given().pathParam("key","10101").log().all().
                header("Content-Type","application/json").
                body("{\n" +
                        "    \"body\": \"Hey this is my Rest Comment for 10101\",\n" +
                        "    \"visibility\": {\n" +
                        "        \"type\": \"role\",\n" +
                        "        \"value\": \"Administrators\"\n" +
                        "    }\n" +
                        "}").filter(session).when().post("/rest/api/2/issue/{key}/comment").then().log().all().
                         assertThat().statusCode(201);
    }
}
