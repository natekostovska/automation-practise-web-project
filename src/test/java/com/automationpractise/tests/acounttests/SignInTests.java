package com.automationpractise.tests.acounttests;

import com.automationpractise.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationpractise.staticvariables.StaticVariables.*;


public class SignInTests extends BaseTests {
    @Test(groups = {"Smoke","Regression"})
    public void forgotPasswordTest(){
        homePage.clickSignIn();
        signInPage.clickForgotPassword();
        Assert.assertEquals(methods.getTitleName(),"FORGOT YOUR PASSWORD?");
        signInPage.enterEmailForRegisteredUser(EMAIL_FOR_REGISTERED_USER);
        signInPage.clickRetrievePassword();
        Assert.assertEquals(signInPage.getTextForSuccessfulPasswordRetrieval(),"A confirmation email has been sent to your address: "+EMAIL_FOR_REGISTERED_USER);
        signInPage.clickBackToLogin();
        Assert.assertEquals(methods.getTitleName(),CREATE_AN_ACCOUNT_PAGE_TITLE);
        signInPage.clickReturnHomeButton();
        Assert.assertEquals(homePage.getTitleName(),HOME_PAGE_TITLE);
    }
}
