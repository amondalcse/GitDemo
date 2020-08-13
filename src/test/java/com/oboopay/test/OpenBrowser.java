package com.oboopay.test;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static com.obopay.customFunctions.PropertyFileReader.config;
import com.obopay.customFunctions.*;

public class OpenBrowser 
{
	public static WebDriver driver;
	
	PropertyFileReader prop=new PropertyFileReader();
	@BeforeClass
	public void openURL() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/home/amondal/Automation_workspace/ChakraWeb/extension/chromedriver");
		ChromeOptions chromeoptions= new ChromeOptions();
		chromeoptions.addArguments("disable-infobars");
		chromeoptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeoptions);
        PropertyFileReader.loadProperty();
        String baseurl = config.getProperty("QA_Environment_URL");
        driver.get(baseurl);
        Thread.sleep(3000);
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}
