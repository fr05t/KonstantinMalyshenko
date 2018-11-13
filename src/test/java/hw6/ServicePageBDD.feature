@smoke
Feature: ServicePageBDD

  Scenario: Service Page Interface test
    Given I'm on the Home Page!
    Then The browser title is 'Home Page'
    When I login as user epam with password 1234
    Then The 'PITER CHAILOVSKII' is displayed on the header
    When
    And Page contains all elements:
        | pictures          | 4 |
        | picturesTexts     | 4 |
        | texts             | 2 |







