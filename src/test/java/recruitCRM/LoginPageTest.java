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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class LoginPageTest extends Base {
	
	
	@BeforeMethod
	public void driverInit() throws IOException {
		driver = driverInitialize();
		driver.get("https://app.recruitcrm.io/");
		
	}

	@Test(dataProvider="logindata")
	public void sampleTest(String id, String password) throws IOException {


		System.out.println(id);
		System.out.println(password);


		LoginPage page = new LoginPage(driver);
		page.email.sendKeys(id);
		page.password.sendKeys(password);
		page.loginButton.click();

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
