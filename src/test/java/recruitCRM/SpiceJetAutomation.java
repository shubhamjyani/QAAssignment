package recruitCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class SpiceJetAutomation extends Base{
	
	
	@BeforeMethod
	public void driverinitialize() throws IOException {
		
		driver= driverInitialize();
		driver.get("https://www.spicejet.com/");
	}
	
	@Test
	public void radioButton() {
		
		// test to verify return date is enabled and disabled on round trip and one way trip
		
		
		// round trip radio button click
		
		driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']")).click();
		
		WebElement returnDate = driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']/div[1]"));
		String opacity1 = returnDate.getAttribute("style");
		
		
		Assert.assertTrue(opacity1.contains("opacity: 1"));
		
		// one-way-radio-button click
		
		driver.findElement(By.xpath("//div[@data-testid='one-way-radio-button']")).click();
		String opacity2 = returnDate.getAttribute("style");
		Assert.assertTrue(opacity2.contains("opacity: 0.5"));
		
			
	}
	
	@AfterMethod
	public void closeDriver() {
		
		driver.quit();
	}

}
