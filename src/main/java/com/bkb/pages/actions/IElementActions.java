package com.bkb.pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface IElementActions {
    void sendKeys(By locator, String text);
    void clickWithJS(By locator);
    void clickWithJS(WebElement element);
    void scrollIntoView(By locator);
    void sendKeysWithJS(WebElement element, String value);
    WebElement waitForElementVisible(By locator);
} 