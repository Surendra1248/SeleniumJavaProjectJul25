package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailElement;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordElement;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtnElement;

	public WebElement getEmailElement() {
		return emailElement;
	}

	public WebElement getPasswordElement() {
		return passwordElement;
	}

	public WebElement getLoginBtnElement() {
		return loginBtnElement;
	}

}
