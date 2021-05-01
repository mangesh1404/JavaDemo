package com.jbk;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoWithDp {

	public static WebDriver driver;
	int row=1;
	// it will execute only once in the project at very first
	@BeforeSuite
	public void userPage() {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	}
	
	@Test( dataProvider = "userData")
	  public void loginTest(String srNo, String uname, String email, String mobile,
			  String course , String gender, String state, String action ) {
		ArrayList<String> actData= new ArrayList<String>();
			ArrayList<String> expData= new ArrayList<String>();
			expData.add(srNo);
			expData.add(uname);
			expData.add(email);
			expData.add(mobile);
			expData.add(course);
			expData.add(gender);
			expData.add(state);
			expData.add(action);
			if(row==1) {
				for(int i=1;i<=8;i++) 
				{
				WebElement header = driver.findElement(By.xpath("//th["+i+"]"));
				String text = header.getText();
				actData.add(text);
				}	
				row++;
			}
			else {
				for(int i=1;i<=8;i++) 
				{
					WebElement header = driver.findElement(By.xpath("//tr["+row+"]/td["+i+"]"));
					String text = header.getText();
					actData.add(text);
				}
				row++;
			}
			
			Assert.assertEquals(actData, expData);
	  }
	@DataProvider
	  public Object[][] userData() {
		  
	    return new Object[][] {
	    	
	      new Object[] { "#","Username","Email","Mobile","Course","Gender","State","Action" },
	      new Object[] { "1","Kiran","kiran@gmail.com","9898989898","Java/J2EE","Male","Maharashtra","Delete" },
	      new Object[] { "2","Sagar","sagar@gmail.com","999999999","Selenium","Male","Punjab","Delete" },
	      new Object[] { "3","Monica","monica@gmail.com","1111111111","Python","Female","Maharashtra","Delete" },
	      new Object[] { "4","Kimaya","kimaya@gmail.com","999999999","PHP","Female","Punjab","Delete" },
	    };
	  }
	
}
