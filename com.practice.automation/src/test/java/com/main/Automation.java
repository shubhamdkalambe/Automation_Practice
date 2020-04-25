package com.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.pom.PageObjectModel;

public class Automation {


	// public static variables
	public static String Level = "Login";
	public static WebDriver driver;
	public static PageObjectModel p;
	public static String Username = "shubhamdakalambe@gmail.com";
	public static String Password =  "Shubh@m9";
	public static SoftAssert SA;

	@BeforeClass
	public void beforeClass() {
		try {
			// System property
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\SK5044330\\Desktop\\Validation Tool\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
			//Maximize the window
			driver.manage().window().maximize();

			// Page Factory Object initiation.
			p = new PageObjectModel(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	// Get any value as string.
	

	}

	@BeforeMethod
	public void beforeMethod() {
	}

	/*
	 * @Test//(dataProvider = "dp") public void invoiceLevelFieldValidations() { try
	 * {
	 * 
	 * }catch(Exception e) { e.printStackTrace(); } }
	 */

	/*
	 * @Test//(dataProvider = "dp") public void packageLevelFieldValdiations() { try
	 * { System.out.println("Inside packageLevelFieldValdiations"); }catch(Exception
	 * e) { e.printStackTrace(); } }
	 */

	@Test // (dataProvider = "dp")
	public void inquiryFieldValidations() {
		try {

			// Call login method
			FunctionLibrary.siteLogin(driver, Level, Username, Password,p);

			// Calling eRAenquiry1 function
			FunctionLibrary.dressesTab(driver);
			
			// Calling eRAenquiry2 function
			//SA.assertEquals(functionLibrary.eRAInquiry2(driver, SA), true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Test//(dataProvider = "dp") public void otherFieldValidations() { try {
	 * System.out.println("Inside otherFieldValidations"); }catch(Exception e) {
	 * e.printStackTrace(); } }
	 */

	@AfterMethod
	public void afterMethod() {
		try {
			// Call the logout.
			//SA.assertEquals(functionLibrary.eRALogout(driver), true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		try {
			SA.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
