package com.sis.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sis.qa.utilities.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sis.qa.utilities.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static String strReportPath;

	public static EventFiringWebDriver RefEventDriver;
	public static WebEventListener RefEventListener;

	public static XSSFWorkbook xWorkbook;
	public static XSSFSheet xSheet;
	public static XSSFRow xRow;
	public static XSSFCell xCell;
	static String FilePath = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\sis\\qa\\testdata\\TestData.xlsx";

	// BaseClass constructor
	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream refProperties = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com"
							+ "/sis/qa/configproperties/config.properties");
			prop.load(refProperties);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Browser Invoke
	public static void fnIntialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("Firefox")) {
			String brPath = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", brPath);
			driver = new FirefoxDriver();

		} else {
			String brPath = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", brPath);
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,
					true);
			dc.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			driver = new InternetExplorerDriver();
		}
		
		RefEventDriver = new EventFiringWebDriver(driver);

		RefEventListener = new WebEventListener();

		RefEventDriver.register(RefEventListener);

		driver = RefEventDriver;

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts()
				.implicitlyWait(TestUtil.Implicit_Timeout, TimeUnit.SECONDS);
	}


	public static void WaitForObjectToClick(WebElement element) {
		wait = new WebDriverWait(driver, TestUtil.Implicit_Timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void WaitforObjecttobeVisible(WebElement element) {
		wait = new WebDriverWait(driver, TestUtil.Implicit_Timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void WaitforObjecttobeInVisible(WebElement element) {
		wait = new WebDriverWait(driver, TestUtil.Implicit_Timeout);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void InitializeReport() {
		TestUtil testUtil = new TestUtil();
		String strRandomNum = Integer.toString(testUtil.GenerateRandomNum(
				999999, 100000));
		strReportPath = System.getProperty("user.dir")
				+ "\\Reports\\Sis_AutomationReport_" + strRandomNum + ".html";
		extentReport = new ExtentReports(strReportPath);
		extentReport.addSystemInfo("Environment", "QA");
	}

	public static void StartTestCase(String strTestCaseDesc) {
		extentTest = extentReport.startTest(strTestCaseDesc);
	}

	public static void WriteSteps(String strTestStatus, String strStep) {
		switch (strTestStatus.toUpperCase()) {
		case "PASS":
			extentTest.log(LogStatus.PASS, strStep);
			break;
		case "FAIL":
			extentTest.log(LogStatus.FAIL, strStep);
			break;
		case "INFO":
			extentTest.log(LogStatus.INFO, strStep);
			break;
		}
	}

	public static void EndTestCase() {
		extentReport.endTest(extentTest);
	}

	public static void GenerateReport() {
		extentReport.flush();
		OpenHTMLReport();
	}

	public static void OpenHTMLReport() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Runtime rnTym = Runtime.getRuntime();
		String browser = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
		try {
			Process pc = rnTym.exec(browser + strReportPath);
			pc.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getdataFromExcel(String strTestCaseId,
			String strColumnName) {
		FileInputStream File = null;
		try {
			File = new FileInputStream(FilePath);
		} catch (FileNotFoundException e) {
			System.out.println("Excel File Not found. Error Message: "
					+ e.getMessage());
		}
		try {
			xWorkbook = new XSSFWorkbook(File);
		} catch (IOException e) {
			System.out.println("Excel Workbook Not found. Error Message: "
					+ e.getMessage());
		}
		xSheet = xWorkbook.getSheet("TestData");
		String CellValue = "";
		int rw;
		int intRw = xSheet.getLastRowNum();
		Row refRw;
		Cell refCl;
		String strColData = "";
		for (rw = 1; rw <= intRw; rw++) {
			refRw = xSheet.getRow(rw);
			refCl = refRw.getCell(0);
			switch (refCl.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				CellValue = String.valueOf(refCl.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				CellValue = refCl.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BLANK:
				break;
			}
			if (CellValue.equals(strTestCaseId)) {
				refCl = refRw.getCell(findColumnNumber(strColumnName));
				DataFormatter objDefaultFormat = new DataFormatter();
				FormulaEvaluator refFor = new XSSFFormulaEvaluator(xWorkbook);
				refFor.evaluate(refCl);
				strColData = objDefaultFormat.formatCellValue(refCl, refFor);
				break;
			}
		}
		return strColData;
	}

	public static int findColumnNumber(String strColumnName) {
		FileInputStream File = null;
		try {
			File = new FileInputStream(FilePath);
		} catch (FileNotFoundException e) {
			System.out.println("Excel File Not found. Error Message: "
					+ e.getMessage());
		}
		try {
			xWorkbook = new XSSFWorkbook(File);
		} catch (IOException e) {
			System.out.println("Excel Workbook Not found. Error Message: "
					+ e.getMessage());
		}
		xSheet = xWorkbook.getSheet("TestData");

		String strActVal = "";
		int Colno;
		Row rfRw = xSheet.getRow(0);

		for (Colno = 1; Colno <= rfRw.getLastCellNum(); Colno++) {
			Cell CellValue = rfRw.getCell(Colno);

			switch (CellValue.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				strActVal = String.valueOf(CellValue.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				strActVal = CellValue.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BLANK:
				break;
			}

			if (strActVal.equals(strColumnName)) {
				break;
			}
		}
		return Colno;
	}
}
