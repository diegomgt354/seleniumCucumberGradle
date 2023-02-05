@demoQA
Feature: atomation practice demoQA page
    @form
    Scenario Outline: Fill fields in form section
        Given Since I'm on the Form page
        When I enter the firstname <firstname>
        And I enter the lastname <lastname>
        And I enter the email <email>
        And select gender <gender>
        And I enter the mobile number <mobile>
        And I enter the Date of Birth <year>, <month> and <day>
        And I enter the Subjects <subject>
        And I enter the Hobbies <hobbies>
        And I enter the picture <ubication>
        And I enter the Current Address <address>
        And I enter the State <state>
        And I enter the City <city>
        And click on the Submit button
        Then the results are displayed
        Examples:
            | firstname | lastname        | email         | gender | mobile    | year | month | day | subject | hobbies | address          | state   | city   |         ubication       |
            | diego     | gutierrez tafur | testgmail.com | Male   | 987654321 | 1989 | May   |  5  | English | Sport   | Mz los pinos 123 | Haryana | Karnal | D:\Scrum-Guide-SFPC.pdf |



