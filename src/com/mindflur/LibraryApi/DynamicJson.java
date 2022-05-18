package com.mindflur.LibraryApi;

import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {
    @Test(dataProvider = "BooksData")
    public void addBook(String isbn,String aisle){
        RestAssured.baseURI="https://rahulshettyacademy.com";
        String response=given().log().all().header("Content-Type","application/json")
                .body(payload.AddBook(isbn,aisle))
                .when()
                .post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js= ReUsableMethods.rowToJson(response);
                String id=js.get("ID");
        System.out.println(id);

    }//close addBook()
    @DataProvider(name="BooksData")
    public Object[][] getData(){
        //multidimensional array
        return new Object[][] {{"abc","123"},{"def","321"},{"ghi","213"}};
    }
}
