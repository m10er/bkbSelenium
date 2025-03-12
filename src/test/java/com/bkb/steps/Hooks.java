package com.bkb.steps;

import com.bkb.driver.DriverFactory;
import com.bkb.driver.DriverManager;
import com.bkb.driver.DriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static DriverManager driverManager;
    public static WebDriver driver;

    @Before
    public void setup() {
        driverManager = DriverFactory.getManager(DriverType.FIREFOX);
        driver = driverManager.getDriver();
    }

    @After
    public void tearDown() {
        if (driverManager != null) {
            driverManager.quitDriver();
        }
    }
} 