package com.jbk;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionEx {

	@Test
	public void test01()throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		WebElement logo = driver.findElement(By.tagName("img"));
		//act.contextClick(logo).build().perform();
		
		act.click(driver.findElement(By.tagName("img"))).perform();
		
		WebElement uname=driver.findElement(By.id("email"));
		
		act.click(uname).sendKeys(uname,"kiran@gmail.com").build().perform();
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		act.moveToElement(driver.findElement(By.xpath("//i[@class='ion ion-bag']"))).pause(3000).perform();
		
	}
	
	@Test
	public void test123(){
		
	}
	@Test
	public void test123(){
		
	}
}
