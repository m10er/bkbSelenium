package com.bkb.pages.actions;

import org.openqa.selenium.WebElement;

public interface IPageActions {
    void waitForPageLoad();
    void acceptCookies();
    WebElement scrollToElementByText(String tagName, String text);
    WebElement findElementByText(String tagName, String text);
} 