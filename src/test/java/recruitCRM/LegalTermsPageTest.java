package recruitCRM;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.LegalTermsPage;
import junit.framework.Assert;

public class LegalTermsPageTest extends Base{
	
	@BeforeMethod
	public void driverInit() throws IOException {
		driver = driverInitialize();
		driver.get("https://recruitcrm.io/de/legal/terms");
		
	}
	
	@Test
	public void languageDropdownTest() {
	
		LegalTermsPage page = new LegalTermsPage(driver);
	
		
		page.gotItButton.click();
		page.dropDownButton.click();
		page.english.click();
		Assert.assertEquals(page.blogLink.getText().contains("Blog"),true);
		Assert.assertEquals(page.featuresDropdown.getText().contains("Features"),true);
		Assert.assertEquals(page.pricingLink.getText().contains("Pricing"),true);
		Assert.assertEquals(page.resourcesDropdown.getText().contains("Resources"),true);
		
		page.dropDownButton.click();
		page.francais.click();
		Assert.assertEquals(page.featuresDropdown.getText().contains("Caractéristiques"),true);
		Assert.assertEquals(page.pricingLink.getText().contains("Tarification"),true);
		
		page.dropDownButton.click();
		page.deutsche.click();
		Assert.assertEquals(page.featuresDropdown.getText().contains("Eigenschaften"),false);
		Assert.assertEquals(page.pricingLink.getText().contains("Preisgestaltung"),false);
		
	}
	

	@AfterMethod
	public void driverClose() {
		
		driver.quit();
	}

}
