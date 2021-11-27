package com.automationpractise.tests.dataproviders;

import com.automationpractise.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationpractise.staticvariables.StaticVariables.*;

public class ContactUsDataProviderTests extends BaseTests {
   @DataProvider(name = "ContactUs")
    public static Object[][] dataProvider(){
     return new Object[][]{
             {1,PNG_FILE_TO_UPLOAD,"",EMAIL_FOR_REGISTERED_USER,"For any question about a product, an order"},
             {0,PNG_FILE_TO_UPLOAD,fakeMessage,EMAIL_FOR_REGISTERED_USER,""},
             {2,PNG_FILE_TO_UPLOAD,fakeMessage,"nate@com","If a technical problem occurs on this website"},

     };
   }
   @Test(dataProvider = "ContactUs",groups = {"Smoke","Regression"})
    public void contactUsPageTests(int subject,String enterFilePath,String message,String email,String response) throws IOException, InterruptedException {
       homePage.clickContactUs();
       Assert.assertEquals(contactUsPage.getTitleName(), CONTACT_US_PAGE_TITLE);
       contactUsPage.chooseSubjectHeading(subject);
       signInPage.enterEmailForRegisteredUser(email);
       contactUsPage.enterOrderReference("T-Shirt");
       contactUsPage.enterFile(enterFilePath);
       waitTime();
       contactUsPage.enterMessage(message);
       contactUsPage.clickSendButton();
       Assert.assertEquals(signInPage.getTextForError(),"There is 1 error");
   }
}
