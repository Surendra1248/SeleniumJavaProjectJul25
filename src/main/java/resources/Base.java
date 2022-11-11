package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String browser=prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	
	public String takeScreenShot(String testName,WebDriver driver) throws IOException {
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(sourceFile, new File(destFile));
		
		return destFile;
	}
}
