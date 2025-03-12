package com.bkb.driver;

public class DriverFactory {
    public static DriverManager getManager(DriverType type) {
        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                throw new IllegalArgumentException("Desteklenmeyen tarayıcı tipi: " + type);
        }
        return driverManager;
    }
}

