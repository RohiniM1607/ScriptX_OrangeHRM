<<<<<<< HEAD
Feature: Reshma_17May2026_ScriptX_OrangeHRM File for ProfilePicture
=======
@Reshma
Feature: Reshma_19May2026_ScriptX_OrangeHRM File for ProfilePicture
>>>>>>> 15a3839f2a1977048e179f59319bab79736e2829

  Background:
    Given Employee is on OrangeHRM Profile Picture login page
    When Employee enters valid username and password for profile
      | username    | password       |
      | Renukkka R  | RenukkkaR@123  |
    And Employee clicks on login
    And the Employee is on the OrangeHRM Dashboard page

<<<<<<< HEAD
  @ReshmaProfilePicture
  Scenario Outline: Upload profile picture successfully
    When Employee navigates to Profile Picture page
    And Employee uploads a profile picture with "<FilePath>"
    And Employee clicks on the Save button
    Then Profile picture should be uploaded successfully with "<SuccessMessage>"

    Examples:
      | FilePath                                    | SuccessMessage |
      | C:\Users\Reshma\Desktop\RESHMA\profile.jpg  | Success        |

  @InvalidReshmaProfilePicture
  Scenario Outline: Changing the profile picture without saving
    When Employee moves to Profile Picture page
    And Employee uploads a profile picture using "<FilePath>"
    And Employee forgot to click on the Save button
    Then Profile picture should not be updated with "<ErrorMessage>"

    Examples:
      | FilePath                                     | ErrorMessage                                          |
      | C:\Users\Reshma\Desktop\RESHMA\profile1.jpg  | Success message should NOT appear as Save was not clicked! |
=======
  @ReshmaProfilePicture 
  Scenario: Upload profile picture successfully
    When Employee navigates to Profile Picture page
    And Employee uploads a profile picture with "\\src\\test\\resources\\profile.jpg"
    And Employee clicks on the Save button
    Then Profile picture should be uploaded successfully with "Success"

  @InvalidReshmaProfilePicture 
   Scenario: Changing the profile picture without saving
    When Employee moves to Profile Picture page
    And Employee uploads a profile picture using "\\src\\test\\resources\\profile1.jpg"
    And Employee forgot to click on the Save button
    Then Profile picture should not be updated with "Success message should not appear"
>>>>>>> 15a3839f2a1977048e179f59319bab79736e2829
