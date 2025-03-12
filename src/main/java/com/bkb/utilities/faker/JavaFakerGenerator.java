package com.bkb.utilities.faker;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class JavaFakerGenerator implements TestDataGenerator {
    private static final Logger logger = LoggerFactory.getLogger(JavaFakerGenerator.class);
    private final Faker faker;
    private final SimpleDateFormat dateFormat;

    public JavaFakerGenerator() {
        this(new Locale("tr"));
    }

    public JavaFakerGenerator(Locale locale) {
        this.faker = new Faker(locale);
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public String generateFirstName() {
        return faker.name().firstName();
    }

    @Override
    public String generateLastName() {
        return faker.name().lastName();
    }

    @Override
    public String generateFullName() {
        return faker.name().fullName();
    }

    @Override
    public String generateEmail() {
        return faker.internet().emailAddress();
    }

    @Override
    public String generateUsername() {
        return faker.name().username();
    }

    @Override
    public String generatePassword() {
        return faker.internet().password(8, 16, true, true);
    }

    @Override
    public String generatePhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    @Override
    public String generateStreetAddress() {
        return faker.address().streetAddress();
    }

    @Override
    public String generateCity() {
        return faker.address().city();
    }

    @Override
    public String generateState() {
        return faker.address().state();
    }

    @Override
    public String generateZipCode() {
        return faker.address().zipCode();
    }

    @Override
    public String generateCountry() {
        return faker.address().country();
    }

    @Override
    public String generateFullAddress() {
        return faker.address().fullAddress();
    }

    @Override
    public String generateCreditCardNumber() {
        return faker.finance().creditCard();
    }

    @Override
    public String generateCreditCardExpiry() {
        return faker.business().creditCardExpiry();
    }

    @Override
    public String generateCreditCardCVV() {
        return faker.number().digits(3);
    }

    @Override
    public String generateIBAN() {
        return "TR" + faker.number().digits(24);
    }

    @Override
    public String generateAccountNumber() {
        return faker.number().digits(10);
    }

    @Override
    public String generateCurrency() {
        return faker.currency().code();
    }

    @Override
    public String generateAmount(double min, double max) {
        return String.format("%.2f", faker.number().randomDouble(2, (long)min, (long)max));
    }

    @Override
    public String generateCompanyName() {
        return faker.company().name();
    }

    @Override
    public String generateJobTitle() {
        return faker.job().title();
    }

    @Override
    public String generateDepartment() {
        return faker.commerce().department();
    }

    @Override
    public String generateWebsite() {
        return faker.internet().url();
    }

    @Override
    public String generateIPAddress() {
        return faker.internet().ipV4Address();
    }

    @Override
    public String generateMACAddress() {
        return faker.internet().macAddress();
    }

    @Override
    public String generateSSN() {
        return faker.idNumber().ssnValid();
    }

    @Override
    public String generatePassportNumber() {
        return faker.number().digits(9);
    }

    @Override
    public String generateDriverLicense() {
        return faker.idNumber().valid();
    }

    @Override
    public String generatePastDate() {
        Date pastDate = faker.date().past(365, TimeUnit.DAYS);
        return dateFormat.format(pastDate);
    }

    @Override
    public String generateFutureDate() {
        Date futureDate = faker.date().future(365, TimeUnit.DAYS);
        return dateFormat.format(futureDate);
    }

    @Override
    public String generateBirthDate() {
        Date birthDate = faker.date().birthday();
        return dateFormat.format(birthDate);
    }

    @Override
    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String generateCustomPattern(String pattern) {
        return faker.regexify(pattern);
    }
} 