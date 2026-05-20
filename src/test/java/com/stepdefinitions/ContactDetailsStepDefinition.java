package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.ContactDetailsActions;
import com.actions.DashBoardActions;
import com.actions.LoginActions;
import com.pages.LoginPage;
import com.utilities.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactDetailsStepDefinition {

    private static final Logger log = LogManager.getLogger(ContactDetailsStepDefinition.class);

    LoginActions loginActions;
    DashBoardActions dashBoardActions;
    ContactDetailsActions contactDetailsActions;
    LoginPage loginPage;
    ConfigReader testData = new ConfigReader("testData.properties");

    @Given("Employee is on OrangeHRM Contact Details page")
    public void employee_is_on_orange_hrm_contact_details_page() {
        log.info("Navigating to OrangeHRM login page for Contact Details scenario");
        loginActions = new LoginActions();
        loginPage = new LoginPage();
    }

    @When("Employee enters username and password for contact details")
    public void employee_enters_username_and_password_for_contact_details(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        String username = credentials.get(0).get("username").trim();
        log.info("Entering username: {}", username);
        loginPage.enterUsername(username);
        log.info("Entering password");
        loginPage.enterPassword(credentials.get(0).get("password").trim());
    }

    @When("Employee clicks on Contact Details login button")
    public void employee_clicks_on_contact_details_login_button() {
        log.info("Clicking the Login button");
        loginActions.clickLogin();
    }

    @When("the Employee is on the Contact Details Dashboard page")
    public void the_employee_is_on_the_contact_details_dashboard_page() {
        log.info("Verifying that the Dashboard is displayed after login");
        dashBoardActions = new DashBoardActions();
        Assert.assertTrue(dashBoardActions.isDashboardDisplayed(),
                "Dashboard is not displayed after login!");
        log.info("Dashboard loaded successfully");
    }

    @When("the Employee navigates to Contact Details page")
    public void the_employee_navigates_to_contact_details_page() {
        log.info("Navigating to Contact Details page via My Info");
        dashBoardActions.navigateToContactDetails();
        contactDetailsActions = new ContactDetailsActions();
        log.info("Successfully landed on the Contact Details page");
    }

    @When("Employee updates contact details from test data")
    public void employee_updates_contact_details_from_test_data() {
        log.info("Filling contact details fields using data from testData.properties");
        contactDetailsActions.updateContactDetails();
        log.info("All contact detail fields filled successfully");
    }

    @When("Employee clicks on the Contact Details Save button")
    public void employee_clicks_on_the_contact_details_save_button() {
        log.info("Clicking Save button to save contact details");
        contactDetailsActions.clickSave();
    }

    @Then("the Contact details should be updated successfully")
    public void the_contact_details_should_be_updated_successfully() {
        log.info("Verifying success message after saving contact details");
        String message = contactDetailsActions.getSuccessMessage();
        log.info("Success message received: {}", message);
        Assert.assertEquals(message, "Success", "Contact details save failed!");
        log.info("Contact details updated successfully as expected");
    }

    @When("Employee clicks on Add Attachment icon")
    public void employee_clicks_on_add_attachment_icon() {
        log.info("Clicking the Add Attachment icon to open the attachment section");
        contactDetailsActions.clickAddAttachment();
        log.info("Attachment section opened and file input is ready");
    }

    @When("Employee uploads attachment from test data")
    public void employee_uploads_attachment_from_test_data() {
        log.info("Uploading attachment file from resources folder");
        contactDetailsActions.uploadAttachment();
        log.info("Attachment file uploaded successfully");
    }

    @When("Employee clicks on Save Attachment button")
    public void employee_clicks_on_save_attachment_button() {
        log.info("Clicking Save button to confirm the attachment upload");
        contactDetailsActions.clickSaveAttachment();
    }

    @Then("the Attachment should be uploaded successfully")
    public void the_attachment_should_be_uploaded_successfully() {
        log.info("Verifying success message after attachment upload");
        String message = contactDetailsActions.getSuccessMessage();
        log.info("Success message received: {}", message);
        Assert.assertEquals(message, "Success", "Attachment upload failed!");
        log.info("Attachment uploaded successfully as expected");
    }
}