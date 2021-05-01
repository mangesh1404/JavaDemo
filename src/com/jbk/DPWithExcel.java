package com.jbk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class DPWithExcel {

	WebDriver driver ;
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
	}
	@Test(dataProvider="loginData")
	public void loginTest(String uname, String pass, String title) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		if(title.contains("Dashboard")) 
			driver.findElement(By.linkText("LOGOUT")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	
	@DataProvider
	public String[][] loginData() throws Exception {
	
		FileInputStream fis = new FileInputStream("LoginData.xls");
		Workbook wb= Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet("login");
		String [][] data = new String[sh.getRows()-1][sh.getColumns()];
		for(int i=1;i<sh.getRows();i++) {// for rows
			for(int j=0;j<sh.getColumns();j++) { //for columns		
				Cell cell= sh.getCell(j, i);
				String value= cell.getContents();		
				data[i-1][j]=value;
			}
		}
		System.out.println(data);
		return data;
	}
	
	
}
