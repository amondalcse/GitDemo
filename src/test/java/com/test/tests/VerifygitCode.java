package com.test.tests;

import org.testng.annotations.Test;

public class VerifygitCode 
{
	@Test
	public void firstTest()
	{
		System.out.println("first chages");
		System.out.println("Second changes");
	}
	@Test(description = "Second test")
	public void secondTest()
	{
		System.out.println("New branch");
	}

}
