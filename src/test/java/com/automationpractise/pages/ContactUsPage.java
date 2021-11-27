package com.automationpractise.pages;

import com.automationpractise.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.automationpractise.staticvariables.StaticVariables.fakeMessage;

public class ContactUsPage extends Methods {

    public ContactUsPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    By subject = By.xpath("//*[@id=\"id_contact\"]/*");
    By order = By.id("id_order");
    By message = By.id("message");
    By upload = By.id("uniform-fileUpload");
    By sendButton = By.id("submitMessage");
    By responseHeader = By.cssSelector("p.alert");

    public void chooseSubjectHeading(int i) {
        javaExecutorScrollIntoView(subject);
        clickWithIndex(subject, i);
    }

    public void enterOrderReference(String orderReference) {
        sendKeys(order, orderReference);
    }

    public void enterMessageWithFaker() {
        sendKeys(message, fakeMessage);
    }

    public void enterMessage(String mes) {
        sendKeys(message, mes);
    }

    public void enterFile(String path) throws IOException, InterruptedException {
        uploadFileWithAutoIt(upload, path);
    }

    public void clickSendButton() {
        clickActions(sendButton);
    }

    public String getResponseMessage() {
        return getText(responseHeader);
    }

}
