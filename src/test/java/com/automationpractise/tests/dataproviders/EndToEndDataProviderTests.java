package com.automationpractise.tests.dataproviders;

import com.automationpractise.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.automationpractise.staticvariables.StaticVariables.*;

public class EndToEndDataProviderTests extends BaseTests {
    @DataProvider(name = "ContactUs")
    public static Object[][] dataProvider() {
        return new Object[][]{
                {fakeEmail, "Mrs", fakeFirstName, fakeLastName, "12345$%Na", 12, 10,"1995", fakeCompanyName, fakeAddress,
                        fakeSecondaryAddress, fakeCity,2,"00000",1,fakePhoneNumber,fakePhoneNumber,fakeAlias,"T-Shirts",
                        "2","L",1,PAYMENT_METHOD[1]},


        };
    }

    @Test(dataProvider = "ContactUs", groups = {"Smoke", "Regression"})
    public void contactUsPageTests(String email, String gender, String firstName, String lastName, String password, int days,
                                   int months, String years,String companyName, String address, String secondAddress, String city,
                                   int state,String zipcode,int country,String homeNumber,String phoneNumber,String alias,
                                   String searchProduct,String quantityOfProduct,String sizeOfProduct,int productColor,
                                   String paymentMethod)
    {
        homePage.clickSignIn();
        Assert.assertEquals(signInPage.getSubtitle(0), "CREATE AN ACCOUNT");
        signInPage.enterEmailForNewAccount(EMAIL_FOR_REGISTERED_USER);
        signInPage.clickCreateAnAccount();
        Assert.assertEquals(signInPage.getCreateAnAccountMessageError(), CREATE_AN_ACCOUNT_EMAIL_ERROR_MESSAGE);
        signInPage.clearEmail();
        signInPage.enterEmailForNewAccount(email);
        waitTime();
        signInPage.clickCreateAnAccount();
        Assert.assertEquals(methods.getTitleName(), "AUTHENTICATION");
        createAnAccount.chooseGender(gender);
        createAnAccount.enterFirstName(firstName);
        createAnAccount.enterLastName(lastName);
        createAnAccount.checkIfEmailFieldIsNotEmpty();
        createAnAccount.enterPasswordForNewUser(password);
        createAnAccount.selectDays(days);
        createAnAccount.selectMonths(months);
        createAnAccount.selectYears(years);
        createAnAccount.clickNewsletter();
        createAnAccount.clickOffers();
        Assert.assertEquals(createAnAccount.getFirstName(), createAnAccount.getFirstNameForAddress());
        Assert.assertEquals(createAnAccount.getLastName(), createAnAccount.getLastNameForAddress());
        createAnAccount.enterNameOfCompany(companyName);
        createAnAccount.enterAddress1(address);
        createAnAccount.enterAddress2(secondAddress);
        createAnAccount.enterCity(city);
        createAnAccount.selectState(state);
        createAnAccount.enterZipcode(zipcode);
        createAnAccount.selectCountry(country);
        createAnAccount.enterAddInfo("Hello");
        createAnAccount.enterHomePhone(homeNumber);
        createAnAccount.enterMobilePhone(phoneNumber);
        createAnAccount.assignAliasAddress(alias);
        createAnAccount.clickRegisterButton();
        Assert.assertEquals(myAccount.getTitleName(), MY_ACCOUNT_TITLE);

        //adding items to cart
        Assert.assertEquals(cartPage.getEmptyTextForCart(),"(empty)");
        cartPage.clickCart();
        Assert.assertEquals(cartPage.getTitleName(), CART_PAGE_TITLE);
        Assert.assertEquals(cartPage.getMessageForEmptyCart(), "Your shopping cart is empty.");
        signInPage.clickReturnHomeButton();
        homePage.searchItems(searchProduct);
        Assert.assertEquals(cartPage.getInStockText(), "In stock");
        cartPage.clickMoreForProduct(0);
        cartPage.enterWantedQuantityOfAProduct(quantityOfProduct);
        cartPage.selectProductSize(sizeOfProduct);
        cartPage.clickToChooseColorForTheProduct(productColor);
        waitTime();
        Assert.assertEquals(cartPage.getSuccessAddItemText(), "Product successfully added to your shopping cart");
        cartPage.clickContinueShoppingOrProceedToCheckout("Continue");
        homePage.clickMenuItem("Women");

        //checkout
        cartPage.clickCheckOutButton();
        cartPage.clickContinueProceedButtons("Continue");
        Assert.assertEquals(methods.getTitleName(),"ADDRESSES");
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
        cartPage.clickToChooseAPayingMethod(paymentMethod);
        Assert.assertEquals(methods.getTitleName(), "ORDER SUMMARY");
        cartPage.clickProceedForAddresses();
        Assert.assertEquals(cartPage.getTextForSuccessfulOrder(), "Your order on My Store is complete.");
        homePage.clickWhenLoggedIn();
        myAccount.clickOnOneOfTheItemsForMyAccount("Order History");
        Assert.assertEquals(methods.getTitleName(),"ORDER HISTORY");
        myAccount.chooseToDownloadPDFInvoiceForAnOrder(0);
        myAccount.clickToSeeOrdersDetails(0);
        waitTime();

    }
}
