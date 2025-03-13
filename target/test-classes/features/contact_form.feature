@contact
Feature: BKB Contact Form
  In order to test the contact form functionality
  on the BKB website

  Background:
    * User navigates to BKB contact page
    * User accepts the cookie notification

  @negative
  Scenario: Submit consultation request
    When user selects "Consultation request" option
    And selects "Konten und Karten" as topic
    And selects "Nein" for existing customer status
    And selects "Herr" as gender
    And fills personal information
      | Field     | Value         |
      | FirstName | Test          |
      | LastName  | User          |
      | Email     | test@test.com |
      | Phone     | 0123456789    |
      | Adress    | Test Street   |
      | Plz       | 4000          |
      | Ort       | Basel         |
      | Birthday  | 01.01.1999    |
    And confirms residence in Switzerland
    And selects "Nachmittags" as availability preference
    When submits the form
    Then user should see Captcha error message

  @negative
  Scenario Outline: Submit form for different topics
    When user selects "Consultation request" option
    And selects "<Topic>" as topic
    And fills personal information with fake Info
    When submits the form
    Then user should see Captcha error message

    Examples:
      | Topic                  |
      | Konten und Karten      |
      | Anlegen                |
      | Hypotheken und Kredite |
      | Vorsorge               |

  @negative
  Scenario: Display error messages for mandatory fields
    When user selects "Consultation request" option
    And selects "Konten und Karten" as topic
    When submits the form
    Then should see mandatory field error messages

  @negative
  Scenario Outline: Form submission with invalid email
    Given user enters as a email "<invalid email address>"
    When submits the form
    Then should see email error message

    Examples:
      | invalid email address |
      | muammer10er           |
      | muammer10ergmail.com  |
      | muammer  er@gmail.com |
      | muammer10er@gmailcom  |

  @negative
  Scenario Outline: Form submission with invalid phone number
    Given user enters as a Phone number "<invalid phone number>"
    When submits the form
    Then should see phone error message
    Examples:
      | invalid phone number |
      | phoneNumber          |
      | ph123214322          |
      | ?>324324322          |


  @dene
  Scenario Outline: Form submission with invalid phone number
    Given user enters as a birthday "<invalid birthday>"
    When submits the form
    Then should see birthday error message
    Examples:
      |invalid birthday      |
      | birthday             |
      | 12345677888          |
      | ?%43@43              |

