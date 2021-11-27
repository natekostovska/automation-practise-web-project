package com.automationpractise.tests.acounttests;

import com.automationpractise.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationpractise.staticvariables.StaticVariables.*;

public class ContactUsTests extends BaseTests {
    @Test(groups = {"Smoke","Regression"})
    public void contactUsFormWithCorrectCredentials() throws IOException, InterruptedException {
        homePage.clickContactUs();
        Assert.assertEquals(contactUsPage.getTitleName(), CONTACT_US_PAGE_TITLE);
        contactUsPage.chooseSubjectHeading(1);
        waitTime();
        signInPage.enterEmailForRegisteredUser(EMAIL_FOR_REGISTERED_USER);
        contactUsPage.enterOrderReference("T-Shirt");
        contactUsPage.enterFile(PNG_FILE_TO_UPLOAD);
        contactUsPage.enterMessageWithFaker();
        contactUsPage.clickSendButton();
        Assert.assertEquals(contactUsPage.getResponseMessage(), "Your message has been successfully sent to our team.");
    }
}
