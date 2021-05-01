package com.jbk;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;


// JXL--.xls
//POI---- .xlsx

public class NewTest {
	
	@Test
	public void readJXL() throws Exception {
		
		FileInputStream fis = new FileInputStream("LoginData.xls");
		Workbook wb= Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet("login");
		int rows = sh.getRows();//4
		int col = sh.getColumns();//2
		System.out.println("rows and cols in a file are: "+rows+ "  "+col);
		
		for(int i=0;i<rows;i++) {// for rows
			for(int j=0;j<col;j++) {// for col
				Cell c = sh.getCell(j, i);
				System.out.print(c.getContents()+"  ");
			}
			System.out.println();
		}
		
	}
  @Test(dataProvider = "dp")
  public void loginWithExcelDP(String uname, String pass, String title) {
	  System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		
		//Assert.assertEquals(driver.getTitle(), title);
		if(driver.findElement(By.linkText("LOGOUT")).isDisplayed())
			Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
		else
			Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
  }

  @DataProvider
  public Object[][] dp()throws Exception {
    
	  FileInputStream fis = new FileInputStream("LoginData.xls");
	  Workbook wb= Workbook.getWorkbook(fis);
	  Sheet sh = wb.getSheet("login");
	  String [][] data= new String[sh.getRows()][sh.getColumns()];
	  
	  for(int i=1;i<sh.getRows();i++) {// for rows
		for(int j=0;j<sh.getColumns();j++) {// for col
			Cell c = sh.getCell(j, i);
			data[i-1][j]=c.getContents();
		}
	  }
	  return data;
  }
  
  
  
  
}
