package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public abstract class BaseClass {
	Properties prop;
	public BaseClass() throws IOException 
	{   
		
		prop=new Properties();//
		String filepath=System.getProperty("user.dir")+"\\Config.properties";
		FileInputStream fis= new FileInputStream(filepath);
		prop.load(fis);
		
		//Wait
	  
		
		
	}

}
