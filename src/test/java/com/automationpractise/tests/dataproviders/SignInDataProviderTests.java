package com.automationpractise.tests.dataproviders;

import com.automationpractise.staticvariables.StaticVariables;
import com.automationpractise.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.automationpractise.staticvariables.StaticVariables.*;

public class SignInDataProviderTests extends BaseTests {
    @DataProvider(name = "Already Registered Valid Credentials")
    public static Object[][] dataProvider(){
        return new Object[][]{
                {EMAIL_FOR_REGISTERED_USER,PASSWORD_FOR_REGISTERED_USER},
                {EMAIL_FOR_REGISTERED_USER.toUpperCase(Locale.ROOT),PASSWORD_FOR_REGISTERED_USER.toUpperCase(Locale.ROOT)},
                {EMAIL_FOR_REGISTERED_USER.toLowerCase(Locale.ROOT),PASSWORD_FOR_REGISTERED_USER.toLowerCase(Locale.ROOT)}
        };
    }

    @Test(dataProvider = "Already Registered Valid Credentials",groups={"Smoke","Regression"})
    public void alreadyRegistered(String email, String password){
        homePage.clickSignIn();
        Assert.assertEquals(methods.getTitleName(),CREATE_AN_ACCOUNT_PAGE_TITLE);
        signInPage.enterEmailForRegisteredUser(email);
        signInPage.enterPasswordForExistingUser(password);
        signInPage.clickSignInButton();
        Assert.assertEquals(methods.getTitleName(),MY_ACCOUNT_TITLE);
        Assert.assertEquals(myAccount.getWelcomeToAccountText(),WELCOME_TO_ACCOUNT_TEXT);
    }

    @DataProvider(name = "Already Registered")
    public static Object [][] dataProvider1(){
        return new Object[][]
        {
                {"","!@@#$23"},
                {"",""},
                {"something@test.com","123456"},
                {"something@TEST.com",""},
                {"SOMETHING@TEST","123456789"}
        };
    }
    @Test(dataProvider = "Already Registered",groups = {"Smoke","Regression"})
    public void invalidCredentialsTest(String email,String pass){
        homePage.clickSignIn();
        Assert.assertEquals(methods.getTitleName(), StaticVariables.CREATE_AN_ACCOUNT_PAGE_TITLE);
        Assert.assertEquals(signInPage.getSubtitle(1),ALREADY_REGISTERED_TITLE);
        signInPage.enterEmailForRegisteredUser(email);
        signInPage.enterPasswordForExistingUser(pass);
        signInPage.clickSignInButton();
        Assert.assertEquals(signInPage.getTextForError(),AUTHENTICATION_ERROR);
    }
}
