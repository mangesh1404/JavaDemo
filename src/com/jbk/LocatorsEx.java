package com.jbk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorsEx {

	
	@Test
	public void test01() {
		
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();	
		
		driver.findElement(By.id("email"));
		
		driver.findElement(By.name("viewport"));// rare attribute
		
		driver.findElement(By.tagName("img"));
		
		driver.findElement(By.className("login-box-msg"));
		
		// applicable only for links on a webpage
		driver.findElement(By.linkText("Users"));
		
		driver.findElement(By.partialLinkText("Register"));
		
		// css selector--cascade style sheet
		
		//This type of locator is based on physical things of WebElement. 
		
			
			//	1. Tag and Id
			//syntax--- tagName#id
			driver.findElement(By.cssSelector("input#email"));
			
			//  2. tag and class
			
			//syntax--- tagName.class
			WebElement abc=driver.findElement(By.cssSelector("p.login-box-msg"));
			
			WebElement sel_box =driver.findElement(By.className("small-box bg-aqua"));
			
			sel_box.getCssValue("background-color");
			
			
			abc.getCssValue("display");//block
			
			//3. Tag and Attributes
			
			//syntax---  tagName[attribute=value]
			
			driver.findElement(By.cssSelector("input[placeholder=Email]"));
					
			// 4. tag class and attribute
			
			//syntax---  tagName.class[attribute=value]
			
			driver.findElement(By.cssSelector("input.form-control[placeholder=Email]"));
			
			/*//5 tag and inner text
			
			//syntax-- tag:contains("text")
			
			driver.findElement(By.cssSelector("p:contains('Kiran')"));*/
			
			
			
			
	}	
}
