package org.base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1{
	static WebDriver driver;
	
	public static void browserConfigChrome() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
}
	
	public static void openUrl(String url) {
		driver.get(url);
	}
	
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public static WebElement locateById(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;
	}
	
	public static WebElement locateByName(String name) {
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;
		
	}
	
	public void refresh() {
		
		driver.navigate().refresh();
	}
	
	public void back() {
		
		driver.navigate().back();
	}
	
	public void forward() {
		driver.navigate().forward();
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	public static void inputText(WebElement element,String value) {
		element.sendKeys(value);
	}
	public static void click(WebElement element) {
		element.click();
	}
	
	public static void staticWait(long time) throws InterruptedException {
		Thread.sleep(time);
	}
	public static String getAttribute(WebElement element,String value) {
		String attribute = element.getAttribute(value);
		return attribute;
	}
	public static void dropDownVisibleText(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByVisibleText(value);
	}
	/*public static void scrollTop(String arguments,WebElement element) {
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript(arguments, element);
	}*/
	
	
	
}