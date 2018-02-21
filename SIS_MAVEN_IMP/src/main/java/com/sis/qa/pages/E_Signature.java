package com.sis.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.qa.base.TestBase;

public class E_Signature extends TestBase {
	
	@FindBy(xpath = "//input[@name='eSignatureWindow:content:chooser:chooserForm:email']")
	WebElement Email;

	@FindBy(xpath = "//input[@name='eSignatureWindow:content:chooser:chooserForm:password']")
	WebElement passwordsign;

	@FindBy(xpath = "//input[@name='eSignatureWindow:content:chooser:chooserForm:button']")
	WebElement Confirm;
	
	public E_Signature()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage ReportSaveCredential(String emaiaddress, String password) throws InterruptedException{
		
		Thread.sleep(1000);
		Email.sendKeys("test_pooja.pandey@parexel.com");
		passwordsign.sendKeys("welcome123");
		
		if (Confirm.isDisplayed())
		{
			WriteSteps("Pass", "Report is saved successfully.");
		}else {
			WriteSteps("Fail", "Report is not saved successfully.");
		}
		
		Confirm.click();
		
		return new HomePage();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
