package com.sis.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sis.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Pooja Pandey')]")
	WebElement LoginUserName;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement HomeLink;

	@FindBy(name = "reportDateFrom:date")
	WebElement FromDate;

	@FindBy(name = "")
	WebElement ToDate;

	@FindBy(xpath = ".//img[@id='id2bIcon']")
	WebElement CalendarIcon;

	@FindBy(xpath = ".//span[@id='id6Dp']")
	WebElement CalendarWindow;

	@FindBy(xpath = "//select[@name='ddcCountries']")
	WebElement Countries;

	@FindBy(name = "searchTable:searchBox:tfCaseNumber")
	WebElement CaseNo;

	@FindBy(xpath = "//select[@name='ddcIcsrType']")
	WebElement ICSRType;

	@FindBy(xpath = "//input[@name='tfStudyNumber']")
	WebElement StudyNo;

	@FindBy(xpath = "//select[@name='ddcReportType']")
	WebElement ReportType;

	@FindBy(xpath = "//select[@name='ddcQc']")
	WebElement ReportState;

	@FindBy(xpath = "//select[@name='ddcProduct']")
	WebElement Product;

	@FindBy(name = "tfEvents")
	WebElement Events;

	@FindBy(xpath = "//input[(@type='button') and (@value='Work list')]")
	WebElement WorklistBtn;

	@FindBy(xpath = "//input[(@type='submit') and (@value='Search')]")
	WebElement SeacrhBtn;

	@FindBy(xpath = "//span[text()='QC needed']")
	WebElement QCneeded;

	@FindBy(xpath = "//form[@method='post']")
	WebElement page;

	@FindBy(xpath = "//input[@name='qcPassedButton']")
	WebElement QcPassedBtn;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement MedSeacrh;
	
	@FindBy(xpath=".//*[@id='busy_overlay']")
	WebElement BusyPopup;
	
	
	// Constructor of homepage
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void SearchCriteria(String caseValue) throws InterruptedException {
		Thread.sleep(3000);

		if (CaseNo.isDisplayed()) {
			WriteSteps("Pass", "CaseNo entered.");
		} else {
			WriteSteps("Fail", "Case No not entered.");
		}
		CaseNo.sendKeys(caseValue);

	
		if (SeacrhBtn.isDisplayed()) {
			WriteSteps("Pass", "Report displayed.");
		} else {
			WriteSteps("Fail", "Report not displayed.");
		}
		SeacrhBtn.click();
		Thread.sleep(10000);

	}

	public void clickWorklist() {
		WorklistBtn.click();

	}

	public ReportUploadPage QcNeededtest(String CaseVal) throws InterruptedException {
	WaitforObjecttobeInVisible(BusyPopup);

		if (CaseNo.isDisplayed()) {
			WriteSteps("Pass", "CaseNo entered.");
		} else {
			WriteSteps("Fail", "Case No not entered.");
		}
		
		CaseNo.sendKeys(CaseVal);
		
		Thread.sleep(1000);
		SynchronizePage();
		if (MedSeacrh.isDisplayed()) {
			WriteSteps("Pass", "Report displayed.");
		} else {
			WriteSteps("Fail", "Report not displayed.");
		}
		MedSeacrh.click();
		
		Thread.sleep(2000);
		SynchronizePage();
		WaitForObjectToClick(QCneeded);
		if (QCneeded.isDisplayed()) {
			WriteSteps("Pass", "QC Needed report page displayed.");
		} else {
			WriteSteps("Fail", "QC Needed report page displayed.");
		}
		QCneeded.click();

		Thread.sleep(2000);
		page.click();
		page.sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(10000);
		WaitforObjecttobeVisible(QcPassedBtn);
		//SynchronizePage();
		if (QcPassedBtn.isDisplayed()) {
			WriteSteps("Pass", "QC Pass is done.");
		} else {
			WriteSteps("Fail", "Perform QC Pass.");
		}
		QcPassedBtn.click();
		//Thread.sleep(2000);
		/*if (Email.isDisplayed()) {
			WriteSteps("Pass", "eSignature entered.");
		} else {
			WriteSteps("Fail", "eSignature not entered.");
		}*/
		SynchronizePage();
		
		return new ReportUploadPage();
		
	}
	
	public void SynchronizePage()
	{
		//BusyPopup
		WaitforObjecttobeInVisible(BusyPopup);
	}
	
	

}
