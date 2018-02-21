package com.sis.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sun.print.resources.serviceui_zh_TW;

import com.sis.qa.base.TestBase;

public class ClinicalUserPage extends TestBase {
	
	@FindBy(name="oldPassword")
	WebElement OldPassword;
	
	@FindBy(name="newPassword")
	WebElement NewPassword;
	
	@FindBy(name="confirmNewPassword")
	WebElement ConfirmPassword;
	
	@FindBy(name="submit")
	WebElement Save;
	
	@FindBy(xpath="//form[@method='post']")
	WebElement NewUserPage;
	
	@FindBy(name="studySiteComponent:ddcSites")
	WebElement StudySite;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement SeacrhReport;
	
	@FindBy(name="searchBox:tfCaseNumber")
	WebElement CaseNo;
	
	@FindBy(name="searchBox:reportDateFrom:date")
	WebElement FromDate;
	
	@FindBy(name="searchBox:reportDateTo:date")
	WebElement ToDate;
	
	@FindBy(name="searchBox:tfStudyNumber")
	WebElement StudyNumSeacrh;
	
	@FindBy(name="searchBox:ddcReportType")
	WebElement ReportType;
	
	@FindBy(name="searchBox:ddcAcknowledged")
	WebElement AckType;
	
	@FindBy(name="searchBox:ddcIcsrType")
	WebElement ICSRType;
	
	@FindBy(name="searchBox:ddcProduct")
	WebElement ProductSearch;
	
	@FindBy(name="searchBox:ddcCountries")
	WebElement CountrySearch;
	
	@FindBy(name="searchBox:tfEvents")
	WebElement EventSearch;
	
	public ClinicalUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void ReportAcknowledgment(){
		SeacrhReport.click();
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
