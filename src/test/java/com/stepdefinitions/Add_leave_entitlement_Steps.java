package com.stepdefinitions;

import com.actions.Add_leave_entitlement_action;
import com.actions.LoginActions;

import io.cucumber.java.en.*;

public class Add_leave_entitlement_Steps {

	LoginActions la;
	Add_leave_entitlement_action ac=new Add_leave_entitlement_action();

	@Given("Admin is on the Leave page")
	public void admin_is_on_the_leave_page() {
		la = new LoginActions();
		la.enterValidCredentials();
		la.clickLogin();
	}

	@Given("Admin clicks on Entitlements and Admin selects Add Entitlements")
	public void admin_clicks_on_entitlements_and_admin_selects_add_entitlements() {
		ac.leavePage();
		ac.addEntitlement();
	}

	@When("Admin enters valid employee leave entitlement details")
	public void admin_enters_valid_employee_leave_entitlement_details() {
		ac.user_details("John David","10" );
	}

	@When("clicks on the Save button")
	public void clicks_on_the_save_button() {
		ac.save();

	}

	@Then("the Updating Entitlement pop-up should be displayed and  leave entitlement should be added successfully")
	public void the_updating_entitlement_pop_up_should_be_displayed_and_leave_entitlement_should_be_added_successfully() {
		ac.confirmation_message();
	}

}
