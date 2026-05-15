package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_leave_entitlement_page {
	
	WebDriver driver;

    public Add_leave_entitlement_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	@FindBy(xpath="//span[normalize-space()='Leave']")
	public WebElement leave_page;
	
	@FindBy(xpath="//span[normalize-space()='Entitlements']")
	public WebElement entitlement_link;
	
	@FindBy(xpath="//a[normalize-space()='Add Entitlements']")
	public WebElement add_entitlement;
	
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
