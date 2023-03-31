package com.ecom.amazon.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public class BaseTest {

	public static final Logger log = LogManager.getLogger(new Object().getClass().getName());



	public static WebDriver driver;
	public static Properties pros;

	public BaseTest(){

		try {
			FileInputStream file = new FileInputStream("..\\Ecom-Amazon-Retail\\Properties.text");
			pros = new Properties();
			pros.load(file);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}




	public static void setup() {

		switch (pros.getProperty("browserN")) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver= new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("***** Invalid browser name " +pros.getProperty("browserN")+" *****");

		}

		driver.get(pros.getProperty("Url"));
		driver.manage().window().maximize();

	}




	public static void tempWait(int wait) {

		int b=wait*1000;
		try {
			Thread.sleep(b);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}


	public static String getScreenshot(String testName) {

		String r  =RandomString.make(4);
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("..//Ecom-Amazon-Retail//FailTcScreenshot//"+testName+r+".png");
		try {
			FileHandler.copy(source, dest);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		return dest.getAbsolutePath();	
	}




}
