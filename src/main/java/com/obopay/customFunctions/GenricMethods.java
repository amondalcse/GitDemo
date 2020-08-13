package com.obopay.customFunctions;

import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenricMethods 
{
	public static Logger log = Logger.getLogger(GenricMethods.class.getName());
	public  static WebDriver driver;
	public static void clickElement(WebDriver driver, By by)
	{
		try
		{
		driver.findElement(by).click();
		}
		catch (ElementNotVisibleException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void enterValue(WebDriver driver, By by, String value)
	{
		try
		{
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(value);
		}
		catch(ElementNotVisibleException e)
		{
			e.printStackTrace();
			
		}
	}
	
	//-----------------------------------------------------------
	
	/**
	 * 
	 * This Method is used to Select the browser you want to work. Pass browser name as parameter.
	 * 
	 */
	public static WebDriver selectDriver(String browser, WebDriver dr) throws Exception//select anyone of the browser
	{
        
		if(browser.equalsIgnoreCase("firefox"))
		{
			try
			{
			dr= new FirefoxDriver();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			try
			{
			System.setProperty("webdriver.chrome.driver", "D:\\Extensionfile\\chromedriver.exe");
			dr = new ChromeDriver();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
			System.setProperty("webdriver.ie.driver", "D:\\Extensionfile\\IEdriver.exe");
			dr=new InternetExplorerDriver();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return dr;
	}
	/**
	 * This method is used to,it's should take care of waiting till the element is not found.
	 */
	public static void Implicitwait(WebDriver dr, int time)//using in implicit wait
	{
		try
		{
		dr.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used instead of the code of Thread.sleep(),its used By Xpath.
	 *
	 */
	public static void ExplicitByXpath(WebDriver dr, int time, String xpath)//using explicit wait by xpath
	{
		try
		{
		WebDriverWait wait= new WebDriverWait(dr, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xpath"))).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method is used instead of the code of Thread.sleep(),its used By Id.
	 *
	 */
	public static void ExplicitById(WebDriver dr, int time, String Id)//using explicit wait by id
	{
		try
		{
		WebDriverWait wait= new WebDriverWait(dr, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Id"))).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used instead of the code of Thread.sleep(),its used By Name.
	 *
	 */
	public static void ExplicitByName(WebDriver dr, int time, String name)//using explicit wait by name
	{
		try
		{
		WebDriverWait wait= new WebDriverWait(dr, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name"))).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used for mousehover the categories and pass the webElement and Current Driver Object.
	 *
	 */
	public static void mousehoverCategory(WebDriver dr, WebElement wb)//using mousehover function
	{
		try
		{
		Actions action = new Actions(dr);
		action.moveToElement(wb).perform();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used for mousehover By Id the categories and pass the webElement and Current Driver Object.
	 *
	 */
	public static void mousehoverbyid(WebDriver dr, String id)
	{
		try
		{
		Actions action = new Actions(dr);
		action.moveToElement(dr.findElement(By.id(id))).perform();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used for mousehover By Id the Subcategories and pass the webElement and Current Driver Object.
	 *
	 */
	public static void mousehoverSubCategory(WebDriver dr, WebElement cat, WebElement Subcat)
	{
		try
		{
		Actions action = new Actions(dr);
		action.moveToElement(cat).moveToElement(Subcat).build().perform();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used for Clicking the object.
	 *
	 */
	public static void ObjClick(WebElement wb)
	{
		try
		{
		wb.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used for DropDown and select any one of the option by Text.
	 *
	 */
	public static void Drop_Down_ByText(WebElement wb, String str)
	{
		try
		{
		Select select = new Select(wb);
		select.selectByVisibleText(str);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used for DropDown and select any one of the option by Value.
	 *
	 */
	public static void Drop_Down_ByValue(WebElement wb, String str)
	{
		try
		{
		Select select = new Select(wb);
		select.selectByValue(str);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used for DropDown and select any one of the option by Index.
	 *
	 */
	public static void Drop_Down_ByIndex(WebElement wb, int Index)
	{
		try
		{
		Select select = new Select(wb);
		select.selectByIndex(Index);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used for RadioButton and Click on this button.
	 *
	 */
	public static void Radio_Button(WebElement wb)
	{
	if ( !wb.isSelected())
		{
		try
		{
			wb.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}


	/**
	 * This method is used for to Check the WebElement is Disable or Enable.
	 *
	 */
	public static boolean Check_Disable(WebElement wb)
	{
		return wb.isEnabled();
		}
	
	/**
	 * This method is used for to Check the WebElement is Displayed or not.
	 *
	 */
	public static boolean Check_Displayed(WebElement wb)
	{
		return wb.isDisplayed();
	}
	/**
	 * This method is used for to Check the Text is clear or not and after clear to pass the String.
	 */
	public static void Set_Text(WebElement wb, String  text)
	{
		try
		{
		wb.clear();
		wb.sendKeys(text);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used for Check Box if it's already clicked then first unchecked and click on.
	 *
	 */
	public static void Check_Box(WebElement wb, String value)
	{
		if(value.equalsIgnoreCase("checked"))
		{
			if(!wb.isSelected())
			{
				try
				{
				wb.click();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else
		{
			
			try
			{
				wb.click();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		}
	}
	


	public static boolean NavigateURL(String url, WebDriver driver) throws Exception{
		boolean flag = false;
		driver.get(url);
		Thread.sleep(4000);
		String AppURL = driver.getCurrentUrl();

		if (AppURL.contains(url))
		{
			flag =true;
		}
		else
		{
			driver.get(url);
			if (AppURL.equalsIgnoreCase(url)){
				flag =true;
			}
		}
		return flag;
	}
	
//	public static void VerifyElementOnPage (WebDriver driver,String xpath, String msg) throws Exception{
//		if (isElementPresent(driver,xpath)){
//			System.out.println(xpath+ "Element present");
//		}else{
//			System.out.println(xpath+ "Element not present");
//		}
//	}
//	public static boolean isElementPresent(WebDriver driver, String xpath){
//		boolean flag = false;
//		try {
//			driver.findElement(By.xpath(xpath));
//
//			flag = true;
//		} catch (Exception e) {	
//
//
//		}
//		return flag;
//	}
	/**
	 * This method is used for get the text from WebElement and its String .
	 *
	 */
//	public static String GetTextFromElement(WebElement wb,  String msg)throws Exception
//	{
//		String getText="";
//		getText = wb.getText();
//		return getText;
//	}
	/**
	 * This method is used for set the time while filling the form.We need to pass 3 parameters 1st is WebDriver Object, Time and Period(AM/PM)
	 *
	 */
	public static void set_Time(WebDriver dr,String time, String period)

	{
		try
		{
		dr.findElement(By.linkText(time)).click();

		dr.findElement(By.linkText(period)).click();

		dr.findElement(By.xpath("//div[@class='dtp']/div/div/button[@class='dtp-btn-ok btn btn-flat' or @text()='OK']")).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		}

	}
	/**
	 * This method is used to set the window control to current or child window
	 *
	 */
	public static void setWindowControl(WebDriver dr)

	{
		try
		{
		Set<String> ids=dr.getWindowHandles();

		Iterator<String> itr=ids.iterator();

		String Parentid=itr.next();

		dr.switchTo().window(itr.next());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	/**
	 * This method is used to click on OK button if you get any Alert Pop up
	 *
	 */
	public static void Accept_Alert(WebDriver dr)
	{
		try
		{
		Alert alt = dr.switchTo().alert();
		alt.accept();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to click on CANCEL button if you get any Alert Pop up
	 *
	 */
	public static void Dismiss_Alert(WebDriver dr)
	{
		try
		{
		Alert alt = dr.switchTo().alert();
		alt.dismiss();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static String getText(WebDriver driver, By by)
	{
		String text=driver.findElement(by).getText();
		return text;
	}
	
		
		
	

}
