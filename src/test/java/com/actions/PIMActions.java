package com.actions;

import com.pages.PIMPage;

public class PIMActions extends BaseActions {

	PIMPage pimPage = new PIMPage();

	public void navigateToAddEmployee() {
		pimPage.clickPIMMenu();
		pimPage.clickAddEmployee();
	}

	public void enterEmployeeDetails(String firstName, String lastName, String empId) {

		pimPage.enterFirstName(firstName);
		pimPage.enterLastName(lastName);

		if (!empId.isEmpty()) {
			pimPage.enterEmployeeId(empId);
		}
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
}