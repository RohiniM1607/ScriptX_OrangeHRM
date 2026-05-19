package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.actions.ContactDetailsActions;
import com.actions.DashBoardActions;
import com.actions.LoginActions;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactDetailsStepDefinition {

    LoginActions loginActions;
    DashBoardActions dashBoardActions;
    ContactDetailsActions contactDetailsActions;  
    LoginPage loginPage;

    @Given("Employee is on OrangeHRM Contact Details login page")
    public void employee_is_on_orange_hrm_contact_details_login_page() {
        loginActions = new LoginActions();
        loginPage = new LoginPage();
    }

    @When("Employee enters valid credentials for contact details")
    public void employee_enters_valid_credentials_for_contact_details(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        String username = credentials.get(0).get("username").trim();
        String password = credentials.get(0).get("password").trim();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("Employee clicks on the login button")
    public void employee_clicks_on_the_login_button() {
        loginActions.clickLogin();
    }

    @And("the Employee is logged in to the Dashboard page")
    public void the_employee_is_logged_in_to_the_dashboard_page() {
        dashBoardActions = new DashBoardActions();
        Assert.assertTrue(dashBoardActions.isDashboardDisplayed(), "Dashboard is not displayed!");
    }

    @When("Employee navigates to Contact Details page")
    public void employee_navigates_to_contact_details_page() {
        dashBoardActions.navigateToContactDetails();
        contactDetailsActions = new ContactDetailsActions();
    }

    @When("Employee updates contact details from excel sheet {string} and row {int}")
    public void employee_updates_contact_details_from_excel_sheet_and_row(String sheetName, int rowNum) {
        contactDetailsActions.updateContactDetails(sheetName, rowNum);
    }

    @When("Employee clicks on Contact Details Save button")
    public void employee_clicks_on_contact_details_save_button() {
        contactDetailsActions.clickSave();
    }

    @Then("Contact details should be updated successfully")
    public void contact_details_should_be_updated_successfully() {
        String message = contactDetailsActions.getSuccessMessage();
        Assert.assertEquals(message, "Success", "Successfully Updated");
    }

    @When("Employee navigates to the Contact Details page")
    public void employee_navigates_to_the_contact_details_page() {
        dashBoardActions.navigateToContactDetails();
        contactDetailsActions = new ContactDetailsActions();
    }

    @When("Employee clicks on Add Attachment button")
    public void employee_clicks_on_add_attachment_button() {
        contactDetailsActions.clickAddAttachment();
    }

    @When("Employee uploads attachment from excel sheet {string} and row {int}")
    public void employee_uploads_attachment_from_excel_sheet_and_row(String sheetName, int rowNum) {
        contactDetailsActions.uploadAttachment(sheetName, rowNum);
    }

    @When("Employee clicks on Attachment Save button")
    public void employee_clicks_on_attachment_save_button() {
        contactDetailsActions.clickAttachmentSave();
    }

    @Then("Attachment should be uploaded successfully")
    public void attachment_should_be_uploaded_successfully() {
        String message = contactDetailsActions.getSuccessMessage();
        Assert.assertEquals(message, "Success", "Successfully Saved");
    }
}