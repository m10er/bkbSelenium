package com.bkb.utilities;

public enum ErrorMessages {
    CAPTCHA_ERROR("Bitte geben Sie die Zeichen", "Captcha doğrulama hatası"),
    INVALID_EMAIL("Geben Sie bitte eine gültige E-Mail-Adresse ein.", "Geçersiz email adresi"),
    INVALID_PHONE("Die Telefonnummer in Telefon* ist ungültig.", "Geçersiz telefon numarası");

    private final String message;
    private final String description;

    ErrorMessages(String message, String description) {
        this.message = message;
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
} 