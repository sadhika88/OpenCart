package day1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//location of properties
		Properties obj=new Properties();
		//loading properties file
		FileInputStream file=new FileInputStream(System.getProperty("user.dir") +"\\testData\\Config2.properties");
		obj.load(file);
		//reading data from properties file
		
		String email=obj.getProperty("email");
		String password=obj.getProperty("password");
		String orderid=obj.getProperty("orderid");
		String customerid=obj.getProperty("customerid");
System.out.println(email+ " " +password+ " " +orderid+ "   "+customerid);
//reading all keys from properties file //method-1
Set<String> keys=obj.stringPropertyNames();
System.out.println(keys);
//reading all keys from properties file //method-2
Set<Object> keys1=obj.keySet();
System.out.println(keys1);
//reading all values from properties file 
Collection<Object> values=obj.values();
System.out.println(values);
file.close();
	}

}
