package com.actions;

import com.pages.PIMPage;
import com.utilities.ExcelUtility;

public class PIMActions extends BaseActions {

	PIMPage pimPage = new PIMPage();

	ExcelUtility excel = new ExcelUtility("src/test/resources/testdata/PIMData.xlsx");

	public void navigateToAddEmployee() {

		pimPage.clickPIMMenu();

		pimPage.clickAddEmployee();
	}

	public void enterEmployeeDetails(String firstName, String lastName, String employeeId) {

		pimPage.enterFirstName(firstName);

		pimPage.enterLastName(lastName);

		pimPage.enterEmployeeId(employeeId);
	}

	public void clickSaveButton() {

		pimPage.clickSaveButton();
	}

	public boolean verifyEmployeeCreated() {

		return pimPage.isPersonalDetailsDisplayed();
	}

	public boolean verifyRequiredMessage() {

		return pimPage.isRequiredMessageDisplayed();
	}

	public void navigateToSearchEmployee() {

		pimPage.clickPIMMenu();
	}

	public void searchEmployeeUsingExcelData() {

		String employeeName = excel.getData("SearchEmployee", 1, 0);

		pimPage.enterSearchEmployeeName(employeeName);

		pimPage.clickSearchButton();
	}

	public boolean verifySearchSuccess() {

		return pimPage.isSearchResultDisplayed();
	}
}