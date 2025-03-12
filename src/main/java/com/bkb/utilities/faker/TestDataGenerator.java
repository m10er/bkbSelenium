package com.bkb.utilities.faker;

public interface TestDataGenerator {
    // Kullanıcı bilgileri
    String generateFirstName();
    String generateLastName();
    String generateFullName();
    String generateEmail();
    String generateUsername();
    String generatePassword();
    String generatePhoneNumber();
    
    // Adres bilgileri
    String generateStreetAddress();
    String generateCity();
    String generateState();
    String generateZipCode();
    String generateCountry();
    String generateFullAddress();
    
    // Finansal bilgiler
    String generateCreditCardNumber();
    String generateCreditCardExpiry();
    String generateCreditCardCVV();
    String generateIBAN();
    String generateAccountNumber();
    String generateCurrency();
    String generateAmount(double min, double max);
    
    // İş bilgileri
    String generateCompanyName();
    String generateJobTitle();
    String generateDepartment();
    
    // İletişim bilgileri
    String generateWebsite();
    String generateIPAddress();
    String generateMACAddress();
    
    // Kimlik bilgileri
    String generateSSN();
    String generatePassportNumber();
    String generateDriverLicense();
    
    // Zaman bilgileri
    String generatePastDate();
    String generateFutureDate();
    String generateBirthDate();
    
    // Diğer
    String generateUUID();
    String generateCustomPattern(String pattern);
} 