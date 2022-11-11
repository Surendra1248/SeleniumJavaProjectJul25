package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Login extends Base{
	WebDriver driver;
	LoginPage login ;
	 @Given("^Open any browser$")
	    public void open_any_browser() throws Throwable {
	      driver=  initializeDriver();
	    }
	 @And("^Navigate to login page$")
	    public void navigate_to_login_page() throws Throwable {
	        driver.get(prop.getProperty("URL"));
	        LandingPage landing = new LandingPage(driver);
	        landing.myAccDropDownField().click();
	        landing.loginOptField().click();
	    }

	    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	    public void user_enters_username_as_something_and_password_as_something_into_the_fields(String strArg1, String strArg2) throws Throwable {
	       login = new LoginPage(driver);
	       
	       login.getEmailElement().sendKeys(strArg1);
	       login.getPasswordElement().sendKeys(strArg2);
	    }
	    @And("^User clicks on login button$")
	    public void user_clicks_on_login_button() throws Throwable {
	       login.getLoginBtnElement().click();
	    }


	    @Then("^verify user is able to successfully login$")
	    public void verify_user_is_able_to_successfully_login() throws Throwable {
	        AccountPage account = new AccountPage(driver);
	        Assert.assertTrue(account.getEditaccElement().isDisplayed());
	    }
	    
	    @After
	    public void closeBrowser() {
	    	driver.close();
	    }

	   

	    
}
