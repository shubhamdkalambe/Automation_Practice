package com.main;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pom.PageObjectModel;

public class FunctionLibrary {
	
	//Login Method
		public static void siteLogin(WebDriver driver, String Level, String Username, String Password,PageObjectModel p) {
			try {
				
				//Enter Level 
				if(Level.equals("Login")){
					driver.get("http://automationpractice.com/index.php");
				}else {
					System.out.println("Please provide valid Level");
				}
				
				//Click on Login Page
				p.setLoginPage();
				Thread.sleep(5000);
				
				//Enter UserName and Password
				p.setUsername(Username);
				p.setPassword(Password);
				p.clickSubmit();
				
				WebDriverWait wait1 = new WebDriverWait(driver, 60);
				System.out.println("Login Successful");
				Thread.sleep(5000);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//Clicking on Dresses
		public static void dressesTab(WebDriver driver) {
			try {
				
				//Mouse Hovering to Dresses and clicking on summer dresses.
				WebElement dresses=driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
				Actions action = new Actions(driver);
				
				action.moveToElement(dresses).moveToElement(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a"))).click().build().perform();
				System.out.println("Success");
				
				//Switching to List
				driver.findElement(By.className("icon-th-list")).click();
				
				//Scrolling down
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("scroll(0, 250);");
				
				//Store Add to WishList and scroll till that point
				//driver.findElement(By.xpath("//*[@class=\"wishlist\"]/a")).click();
				
				//check product is in stock and Clicking on InStock product and QuickView
				WebElement in_stock= driver.findElement(By.xpath("//*[@class=\"available-now\"][1]"));
				
				WebElement Blue_color=driver.findElement(By.xpath("//*[@style=\"background:#5D9CEC;\"]"));
				
				if(in_stock.isDisplayed()) {
					if(Blue_color.isDisplayed()) {
						
						//Identify QuickView Tab
						WebElement Quick_View=driver.findElement(By.xpath("//*[@class=\"quick-view\"][1]"));
						
						action.moveToElement(Quick_View).click().build().perform();
					}
				}
				
				WebDriverWait wait = new WebDriverWait(driver, 6000);
				
				
				//Switching to Frame.
				WebElement Quick_view_Frame= driver.findElement(By.xpath("//*[@src=\"http://automationpractice.com/index.php?id_product=5&controller=product&content_only=1\"]"));
				
				driver.switchTo().frame(Quick_view_Frame);
				
				//Storing the current Window.
				String parent_window = driver.getWindowHandle();
				
				Thread.sleep(2000);
				
				//Clicking on FB URL
				driver.findElement(By.xpath("//*[@class=\"btn btn-default btn-facebook\"]")).click();
				
				//Handling New Windows popup
				
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}
				
				if(driver.getTitle().equals("Facebook")){
					System.out.println("Going successfully to Facebook");
				}
				
				//driver.close();
				
				//Going back to previous window.
				driver.switchTo().window(parent_window);
				
				driver.switchTo().frame(Quick_view_Frame);
				
				Thread.sleep(2000);
				//driver.switchTo().
				
				//Clicking on Quantity
				driver.findElement(By.id("quantity_wanted")).clear();
				driver.findElement(By.id("quantity_wanted")).sendKeys("2");
				
				//CLick on blue color
				driver.findElement(By.id("color_14")).click();	
				
				WebDriverWait wait1 = new WebDriverWait(driver, 2000);
				
				//Clicking on Wishlist button.
				//driver.findElement(By.id("wishlist_button")).click();
				
				//WebDriverWait wait2 = new WebDriverWait(driver, 3000);
				
				//wait.until(ExpectedConditions.alertIsPresent());
				
				//Alert alert=driver.switchTo().alert();
				
				
				//alert.dismiss();
				
				//Closing.
				//driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/a"));
					
				
				//Clicking on add to Cart
				driver.findElement(By.id("add_to_cart")).click();
				
				Thread.sleep(5000);
				
				//Check Price and verify.
				String price=driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[3]/span")).getText();
				
				
				//Proceed on checkout.
				driver.findElement(By.xpath("//*[@title=\"Proceed to checkout\"]")).click();
				
				
				//Scrolling down
				js.executeScript("scroll(0, 550);");
				
				//Verify Address on Shopping cart page.
				String Address= driver.findElement(By.className("address first_item item box")).getText();
				
				if(Address!=null) {
					System.out.println("Address is present");
				}
				
				//Checking amount is correct or not.
				String size= driver.findElement(By.className("//*[@class=\"cart_quantity_input form-control grey\"]")).getText();
				
				if(size.equals(2)) {
					System.out.println("Size is correct");
				}
				
				//Checking Product is same or not(Color is blue or not.)
				String color = driver.findElement(By.xpath("//*[@id=\"product_5_19_0_307068\"]/td[2]/small[2]/a")).getText();
				
				color.toLowerCase();
				
				if(color.contains("blue")) {
					System.out.println("Product is same");
				}
				
				
				//Check total price and store it.
				String Total_price= driver.findElement(By.id("total_price")).getText();
				
				//Scrolling down
				js.executeScript("scroll(0, 250);");
				
				
				//Click on Proceed to Checkout.
				driver.findElement(By.xpath("//*[@class=\"cart_navigation clearfix\"]/a[1]")).click();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		//Logout Method
		public static boolean eRALogout(WebDriver driver) {		
			try {
				//click on logout.
				driver.findElement(By.partialLinkText("LogOut")).click();
				Thread.sleep(3000);
				driver.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return true;
		}
		
}
