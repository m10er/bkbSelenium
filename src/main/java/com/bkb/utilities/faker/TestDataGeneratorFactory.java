package com.bkb.utilities.faker;

import java.util.Locale;

public class TestDataGeneratorFactory {
    private static TestDataGenerator instance;

    private TestDataGeneratorFactory() {
        throw new UnsupportedOperationException("Bu bir utility class'tır ve instance oluşturulamaz");
    }

    public static TestDataGenerator getGenerator() {
        if (instance == null) {
            instance = new JavaFakerGenerator();
        }
        return instance;
    }

    public static TestDataGenerator getGenerator(Locale locale) {
        return new JavaFakerGenerator(locale);
    }

    public static TestDataGenerator getGenerator(String type) {
        switch (type.toLowerCase()) {
            case "javafaker":
                return new JavaFakerGenerator();
            default:
                throw new IllegalArgumentException("Desteklenmeyen test data generator tipi: " + type);
        }
    }

    public static TestDataGenerator getGenerator(String type, Locale locale) {
        switch (type.toLowerCase()) {
            case "javafaker":
                return new JavaFakerGenerator(locale);
            default:
                throw new IllegalArgumentException("Desteklenmeyen test data generator tipi: " + type);
        }
    }
} 