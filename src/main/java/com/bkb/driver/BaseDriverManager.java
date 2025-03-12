package com.bkb.driver;

import com.bkb.utilities.TimeoutConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BaseDriverManager implements DriverManager {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger logger = LoggerFactory.getLogger(BaseDriverManager.class);

    @Override
    public WebDriver getDriver() {
        if (driver.get() == null) {
            logger.info("Creating new WebDriver instance");
            driver.set(createDriver());
        }
        return driver.get();
    }


    @Override
    public void quitDriver() {
        if (hasDriver()) {
            try {
                WebDriver currentDriver = driver.get();
                currentDriver.manage().deleteAllCookies();
                currentDriver.quit();
            } finally {
                driver.remove();
            }
        }
    }

    @Override
    public boolean hasDriver() {
        return driver.get() != null;
    }

    protected abstract void setupDriver();
    protected abstract WebDriver createSpecificDriver();

    @Override
    public WebDriver createDriver() {
        setupDriver();
        WebDriver webDriver = createSpecificDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeoutConstants.RETRY_TIMEOUT.getSeconds()));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeoutConstants.PAGE_LOAD_TIMEOUT.getSeconds()));
        return webDriver;
    }
} 