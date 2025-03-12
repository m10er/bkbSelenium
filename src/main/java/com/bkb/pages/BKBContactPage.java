package com.bkb.pages;

import com.bkb.model.ContactInfo;
import com.bkb.utilities.ErrorMessages;
import com.bkb.utilities.URLs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ElementNotInteractableException;
import java.util.List;

public class BKBContactPage extends BasePage {
    // Form elemens
    private final By consultationRadio = By.cssSelector("[data-sc-field-name='Anliegen']");
    private final By topicDropdown = By.cssSelector("[data-sc-field-name='Interesse']");
    private final By messageTextarea = By.cssSelector("[data-sc-field-name='Mitteilung']");
    private final By existingCustomerRadio = By.cssSelector("[data-sc-field-name='KundinKunde']");
    private final By genderRadio = By.cssSelector("[data-sc-field-name='Anrede']");
    
    // Personal Info
    private final By firstNameInput = By.cssSelector("[data-sc-field-name='Vorname']");
    private final By lastNameInput = By.cssSelector("[data-sc-field-name='Name']");
    private final By streetInput = By.cssSelector("[data-sc-field-name='Strasse Nr']");
    private final By postalCodeInput = By.cssSelector("[data-sc-field-name='PLZ']");
    private final By cityInput = By.cssSelector("[data-sc-field-name='Ort']");
    private final By emailInput = By.cssSelector("[data-sc-field-name='Email']");
    private final By birthdayInput = By.cssSelector("[data-sc-field-name='Geburtsdatum']");
    private final By phoneInput = By.cssSelector("[data-sc-field-name='Telephone']");
    
    // Dropdown
    private final By availabilityDropdown = By.cssSelector("[data-sc-field-name='dateTime']");
    
    // checkbox
    private final By swissResidenceCheckbox = By.cssSelector("[data-sc-field-name='Land']");

    // messages
    private final By submitButton = By.xpath("//button[@type='submit']");
    private final By errorMessages = By.cssSelector("[class='BFormValidationMsg field-validation-error']");

    public BKBContactPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void navigateToPage() {
        driver.get(URLs.CONTACT_PAGE.getUrl());
        waitForPageLoad();
    }

    public void fillPersonalInformation(ContactInfo info) {
        WebElement name= driver.findElement(firstNameInput);
       sendKeysWithJS(name, info.getFirstName());
       WebElement lastNm=driver.findElement(lastNameInput);
       sendKeysWithJS(lastNm, info.getLastName());
        WebElement adress= driver.findElement(streetInput);
        sendKeysWithJS(adress, info.getAdress());
        WebElement plz=driver.findElement(postalCodeInput);
        sendKeysWithJS(plz, info.getPlz());
        WebElement city= driver.findElement(cityInput);
        sendKeysWithJS(city, info.getOrt());
        WebElement email=driver.findElement(emailInput);
        sendKeysWithJS(email, info.getEmail());
        WebElement birthday= driver.findElement(birthdayInput);
        sendKeysWithJS(birthday, info.getBirthday());
        WebElement phone=driver.findElement(phoneInput);
        sendKeysWithJS(phone, info.getPhone());
    }

    public void availability(String availabilityOption){
        WebElement availabilty= driver.findElement(availabilityDropdown);
        selectDropdownByValue(availabilty,availabilityOption);
    }

    public void setMessage(String message) {
        sendKeys(messageTextarea, message);
    }

    public void selectGender(String gender){
        List<WebElement> gen = driver.findElements(genderRadio);
        if (gender.equalsIgnoreCase("frau")){
            clickWithJS(gen.get(0));
        }else {
            clickWithJS(gen.get(1));
        }
    }

    public void setExistingCustomer(boolean isExisting)  {
        List<WebElement> values = driver.findElements(existingCustomerRadio);
        if (isExisting){
            clickWithJS(values.get(0));
        }else{
            clickWithJS(values.get(1));
        }
    }

    public void submitForm() {
        clickWithJS(submitButton);
    }

    public void selectTopic(String topic) {
        WebElement element = driver.findElement(topicDropdown);
        selectDropdownByValue(element, topic);
    }

    public void confirmSwissResidence() {
        clickWithJS(swissResidenceCheckbox);
    }

    public void selectMeetingType(String option) {
        try {
            logger.info("Attempting to select meeting type: {}", option);
            List<WebElement> elements = driver.findElements(consultationRadio);
            if (!elements.isEmpty()) {
                WebElement element;
                switch (option.toLowerCase()) {
                    case "consultation request":
                        element = elements.get(0);
                        break;
                    case "general inquiry":
                        element = elements.get(1);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + option);
                }
                clickWithJS(element);
                logger.info("Successfully selected meeting type: {}", option);
            } else {
                throw new ElementNotInteractableException("Meeting type radio buttons not found");
            }
        } catch (Exception e) {
            logger.error("Failed to select meeting type: {}", option, e);
            throw e;
        }
    }

    public boolean isErrorMessageDisplayed() {
        boolean result=false;
        List<WebElement> elements= driver.findElements(errorMessages);
        for(WebElement element: elements){
            if (element.isDisplayed()){
                result= true;
            }
        }
        return result;
    }

    public boolean isCaptchaErrorDisplayed() {
        WebElement element = findElementByText("span", ErrorMessages.CAPTCHA_ERROR.getMessage());
        scrollToElementByText("span", ErrorMessages.CAPTCHA_ERROR.getMessage());
        return element.isDisplayed();
    }

    public boolean isErrorMailMessagesDisplayed() {
        scrollIntoView(emailInput);
        WebElement element = findElementByText("span", ErrorMessages.INVALID_EMAIL.getMessage());
        return element.isDisplayed();
    }

    public boolean isErrorPhoneMessagesDisplayed() {
        scrollIntoView(phoneInput);
        WebElement element = findElementByText("span", ErrorMessages.INVALID_PHONE.getMessage());
        return element.isDisplayed();
    }

}