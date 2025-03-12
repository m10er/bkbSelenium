package com.bkb.steps;

import com.bkb.model.ContactInfo;
import com.bkb.pages.BKBContactPage;
import com.bkb.utilities.URLs;
import com.bkb.utilities.faker.TestDataGeneratorFactory;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.util.Map;

public class ContactFormSteps {
    private final WebDriver driver;
    private final BKBContactPage contactPage;

    public ContactFormSteps() {

        this.driver = Hooks.driverManager.getDriver();
        this.contactPage = new BKBContactPage(driver);
    }

    @Given("User navigates to BKB contact page")
    public void userNavigatesToBKBContactPage() {
        driver.get(URLs.CONTACT_PAGE.getUrl());
    }

    @Given("User accepts the cookie notification")
    public void userAcceptsCookieNotification() {
        contactPage.acceptCookies();
    }

    @When("user selects {string} option")
    public void userSelectsOption(String option) {
        contactPage.selectMeetingType(option);
    }

    @When("selects {string} as topic")
    public void selectsTopic(String topic) {
        contactPage.selectTopic(topic);
    }

    @When("enters {string} in message field")
    public void entersInMessageField(String message) {
        contactPage.setMessage(message);
    }

    @When("selects {string} for existing customer status")
    public void selectsForExistingCustomerStatus(String status) {
        contactPage.setExistingCustomer(status.equalsIgnoreCase("Ja"));
    }

    @When("selects {string} as gender")
    public void selectsAsGender(String gender){
        contactPage.selectGender(gender);
    }

    @When("fills personal information")
    public void fillsPersonalInformation(DataTable dataTable) {
        Map<String, String> personalInfo = dataTable.asMap(String.class, String.class);
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setFirstName(personalInfo.get("FirstName"));
        contactInfo.setLastName(personalInfo.get("LastName"));
        contactInfo.setEmail(personalInfo.get("Email"));
        contactInfo.setPhone(personalInfo.get("Phone"));
        contactInfo.setAdress(personalInfo.get("Adress"));
        contactInfo.setOrt(personalInfo.get("Ort"));
        contactInfo.setPlz(personalInfo.get("Plz"));
        contactInfo.setBirthday(personalInfo.get("Birthday"));
        contactPage.fillPersonalInformation(contactInfo);
    }


    @When("confirms residence in Switzerland")
    public void confirmsResidenceInSwitzerland() {
        contactPage.confirmSwissResidence();
    }

    @When("selects {string} as availability preference")
    public void selectsAsAvailabilityPreference(String preference) {
        contactPage.availability(preference);

    }

    @When("submits the form")
    public void submitsTheForm() {
        contactPage.submitForm();
    }

    @And("fills personal information with fake Info")
    public void fillsPersonalInformationWithFakeInfo() {
        ContactInfo contactInfo = new ContactInfo(TestDataGeneratorFactory.getGenerator().generateUsername(),
                TestDataGeneratorFactory.getGenerator().generateLastName(),
                TestDataGeneratorFactory.getGenerator().generateEmail(),
                TestDataGeneratorFactory.getGenerator().generatePhoneNumber(),
                TestDataGeneratorFactory.getGenerator().generateFullAddress(),
                TestDataGeneratorFactory.getGenerator().generateZipCode(),
                TestDataGeneratorFactory.getGenerator().generateCity(),
                TestDataGeneratorFactory.getGenerator().generateBirthDate());
        contactPage.fillPersonalInformation(contactInfo);
    }

    @Then("user should see Captcha error message")
    public void userShouldSeeCaptchaErrorMessage()  {
        Assert.assertTrue(contactPage.isCaptchaErrorDisplayed());
    }

    @Then("should see mandatory field error messages")
    public void shouldSeeMandatoryFieldErrorMessages() {
        Assert.assertTrue(contactPage.isErrorMessageDisplayed());
    }


    @Given("user enters as a email {string}")
    public void userEntersAsAEmail(String email) {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setEmail(email);
        contactPage.fillPersonalInformation(contactInfo);
    }

    @Then("should see email error message")
    public void shouldSeeEmailErrorMessage()  {
        Assert.assertTrue(contactPage.isErrorMailMessagesDisplayed());
    }

    @Given("user enters as a Phone number {string}")
    public void userEntersAsAPhoneNumber(String phone) {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setPhone(phone);
        contactPage.fillPersonalInformation(contactInfo);
    }

    @Then("should see phone error message")
    public void shouldSeePhoneErrorMessage() {
        Assert.assertTrue(contactPage.isErrorPhoneMessagesDisplayed());

    }
}