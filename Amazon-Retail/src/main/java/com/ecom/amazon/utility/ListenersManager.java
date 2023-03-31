package com.ecom.amazon.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ecom.amazon.base.BaseTest;

import net.bytebuddy.utility.RandomString;

public class ListenersManager extends BaseTest {
	
	private static ExtentReports extent ;
	
	public static ExtentReports gethtmlReport() {
		
		String r =RandomString.make(3);
		ExtentHtmlReporter htmlreport= new ExtentHtmlReporter("..//Ecom-Amazon-Retail//ExtentReport//report"+r+".html");
		htmlreport.config().setChartVisibilityOnOpen(true);
		htmlreport.config().setDocumentTitle("Automation Test Result");
		htmlreport.config().setEncoding("UFT-8");
		htmlreport.config().setReportName("Extent Report");
		htmlreport.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlreport.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);	
		return extent;
		
	}

}
