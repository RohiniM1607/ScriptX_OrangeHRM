package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search_user_page extends BasePage {

	
	@FindBy(xpath="//a[@class='oxd-main-menu-item active']")
	public WebElement Admin_page;
	
	@FindBy(xpath="//div[@class=\"oxd-input-group__label-wrapper\"]/following-sibling::div/input")
	public WebElement username_field;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div[@class='oxd-select-text-input'][normalize-space()='-- Select --']")
	public WebElement userRole;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	public WebElement employeeName;
	
	@FindBy(css="button[type='submit']")
	public WebElement save_btn;
	
	@FindBy(xpath="//div[@role='rowgroup']//div[1]//div[1]//div[2]//div[1]")
	public WebElement username_record;
	
	@FindBy(xpath="//div[@role='rowgroup']//div[1]//div[1]//div[3]//div[1]")
	public WebElement userrole_record;
	
	@FindBy(xpath="//div[@role='rowgroup']//div[1]//div[1]//div[4]//div[1]")
	public WebElement employeeName_record;
}
