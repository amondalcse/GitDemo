package com.obopay.customFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader
{
	public static Properties prop;
	public static Properties config;
	public static Properties OR;
	//public static Properties text;
	
	public static String rootDir=CustomFunctions.getRootDirectory();
	
	public static void loadProperty()throws IOException
	{
		prop= new Properties();
		config= new Properties();
		OR= new Properties();
	//	text=new Properties();
		
		try
		{
			FileInputStream input1= new  FileInputStream(rootDir+"/Resources/config.properties");
			config.load(input1);
			
			FileInputStream input2= new FileInputStream(rootDir+"/Resources/OR.properties");
			OR.load(input2);
			
			/*
			 * FileInputStream input3 = new
			 * FileInputStream(rootDir+"Resources/text.properties"); text.load(input3);
			 */
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			// TODO: handle exception
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
