package com.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMPage extends BasePage {

	JavascriptExecutor js = (JavascriptExecutor) driver;

	// ================= ADD EMPLOYEE =================

	@FindBy(xpath = "//span[text()='PIM']")
	WebElement pimMenu;

	@FindBy(xpath = "//a[text()='Add Employee']")
	WebElement addEmployeeMenu;

	@FindBy(name = "firstName")
	WebElement firstNameTxt;

	@FindBy(name = "lastName")
	WebElement lastNameTxt;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement employeeIdTxt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;

	@FindBy(xpath = "//h6[text()='Personal Details']")
	WebElement personalDetailsHeader;

	@FindBy(xpath = "//span[text()='Required']")
	List<WebElement> requiredMsg;

	// ================= SEARCH EMPLOYEE =================

	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
	WebElement employeeNameSearchTxt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBtn;

	@FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']")
	WebElement searchResultTable;

	// ================= COMMON METHODS =================

	public void clickByJS(WebElement element) {

		js.executeScript("arguments[0].click();", element);
	}

	public void enterText(WebElement element, String value) {

		element.clear();

		element.sendKeys(value);
	}

	// ================= ADD EMPLOYEE METHODS =================

	public void clickPIMMenu() {

		clickByJS(pimMenu);
	}

	public void clickAddEmployee() {

		clickByJS(addEmployeeMenu);
	}

	public void enterFirstName(String firstName) {

		enterText(firstNameTxt, firstName);
	}

	public void enterLastName(String lastName) {

		enterText(lastNameTxt, lastName);
	}

	public void enterEmployeeId(String employeeId) {

		enterText(employeeIdTxt, employeeId);
	}

	public void clickSaveButton() {

		clickByJS(saveBtn);
	}

	public boolean isPersonalDetailsDisplayed() {

		try {

			return personalDetailsHeader.isDisplayed();
		}

		catch (Exception e) {

			return false;
		}
	}

	public boolean isRequiredMessageDisplayed() {

		return requiredMsg.size() > 0;
	}

	// ================= SEARCH EMPLOYEE METHODS =================

	public void enterSearchEmployeeName(String employeeName) {

		enterText(employeeNameSearchTxt, employeeName);
	}

	public void clickSearchButton() {

		clickByJS(searchBtn);
	}

	public boolean isSearchResultDisplayed() {

		try {

			return searchResultTable.isDisplayed();
		}

		catch (Exception e) {

			return false;
		}
	}
}