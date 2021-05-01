package com.jbk;

import java.io.FileInputStream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadJXL {

	
	public String getData(String fileName, String sheetName, int row, int col)throws Exception{
		
		FileInputStream fis = new FileInputStream(fileName);
		Workbook wb= Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet(sheetName);
		String data= sh.getCell(col, row).getContents();
		
		if(data.equals(null))
			return "no data";
		else
		return 	data;
	}
	
	public int getRowCount(String fileName, String sheetName) throws Exception{
		
		FileInputStream fis = new FileInputStream(fileName);
		Workbook wb= Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet(sheetName);
		
		return sh.getRows();			
	}
	
	@Test
	public void readAllData() throws Exception {
		
		FileInputStream fis = new FileInputStream("LoginData.xls");
		Workbook wb= Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet("login");
		int rows= sh.getRows();//4
		int cols= sh.getColumns();//2
		for(int i=0;i<rows;i++) {// loop for rows
			for(int j=0;j<cols;j++) {//loop for cols	
				Cell cell= sh.getCell(j, i);// getCell method ask for input col and row
				String data = cell.getContents();
				System.out.print(data+"   ");
			}
			System.out.println();
		}
	}
	// fileName, sheetName, rowNum, colNum
	@Test
	public void readCellData() throws Exception {
		FileInputStream fis = new FileInputStream("LoginData.xls");
		Workbook wb= Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet("login");
		Assert.assertEquals(sh.getCell(0, 2).getContents(), "mangesh@gmail.com");		
	}
	@Test
	public void readAnyData() throws Exception{	
		getData("LoginData.xls", "login", 0, 0);
		getData("LoginData.xls", "login", 0, 1);
		getData("LoginData.xls", "login", 1,1);
		getData("LoginData.xls", "login", 1,2);
	}

	@Test
	public void loginFromExcel() throws Exception{
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys(getData("LoginData.xls", "login", 1, 0));
		driver.findElement(By.id("password")).sendKeys(getData("LoginData.xls", "login", 1, 1));
		driver.findElement(By.xpath("//button")).click();
	}
	
	
	@Test
	public void registerUserWithExcel() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.partialLinkText("Register")).click();
		int rows = getRowCount("LoginData.xls", "register");
		for (int i = 1; i < rows; i++) {// only for row
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys(getData("LoginData.xls", "register", i, 0));
			driver.findElement(By.id("mobile")).clear();
			driver.findElement(By.id("mobile")).sendKeys(getData("LoginData.xls", "register", i, 1));
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(getData("LoginData.xls", "register", i, 2));
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(getData("LoginData.xls", "register", i, 3));
			driver.findElement(By.xpath("//button")).click();
			Alert al = driver.switchTo().alert();
			System.out.println(al.getText());
			al.accept();
		}
	}
	
}
