package com.jbk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LocDemo {

	
	
	
	
	WebDriver driver;
	
	@Test
	public void test(){
		
		driver.findElement(By.id(""));
		driver.findElement(By.name(""));
		driver.findElement(By.linkText(""));
		driver.findElement(By.tagName(""));
		driver.findElement(By.partialLinkText(""));
		driver.findElement(By.className(""));
		
		driver.findElement(By.cssSelector(""));
		
		//1. for id==== #
		//2. for class ===  .(dot)
		
		//3 tag class id
		//tag 
		
	}
}
