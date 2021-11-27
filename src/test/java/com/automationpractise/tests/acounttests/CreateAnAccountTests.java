package com.automationpractise.tests.acounttests;

import com.automationpractise.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationpractise.staticvariables.StaticVariables.*;

public class CreateAnAccountTests extends BaseTests {
    @Test(groups = {"Smoke", "Regression"})
    public void signInCreateAnAccount() {
        homePage.clickSignIn();
        Assert.assertEquals(signInPage.getSubtitle(0), "CREATE AN ACCOUNT");
        signInPage.enterEmailForNewAccount(EMAIL_FOR_REGISTERED_USER);
        signInPage.clickCreateAnAccount();
        Assert.assertEquals(signInPage.getCreateAnAccountMessageError(), CREATE_AN_ACCOUNT_EMAIL_ERROR_MESSAGE);
        signInPage.clearEmail();
        signInPage.enterEmailForNewAccount(fakeEmail);
        waitTime();
        signInPage.clickCreateAnAccount();
        Assert.assertEquals(methods.getTitleName(), "AUTHENTICATION");
        createAnAccount.chooseGender("Mrs");
        createAnAccount.enterFirstName(fakeFirstName);
        createAnAccount.enterLastName(fakeLastName);
        createAnAccount.checkIfEmailFieldIsNotEmpty();
        createAnAccount.enterPasswordForNewUser("12345$%Na");
        createAnAccount.selectDays(12);
        createAnAccount.selectMonths(10);
        createAnAccount.selectYears("1995");
        createAnAccount.clickNewsletter();
        createAnAccount.clickOffers();
        Assert.assertEquals(createAnAccount.getFirstName(), createAnAccount.getFirstNameForAddress());
        Assert.assertEquals(createAnAccount.getLastName(), createAnAccount.getLastNameForAddress());
        createAnAccount.enterNameOfCompany(fakeCompanyName);
        createAnAccount.enterAddress1(fakeAddress);
        createAnAccount.enterAddress2(fakeSecondaryAddress);
        createAnAccount.enterCity(fakeCity);
        createAnAccount.selectState(2);
        createAnAccount.enterZipcode("00000");
        createAnAccount.selectCountry(1);
        createAnAccount.enterAddInfo("Hello");
        createAnAccount.enterHomePhone(fakePhoneNumber);
        createAnAccount.enterMobilePhone(fakePhoneNumber);
        createAnAccount.assignAliasAddress(fakeAlias);
        createAnAccount.clickRegisterButton();
        Assert.assertEquals(myAccount.getTitleName(), MY_ACCOUNT_TITLE);
    }
}
