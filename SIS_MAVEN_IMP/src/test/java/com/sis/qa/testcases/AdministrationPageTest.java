package com.sis.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sis.qa.base.TestBase;
import com.sis.qa.pages.AdministrationPage;
import com.sis.qa.pages.LoginPage;
import com.sis.qa.pages.ReportsPage;
import com.sis.qa.utilities.TestUtil;

public class AdministrationPageTest extends TestBase {

	LoginPage loginpage;
	ReportsPage reportspage;
	AdministrationPage adminpage;
	TestUtil util;

	// ExcelUtils excelUtil;

	public AdministrationPageTest() {
		super();
		InitializeReport();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		fnIntialization();
		loginpage = new LoginPage();
		//util = new TestUtil();
	}

	@Test(priority = 1)
	public void newStudyCreation() throws InterruptedException {
		StartTestCase("!! Study Creation !!");
		//String strTCid = "newStudytest";
		reportspage = loginpage.LoginAdmin(prop.getProperty("username"),
				prop.getProperty("password"));
		Thread.sleep(5000);
		adminpage = reportspage.clickAdminstrationLink();
		adminpage.findNavigationLinkAndClick("Studies");
		adminpage.createNewStudy("Study7Feb", "Demo7Feb", "245", "1",
				"296", "SiteA");
		
		/*String strStudyNumber = getdataFromExcel(strTCid, "StudyNumber");
		//String strStudyNumber = "Automation_StudyNo" + tUtils.GenerateRandomNum(999999, 100000);
		String strProtocolNumbe = getdataFromExcel(strTCid, "ProtocolNumbe");
		String strClients = getdataFromExcel(strTCid, "Clients");
		String strNotificationNo = getdataFromExcel(strTCid, "NotificationNo");
		String strCenter = getdataFromExcel(strTCid, "Center");
		String strSiteRefNumber = getdataFromExcel(strTCid, "SiteRefNumber");
		
		
		adminpage.createNewStudy(strStudyNumber, strProtocolNumbe, strClients, strNotificationNo,
				strCenter, strSiteRefNumber);*/

		EndTestCase();
	}

	@Test(priority = 2)
	public void newUserCreation() throws InterruptedException {
		StartTestCase("!! User Creation !!");
		String strTCid = "newUsertest";
		reportspage = loginpage.LoginAdmin(prop.getProperty("username"),
				prop.getProperty("password"));
		adminpage = reportspage.clickAdminstrationLink();
		adminpage.findNavigationLinkAndClick("Users");
		
		adminpage.NewUserCreation("User7Feb", "Demo7Feb@qa.com", "welcome123",
				"India", "296", "India", "296",
				"Principal Investigator (PI)");
		

		/*String strUser = getdataFromExcel(strTCid, "Username");
		//String strStudyNumber = "Automation_StudyNo" + tUtils.GenerateRandomNum(999999, 100000);
		String strUserId = getdataFromExcel(strTCid, "UserId");
		String strPassword = getdataFromExcel(strTCid, "Password");
		//String strCnfrmPassword = getdataFromExcel(strTCid, "Password");
		String strCountry = getdataFromExcel(strTCid, "Country");
		String strClient = getdataFromExcel(strTCid, "Clients");	
		String strCountryofSite = getdataFromExcel(strTCid, "CountryOfSite");
		String strSiteCenter = getdataFromExcel(strTCid, "SiteCenter");	
		String strSiteRole = getdataFromExcel(strTCid, "ClinicalSiteRole");
				
		//String userName = "Automation_UserName" + util.GenerateRandomNum(999999, 100000);
		adminpage.NewUserCreation(strUser, strUserId, strPassword,
				strCountry, strClient, strCountryofSite, strSiteCenter,
				strSiteRole);*/
		adminpage.SearchCreatedUser("User16Jan");

		EndTestCase();
	}

	
/*	 * @Test(priority=3) public void existingUserSearch() throws
	 * InterruptedException { StartTestCase("!! User Search !!"); reportspage =
	 * loginpage.LoginAdmin(prop.getProperty("username"),
	 * prop.getProperty("password")); adminpage =
	 * reportspage.clickAdminstrationLink();
	 * adminpage.findNavigationLinkAndClick("Users");
	 * adminpage.SearchCreatedUser("TestUser_Auto5");
	 * 
	 * EndTestCase(); }*/
	 

	@Test(priority = 3)
	public void existingStudySearch() throws InterruptedException  {
		StartTestCase("!! Study Seacrh !!");
		//String strTCid = "newStudytest";
		
		reportspage = loginpage.LoginAdmin(prop.getProperty("username"),
				prop.getProperty("password"));
		adminpage = reportspage.clickAdminstrationLink();
		adminpage.findNavigationLinkAndClick("Studies");
		
		//String strStudyNumber = getdataFromExcel(strTCid, "StudyNumber");
		adminpage.SeacrhStudies("Study7Feb");

		EndTestCase();

	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit(); 
	}
	

	@AfterSuite
	public void afterSuite() {
		GenerateReport();
	}
}
