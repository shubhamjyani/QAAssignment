package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	
public WebDriver Driver;
	
	public ForgotPasswordPage(WebDriver driver)
	{
		
		this.Driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='Logintitle']")
	public WebElement pageTitle;
	

}
