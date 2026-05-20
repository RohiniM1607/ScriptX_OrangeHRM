package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.DashBoardActions;
import com.actions.LoginActions;
import com.actions.ProfilePictureActions;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class ProfilePictureStepDefinition {

    private static final Logger log = LogManager.getLogger(ProfilePictureStepDefinition.class);

    LoginActions loginActions;
    DashBoardActions dashBoardActions;
    ProfilePictureActions profilePictureActions;
    LoginPage loginPage;

    @Given("Employee is on OrangeHRM Profile Picture login page")
    public void employee_is_on_orange_hrm_profile_picture_login_page() {
        log.info("Navigating to OrangeHRM login page for Profile Picture scenario");
        loginActions = new LoginActions();
        loginPage = new LoginPage();
    }

    @When("Employee enters valid username and password for profile")
    public void employee_enters_valid_username_and_password_for_profile(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        String username = credentials.get(0).get("username").trim();
        log.info("Entering username: {}", username);
        loginPage.enterUsername(username);
        log.info("Entering password");
        loginPage.enterPassword(credentials.get(0).get("password").trim());
    }

    @When("Employee clicks on login")
    public void employee_clicks_on_login() {
        log.info("Clicking the Login button");
        loginActions.clickLogin();
    }

    @When("the Employee is on the OrangeHRM Dashboard page")
    public void the_employee_is_on_the_orange_hrm_dashboard_page() {
        log.info("Verifying that the Dashboard is displayed after login");
        dashBoardActions = new DashBoardActions();
        Assert.assertTrue(dashBoardActions.isDashboardDisplayed(), "Dashboard is not displayed!");
        log.info("Dashboard loaded successfully");
    }

    @When("Employee navigates to Profile Picture page")
    public void employee_navigates_to_profile_picture_page() {
        log.info("Navigating to the Profile Picture page via My Info");
        dashBoardActions.navigateToProfilePicture();
        profilePictureActions = new ProfilePictureActions();
        log.info("Successfully landed on the Profile Picture page");
    }

    @When("Employee uploads a profile picture with {string}")
    public void employee_uploads_a_profile_picture_with(String filePath) {
        log.info("Uploading profile picture using file: {}", filePath);
        profilePictureActions.uploadProfilePicture(filePath);
        log.info("Profile picture sent to file input successfully");
    }

    @When("Employee clicks on the Save button")
    public void employee_clicks_on_the_save_button() {
        log.info("Clicking Save button to upload the profile picture");
        profilePictureActions.clickSave();
    }

    @Then("Profile picture should be uploaded successfully with {string}")
    public void profile_picture_should_be_uploaded_successfully_with(String expectedMessage) {
        log.info("Verifying success message after profile picture upload");
        String actual = profilePictureActions.getSuccessMessage();
        log.info("Success message received: {}", actual);
        Assert.assertEquals(actual, expectedMessage,
                "Expected success message '" + expectedMessage + "' but got '" + actual + "'");
        log.info("Profile picture uploaded successfully as expected");
    }

    @When("Employee moves to Profile Picture page")
    public void employee_moves_to_profile_picture_page() {
        log.info("Navigating to the Profile Picture page for the negative scenario");
        dashBoardActions.navigateToProfilePicture();
        profilePictureActions = new ProfilePictureActions();
        log.info("Successfully landed on the Profile Picture page");
    }

    @When("Employee uploads a profile picture using {string}")
    public void employee_uploads_a_profile_picture_using(String filePath) {
        log.info("Uploading profile picture using file: {}", filePath);
        profilePictureActions.uploadProfilePicture(filePath);
        log.info("Profile picture sent to file input — Save will not be clicked");
    }

    @When("Employee forgot to click on the Save button")
    public void employee_forgot_to_click_on_the_save_button() {
        log.info("Save button intentionally not clicked — simulating user forgetting to save");
    }

    @Then("Profile picture should not be updated with {string}")
    public void profile_picture_should_not_be_updated_with(String message) {
        log.info("Verifying that no success message appears since Save was not clicked");
        Assert.assertFalse(profilePictureActions.isSuccessMessageDisplayed(),
                "Success message appeared even though Save was not clicked!");
        log.info("Confirmed — success message did not appear as expected");
    }
}