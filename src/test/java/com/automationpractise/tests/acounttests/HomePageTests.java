package com.automationpractise.tests.acounttests;

import com.automationpractise.tests.BaseTests;
import org.testng.annotations.Test;

import static com.automationpractise.staticvariables.StaticVariables.EMAIL_FOR_REGISTERED_USER;
import static com.automationpractise.staticvariables.StaticVariables.PASSWORD_FOR_REGISTERED_USER;

public class HomePageTests extends BaseTests {
    @Test(groups = {"Smoke","Regression"})
    public void homePageWhenLoggedIn(){
        homePage.clickSignIn();
        signInPage.enterEmailForRegisteredUser(EMAIL_FOR_REGISTERED_USER);
        signInPage.enterPasswordForExistingUser(PASSWORD_FOR_REGISTERED_USER);
        signInPage.clickSignInButton();
    }
}
