package com.sis.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sis.qa.base.TestBase;

public class StudiesPage extends TestBase {

	AdministrationPage adminPage;
	
	
	@FindBy(xpath = "//a[contains(text(),'Administration')]")
	WebElement Administrationtab;

	@FindBy(xpath = ".//*[text()='Administration Studies']")
	WebElement AdminLabel;

	@FindBy(xpath="//caption[text()='Search Studies']")
	WebElement SearchStudies;	
	
	@FindBy(xpath = ".//*[text()='Administration Users']")
	WebElement UserPageTitle;

	// @FindBy(xpath=".//*[@id='submenu']/li[5]") //
	@FindBy(xpath = ".//*[@id='submenu']")
	WebElement LeftPanel;

	@FindBy(xpath = "//input[@value='New']")
	WebElement NewBtn;

	@FindBy(xpath = "//input[@name='protocolNumber']")
	WebElement ProtocolNumber;

	@FindBy(xpath = "//input[contains(@name,'studyNumber')]")
	WebElement StudyNumber;

	@FindBy(xpath = "//input[contains(@name,'ctmsTrialNumber')]")
	WebElement CtmsTrialNo;

	@FindBy(name = "Client")
	WebElement client;

	@FindBy(xpath = "//input[contains(@name,'notificationInterval')]")
	WebElement NotificationInterval;

	@FindBy(name = "changeProducts")
	WebElement ChangeProductButton;

	@FindBy(xpath = "//td[text()='1003']/following-sibling::td/a[text()='add']")
	WebElement ProductAdd;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement OkButton;

	@FindBy(xpath = "//input[@id='idc']")
	WebElement ChangeSites;
	
	@FindBy(xpath="//input[@name='submitButton']")
	WebElement OKVerify;

	/*
	 * @FindBy(xpath="//select[@name='ddcCenter']") WebElement CentreDropDown;
	 */

	@FindBy(xpath = "//input[@name='tfReferenceNumber']")
	WebElement RefNumber;

	@FindBy(xpath = "//input[contains(@value,'Cancel')]")
	WebElement CancelBtn;

	@FindBy(xpath = "//input[@id='formsubmit_do_load']")
	WebElement SaveSite;

	@FindBy(xpath = "//input[@id='ide']")
	WebElement Changebutton;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement SaveStudy;

	@FindBy(xpath = ".//*[@id='busy_overlay']")
	WebElement BusyPopup;

	@FindBy(xpath = "//caption[text()='New Study']")
	WebElement NewStudyTitle;

	// User PageOR
	@FindBy(xpath = "//caption[text()='New User']")
	WebElement NewUserTitle;

	@FindBy(name = "p::name")
	WebElement UserName;

	@FindBy(name = "email")
	WebElement Email;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(name = "confirmPassword")
	WebElement CnfrmPassword;

	@FindBy(name = "Country")
	WebElement country;

	@FindBy(name = "changeRoles")
	WebElement ChangeRoles;

	@FindBy(className = "dataview")
	WebElement RolesTable;

	@FindBy(xpath = "//td[text()='Clinical']//following-sibling::td//a[text()='add']")
	WebElement AddClinical;

	@FindBy(xpath = "//td[text()='Clinical']//following-sibling::td//a[text()='remove']")
	WebElement RemoveClinical;

	@FindBy(xpath = "//input[@name='changeCenters']")
	WebElement AssignSites;

	@FindBy(name = "searchPanel:ddcCountries")
	WebElement CountrySite;

	@FindBy(name = "searchPanel:ddcCenters")
	WebElement SelectSite;

	@FindBy(xpath = "//td[contains(text(),'Study7Feb - SiteA')]//following-sibling::td//a[text()='add']")
	WebElement AddStudySite;

	@FindBy(xpath = ".//*[@id='id8']")
	WebElement UserPage;

	@FindBy(xpath = "//span[text()='(no role assigned)']")
	WebElement SelectSiteRole;

	@FindBy(name = "studyRole")
	WebElement SiteRoleList;

	@FindBy(name = "activeBox")
	WebElement ActiveSiteRole;

	@FindBy(name = "submit")
	WebElement SaveUser;

	@FindBy(name = "tfName")
	WebElement CreatedUserName;

	@FindBy(name = "tfEmail")
	WebElement CreatedUserEmail;

	@FindBy(name = "tfPersNo")
	WebElement PersonelNo;

	@FindBy(name = "submit")
	WebElement existingSearch;
	
	@FindBy(xpath="//form[@method='post']")
	WebElement ProductSelectionPage;
	
	@FindBy(xpath="//input[@value='Edit']")
	WebElement EditLink;
	
	@FindBy(xpath="//span[text()='SiteA - 296']")
	WebElement SiteAddedLink;
	
	@FindBy(xpath="//input[@value='Cancel']")
	WebElement CancelBtnUser;
	
	@FindBy(xpath="//table[@class='dataview']")
	WebElement ProductTable;


	
	public  StudiesPage(){
		PageFactory.initElements(driver, this);
	}


	// Actions

	public void createNewStudy(String StudyNo, String ProtocolNo,
			 String Clientvalue, String NotfNo, String Center, String ReferenceNo)
			throws InterruptedException {

		//findNavigationLinkAndClick("Studies");
		
		//Thread.sleep(2000);
		if (AdminLabel.isDisplayed()) {
			WaitforObjecttobeVisible(NewBtn);
			//WaitForObjectToClick(NewBtn);
			Actions action = new Actions(driver);
			action.moveToElement(NewBtn);
			NewBtn.click();
		}

		if (NewStudyTitle.isDisplayed()) {
			WaitforObjecttobeVisible(StudyNumber);
			StudyNumber.sendKeys(StudyNo);
		}

		ProtocolNumber.sendKeys(ProtocolNo);
		//CtmsTrialNo.sendKeys(Ctms);
			
		Select ClientDp = new Select(client);
		ClientDp.selectByVisibleText(Clientvalue);

		NotificationInterval.sendKeys(NotfNo);
		ChangeProductButton.click();
		if (ProductAdd.isDisplayed()) {
			WriteSteps("Pass", "Product added.");
		} else {
			WriteSteps("Fail", "Select atleast one prodcut.");
		}
		
		Thread.sleep(3000);
		//ProductAdd.click();
		ProductSearchandClick("296");
		WaitforObjecttobeInVisible(BusyPopup);
		Thread.sleep(3000);
		
		ProductSelectionPage.submit();
		ChangeSites.click();

		Select CenterDropDown = new Select(driver.findElement(By
				.name("ddcCenter")));
		CenterDropDown.selectByVisibleText(Center);

		RefNumber.sendKeys(ReferenceNo);
		if (SaveSite.isDisplayed()) {
			WriteSteps("Pass", "Site selected.");
		} else {
			WriteSteps("Fail", "Select at least one Site.");
		}
		SaveSite.click();
		if (SaveStudy.isDisplayed()) {
			WriteSteps("Pass", "Study Created.");
		} else {
			WriteSteps("Fail", "Please verfiy alert message.");
		}
		Thread.sleep(2000);
		WaitforObjecttobeInVisible(BusyPopup);
		SaveStudy.click();
		//WaitforObjecttobeInVisible(BusyPopup);
		
		WebElement StudySaveMessage=driver.findElement(By.xpath("//span[text()='Study7Feb_Demo7Feb saved']"));
		WaitforObjecttobeVisible(StudySaveMessage);
	}
	
	public void SeacrhStudies(String ExistingStudy){
		if (SearchStudies.isDisplayed()) {
			StudyNumber.sendKeys(ExistingStudy);
			}
		if (existingSearch.isDisplayed()) {
			WriteSteps("Pass", "Study displayed in Search Result.");
		} else {
			WriteSteps("Fail", "Study does not exist.");
		}
			existingSearch.click();
			
			if (EditLink.isDisplayed()) {
				WriteSteps("Pass", "Study data verified.");
			} else {
				WriteSteps("Fail", "Study data mismatch.");
			}
			EditLink.click();
			SiteAddedLink.click();
			WebElement UserNameLinked = driver.findElement(By.xpath("//span[text()='User7Feb']"));
			
			if (UserNameLinked.isDisplayed()) {
				WriteSteps("Pass", "User assigned confirmed.");
			} else {
				WriteSteps("Fail", "No User assihned.");
			}
			
			String UserName = UserNameLinked.getText();
			System.out.println(UserName+" is linked to "+ ExistingStudy);
			
			OKVerify.click();
}
		
	public void ProductSearchandClick(String strProductName)
	{
			List<WebElement> listProduct = ProductTable.findElements(By.tagName("tr"));
			
			for (int intCnt =1; intCnt < listProduct.size(); intCnt++)
			{
				WebElement RowObj = listProduct.get(intCnt);
				WebElement expProdName = RowObj.findElements(By.tagName("td")).get(0);
				if (expProdName.getText().equals(strProductName))
				{
					WebElement AddBtn = RowObj.findElement(By.tagName("a"));
					AddBtn.click();
					break;
				}
			}
		}
	
	
/*	public void SelectStudySite(String StudySiteName){
		
		List<WebElement> refSTudySiteList = driver.findElements(By.tagName("tr"));
		
		for(int intcount = 1;intcount<refSTudySiteList.size();intcount++)
		{
			
			
		}
	
	}*/
	
	
	
	
	public void findNavigationLinkAndClick(String LinkName)
	{
		List<WebElement> RefList = LeftPanel.findElement(By.tagName("ul")).findElements(By.tagName("li"));
		if (RefList.size() > 0){
			for (WebElement ele : RefList)
			{
				//System.out.println(ele.getText());
				if (ele.getText().equals(LinkName))
				{
					//WebElement newEle = ele.findElement(By.tagName("a"));
					ele.click();
				//	WaitforObjecttobeInVisible(BusyPopup);
				}
				}
		}
	}

/*	public void findNavigationLinkAndClick(String LinkName) {
		List<WebElement> RefList = LeftPanel.findElement(By.tagName("ul"))
				.findElements(By.tagName("li"));

		if (RefList.size() > 0) {
			for (WebElement ele : RefList) {
				// System.out.println(ele.getText());
				if (ele.getText().equals(LinkName)) {
					ele.click();
					WaitforObjecttobeInVisible(BusyPopup);
				}
			}
		}
	}
*/
	
}


