package com.mindflur.RestApi;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js=new JsonPath(payload.CoursePrice());
		//Print no of courses returned by RestApi
		int count=js.getInt("courses.size()");
		System.out.println("size="+count);
		//print purchase amount
		int totalAmount=js.getInt("dashboard.purchaseAmount");
		System.out.println("Amount="+totalAmount);
		//print title of the firstCourse
		String titleFirstCourse=js.get("courses[0].title");
		System.out.println("Title="+titleFirstCourse);
		//Print All course titles and their respective Prices
		for(int i=0;i<count;i++) {
			String courseTitles = js.get("courses[" + i + "].title");
			System.out.println(js.get("courses[" + i + "].price").toString());
			System.out.println(courseTitles);
		}
			//Print no of copies sold by RPA Course
			System.out.println("Print no of copies sold by RPA");
				for (int i=0;i<count;i++){
					String courseTitles=js.get("courses["+i+"].title");
					 if(courseTitles.equalsIgnoreCase("RPA")){
						 int copies=js.get("courses["+i+"].copies");
						 System.out.println(copies);
						 break;
					 }
				}

		}
	}


