package com.sis.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sis.qa.base.TestBase;
import com.sis.qa.pages.LoginPage;
import com.sis.qa.pages.ReportUploadPage;
import com.sis.qa.pages.ReportsPage;


public class ReportPageTest extends TestBase{
	
	LoginPage loginpage;
	ReportsPage reportspage;
	ReportUploadPage reportuploadpage;
	//TestUtil testutils;
	
	public ReportPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		fnIntialization();		
	    loginpage = new LoginPage();
	    reportuploadpage = new ReportUploadPage();
	    reportspage = loginpage.LoginAdmin(prop.getProperty("username"), prop.getProperty("password"));
	    
	}
	
	@Test(priority=1)
	public void clickreportUploadtest() throws InterruptedException{
		
		//WaitForObjectToClick(ReportUploadLink);
		reportspage.clickReportUploadLink();
	}
	
	/*@Test()
	public void clickAdminLink() throws InterruptedException{
		reportspage.clickAdminstrationLink();
	}*/

	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
