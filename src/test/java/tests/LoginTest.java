package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	@BeforeMethod
	public void openApplication() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
	}

	@Test(dataProvider = "getLoginData")
	public void login(String uname, String pwd, String expected) {

		LandingPage landing = new LandingPage(driver);
		landing.myAccDropDownField().click();
		landing.loginOptField().click();

		LoginPage login = new LoginPage(driver);
		login.getEmailElement().sendKeys(uname);
		login.getPasswordElement().sendKeys(pwd);
		login.getLoginBtnElement().click();

		AccountPage account = new AccountPage(driver);
		String actual = null;
		try {
			if (account.getEditaccElement().isDisplayed()) {
				actual = "success";
			}
		} catch (Exception e) {
			actual = "failure";
		}

		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "phaniatw2@gmail.com", "atw@123", "success" },
				{ "sample@test.com", "sample123", "failure" } };
		return data;
	}

}
