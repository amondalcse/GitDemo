package com.test.pages;
import static com.test.customFunctions.PropertyFileReader.OR;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.customFunctions.GenricMethods;

public class LoginPage 
{
	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//-------------Login page all the locators----------------:
	
	By username= By.id(OR.getProperty("UserName_ID"));
	By password= By.id(OR.getProperty("Password_ID"));
	By loginbutton= By.xpath(OR.getProperty("LoginButton_xpath"));
	By invalidErrorMessage=By.xpath(OR.getProperty("Invalid_Login_Error_Xpath"));
	//---------------Login methods----------------------------:
	
	public LoginPage enteruserName(WebDriver driver, String value)
	{
		GenricMethods.enterValue(driver,username, value);
		return new LoginPage(driver);
		
	}
	
	public LoginPage enterPassword(WebDriver driver,String value)
	{
		GenricMethods.enterValue(driver,password, value);
		return new LoginPage(driver);
	}
	
	public LoginPage clickLoginButton(WebDriver driver)
	{
		GenricMethods.clickElement(driver,loginbutton);
		return new LoginPage(driver);
	}
	public LoginPage invalidLoginError(WebDriver driver)
	{
		String msg = GenricMethods.getText(driver, invalidErrorMessage);
		System.out.println(msg);
		return new LoginPage(driver);
	}

}
