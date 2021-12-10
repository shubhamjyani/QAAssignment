
package recruitCRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;

	@SuppressWarnings("deprecation")
	public WebDriver driverInitialize() throws IOException {

		Properties prop = new Properties();
		FileInputStream infoFile = new FileInputStream("src\\main\\java\\recruitCRM\\info.properties");
		prop.load(infoFile);
		String browser = prop.getProperty("browser");

		if (browser.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver", "src\\main\\java\\drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		else if (browser.contains("firefox")) {

			System.setProperty("webdriver.gecko.driver", "src\\main\\java\\drivers\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else 
			System.out.println("Browser not found");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;

	}
	
	public void getScreenshot(String name) throws IOException {
		
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File("src\\test\\java\\screenshots\\"+name+"screenshot.png"));
	}
}
