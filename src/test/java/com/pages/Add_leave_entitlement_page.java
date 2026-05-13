package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Add_leave_entitlement_page {

	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	public WebElement employee_name;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']")
	public WebElement leave_type;
	
	@FindBy(xpath="//div[contains(text(),'2026-01-01 - 2026-31-12')]")
	public WebElement leave_period;
	
	@FindBy(xpath="//input[@class='oxd-input oxd-input--focus']")
	public WebElement entitlement;
	
	@FindBy(css="button[type='submit']")
	public WebElement save;
	
	@FindBy(xpath="//button[normalize-space()='Confirm']")
	public WebElement confirm;
	
	
}
