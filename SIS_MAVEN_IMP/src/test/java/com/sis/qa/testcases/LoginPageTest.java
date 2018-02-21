package com.sis.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sis.qa.base.TestBase;
import com.sis.qa.pages.LoginPage;
import com.sis.qa.pages.ReportsPage;

public class LoginPageTest extends TestBase{
	
	//to access all non static function of loginPage class
	LoginPage loginpage;
	ReportsPage reportsPage;
	
	//Class constructor
	//super() : testbase class constructor to call properties

	
	public LoginPageTest(){
		super();
		InitializeReport();
	}
	
	//test case should be seperated- independent
	//for every test launch and login 
	//@test
	//Logout after every test 
	
	/*@BeforeClass
	public void beforeClass()
	{
		InitializeReport();
	}*/
	
	@BeforeMethod
	public void setup(){
		//InitializeReport();
		fnIntialization();		
	    loginpage = new LoginPage();			
	}
	
	
	/*@Test(priority=1)
	public void LoginPageTitleTest(){
		
		String Apptitle = loginpage.vlaidateLoginPage();
		Assert.assertEquals(Apptitle, "PAREXEL - SIS");
		
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);
	}*/
	


	@Test(priority=1)
	public void LoginTest(){
		StartTestCase("Login_Validation_001");
		reportsPage = loginpage.LoginAdmin(prop.getProperty("username"), prop.getProperty("password"));
		EndTestCase();
	}
	
	
	@AfterMethod
	public void tearDown(){
		//close all browser
		driver.quit();
	}	
		
	@AfterSuite
	public void afterSuite()
	{
		GenerateReport();
	}
	
}
	
	
	
	


