package com.jbk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadProperty {

	
	public String getPropertyValue(String key) {
		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return prop.getProperty(key);
	}
	@Test
	public void loginTest() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(getPropertyValue("URL"));
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(getPropertyValue("username"));
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(getPropertyValue("password"));
		driver.findElement(By.xpath("//button")).click();
	}
	

	@Test
	public void test01() throws Exception {
		
		FileInputStream fis = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty("URL");
		System.out.println(value);
		
	}
	
}
