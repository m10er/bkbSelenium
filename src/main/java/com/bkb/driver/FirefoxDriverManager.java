package com.bkb.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.bkb.utilities.TimeoutConstants;

public class FirefoxDriverManager extends BaseDriverManager {
    @Override
    protected void setupDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Override
    protected WebDriver createSpecificDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setAcceptInsecureCerts(true);

        options.setImplicitWaitTimeout(TimeoutConstants.IMPLICIT_WAIT);
        options.setPageLoadTimeout(TimeoutConstants.PAGE_LOAD_TIMEOUT);
        options.setScriptTimeout(TimeoutConstants.SCRIPT_TIMEOUT);
        
        return new FirefoxDriver(options);
    }
} 