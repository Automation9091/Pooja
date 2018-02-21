package com.sis.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.sis.qa.base.TestBase;
import com.sis.qa.pages.E_Signature;
import com.sis.qa.pages.HomePage;
import com.sis.qa.pages.LoginPage;
import com.sis.qa.pages.ReportUploadPage;
import com.sis.qa.pages.ReportsPage;
import com.sis.qa.utilities.TestUtil;

public class ReportUploadPageTest extends TestBase {

	LoginPage loginpage;
	ReportsPage reportspage;
	ReportUploadPage reportuploadpage;
	HomePage homepage;
	E_Signature eSignature;
	TestUtil tUtils;

	public ReportUploadPageTest() {
		super();
		InitializeReport();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		fnIntialization();
		loginpage = new LoginPage();
		tUtils = new TestUtil();
		
	}

	@Test(priority = 1)
	public void newReportUploadtest() throws InterruptedException {
		StartTestCase("!! Upload Report Validation !!");
		String strTCid = "newReportUploadtest";
		reportspage = loginpage.LoginAdmin(prop.getProperty("username"),
				prop.getProperty("password"));
		Thread.sleep(5000);
		// reportspage.clickTabInHomePage("Report Upload");
		reportuploadpage = reportspage.clickReportUploadLink();
		reportuploadpage.selectICSRReporttype();

		String strProduct = getdataFromExcel(strTCid, "Product");
		String strStudyNumber = getdataFromExcel(strTCid, "StudyNumber");
		String strCaseValue = getdataFromExcel(strTCid, "CaseValue");
		//String strCaseValue = "Test_CN" + tUtils.GenerateRandomNum(999999, 100000);
		String strDocTitle = getdataFromExcel(strTCid, "Doctitle");
		String strSeriousValue = getdataFromExcel(strTCid, "SeriousValue");
		String strIcsrValue = getdataFromExcel(strTCid, "icsrvalue");
		String strCountry = getdataFromExcel(strTCid, "Country");
		String strReportnotINDSRval = getdataFromExcel(strTCid, "ReportnotINDSR");
		String strPlacebo = getdataFromExcel(strTCid, "Placebo");
		String strScheduleY = getdataFromExcel(strTCid, "ScheduleY");
		String strManufDate = getdataFromExcel(strTCid, "ManufDate");
		String strDateofReport = getdataFromExcel(strTCid, "DateofReport");
		

		reportuploadpage.UploadNewReporttest(strProduct, strStudyNumber,
				strCaseValue, strDocTitle, strSeriousValue, strIcsrValue,
				strCountry,strReportnotINDSRval,strPlacebo,strScheduleY,strManufDate,strDateofReport);

		homepage = reportuploadpage.fnPerformESignature(prop.getProperty("username"),
				prop.getProperty("password"));

		homepage.SearchCriteria(strCaseValue);

		EndTestCase();
	}

	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}
*/
	@AfterSuite
	public void afterSuite() {
		GenerateReport();
	}
}
