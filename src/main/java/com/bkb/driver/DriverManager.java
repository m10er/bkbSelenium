package com.bkb.driver;

import org.openqa.selenium.WebDriver;

public interface DriverManager {
    WebDriver createDriver();
    void quitDriver();
    WebDriver getDriver();
    boolean hasDriver();
} 