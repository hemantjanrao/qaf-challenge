package com.ui.framework.driver;

import com.ui.framework.utils.PropertyUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebUtils {

    private static WebElement getElement(WebDriver driver, By element){
        return driver.findElement(element);
    }
    public static void moveToElementAndClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);

        actions.moveToElement(element).click().perform();
    }

    public static void moveToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);

        actions.
                moveToElement(element)
                .perform();
    }

    public static void fill(WebDriver wd, By elem, String value) {
        WebElement element = getElement(wd, elem);
        if (!isElementDisplayed(wd, elem)) {
            throw new ElementNotVisibleException(element + " is not visible");
        }

       try{
        element.clear();

        element.sendKeys(value);
       } catch(ElementNotVisibleException ex){
           ex.printStackTrace();
       }
    }

    public static boolean isElementDisplayed(WebDriver wd, By element) {

        WebElement elem = getElement(wd,element);
        try {
            return elem.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public static void waitForElementToBeDisplayed(WebDriver driver, WebElement element, long timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));

        } catch (TimeoutException e) {
            throw new ElementNotVisibleException("Timeout" + element + " is not visible/present.");
        }
    }

    public static void waitForElementsToBeDisplayed(WebDriver driver, List<WebElement> elements, long timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElements(elements));

        } catch (TimeoutException e) {
            throw new ElementNotVisibleException("Timeout" + elements + " are not visible/present.");
        }
    }

    private static void waitForElementToBeClickable(WebDriver driver, WebElement element, long timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));

        } catch (TimeoutException e) {
            throw new ElementNotVisibleException("Timeout" + element + " is not visible/present.");
        }
    }

    public static void waitForPageLoad(WebDriver driver) {
        new WebDriverWait(driver, 120).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static void clickWithWaitForElement(WebDriver wd, By elem, long timeout) {

        WebElement element = getElement(wd,elem);
        WebUtils.waitForElementToBeDisplayed(wd,element, timeout);
        element.click();
    }

    public static void clickWithWaitForElement(WebDriver wd, By element) {
        WebElement elem = getElement(wd, element);
        WebUtils.waitForElementToBeDisplayed(wd, elem, PropertyUtils.getDefaultTimeOutForElement());
        WebUtils.waitForElementToBeClickable(wd, elem, PropertyUtils.getDefaultTimeOutForElement());
        elem.click();
    }


    public static String getTextValue(WebDriver wd, WebElement elem) {
        WebUtils.waitForElementToBeDisplayed(wd, elem, PropertyUtils.getDefaultTimeOutForElement());
        return elem.getText();
    }

    public static void scrollToElement(WebDriver wd, WebElement elem) {
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", elem);
    }

    public static void executeJavascript(WebDriver wd, String script) {
        ((JavascriptExecutor) wd).executeScript(script);
    }

    public static void selectByValue(WebDriver wd, By element, String optionName ){
        WebElement elem = getElement(wd,element);
        Select dropdown = new Select(elem);
        dropdown.selectByValue(optionName);
    }

    public static void selectByIndex(WebDriver wd, By element, int index ){
        WebElement elem = getElement(wd,element);
        Select dropdown = new Select(elem);
        dropdown.selectByIndex(index);
    }

    public static void selectByText(WebDriver wd, By element, String text){
        WebElement elem = getElement(wd,element);
        Select dropdown = new Select(elem);
        dropdown.selectByVisibleText(text);
    }

    public static void navigateTo(WebDriver wd, String linkName){
        moveToElementAndClick(wd, wd.findElement(By.linkText(linkName)));
    }
}
