package com.sis.qa.utilities;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sis.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long Page_Load_Timeout =30;
	public static long Implicit_Timeout=60;
	
	 String date1 = "30-Nov-2017";
	 String dateArr[] = date1.split("-");
	 String day = dateArr[0];
	 String month = dateArr[1];
	 String year = dateArr[2];
	 
	 @FindBy(xpath="//img[@src='./wicket/resource/org.apache.wicket.extensions.yui.calendar.DatePicker/icon1-ver-A9D71378ED9162B2DB5DE040C09D5BDE.gif']")
	 WebElement calendaricon;
	 
	 @FindBy(xpath="//a[text()='Previous Month (September 2017)']")
	 WebElement previousmonth;
	 
	 public void PageObjectInt(){
		 PageFactory.initElements(driver, this);
	 }
	 
	 
	 public void fnDatePicker(){
		 calendaricon.click();
		 		 
		 String beforexpath = "//td[@id='ideDpJs_cell";
		 String afterxpath = "']/a";
		 		 
		 for(int cellNO=0;cellNO<=41;cellNO++){
			 String dayVal = driver.findElement(By.xpath(beforexpath+cellNO+afterxpath)).getText();
			 System.out.println(dayVal);
			 if(dayVal.equals(day)){
				 driver.findElement(By.xpath(beforexpath+cellNO+afterxpath)).click();
			 }
		}
	 }
	 
	 public void slecetdatebyJS(WebElement element, String date){
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].setArgument('value',"+date+");", element);
		
	 }
	
	
	//public WebDriverWait wait= new WebDriverWait(driver, 20);
	
	 public int GenerateRandomNum(int max, int min)
	 {
		 Random RNum = new Random();
		 return RNum.nextInt((max-min)+1) + min;
	 }
}
