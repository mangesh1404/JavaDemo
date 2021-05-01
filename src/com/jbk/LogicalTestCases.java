package com.jbk;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogicalTestCases {

	// for every TC-- actual data , expected data, result & testdata
	
	//verifying user table's headers
	
	@Test
	public void test01() {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
		ArrayList<String> expectedHeaders = new ArrayList<String>();
		
		ArrayList<String> actualHeaders = new ArrayList<String>();
		expectedHeaders.add("#");
		expectedHeaders.add("Username");
		expectedHeaders.add("Email");
		expectedHeaders.add("Mobile");
		expectedHeaders.add("Course");
		expectedHeaders.add("Gender");
		expectedHeaders.add("State");
		expectedHeaders.add("Action");
		List<WebElement> headers=driver.findElements(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]/th"));// 8 elements
		
		for(WebElement element : headers) {
			System.out.println(element.getText());
			actualHeaders.add(element.getText());
		}
		
		for(int i=0; i<actualHeaders.size();i++) {
			System.out.println("actualData: "+actualHeaders.get(i)+"  expectedData: "+expectedHeaders.get(i));
			Assert.assertEquals(actualHeaders.get(i), expectedHeaders.get(i));
		}
		Assert.assertEquals(actualHeaders, expectedHeaders);
		
		
	}
	// verifying user mail id's with gmail.com
	@Test
	public void test02() {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
		
		List<WebElement> emailId = driver.findElements(By.xpath("//td[3]"));// 4 elements
		
		for(WebElement element : emailId) {
			String text = element.getText();
			
			boolean value = text.contains("gmail.com");
			
			Assert.assertTrue(value);
			
			
		}
	}
	// verifying gender of a user
	@Test
	public void test03() {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
		
		List<WebElement> gender = driver.findElements(By.xpath("//td[6]"));// 4 elements
		
		for(WebElement element : gender) {
			
			String text = element.getText();// Male or Female
			boolean flag= text.equals("Male") || text.equals("Female");
			Assert.assertTrue(flag);
	}
	}
	//to verify left side menus on dashboard
	@Test
	public void test04() {
		
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		ArrayList<String> expectedMenus= new ArrayList<String>();
		ArrayList<String> actualMenus= new ArrayList<String>();
		
		expectedMenus.add("Dashboard");
		expectedMenus.add("Users");
		expectedMenus.add("Operators");
		expectedMenus.add("Useful Links");
		expectedMenus.add("Downloads");
		expectedMenus.add("Logout");
		
		List<WebElement> menus= driver.findElements(By.xpath("//li//span"));// 6elements
		
		for(WebElement element:menus)
			actualMenus.add(element.getText());
		
		Assert.assertEquals(actualMenus, expectedMenus);
	}
	
	@Test
	public void test05() {
		int i=2;
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//span[text()='Downloads']")).click();
		
		List<WebElement> bitValue= driver.findElements(By.xpath("//td[5]"));// 7 element
		
		for(WebElement element :bitValue ) {
			if(element.getText().equals("32bit")) 
			{
				System.out.println("32 bit link is available for: "+driver.findElement(By.xpath("//tr["+i+"]/td[3]")).getText());
			}
			i++;
		}
	}
	
	//if colour is aqua  its course should be Selenium
	@Test
	public void test06() {
		String text=null;
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Selenium");
		courses.add("Java");
		courses.add("Python");
		courses.add("Php");
		List<WebElement>boxes = driver.findElements(By.xpath("//div[contains(@class,'small-box')]"));//4 element
		
		for(WebElement box :boxes) {
			
			if(box.getAttribute("class").contains("aqua")) {
				text=driver.findElement(By.tagName("h3")).getText();
				
			}
		}
		SoftAssert sa= new SoftAssert();
		
		for(String course: courses)
			sa.assertEquals(text, course);
	
		sa.assertAll();
	}
	
	
	@Test
	public void winTest() {
		
		String expUrl ="file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/pages/pdf/selenium-testing-syllabus-jbk.pdf";
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();// 1window
		
		String parentId = driver.getWindowHandle();
		System.out.println("parent window id is:  "+parentId);
		driver.findElement(By.partialLinkText("More")).click();// 2 window
		
		Set<String> allWins= driver.getWindowHandles();// 2 vlaues
		
		for(String str: allWins) {
			if(!str.equals(parentId)) {
				System.out.println("child window id: "+str);
				driver.switchTo().window(str);
				//Assert.assertEquals(driver.getCurrentUrl(), expUrl);
			}
		}
	}
	@Test
	public void verifyTable() {
		int expectedValue = 1;
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		
		List<WebElement> userId =driver.findElements(By.xpath("//tr/td[1]"));// 4 element
		
		for(WebElement element : userId) {
			String text = element.getText();//"1",  "2"
			int actualValue = Integer.parseInt(text);// 1 , 2
			Assert.assertEquals(actualValue, expectedValue);
			expectedValue++;
		}	
		
	}
	@Test
	public void verifyMobile() {
		
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	
List<WebElement> mobiles =driver.findElements(By.xpath("//tr/td[4]"));// 4 element
WebElement e1=null;
		SoftAssert sa = new SoftAssert();
		for(WebElement element : mobiles) {
			String text = element.getText();//
			
			int noOfDig = text.length();
			if(noOfDig==10) {
				int index=mobiles.indexOf(element)+2;
				e1 = driver.findElement(By.xpath("//tr["+index+"]/td[2]"));
				System.out.println("moblie number is correct for: "+e1.getText());
			}
			else {
				int index=mobiles.indexOf(element)+2;
				e1 = driver.findElement(By.xpath("//tr["+index+"]/td[2]"));
				System.out.println("moblie number is not correct for: "+e1.getText());
			}
			sa.assertEquals(noOfDig, 10);
	
		}	
		sa.assertAll();
	}
	
	@Test
	public void verifyEmail() {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	
		List<WebElement> emails =driver.findElements(By.xpath("//tr/td[3]"));// 4 element
		
		for(WebElement element :emails) {
			 String text =element.getText();
			 boolean flag =text.contains("@gmail.com");
			 Assert.assertTrue(flag);
		}

	}
	// print all usernames belongs to Maharashtra
	// expected data--- Kiran	, Monica
	
	@Test
	public void verifyState() {
		String state= "Maharashtra";
		int i=0;
		
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	
		List<WebElement> unames =driver.findElements(By.xpath("//tr/td[2]"));// 4 names
		
		List<WebElement> states =driver.findElements(By.xpath("//tr/td[7]"));// 4 states
		ArrayList<String> actData = new ArrayList<String>();
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Monica");
		for(WebElement element : states) {
			String name=unames.get(i).getText();
			
			if(element.getText().equals(state)) {
				System.out.println(name);
				actData.add(name);
			}
				i++;
		}
		Assert.assertEquals(actData, expData);
	}
	
	@Test
	public void verifyOperators() {
		
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.xpath("//span[text()='Operators']")).click();
		
		List<WebElement> timings = driver.findElements(By.xpath("//td[6]"));
		int i=2;
		for(WebElement e1 :timings) {
			String xpath ="//tr["+ i + "]/td[2]" ;
			System.out.println(xpath);
			String text = e1.getText();
			if(!text.contains("Sunday")) {
				
				String name = driver.findElement(By.xpath(xpath)).getText();	
			System.out.println("employee not available on Sunday is: "+name);
			}
			i++;
		}
	
		//div[@class='box-body']/div[@class='form-group']/label
		//button//preceding::label
	}
		
		@Test(dataProvider="getLables")
		public void verifyAddUserLabels(String uname, String mobile , String email, 
				String course, String gender, String state, String pass) {
			
			System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
			driver.findElement(By.xpath("//span[text()='Users']")).click();
			driver.findElement(By.xpath("//button[text()='Add User']")).click();
			List<WebElement> labels = driver.findElements(By.xpath("//button//preceding::label"));
			
			Assert.assertEquals(labels.get(0).getText(), uname);
			ArrayList<String> expLabels =new ArrayList<String>();
			expLabels.add(uname);
			expLabels.add(mobile);
			expLabels.add(email);
			expLabels.add(course);
			expLabels.add(gender);
			expLabels.add(state);
			expLabels.add(pass);
			
			ArrayList<String> actLabels =new ArrayList<String>();
			for(WebElement label : labels) {
				String text= label.getText();
				actLabels.add(text);
			}
			
			Assert.assertEquals(actLabels, expLabels);
	}
		
		@Test
		public void verifyDownloadsCommonBlank() {
			int i = 2;
			System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
			driver.manage().window().maximize();
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
			driver.findElement(By.xpath("//span[text()='Downloads']")).click();

			List<WebElement> names = driver.findElements(By.xpath("//td[7]"));// all
			for (WebElement name : names) {
				//System.out.println(name.getText());
				WebElement app = driver.findElement(By.xpath("//tr["+i+"]/td[3]"));
				if (name.getText().equals(""))
					System.out.println(app.getText());
				i++;
			}
		}
		
		
		@DataProvider
		  public Object[][] getLables() {
		    return new Object[][] {
		      new Object[] { "Username", "Mobile", "Email","Courses","Gender","State","Password"},
		     
		    };
		  }	
		
		WebDriver driver;
		@BeforeMethod
		public void setup() {
			System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button")).click();
			driver.findElement(By.xpath("//span[text()='Users']")).click();
		}
			
	@Test
	public void verifyUserTable() {
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
