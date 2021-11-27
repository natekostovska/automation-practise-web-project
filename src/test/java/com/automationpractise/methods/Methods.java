package com.automationpractise.methods;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class Methods {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public Methods(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }

    By pageTitle = By.tagName("h1");

    public WebElement element(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> elements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void sendKeys(By locator, String string) {
        element(locator).sendKeys(string);
    }

    public void sendKeysEnter(By locator, String string) {
        sendKeys(locator, string);
        sendKeys(locator, "" + Keys.ENTER);
    }

    public void clear(By locator) {
        element(locator).clear();
    }

    public int arrayListToInt(String[] items, String list) {
        return ArrayUtils.indexOf(items, list);
    }

    public void click(By locator) {
        element(locator).click();
    }

    public void clickWithIndex(By locator, int index) {
        elements(locator).get(index).click();
    }

    public String getText(By locator) {
        return element(locator).getText();
    }

    public String getTexts(By locator, int i) {
        return elements(locator).get(i).getText();
    }

    public void clickActionsWithIndex(By locator, int i) {
        actions.click(elements(locator).get(i)).build().perform();
    }

    public void clickActions(By locator) {
        actions.click(element(locator)).build().perform();
    }

    public String getTitleName() {
        return getText(pageTitle);
    }

    public void javaExecutorScrollIntoView(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element(locator));
    }

    public void moveToElement(By locator) {
        actions.moveToElement(element(locator)).build().perform();
    }

    public void moveToElementByIndex(By locator, int index) {
        actions.moveToElement(elements(locator).get(index)).build().perform();
    }

    public void uploadFileWithAutoIt(By locator, String path) throws InterruptedException, IOException {
        javaExecutorScrollIntoView(locator);
        moveToElement(locator);
        Thread.sleep(5000);
        Runtime.getRuntime().exec(path);
    }

    public void softAssert(String actual, String expected) {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(actual, expected);

    }

    public String getAttribute(By locator, String attribute) {
        return element(locator).getAttribute(attribute);
    }

    public String getAttributes(By locator, int i, String attribute) {
        return elements(locator).get(i).getAttribute(attribute);
    }

    public boolean getEmptyAttribute(By locator, String attribute) {
        return getAttribute(locator, attribute).isEmpty();
    }

    public boolean getContainsAttribute(By locator, int i, String attribute, String contain) {
        return getAttributes(locator, i, attribute).contains(contain);
    }

}
