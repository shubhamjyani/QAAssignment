package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

	public WebDriver Driver;

	public ProfilePage(WebDriver driver) {

		this.Driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='sTest-dpLinkInAppBtn']")
	public WebElement profileIcon;

}
