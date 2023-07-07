Feature: Tutorialnuinja Feature
  Background:
    Given user on home page
    @Desktop
  Scenario: Test for top bar
    When user select top menu bar "Desktops"
    And click on tab menu item "Show AllDesktops"
    And product list Short by "Name (A - Z)"
    And select product "HP LP3065"
    Then verify selected product "HP LP3065"
    And select delivery date  "year" "month" "date"
    And update Qty to cart "1"
    And click add to cart button
    And change currency in to "£Pound Sterling"
    And click on shopping cart
    Then verify product name in shoping cart "HP LP3065"
    Then verify delivery date "Delivery Date:2023-07-15"
    Then verify product model "Product 21"
    Then verify unit price "£74.73"
@Laptop
    Scenario: user can place an order successfully
      When user select top menu bar "Laptops & Notebooks"
      And click on tab menu item "Show AllLaptops & Notebooks"
      And change currency in to "£Pound Sterling"
      And product list Short by "Price (High > Low)"
      And select product "MacBook"
      Then verify selected product "MacBook"
      And click add to cart button
      And click on shopping cart
      Then verify product name in shoping cart "MacBook"
      And update product qty "2"
      And click on product update button
      Then verify total price "£737.45"
      And click on checkout button
      Then verify user on check out page "Checkout"
      Then verify user on New user page "New Customer"
      And select guest radio button
      And click on continue button
      And user enter first name "Jave"
      And user enter last name "Bava"
      And user enters email "Java@bava.com"
      And user enters telephone number "0123456789"
      And user enters Address "1 close drive"
      And user enters city name "London"
      And user enters postcode "NW10 8LT"
      And user enter country "United Kingdom"
      And user enter state name "Northamptonshire"
      And user select guest button
      And user selects Terms and condition
      And user click on payment button
     # Then verify payment message "Warning: Payment method required!"  "×"

  @Registration
  Scenario: User is register successfully
    When user click on my account tab and select "Register"
    Then verify user on register account page by text "Register Account"
    And user enter first name "Jave"
    And user enter last name "Bava"
    And user enters an emailFirstName "Java"
    And user enters telephone number "0123456789"
    And user enters password "147852"
    And user enters reConfirm password "147852"
    And user select the subscribe option
    And user selects Terms conditions
    And user click on countinue button
    And user click on logout button "Logout"
    And user click on continue button




