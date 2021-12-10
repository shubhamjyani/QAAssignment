package recruitCRM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.ForgotPasswordPage;
import PageObjects.LoginPage;
import PageObjects.ProfilePage;
import junit.framework.Assert;

public class LoginPageTest extends Base {
	
	
	@BeforeMethod
	public void driverInit() throws IOException {
		driver = driverInitialize();
		driver.get("https://app.recruitcrm.io/");
		
	}
	
	@Test
	public void positiveLoginTest() {
		
		// only one set of positive test case available
		// login with correct credentials
		
		String username = "shubhamjyani2@gmail.com";
		String password = "a3jKkxQB";
		
		LoginPage page = new LoginPage(driver);
		page.email.sendKeys(username);
		page.password.sendKeys(password);
		page.loginButton.click();
		
		ProfilePage profile = new ProfilePage(driver);
		
		// assert profile icon is displayed
		
		
		Assert.assertEquals(profile.profileIcon.isDisplayed(), true);
		
		
	}
	

	
	
	@Test
	public void elementVisibleTest() {
		
		
		// verify all the elements are displayed on the login page when opened
		
		LoginPage page = new LoginPage(driver);
		
		Assert.assertEquals(page.email.isDisplayed(), true);
		Assert.assertEquals(page.password.isDisplayed(), true);
		Assert.assertEquals(page.forgotPassword.isDisplayed(), true);
		Assert.assertEquals(page.loginButton.isDisplayed(), true);
		Assert.assertEquals(page.loginTitle.isDisplayed(), true);
		Assert.assertEquals(page.introText.isDisplayed(), true);
	}
	
	
	@Test
	public void forgotPasswordTest() {
		
		// forgot password click redirect test
		
		LoginPage page = new LoginPage(driver);
		
		page.forgotPassword.click();
		ForgotPasswordPage redirectPage = new ForgotPasswordPage(driver);
		String actualTitle = "Forgot your password?";
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expectedTitle = redirectPage.pageTitle.getText();
		
		// assert forget password link redirects to forgot password page
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test
	public void loginTitleTest() {
		
		// verify login page title
		
		LoginPage page = new LoginPage(driver);
		String title = page.loginTitle.getText();
		String loginTitle = "Login to Recruit CRM";
				
		Assert.assertEquals(title, loginTitle);
	}
	
	
	@Test(dataProvider="logindata", enabled =true)
	public void sampleTest(String id, String password) throws IOException {


		// negative test cases from excel sheet
		System.out.println(id);
		System.out.println(password);
		
		

		LoginPage page = new LoginPage(driver);
		
		if(id.contains("empty") && password.contains("empty")) {
			
			page.loginButton.click();
			
			// assert email and password required message when empty inputs
			
			Assert.assertEquals(page.emailRequiredText.getText(), "The email field is required.");
			Assert.assertEquals(page.passwordRequiredText.getText(), "The password field is required.");

			
		}
		else {

		
		
		page.email.sendKeys(id);
		page.password.sendKeys(password);
		page.loginButton.click();
		
		
		String failureMessage = page.loginFaileMessage.getText();
		
		// assert failure to login message
		
		Assert.assertEquals(failureMessage, "Failed to Login : Please check your Email ID & Password, if you still can’t login, email us at support@recruitcrm.io");

		}
	}
	
	@AfterMethod
	public void driverClose() {
		
		driver.quit();
	}

	@DataProvider
	public Object[][] logindata() throws IOException {
		
		
		// getting data from excel sheet to Object[][]

		FileInputStream fis = new FileInputStream("src\\main\\java\\TestData\\Login Test data.xlsx"); // data sheet in
																										// testdata
																										// folder
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0); // get testdata sheet

		Iterator<Row> row = sheet.iterator();
		Row firstRow = row.next();
		Iterator<Cell> cell = firstRow.cellIterator(); // get heading row
		int k = 0;
		int idcolumn = 0;
		int pwcolumn = 0;
		while (cell.hasNext()) {

			Cell value = cell.next();
			if (value.getStringCellValue().equalsIgnoreCase("id")) {

				idcolumn = k; // get id column in the excel sheet
			}
			if (value.getStringCellValue().equalsIgnoreCase("password")) {

				pwcolumn = k; // get password column in the excel sheet
			}
			k++;
		}



		int rowCount = sheet.getLastRowNum();
		Object[][] credentials = new Object[rowCount][2];

		int ci = 0;

		while (row.hasNext()) {

			Row r = row.next();
			
			credentials[ci][0] = r.getCell(idcolumn).getStringCellValue();
			credentials[ci][1] = r.getCell(pwcolumn).getStringCellValue();
			ci++;

		}
		


		workbook.close();
		return credentials;

	}

}
