Feature: Jagadeep_15-05-2026_ScriptX_OrangeHRm_PIM_Functionality

  @CreateEmployee
  Scenario Outline: Create employee with multiple data combinations
    Given admin is logged into OrangeHRM
    When admin enters employee details "<firstName>" "<lastName>" "<employeeId>"
    And admin clicks save button
    Then employee result should be "<result>"

    Examples:
      | firstName | lastName | employeeId | result   |
      | Jagadee   | KC       | 9011       | success  |
      | Rohi      | Kumar    | 9012       | success  |
      | Anan      | Kumar    | 9013       | success  |
      |           |          |            | required |

  @SearchEmployee
  Scenario: Search employee using excel data
    Given admin is logged into OrangeHRM search page
    When admin searches employee using excel data
    Then verify employee search results