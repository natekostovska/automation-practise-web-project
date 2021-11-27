package com.automationpractise.pages;

import com.automationpractise.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends Methods {

    public SignInPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    By pageSubtitles = By.tagName("h3");
    By emailCreate = By.cssSelector("#email_create");
    By createButton = By.id("SubmitCreate");
    By emailRegistered = By.cssSelector("#email");
    By password = By.id("passwd");
    By forgotPassword = By.linkText("Forgot your password?");
    By signInButton = By.id("SubmitLogin");
    By retrievePassword = By.cssSelector("[class*=\"submit\"]>button");
    By backToLogIn = By.xpath("//*[contains(@title,\"Back to Login\")]");
    By responseError = By.cssSelector("div.alert>p");
    By response = By.xpath("//*[contains(text(),'A confirmation email has been sent to your address')]");
    By returnHomeButton = By.cssSelector("a.home");
    By accountEmailError = By.xpath("//*[contains(text(),'An account using this email address has already be')]");

    public String getSubtitle(int i) {
        javaExecutorScrollIntoView(pageSubtitles);
        return getTexts(pageSubtitles, i);
    }

    public void clearEmail() {
        clear(emailCreate);
    }

    public void enterEmailForNewAccount(String email) {
        sendKeys(emailCreate, email);
    }

    public void clickCreateAnAccount() {
        javaExecutorScrollIntoView(createButton);
        click(createButton);
    }

    public String getCreateAnAccountMessageError() {
        return getText(accountEmailError);
    }

    public void enterEmailForRegisteredUser(String email) {
        sendKeys(emailRegistered, email);
    }

    public void enterPasswordForExistingUser(String pass) {
        sendKeys(password, pass);
    }

    public void clickSignInButton() {
        click(signInButton);
    }

    public void clickForgotPassword() {
        click(forgotPassword);
    }

    public void clickRetrievePassword() {
        click(retrievePassword);
    }

    public void clickBackToLogin() {
        click(backToLogIn);
    }

    public String getTextForError() {
        return getText(responseError);
    }

    public String getTextForSuccessfulPasswordRetrieval() {
        return getText(response);
    }

    public void clickReturnHomeButton() {
        javaExecutorScrollIntoView(returnHomeButton);
        click(returnHomeButton);
    }

}
