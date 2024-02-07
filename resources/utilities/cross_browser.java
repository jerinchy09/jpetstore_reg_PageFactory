package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cross_browser {
	WebDriver driver;
	String filepath = "E:\\Nexvalli\\Eclipse Wrokspace\\POM_petstore\\config.properties";

	public WebDriver browser_inititate() throws IOException {		
		FileInputStream fis = new FileInputStream(filepath);
		
		Properties p = new Properties();
		p.load(fis);
		
		String browsername = p.getProperty("browser");
		
		switch(browsername) {
			case "Chrome":
			{
				driver = new ChromeDriver();
				driver.get(p.getProperty("url"));
				break;
			}	
			
			case "Firefox":
			{		
				driver = new FirefoxDriver();
				driver.get(p.getProperty("url"));
				break;
					
			}
			case "Edge":
			{
				driver = new EdgeDriver();
				driver.get(p.getProperty("url"));
				break;
			}
		}	
		return driver;
	}
}
