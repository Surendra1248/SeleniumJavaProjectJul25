package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base {
	public WebDriver driver;
	@Test
	public void testThree() throws IOException, InterruptedException {
		System.out.println("From testThree");

		driver = initializeDriver();

		driver.get(prop.getProperty("url3"));

		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.close();
	}
}
