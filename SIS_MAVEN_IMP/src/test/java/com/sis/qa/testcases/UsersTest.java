package com.sis.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sis.qa.base.TestBase;
import com.sis.qa.pages.AdministrationPage;
import com.sis.qa.pages.LoginPage;
import com.sis.qa.pages.ReportsPage;
import com.sis.qa.pages.StudiesPage;
import com.sis.qa.pages.UsersPage;


public class UsersTest extends TestBase {
	
	LoginPage loginpage;
	ReportsPage reportspage;
	AdministrationPage adminpage;
	StudiesPage studiespage;
	UsersPage userspage;
	

	public UsersTest() {
		super();
		InitializeReport();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		fnIntialization();
		loginpage = new LoginPage();
	}
	
	
	@Test(priority=1)	 
	public void newUserCreation() throws InterruptedException {
		StartTestCase("!! User Creation !!");
		//String strTCid = "newUsertest";
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

	/*@Test(priority=2)
	public void existingUserSearch() throws InterruptedException {
		StartTestCase("!! User Search !!");
		reportspage = loginpage.LoginAdmin(prop.getProperty("username"),
				prop.getProperty("password"));
		adminpage = reportspage.clickAdminstrationLink();
		adminpage.findNavigationLinkAndClick("Users");
		adminpage.SearchCreatedUser("TestUser_Auto5");

		EndTestCase();
	}*/
	
	@Test(priority=2)
	public void existingStudySearch() throws InterruptedException {
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
	
}
