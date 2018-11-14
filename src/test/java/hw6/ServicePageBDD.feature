Feature: ServicePageBDD

  Scenario: Service Page Interface test
    Given I am on "Home Page"
    Then The browser title is 'Home Page'
    When I login as user epam with password 1234
    Then The 'PITER CHAILOVSKII' is displayed on the header
    And Page contains all elements:
      | pictures      | 4 |
      | picturesTexts | 4 |
      | headline      | 1 |
      | description   | 1 |

    When I click on "Service" button in Header
    Then Menu contains elements:
      | DATES              |
      | COMPLEX TABLE      |
      | SIMPLE TABLE       |
      | USER TABLE         |
      | TABLE WITH PAGES   |
      | DIFFERENT ELEMENTS |
      | PERFORMANCE        |
      | SUPPORT            |

    When I click on the Service in the leftMenu
    Then Menu left menu contains elements:
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | User Table         |
      | Table with pages   |
      | Different elements |
      | Performance        |
      | Support            |

    When I click on "Service" button in Header
    And I click on "DIFFERENT ELEMENTS" button in Service dropdown
    Then "Different Elements" page is opened
    When Page contain this elements:
      | checkbox    | 4 |
      | radiobutton | 4 |
      | dropdown    | 1 |
      | button      | 2 |

    And Right section is displayed
    And Left section is displayed

    When I check conditions:
      | Water |
      | Wind  |
    Then Checked conditions are displayed:
      | Water |
      | Wind  |
    When I Select 'Selen'
    Then Selected metal is 'Selen'

    When I Select from dropdown 'Yellow'
    Then Selected color is 'Yellow'

    When I check conditions:
      | Water |
      | Wind  |
    Then Unchecked conditions are displayed:
      | Water |
      | Wind  |






