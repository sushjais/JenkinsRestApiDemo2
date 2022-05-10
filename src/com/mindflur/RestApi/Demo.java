package com.mindflur.RestApi;

import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.payload;

public class Demo {
   //Add place
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server","Apache/2.4.41 (Ubuntu)");

	}

}
