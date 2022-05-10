package com.mindflur.RestApi;

import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.payload;

public class Demo1 {
   //Add place
	public static void main(String[] args) {
		//Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		//Add place
		JsonPath js=new JsonPath(response);//for passing Json path
		String placeId=js.getString("place_id");
		System.out.println(placeId);

	}

}
