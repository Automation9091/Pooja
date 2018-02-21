package com.sis.qa.MultiBrowser;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import com.beust.jcommander.Parameter;
import com.sis.qa.base.TestBase;

public class MultiBroserTest extends TestBase {
	
	//@Parameter("browser")
	@BeforeClass
	public static void fnMultipleBrowser(String browser) {
		browser = prop.getProperty("browser");
		if (browser.equals("Firefox")) {
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
	}
	
}
	
	
	
	
	
	
	


