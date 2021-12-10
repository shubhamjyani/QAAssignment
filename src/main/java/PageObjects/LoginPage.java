package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver Driver;
	
	public LoginPage(WebDriver driver)
	{
		
		this.Driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement email;
	
	@FindBy(css="input[name='password']")
	public WebElement password;
	
	@FindBy(partialLinkText="Forgot your password?")
	public WebElement forgotPassword;
	
	@FindBy(xpath="//button[@id='sTestLoginBtn']")
	public WebElement loginButton;
	
	@FindBy(tagName="h2")
	public WebElement introText;
	
	@FindBy(xpath="//h1[@class=\"Logintitle\"]")
	public WebElement loginTitle;
	
	@FindBy(xpath="//div[@class='intercom-crher1.e4nbtsn3')]")
	public WebElement intercomLauncher;
	
	@FindBy(xpath="//form/div[1]/p")
	public WebElement emailRequiredText;
	
	@FindBy(xpath="//form/div[2]/p")
	public WebElement passwordRequiredText;
	
	@FindBy(xpath="//div[@class='notices is-top']")
	public WebElement loginFaileMessage;

}
