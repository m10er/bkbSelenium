package com.bkb.pages;

import com.bkb.pages.actions.IElementActions;
import com.bkb.pages.actions.IPageActions;
import com.bkb.pages.actions.JavaScriptExecutorHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.bkb.utilities.TimeoutConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage implements IPageActions, IElementActions {
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    private final JavaScriptExecutorHelper jsHelper;
    private final By acceptCookiesButton = By.id("onetrust-accept-btn-handler");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TimeoutConstants.EXPLICIT_WAIT_MEDIUM);
        this.jsHelper = new JavaScriptExecutorHelper(driver);
        PageFactory.initElements(driver, this);
    }

    protected abstract void navigateToPage();

    @Override
    public void acceptCookies() {
        try {
            clickWithJS(acceptCookiesButton);
            logger.info("Cookie accept button clicked successfully");
        } catch (Exception e) {
            logger.error("Failed to click cookie accept button", e);
            throw e;
        }
    }

    public WebElement scrollToElementByText( String tagName, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script =
                "var elements = [...document.querySelectorAll(arguments[0])];" +
                        "var el = elements.find(e => e.innerText.includes(arguments[1]));" +
                        "if (el) { el.scrollIntoView({behavior: 'smooth', block: 'center'}); }" +
                        "return el;";

        return (WebElement) js.executeScript(script, tagName, text);
    }

    public WebElement findElementByText( String tagName, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return [...document.querySelectorAll(arguments[0])].find(el => el.innerText.includes(arguments[1]));";
        return (WebElement) js.executeScript(script, tagName, text);
    }

    protected void selectDropdownByValue(WebElement dropdown, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].value='" + value + "';";
        js.executeScript(script, dropdown);
    }

    public void waitForPageLoad() {
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));
            logger.debug("Page load completed successfully");
        } catch (Exception e) {
            logger.error("Page failed to load within timeout period", e);
            throw e;
        }
    }

    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Override
    public void sendKeys(By locator, String text) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
            logger.debug("Successfully sent text '{}' to element: {}", text, locator);
        } catch (Exception e) {
            logger.error("Failed to send text '{}' to element: {}", text, locator, e);
            throw e;
        }
    }

    @Override
    public void clickWithJS(By locator) {
        WebElement element = driver.findElement(locator);
        jsHelper.executeClick(element);
    }

    @Override
    public void clickWithJS(WebElement element) {
        jsHelper.executeClick(element);
    }

    public void scrollIntoView(By locator) {
        WebElement element = waitForElementVisible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Override
    public void sendKeysWithJS(WebElement element, String value) {
        jsHelper.sendKeys(element, value);
    }

}