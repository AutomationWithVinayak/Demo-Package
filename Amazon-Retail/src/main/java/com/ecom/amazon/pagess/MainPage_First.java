package com.ecom.amazon.pagess;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.amazon.base.BaseTest;

public class MainPage_First extends BaseTest {
	
	
	@FindBy(id="searchDropdownBox") WebElement element;
	@FindBy(xpath ="//select[@id=\"searchDropdownBox\"]//option") List<WebElement> ele2; 
	

	public MainPage_First() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public void m1() {
		
		element.click();
		
		int size= ele2.size();
		
		for(int i=0; i<=size-1; i++) {
			
			String a = ele2.get(i).getText();	
			
			System.out.println(a);
			
			
			
		}
	}
}
