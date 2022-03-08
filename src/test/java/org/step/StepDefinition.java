package org.step;

import java.util.List;
import java.util.Map;

import org.base.BaseClass1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass1{

	public static WebDriver driver;

	@Given("User is on Facebook login page")
	public void user_is_on_facebook_login_page() {
		
	}
	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password(io.cucumber.datatable.DataTable dataTable) {
	
		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(3);
		String string = map.get("username");
		
		String string2 = asMaps.get(0).get("password");
		
		WebElement txtEmail = locateById("email");
		inputText(txtEmail, string);
		
		WebElement txtPass = locateById("pass");
		inputText(txtPass, string2);
	}

	@When("user clicks the login button")
	public void user_clicks_the_login_button() {
		WebElement btnLogin = locateByName("login");
		click(btnLogin);
	}

	@Then("Error is displayed")
	public void error_is_displayed() {
		System.out.println("Done");

	}
	
	
	

}
