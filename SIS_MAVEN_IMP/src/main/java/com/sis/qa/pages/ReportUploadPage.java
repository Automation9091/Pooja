package com.sis.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.sis.qa.base.TestBase;

public class ReportUploadPage extends TestBase {

	/*
	 * @FindBy(xpath="//a[text()='Report Upload']") WebElement ReportUploadLink;
	 */

	@FindBy(xpath = "//caption[contains(text(),'Select Report Type')]")
	WebElement ReportpageText;

	@FindBy(xpath = "//input[@id='id6']")
	WebElement ICSRReportRadioBtn;

	@FindBy(xpath = "//input[@id='id8']")
	WebElement LineListRadioBtn;

	@FindBy(xpath = "//input[@id='id9']")
	WebElement PerfoemanceRptBtn;

	@FindBy(xpath = "//input[contains(@name,'sub')]")
	WebElement ContinueBtn;

	@FindBy(name = "btnChooseProduct")
	WebElement SelectProduct;

	@FindBy(xpath = "//input[contains(@name,'searchPattern')]")
	WebElement ProductName;

	@FindBy(name = "searchButton")
	WebElement SearchProduct;

	@FindBy(xpath = "//td[text()='1003']//preceding-sibling::td//input[@type='radio']")
	WebElement SelectProductRadioBtn;

	@FindBy(xpath = "//td[contains(@align,'right')]//preceding-sibling::td//input[@type='submit']")
	WebElement SelectedProduct;

	@FindBy(xpath = "//input[contains(@name,'btnChooseStudy')]")
	WebElement SelectStudyNo;

	@FindBy(xpath = "//td[text()='245Study (245Test)']//preceding-sibling::td//input[contains(@type,'radio')]")
	WebElement SelectedStudy;

	@FindBy(name = "searchPattern")
	WebElement StudyName;

	@FindBy(xpath = "//input[@name='caseNumber']")
	WebElement CaseNo;

	@FindBy(xpath = "//input[@name='localRefNumber']")
	WebElement RefNo;

	@FindBy(xpath = "//input[@name='followUpNumber']")
	WebElement FollowUpNo;

	@FindBy(xpath = "//input[@name='versionNumber']")
	WebElement ReportVersionNO;

	@FindBy(xpath = "//input[@name='event']")
	WebElement DocumentTitle;

	@FindBy(xpath = "//select[@name='seriousness']")
	WebElement SeriousnessValue;

	@FindBy(xpath = "//select[contains(@name,'icsrType')]")
	WebElement IcsrType;

	@FindBy(xpath = "//input[@name='blinded']")
	WebElement reportBlinded;

	@FindBy(name = "dateReceivedByManufacturer:date")
	WebElement ManufactureDateTextBox;

	@FindBy(name = "dateOfThisReport:date")
	WebElement DateOfThisReportTextBox;

	@FindBy(xpath = ".//*[@name='fileInput']")
	WebElement CIOMSFile;

	@FindBy(xpath = ".//*[@name='medWatchFileName']")
	WebElement MedWatchFile;

	@FindBy(xpath = ".//*[@id='btnUploadFile_no_load']")
	WebElement UploadBtn;

	@FindBy(xpath = "//input[@name='submitButton']")
	WebElement SaveReport;

	@FindBy(xpath = "//input[@name='blinded']")
	WebElement BlindedChcbox;

	@FindBy(xpath = ".//*[@id='id16']")
	WebElement Page;

	@FindBy(id = "_wicket_window_7")
	WebElement eSIgnature;
	
	@FindBy(id = "")
	WebElement CheckBox_InternalReportl;

	@FindBy(xpath = "//input[@name='eSignatureWindow:content:chooser:chooserForm:email']")
	WebElement Email;

	@FindBy(xpath = "//input[@name='eSignatureWindow:content:chooser:chooserForm:password']")
	WebElement passwordsign;

	@FindBy(xpath = "//input[@name='eSignatureWindow:content:chooser:chooserForm:button']")
	WebElement Confirm;
	
	@FindBy(xpath=".//*[@id='busy_overlay']")
	WebElement BusyPopup;
	
	@FindBy(xpath=".//*[@aria-labelledby='E-Signature']")
	WebElement eSignaturePopup;
	
	@FindBy(xpath="//th[text()='Report Origin']/following::input[2]")
	WebElement InternalReport;
	
	// contructor of ReportUploadclass
	public ReportUploadPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateReportUploadPage() {
		return ReportpageText.getText();

	}

	public void selectICSRReporttype() throws InterruptedException {

		// ICSRReportRadioBtn.click();
		Thread.sleep(2000);
		ContinueBtn.click();
	}

	public void UploadNewReporttest(String Product, String StudyNumber,
			String CaseValue, String Doctitle, String SeriousValue,
			String icsrvalue, String Country,String ReportnotINDSR,String Placebo,String ScheduleY,String ManufDate,String DateofReport) throws InterruptedException {

		// select Product
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		SelectProduct = wait.until(ExpectedConditions
				.elementToBeClickable(SelectProduct));
		if (SelectProduct.isDisplayed()) {
			WriteSteps("Pass", "Product Selected.");
		} else {
			WriteSteps("Fail", "Please Select Product.");
		}
		SelectProduct.click();

		Thread.sleep(2000);
		ProductName.sendKeys(Product);
		SearchProduct.click();

		Thread.sleep(2000);
		SelectProductRadioBtn = wait.until(ExpectedConditions
				.elementToBeClickable(SelectProductRadioBtn));
		SelectProductRadioBtn.click();

		Thread.sleep(1000);
		SelectedProduct.click();

		WaitforObjecttobeVisible(SelectStudyNo);
		SelectStudyNo = wait.until(ExpectedConditions
				.elementToBeClickable(SelectStudyNo));
		//WaitforObjecttobeVisible(SelectStudyNo);
		SelectStudyNo.click();
		StudyName.sendKeys(StudyNumber);
		SearchProduct.click();

		//Thread.sleep(5000);
		SelectedStudy = wait.until(ExpectedConditions
				.elementToBeClickable(SelectedStudy));
		SelectedStudy.click();
		Thread.sleep(1000);
		
		if (SelectedProduct.isDisplayed()) {
			WriteSteps("Pass", "Study selected.");
		} else {
			WriteSteps("Fail", "Please select STudy.");
		}
		SelectedProduct.click();

		if (CaseNo.isDisplayed()) {
			WriteSteps("Pass", "Case Number is entered.");
		} else {
			WriteSteps("Fail", "Case Number not entered.");
		}
		CaseNo.sendKeys(CaseValue);

		FollowUpNo.sendKeys("1");
		DocumentTitle.sendKeys(Doctitle);

		Select Seriousdropdown = new Select(SeriousnessValue);
		Seriousdropdown.selectByVisibleText(SeriousValue);

		Select icsrdropdown = new Select(IcsrType);
		icsrdropdown.selectByVisibleText(icsrvalue);

		Select countryOfIncidence = new Select(driver.findElement(By
				.xpath("//select[@name='country']")));
		countryOfIncidence.selectByVisibleText(Country);

		Select Language = new Select(driver.findElement(By.name("language")));
		Language.selectByVisibleText("English");

		Select dpReportnotINDSR = new Select(driver.findElement(By
				.name("distributionRuleParameters:0:ruleParameter")));
		dpReportnotINDSR.selectByVisibleText(ReportnotINDSR);

		Select dpPlacebo = new Select(driver.findElement(By
				.name("distributionRuleParameters:1:ruleParameter")));
		dpPlacebo.selectByVisibleText(Placebo);

		Select dpScheduleY = new Select(driver.findElement(By
				.name("distributionRuleParameters:2:ruleParameter")));
		dpScheduleY.selectByVisibleText(ScheduleY);

		
		
		Actions act = new Actions(driver);
		act.moveToElement(ManufactureDateTextBox).build().perform();
		ManufactureDateTextBox.sendKeys(ManufDate);
		

		act = new Actions(driver);
		act.moveToElement(DateOfThisReportTextBox).build().perform();
		DateOfThisReportTextBox.sendKeys(DateofReport);

		BlindedChcbox.click();

		//Page.sendKeys(Keys.PAGE_DOWN);
		//act.moveToElement(CIOMSFile).build().perform();
		Thread.sleep(2000);

		if (CIOMSFile.isDisplayed()) {
			WriteSteps("Pass", "CIOMS File uploaded.");
		} else {
			WriteSteps("Fail", "CIOMS File not uploaded.");
		}

		CIOMSFile
				.sendKeys("C:\\Users\\pandeypo\\Desktop\\CaseLevelSitePerformanceReport.xls");
		UploadBtn.click();
		Thread.sleep(2000);
		
		//medwatch report upload
		
		/*act.moveToElement(MedWatchFile).build().perform();
		
		Thread.sleep(2000);

		if (MedWatchFile.isDisplayed()) {
			WriteSteps("Pass", "Medwatch File uploaded.");
		} else {
			WriteSteps("Fail", "Medwatch File not uploaded.");
		}

		MedWatchFile
				.sendKeys("C:\\Users\\pandeypo\\Desktop\\CaseLevelSitePerformanceReport.xls");
		UploadBtn.click();
		Thread.sleep(2000);*/

		Page.sendKeys(Keys.PAGE_DOWN);
		
		if(InternalReport.isSelected()) {
			
		}
		else {
			InternalReport.click();
			System.out.println("Internal report selected");
		}
		Thread.sleep(2000);
		if (SaveReport.isDisplayed()) {
			WriteSteps("Pass", "Save report, enter credential.");
		} else {
			WriteSteps("Fail", "E-signature not entered.");
		}
		SaveReport.click();

		Thread.sleep(2000);
		if (Email.isDisplayed()) {
			WriteSteps("Pass", "eSignature entered.");
		} else {
			WriteSteps("Fail", "eSignature not entered.");
		}
		
		//fnPerformESignature(prop.getProperty("username"), prop.getProperty("password"));
		//fnPerformESignature("test_pooja.pandey@parexel.com", "welcome123");
		/*Email.sendKeys("telst_pooja.pandey@parexe.com");
		passwordsign.sendKeys("welcome123");

		if (Confirm.isDisplayed()) {
			WriteSteps("Pass", "Report is saved successfully.");
		} else {
			WriteSteps("Fail", "Report is not saved successfully.");
		}

		Confirm.click();*/

	}
	
	public HomePage fnPerformESignature(String strUsername, String strPassword) throws InterruptedException
	{
		Thread.sleep(2000);
		WaitforObjecttobeInVisible(BusyPopup);
		WaitforObjecttobeVisible(eSignaturePopup);
		if (eSignaturePopup.isDisplayed())
		{
			Email.sendKeys(strUsername);
			passwordsign.sendKeys(strPassword);

			if (Confirm.isDisplayed()) {
				WriteSteps("Pass", "Report is saved successfully.");
			} else {
				WriteSteps("Fail", "Report is not saved successfully.");
			}

			WaitforObjecttobeInVisible(BusyPopup);
			Confirm.click();
			
			
		}
		return new HomePage();
		
	}

}
