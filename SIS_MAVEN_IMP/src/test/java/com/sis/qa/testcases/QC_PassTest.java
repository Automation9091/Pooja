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

public class QC_PassTest extends TestBase {

	LoginPage loginpage;
	ReportsPage reportspage;
	ReportUploadPage reportuploadpage;
	HomePage homepage;
	//E_Signature esign;

	public QC_PassTest() {
		super();
		InitializeReport();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		fnIntialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void QCPassReport() throws InterruptedException {
		StartTestCase("!! QC Pass Report !!");
		homepage = loginpage.LoginMedical(prop.getProperty("medicaluser"),
				prop.getProperty("medpassword"));
		//homepage = reportspage.clickHomePageLink();
		//homepage.SearchCriteria("Test_Automation8");
		reportuploadpage = homepage.QcNeededtest("Test7Feb");
		reportuploadpage.fnPerformESignature(prop.getProperty("medicaluser"), prop.getProperty("medpassword"));
		
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
