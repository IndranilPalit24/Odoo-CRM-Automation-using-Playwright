@tag
Feature: Login Feature File
  I want to test the Login Feature of Odoo Application

  @tag1
  Scenario: Login Feature of Odoo Application
    Given User is on the Login page
    When User provides the "Odoo_USERNAME" username and "Odoo_PASSWORD" password
    When User clicks on LogIn button
    Then User is logged into the Odoo Application
    
    
    

