package com.test.tests;

import static com.test.customFunctions.PropertyFileReader.config;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.test.customFunctions.PropertyFileReader;

public class Assignment
{
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException 
	{
			///System.setProperty("webdriver.chrome.driver", "/home/amondal/Automation_workspace/ChakraWeb/extension/chromedriver");
				WebDriver driver =null;
				for(int i=1;i<=2;i++)
				{
				EnableUserBrowserPermission(driver);
				}
				System.out.println("Connection Established Successfully");
				}

				public static void EnableUserBrowserPermission(WebDriver driver) throws InterruptedException {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "ChakraWeb/extension/chromedriver");
				ChromeOptions chromeoptions= new ChromeOptions();
				chromeoptions.addArguments("use-fake-ui-for-media-stream");
				chromeoptions.addArguments("disable-infobars");;
				chromeoptions.addArguments("--start-maximized");
				       System.out.println(chromeoptions);
				      driver = new ChromeDriver(chromeoptions);
				      driver.get("https://talky.io");
				      Thread.sleep(3000);
				      driver.findElement(By.xpath("//input[@placeholder=\"choose a room name\"]")).sendKeys("1");
				      driver.findElement(By.xpath("//button[@type='submit']")).click();
				      Thread.sleep(2000);
				      driver.findElement(By.xpath("//button[text()='Join Call']")).click();

				
				
	

				}
}
