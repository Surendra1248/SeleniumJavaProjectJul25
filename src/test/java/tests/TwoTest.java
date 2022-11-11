package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {
	public WebDriver driver;
	@Test
	public void testTwo() throws IOException, InterruptedException {
		
		System.out.println("Pavan updated this code ");
		driver=initializeDriver();
		
		driver.get(prop.getProperty("url2"));
		
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		//Assert.assertTrue(false);
		driver.close();
	}

}
