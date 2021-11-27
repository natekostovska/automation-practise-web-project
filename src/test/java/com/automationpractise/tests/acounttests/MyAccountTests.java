package com.automationpractise.tests.acounttests;

import com.automationpractise.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationpractise.staticvariables.StaticVariables.*;

public class MyAccountTests extends BaseTests {
    @Test(groups={"Smoke","Regression"})
    public void myAccountPageTest(){
        homePage.clickSignIn();
        signInPage.enterEmailForRegisteredUser(EMAIL_FOR_REGISTERED_USER);
        signInPage.enterPasswordForExistingUser(PASSWORD_FOR_REGISTERED_USER);
        signInPage.clickSignInButton();
        Assert.assertEquals(methods.getTitleName(),MY_ACCOUNT_TITLE);
        Assert.assertEquals(myAccount.getWelcomeToAccountText(),WELCOME_TO_ACCOUNT_TEXT);
        myAccount.clickOnOneOfTheItemsForMyAccount("Order History");
        Assert.assertEquals(methods.getTitleName(),"ORDER HISTORY");
        myAccount.chooseToDownloadPDFInvoiceForAnOrder(1);
        myAccount.clickToSeeOrdersDetails(1);
        myAccount.chooseHomeButtonToClick(0);
        homePage.clickWhenLoggedIn();
        myAccount.clickOnOneOfTheItemsForMyAccount("My PI");
        Assert.assertEquals(methods.getTitleName(),"YOUR PERSONAL INFORMATION");
        homePage.clickWhenLoggedIn();
    }
}
