package com.automationpractise.tests.acounttests;

import com.automationpractise.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationpractise.staticvariables.StaticVariables.*;

public class CartTests extends BaseTests {
    @Test(groups = {"Smoke", "Regression"})
    public void cartTest() {
        Assert.assertEquals(cartPage.getEmptyTextForCart(), "(empty)");
        cartPage.clickCart();
        Assert.assertEquals(cartPage.getTitleName(), CART_PAGE_TITLE);
        Assert.assertEquals(cartPage.getMessageForEmptyCart(), "Your shopping cart is empty.");
        signInPage.clickReturnHomeButton();
        homePage.searchItems("T-Shirts");
        Assert.assertEquals(cartPage.getInStockText(), "In stock");
        cartPage.clickMoreForProduct(0);
        cartPage.enterWantedQuantityOfAProduct("2");
        cartPage.selectProductSize("L");
        cartPage.clickToChooseColorForTheProduct(1);
        waitTime();
        Assert.assertEquals(cartPage.getSuccessAddItemText(), "Product successfully added to your shopping cart");
        cartPage.clickContinueShoppingOrProceedToCheckout("Continue");
        homePage.clickMenuItem("Women");
        cartPage.clickCheckOutButton();
        cartPage.clickContinueProceedButtons("Continue");
        signInPage.enterEmailForRegisteredUser(EMAIL_FOR_REGISTERED_USER);
        signInPage.enterPasswordForExistingUser(PASSWORD_FOR_REGISTERED_USER);
        signInPage.clickSignInButton();
        Assert.assertEquals(methods.getTitleName(), "ADDRESSES");
        cartPage.clickProceedForAddresses();
        waitTime();
        cartPage.clickProceedForAddresses();
        Assert.assertEquals(cartPage.getErrorTextForTermsOfService(), "You must agree to the terms of service before continuing.");
        waitTime();
        cartPage.closeErrorTextForShipping();
        cartPage.clickCheckboxForTermsOfService();
        waitTime();
        cartPage.clickProceedForAddresses();
        Assert.assertEquals(methods.getTitleName(), "PLEASE CHOOSE YOUR PAYMENT METHOD");
        cartPage.clickToChooseAPayingMethod("Check");
        Assert.assertEquals(methods.getTitleName(), "ORDER SUMMARY");
        cartPage.clickProceedForAddresses();
        Assert.assertEquals(cartPage.getTextForSuccessfulOrder(), "Your order on My Store is complete.");
    }
}
