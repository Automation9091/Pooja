package com.sis.qa.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.*;

import com.sis.qa.testcases.LoginPageTest;

public class Runner {

	static TestNG testng;

	public void createExecute() {

		List<XmlSuite> suiteList = new ArrayList<XmlSuite>();
		List<XmlClass> classList = new ArrayList<XmlClass>();
		
		XmlSuite suiteName = new XmlSuite();
		suiteName.setName("SIS Automation Suite Name");
		
		XmlTest testName = new XmlTest();
		testName.setName("SIS Automation Test Name");
		
		XmlClass className = new XmlClass(LoginPageTest.class);
		classList.add(className);
		
		testName.setXmlClasses(classList);
		
		suiteList.add(suiteName);
		
		testng.setXmlSuites(suiteList);
		
		testng.run();
	}
	
	public static void main(String[] args)
	{
		Runner runTst = new Runner();
		runTst.createExecute();
	}
}