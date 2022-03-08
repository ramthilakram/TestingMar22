package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition1 {
	public static WebDriver driver;
	@Given("User is on AdactinHotel login page and get the order number")
	public void user_is_on_AdactinHotel_login_page_and_get_the_order_number() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.findElement(By.id("username")).sendKeys("Ramkumar22");
		driver.findElement(By.id("password")).sendKeys("F5V089");
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.id("location")).sendKeys("Sydney");
		driver.findElement(By.id("hotels")).sendKeys("Hotel Sunshine");
		driver.findElement(By.id("room_type")).sendKeys("Double");
		driver.findElement(By.id("room_nos")).sendKeys("2-Two");
		driver.findElement(By.id("datepick_in")).sendKeys("02/03/2022");
		driver.findElement(By.id("datepick_out")).sendKeys("04/03/2022");
		driver.findElement(By.id("adult_room")).sendKeys("1-One");
		driver.findElement(By.id("child_room")).sendKeys("1-One");
		driver.findElement(By.id("Submit")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("first_name")).sendKeys("Ramkumar");
		driver.findElement(By.id("last_name")).sendKeys("Kaliamoorthy");
		driver.findElement(By.id("address")).sendKeys("Trichy");
		driver.findElement(By.id("cc_num")).sendKeys("1234567890123456");
		driver.findElement(By.id("cc_type")).sendKeys("VISA");
		driver.findElement(By.id("cc_exp_month")).sendKeys("May");
		driver.findElement(By.id("cc_exp_year")).sendKeys("2022");
		driver.findElement(By.id("cc_cvv")).sendKeys("1234");
		driver.findElement(By.id("book_now")).click();
		
		Thread.sleep(3000);
		
		
	}
	@When("user clicks the login button, book the hotel and get the order number")
	public void user_clicks_the_login_button_book_the_hotel_and_get_the_order_number() {
		WebElement ref = driver.findElement(By.id("order_no"));
		String attribute = ref.getText();
		
		System.out.println(attribute);
	}
	@When("user enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
	}

	
	}




