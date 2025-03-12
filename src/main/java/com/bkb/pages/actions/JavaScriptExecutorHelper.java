package com.bkb.pages.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaScriptExecutorHelper {
    private final WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(JavaScriptExecutorHelper.class);

    public JavaScriptExecutorHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void executeClick(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            logger.error("Failed to execute JavaScript click", e);
            throw e;
        }
    }

    public void sendKeys(WebElement element, String value) {
        try {
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1]; " +
                "arguments[0].dispatchEvent(new Event('input')); " +
                "arguments[0].dispatchEvent(new Event('change'));",
                element,
                value
            );
        } catch (Exception e) {
            logger.error("Failed to enter value using JavaScript", e);
            throw e;
        }
    }
} 