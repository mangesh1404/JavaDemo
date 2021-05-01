package com.jbk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathEx {
	
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		
		System.out.println(driver.findElement(By.id("email")).getAttribute("class"));
		driver.findElement(By.className("form-control"));
		driver.findElement(By.name("viewport"));
		driver.findElement(By.tagName("button"));
		
		// below locators are only used for links on a web page
		driver.findElement(By.linkText("Register a new membership"));
		driver.findElement(By.partialLinkText("new"));
		
		//driver.findElement(By.)
		
		
		
	}
	// there are two types of xpath 
	//Absolute and Relative
	
	// the xpath which starts with single forward slash '/' is Abs. xpath. not used at all in industry
	
	// the xpath which starts with double forward slash '//' is relative xpath.
	
	// means that any inetmediate node of html is started
}

//   /html/body/div/div[2]/form/div[1]/input

//   1.    /html/body/div/div[2]/form/div[1]/input

//	2.  	//input[@id='email']

//*[@id="email"]

//standard syntax:   // tagName [ @ attr.Name =' attr.Value ' ]
//					 //input  [@id       ='email'     ]

/// normal std. syntax xpath's are not always locate unique elements on a page.
//so we need some extra things in xpath that are called as xapth Axes.

//1. text()-----// tagname[ text()='textofElement']
//p[text()='Logout successfully']
//				//p[text()='Sign in to start your session']

// 2. contains()-------this will used to match subString in text.

	//tagName[contains (attr/fun , 'partVal')]

				//p[contains(text(),'Sys')]
				//h4[contains(text(),'PYTHON')]

//3. following------

// current node      							   // target node
//tagName[]//following::tagName
//tagName[]//following-sibling::tagName
//p[text()='Sign in to start your session']//following::h4

//4 . preceding------				

//p[text()='Sign in to start your session']//preceding::h4


//5 following-sibling


//6.  preceding-sibling
//tagName[]//preceding-sibling::tagName

//7. parent

//tagName[]//parent::tagName

//8. child

//tagName[]//child::tagName

//


