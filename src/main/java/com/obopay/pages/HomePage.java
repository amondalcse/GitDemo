package com.obopay.pages;

import static com.obopay.customFunctions.PropertyFileReader.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.obopay.customFunctions.GenricMethods;

public class HomePage 
{
	public WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//-------------Hoome page all the locators----------------:
	
		By Logout= By.xpath(OR.getProperty("Logout_xpath"));
		By UserProfile= By.xpath(OR.getProperty("Welcome_user_Xpath"));
		
		//---------------Home Page methods----------------------------:
		
		public  HomePage clickLogout(WebDriver driver)
		{
			GenricMethods.clickElement(driver, Logout);
			System.out.println("Successfully clicked on logout button");
			return new HomePage(driver);
		}
		
		public HomePage getuserProfile(WebDriver driver)
		{
			String msg=GenricMethods.getText(driver, UserProfile);
			System.out.println(msg);
			if(msg.equalsIgnoreCase("Welcome akuser"))
			{
				System.out.println("Print msg---->"+msg +"Success");
			}
			else
			{
				System.out.println("Fail");
			}
			return new HomePage(driver);
		}

}
