package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LegalTermsPage {
	
public WebDriver Driver;
	
	public LegalTermsPage(WebDriver driver)
	{
		
		this.Driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='dropdownMenuButton']")
	public WebElement dropDownButton;
	
	@FindBy(tagName="h1")
	public WebElement pageHeading;
	
	@FindBy(xpath="//div[@id='navbar-main-collapse']/ul[1]/li[1]")
	public WebElement featuresDropdown;
	
	@FindBy(xpath="//div[@id='navbar-main-collapse']/ul[1]/li[2]")
	public WebElement pricingLink;
	
	@FindBy(xpath="//div[@id='navbar-main-collapse']/ul[1]/li[3]")
	public WebElement blogLink;
	
	@FindBy(xpath="//div[@id='navbar-main-collapse']/ul[1]/li[4]")
	public WebElement resourcesDropdown;
	
	@FindBy(xpath="//div[@aria-labelledby='dropdownMenuButton']/a[1]")
	public WebElement english;
	
	@FindBy(xpath="//div[@aria-labelledby='dropdownMenuButton']/a[2]")
	public WebElement francais;
	
	@FindBy(xpath="//div[@aria-labelledby='dropdownMenuButton']/a[3]")
	public WebElement deutsche;
	
	@FindBy(xpath="//button[text()=' Got it!']")
	public WebElement gotItButton;
		

}
