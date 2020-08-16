package com.test.tests;


import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.customFunctions.GenricMethods;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;
public class VerifyLoginTest extends OpenBrowser
{
	
	static LoginPage login;
	static HomePage home;
	
	@Parameters({"username","password"})
	@Test(enabled = true, description = "Successfully Login to the portal")
	public void aloginTest(String username, String password) throws InterruptedException
	{
		login= new LoginPage(driver);
		home= new HomePage(driver);
		login.enteruserName(driver, username);
		login.enterPassword(driver, password);
		Thread.sleep(3000);
		login.clickLoginButton(driver);
		GenricMethods.Implicitwait(driver, 5);
		Thread.sleep(3000);
		System.out.println("Successfully login to the website");
		Thread.sleep(3000);
		//home.getuserProfile(driver);
		String msg=driver.findElement(By.xpath("//div[@class='row text-right welcomeusertext']")).getText();
		System.out.println(msg);
		
		if(msg.equalsIgnoreCase(" Welcome akusers"))
		{
			System.out.println("Print msg---->"+msg +"Success");
		}
		else
		{
			System.out.println("Fail");
		}
		
	
		home.clickLogout(driver);
		Thread.sleep(5000);
		
	}
	@Parameters({"username"})
	@Test(enabled=true,description = "Enter In valid username and valid password")
	public void bInvalidPassword(String username) throws InterruptedException
	{
		login= new LoginPage(driver);
		home= new HomePage(driver);
		login.enteruserName(driver, username);
		//login.enterPassword(driver, password);
		Thread.sleep(3000);
		login.clickLoginButton(driver);
		login.invalidLoginError(driver);
		GenricMethods.Implicitwait(driver, 5);
		
		Thread.sleep(3000);
	}
	

}
