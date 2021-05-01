package com.jbk;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class DPTest {
	public static WebDriver driver;
	
	public static void initalization() {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
	}
	
	@BeforeSuite
	public void setup() {
		initalization();
	}
	
	@Test(dataProvider = "loginData")
	public void loginTest(String uname, String pass, String title) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		Assert.assertEquals(driver.getTitle(), title);
		if(title.contains("Dashboard"))
			driver.findElement(By.linkText("LOGOUT")).click();

	}

  @DataProvider
  public Object[][] loginData() {
    return new Object[][] {
      new Object[] {"kiran@gmail.com", "123456", "JavaByKiran | Dashboard" },
      new Object[] { "mangesh@gmail.com", "qwerty", "JavaByKiran | Log in"},
    };
  }
}
