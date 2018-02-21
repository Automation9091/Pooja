package com.sis.qa.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sis.qa.base.TestBase;
import com.sis.qa.pages.AdministrationPage;
import com.sis.qa.pages.LoginPage;
import com.sis.qa.pages.ReportsPage;
import com.sis.qa.pages.StudiesPage;
import com.sis.qa.utilities.TestUtil;

public class StudiesTest extends TestBase {

	LoginPage loginpage;
	ReportsPage reportspage;
	AdministrationPage adminpage;
	StudiesPage studiespage;
	TestUtil utils;
	
	public StudiesTest() {
		super();
		InitializeReport();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		fnIntialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void newStudyCreation() throws InterruptedException {
		StartTestCase("!! Study Creation !!");
		//String strTCid = "newStudytest";
		reportspage = loginpage.LoginAdmin(prop.getProperty("username"),
				prop.getProperty("password"));
		Thread.sleep(3000);
		//reportspage.AdministrationLink.click();
		adminpage = reportspage.clickAdminstrationLink();
		adminpage.findNavigationLinkAndClick("Studies");
		studiespage.createNewStudy("Study7Feb", "Demo7Feb", "245", "1",
				"296", "SiteA");
		

		// adminpage.SeacrhStudies("Auto3");
		EndTestCase();
	}

	/*
	 * @Test(priority=0) public void existingStudySearch() throws
	 * InterruptedException { StartTestCase("!! Study Seacrh !!"); reportspage =
	 * loginpage.LoginAdmin(prop.getProperty("username"),
	 * prop.getProperty("password")); adminpage =
	 * reportspage.clickAdminstrationLink();
	 * adminpage.findNavigationLinkAndClick("Studies");
	 * studiespage.SeacrhStudies("TestStudy_Auto10");
	 * 
	 * EndTestCase(); }
	 */

	/*
	 * @AfterMethod public void tearDown() { driver.quit(); }
	 */

	@AfterSuite
	public void afterSuite() {
		GenerateReport();
	}

}
