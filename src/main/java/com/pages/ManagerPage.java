package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManagerPage {

	private WebDriver driver;
	
	// Locators
	
	private By managerSections= By.cssSelector("body:nth-child(2) div:nth-child(7) div:nth-child(1) ul.menusubnav > li.orange:nth-child(1)");
	
	
	// Constructor
	public ManagerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	  public String getManagersPageTitle() { 
		  return driver.getTitle();
	  
	  }
	 
	
	// page actions
	
	public int getManagerSectionCount() {
		System.out.println(managerSections);
		return driver.findElements(managerSections).size();
		
	}
	
public List<String> getManagerSectionList() {
		
		List<String> managerList = new ArrayList<>();
		List<WebElement> managerHeaderList = driver.findElements(managerSections);
		
		for(WebElement e:managerHeaderList) {
			
			String text =e.getText();
			System.out.println(text);
			managerList.add(text);
		}
		
		return managerList;
	}
	
}
