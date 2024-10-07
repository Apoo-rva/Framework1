package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {

	public String getKeyandValuePair(String key) throws Throwable{
		
FileInputStream path = new FileInputStream("./src/test/resources/Vtigerlogincredential.properties");
		
        //2nd--to start reading data ,create objfor properties class and load path
        Properties prop = new Properties();
	         prop.load(path);

	         //3rd--call keys from properties file
	         
	         String value = prop.getProperty(key);
	           
		
		
		return value;

	}

}
