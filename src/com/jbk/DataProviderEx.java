package com.jbk;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class DataProviderEx {
	
	
	@DataProvider
	  public Object[][] loginData() {
		  
	    return new Object[][] {
	    	
	      new Object[] { "kiran@gmail.com", "123456","JavaByKiran | Dashboard" },
	      new Object[] { "mangesh@gmail.com", "qwerty","JavaByKiran | Log in" },
	      new Object[] { "neelam@gmail.com", "asdfgh", "JavaByKiran | Log in" },
	    };
	  }
	
  

  
}
