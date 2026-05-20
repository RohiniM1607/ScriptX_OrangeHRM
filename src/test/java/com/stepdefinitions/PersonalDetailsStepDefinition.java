package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.DashBoardActions;
import com.actions.LoginActions;
import com.actions.PersonalDetailsActions;
import com.pages.LoginPage;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalDetailsStepDefinition {

    private static final Logger log = LogManager.getLogger(PersonalDetailsStepDefinition.class);

    LoginActions loginActions;
    DashBoardActions dashBoardActions;
    PersonalDetailsActions personalDetailsActions;
    LoginPage loginPage;
    HelperClass helper = new HelperClass();

    @Given("Employee is on OrangeHRM login page")
    public void employee_is_on_orangehrm_login_page() {
        log.info("Navigating to OrangeHRM login page");
        loginActions = new LoginActions();
        loginPage = new LoginPage();
    }

    @When("Employee enters valid username and password")
    public void employee_enters_valid_username_and_password(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        String username = credentials.get(0).get("username").trim();
        String password = credentials.get(0).get("password").trim();
        log.info("Entering username: {}", username);
        loginPage.enterUsername(username);
        log.info("Entering password");
        loginPage.enterPassword(password);
    }

    @And("Employee clicks on login button")
    public void employee_clicks_on_login_button() {
        log.info("Clicking the Login button");
        loginActions.clickLogin();
    }

    @Given("the Employee is on the Dashboard page")
    public void the_employee_is_on_the_dashboard_page() {
        log.info("Verifying that the Dashboard is displayed after login");
        dashBoardActions = new DashBoardActions();
        boolean isDashboardVisible = dashBoardActions.isDashboardDisplayed();
        Assert.assertTrue(isDashboardVisible, "Dashboard is not displayed!");
        log.info("Dashboard is displayed successfully");
    }

    @When("Employee navigates to My Info page")
    public void employee_navigates_to_my_info_page() {
        log.info("Navigating to My Info page from the Dashboard");
        dashBoardActions.navigateToMyInfo();
        personalDetailsActions = new PersonalDetailsActions();
        log.info("Successfully landed on My Info - Personal Details page");
    }

    @And("Employee updates personal details with following data")
    public void employee_updates_personal_details_with_following_data(DataTable dataTable) {
        log.info("Updating personal details with the provided data");
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        personalDetailsActions.updatePersonalDetails(data);
        log.info("Personal details fields filled successfully");
    }

    @And("Employee clicks on Save button")
    public void employee_clicks_on_save_button() {
        log.info("Clicking Save button to submit personal details");
        personalDetailsActions.clickSave();
    }

    @Then("Personal details should be updated successfully")
    public void personal_details_should_be_updated_successfully() {
        log.info("Verifying success message after saving personal details");
        String message = personalDetailsActions.successisDisplayed();
        log.info("Success message received: {}", message);
        Assert.assertEquals(message, "Success", "Successfully updated");
        log.info("Personal details updated successfully as expected");
    }

    @When("Employee moves to My Info page")
    public void employee_moves_to_my_info_page() {
        log.info("Navigating to My Info page for the negative scenario");
        dashBoardActions.navigateToMyInfo();
        personalDetailsActions = new PersonalDetailsActions();
        log.info("Landed on My Info - Personal Details page");
    }

    @And("Employee edit personal details with following data")
    public void employee_edit_personal_details_with_following_data(DataTable dataTable) {
        log.info("Editing personal details fields without saving");
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        personalDetailsActions.updatePersonalDetails(data);
        log.info("Personal details fields edited but Save will not be clicked");
    }

    @And("Employee forgot to click on Save button")
    public void employee_forgot_to_click_on_save_button() {
        log.info("Save button intentionally not clicked — simulating user forgetting to save");
    }

    @Then("Personal details should not saved successfully")
    public void personal_details_should_not_saved_successfully() {
        log.info("Verifying that no success message appears since Save was not clicked");
        boolean isMessageShown = personalDetailsActions.SuccesssisnotDisplayed();
        Assert.assertFalse(isMessageShown, "Success message should NOT appear as Save was not clicked!");
        log.info("Confirmed — success message did not appear as expected");
    }
}