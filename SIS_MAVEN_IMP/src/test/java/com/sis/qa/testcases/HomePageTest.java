package com.sis.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sis.qa.base.TestBase;
import com.sis.qa.pages.HomePage;
import com.sis.qa.pages.LoginPage;
import com.sis.qa.pages.ReportUploadPage;
import com.sis.qa.pages.ReportsPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	ReportsPage reportspage;
	ReportUploadPage reportuploadpage;
	HomePage homepage;
	
	public HomePageTest(){
		super();
		InitializeReport();
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		fnIntialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void newReportSearchTest() throws InterruptedException {
		StartTestCase("!! Search Report !!");
		reportspage = loginpage.LoginAdmin(prop.getProperty("username"),
				prop.getProperty("password"));
		homepage = reportspage.clickHomePageLink();
		homepage.SearchCriteria("Report_9Jan");
		
		EndTestCase();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		GenerateReport();
	}
		
}
