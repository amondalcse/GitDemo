package com.test.customFunctions;

import java.io.File;

public class CustomFunctions
{
	public static String getRootDirectory()
	{
		File file=new File("");
		String absolutePath =file.getAbsolutePath();
		File dir= new File(absolutePath);
		String rootDir= dir.getPath();
		return rootDir;
		
	}

}
