package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest5 {
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
		driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
	@Test(dataProvider="dp1")
	public void testDemoWebShopLogin(String username,String password)
	{
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		if(driver.getTitle().contains("Login"))
		{
			
		}
		else {
			Assert.assertNotNull(driver.findElement(By.linkText("Log out")));
			driver.findElement(By.linkText("Log out")).click();
			
		}
		
	}
	@DataProvider(name="dp1")
	public Object[][] getDataFromExcel()
	{
		//read data from excel
		return ReadExcel.readExcel();
		
	}

}
