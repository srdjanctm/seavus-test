@test
Feature: Practice automation for Seavus test

  In order to pass the test
  As an automation engineer
  I need to fill out toolsQA practice form


  Background:
    Given engineer has navigated to practice form

  Scenario: Reading And Printing Form Message
    When engineer reads and prints message in practice form
    Then printed message in console is "ToolsQA is a leading provider of technology content for learning."


  Scenario: Fill Out Form
    When engineer fills out first name as "Srdjan" and last name
    And engineer selects sex as "Male"
    And engineer selects four years of experience
    And engineer sets today date
    And engineer checks both profession
    And engineer uploads profile picture "srdjan.jpg"
    And engineer downloads files
    And engineer checks automation tool "Selenium IDE"
    And engineer selects continents as "Europe" from drop down
    And engineer selects Europe in multiple select
    And engineer selects Navigation Commands
    And engineer clicks on button 4
    Then page scrolls to top
    And engineer sees title "Automation practice form"