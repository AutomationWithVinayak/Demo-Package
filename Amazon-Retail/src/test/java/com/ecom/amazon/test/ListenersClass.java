package com.ecom.amazon.test;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecom.amazon.base.BaseTest;
import com.ecom.amazon.utility.ListenersManager;

public class ListenersClass extends BaseTest implements ITestListener {


	private static ExtentReports extent = ListenersManager.gethtmlReport();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();


	@Override
	public void onTestStart(ITestResult result) {

		ExtentTest child =test.get().createNode(result.getTestClass()+" > "+result.getMethod().getMethodName());
		test.set(child);
		child.log(Status.INFO,"Execution Start");
		log.info("Execution Start >> " + result.getTestClass()+" > "+result.getMethod().getMethodName() );

	}




	@Override
	public void onTestSuccess(ITestResult result) {

		log.info("  Test PASS  >> "+ result.getTestClass()+" > "+result.getMethod().getMethodName());
		test.get().log(Status.PASS, "  Test PASS  >> "+ result.getTestClass()+" > "+result.getMethod().getMethodName());

	}



	@Override
	public void onTestFailure(ITestResult result) {

		String name = result.getMethod().getMethodName();
		test.get().log(Status.FAIL, "  Test FAIL  >> "+ result.getTestClass()+" > "+result.getMethod().getMethodName()+"  "+result.getThrowable());
		
		try {
			test.get().addScreenCaptureFromPath(getScreenshot(name));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		log.info("  Test Fail From >> "+ result.getTestClass()+" > "+result.getMethod().getMethodName());
        
	}



	@Override
	public void onTestSkipped(ITestResult result) {

		log.info("  Test Skipped  >> "+ result.getTestClass()+" > "+result.getMethod().getMethodName());
		test.get().log(Status.SKIP, "  Test Skipped  >> "+ result.getTestClass()+" > "+result.getMethod().getMethodName());


	}



	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {



	}



	@Override
	public void onTestFailedWithTimeout(ITestResult result) {



	}



	@Override
	public void onStart(ITestContext context) {

		ExtentTest parent = extent.createTest(getClass().getName());
        test.set(parent);

	}



	@Override
	public void onFinish(ITestContext context) {

		test
		.get().log(Status.INFO, "\"\\n\"\r\n"
				+ "				+ \"------------------------------------\"+'\\n'\r\n"
				+ "				+ \"---------VINAYAK-FRAMEWORK----------\"+'\\n'\r\n"
				+ "				+ \"------------------------------------\"+'\\n'\r\n"
				+ "				+ \"------------------------------------\"+'\\n'\r\n"
				+ "				+ \"--------Execution_Completed---------\"+'\\n'\r\n"
				+ "				+ \"------------------------------------\"+'\\n'\r\n"
				+ "				+ \"------------------------------------\"+'\\n'\r\n"
				+ "				+ \"-------------Amazon-----------------\"+'\\n'\r\n"
				+ "				+ \"------------------------------------\"+'\\n'\r\n"
				+ "				+ \"----------------*-------------------\"+'\\n'\r\n"
				+ "				+ \"------------------------------------\"+'\\n'\r\n"
				+ "				+ \"------------------------------------\"+'\\n'\r\n"
				+ "				+\"-------------------------------------\"+'\\n'\r\n"
				+ "				+\"-------------------------------------\"");

		log.info("\n"
				+ "------------------------------------"+'\n'
				+ "---------VINAYAK-FRAMEWORK----------"+'\n'
				+ "------------------------------------"+'\n'
				+ "------------------------------------"+'\n'
				+ "--------Execution_Completed---------"+'\n'
				+ "------------------------------------"+'\n'
				+ "------------------------------------"+'\n'
				+ "-------------Amazon-----------------"+'\n'
				+ "------------------------------------"+'\n'
				+ "----------------*-------------------"+'\n'
				+ "------------------------------------"+'\n'
				+ "------------------------------------"+'\n'
				+"------------------------------------"+'\n'
				+"------------------------------------");
		
		extent.flush();
		

	}






}
