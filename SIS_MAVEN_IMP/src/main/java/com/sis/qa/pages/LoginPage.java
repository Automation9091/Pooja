package com.sis.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.support.PageFactory;
import com.sis.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR
	
	@FindBy(name="Username")
	WebElement emailaddress;

	@FindBy(name="Password")
	WebElement password;
	
	@FindBy(name="submit")
	WebElement loginbutton;
	
	@FindBy(xpath=".//img[@src='../../media/PAREXEL_Lockup_Small.jpg']")
	WebElement paraxelLogo;
	
	
	//this points to current class constructor to initialize object
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String vlaidateLoginPage(){
		return driver.getTitle();
	}
	
	public boolean validateLogo(){
		return paraxelLogo.isDisplayed();
	}
	
	public ReportsPage LoginAdmin(String emaladd, String pwd){
		if (emailaddress.isDisplayed())
		{
			WriteSteps("Pass", "Email address entered.");
		}else {
			WriteSteps("Fail", "Email address field is not displayed.");
		}
		
		emailaddress.sendKeys(emaladd);
		
		if (password.isDisplayed())
		{
			WriteSteps("Pass", "password entered.");
		}else {
			WriteSteps(" Fail", "password field is not displayed.");
		}
		password.sendKeys(pwd);
		
		if (loginbutton.isDisplayed())
		{
			WriteSteps("Pass", "Amin user login Successfully.");
		}else {
			WriteSteps("Fail", "Admin user unable to login.");
		}
		loginbutton.click();
		
		return new ReportsPage();
		
		
		
	}
	
	
	public HomePage LoginMedical(String emaladd, String pwd){
		if (emailaddress.isDisplayed())
		{
			WriteSteps("Pass", "Email address entered.");
		}else {
			WriteSteps("Fail", "Email address field is not displayed.");
		}
		
		emailaddress.sendKeys(emaladd);
		
		if (password.isDisplayed())
		{
			WriteSteps("Pass", "password entered.");
		}else {
			WriteSteps("Fail", "password field is not displayed.");
		}
		password.sendKeys(pwd);
		
		if (loginbutton.isDisplayed())
		{
			WriteSteps("Pass", "Medical user login Successfully.");
		}else {
			WriteSteps("Fail", "Medical User unable to login.");
		}
		loginbutton.click();
		
		return new HomePage();
		
		
		
	}

}
