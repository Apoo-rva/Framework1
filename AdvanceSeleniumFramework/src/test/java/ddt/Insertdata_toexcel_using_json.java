package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Insertdata_toexcel_using_json {

	public static void main(String[] args) throws Throwable {

		//1st add dependencies
		
		FileInputStream fis = new FileInputStream("./src/test/resources/jsonfile.json");
		               
		ObjectMapper jsondata = new ObjectMapper();
		JsonNode data = jsondata.readTree(fis);
		
		data.get("url");
	
	
	}

}
