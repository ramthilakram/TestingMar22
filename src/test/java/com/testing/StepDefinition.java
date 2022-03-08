package com.testing;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {

	public static WebDriver driver;

	@Given("User is on Facebook login page")
	public void user_is_on_facebook_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password(io.cucumber.datatable.DataTable dataTable) {
	
		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(3);
		String string = map.get("username");
		
		String string2 = asMaps.get(3).get("password");
		
		driver.findElement(By.id("email")).sendKeys("Greens");
		driver.findElement(By.id("pass")).sendKeys("Ram@1234");
	}

	@When("user clicks the login button")
	public void user_clicks_the_login_button() {
		driver.findElement(By.name("login")).click();
	}

	@Then("Error is displayed")
	public void error_is_displayed() {
		WebElement findElement = driver.findElement(By.xpath("//div[contains(text(),'incorrect')]"));
		String text = findElement.getText();
		boolean contains = text.contains(text);
		System.out.println(contains);

	}

}
