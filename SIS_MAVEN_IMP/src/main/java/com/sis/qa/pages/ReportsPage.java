package com.sis.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sis.qa.base.TestBase;
import com.sis.qa.utilities.TestUtil;

public class ReportsPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement HomepageLink;
	
	@FindBy(xpath="//a[text()='Reports']//parent::li//following-sibling::li//a[text()='Administration']")
	public WebElement AdministrationLink;
	
	@FindBy(xpath="//a[text()='Performance Report']//parent::li//following-sibling::li//a[text()='Report Upload']")
	WebElement ReportUploadLink;
	
		
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement LogoutLink;
	
	@FindBy(xpath="//span[contains(text(),'Pooja Pandey')]")
	WebElement LoginUserName;
	
	@FindBy(xpath=".//*[@id='mainMenu']")
	WebElement TabTable;
	


	
	//Constructor of Page
	public ReportsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean verifyLoginUserNametest(){
	 return LoginUserName.isDisplayed();
		
	}
	
	public void clickTabInHomePage(String strTabName)
	{
			List<WebElement> lstTabs = TabTable.findElements(By.tagName("li"));
			
			for (WebElement ele : lstTabs)
			{
				System.out.println(ele.getText());
				if (ele.getText().equals(strTabName))
				{
					WebElement newEle = ele.findElement(By.tagName("a"));
					Actions ac = new Actions(driver);
					//ac.moveToElement(ele).build().perform();
					ac.click(ele).build().perform();
					//ele.click();
					break;
				}
			}
		}
	
	//HomePage
	public HomePage clickHomePageLink() throws InterruptedException{
		Thread.sleep(5000);
		WaitforObjecttobeVisible(HomepageLink);
		HomepageLink.click();
		return new HomePage();
	}
	
	//AdmintrationPage 
	public AdministrationPage clickAdminstrationLink() throws InterruptedException{
		//WaitForObjectToClick(AdministrationLink);
		Thread.sleep(5000);
		WaitforObjecttobeVisible(AdministrationLink);
		AdministrationLink.click();
		//WaitforObjecttobeInVisible(BusyPopup);
		return new AdministrationPage();
	}
	
	
	public ReportUploadPage clickReportUploadLink() throws InterruptedException{
		//WebDriverWait wait=new WebDriverWait(driver,10);
		//ReportUploadLink = wait.until(ExpectedConditions.elementToBeClickable(ReportUploadLink));
		Thread.sleep(10000);
		WaitForObjectToClick(ReportUploadLink);
		ReportUploadLink.click();
		//clickTabInHomePage("Report Upload");
		return new ReportUploadPage();
	}

	
	
	
	
	
	
	
}
