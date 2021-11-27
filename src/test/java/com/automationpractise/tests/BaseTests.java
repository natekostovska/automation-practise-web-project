package com.automationpractise.tests;

import com.automationpractise.framework.Browsers;
import com.automationpractise.methods.Methods;
import com.automationpractise.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    Browsers browsers=new Browsers();

    private static final String URL = "http://automationpractice.com/index.php";

    public Methods methods;
    public SignInPage signInPage;
    public HomePage homePage;
    public CreateAnAccountPage createAnAccount;
    public ContactUsPage contactUsPage;
    public MyAccountPage myAccount;
    public CartPage cartPage;

    public void waitTime() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
    }

    @BeforeMethod
    public void setup(){
        driver=browsers.open("chrome");
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,20);
        actions=new Actions(driver);
        methods=new Methods(driver,wait,actions);
        signInPage =new SignInPage(driver,wait,actions);
        homePage=new HomePage(driver,wait,actions);
        createAnAccount=new CreateAnAccountPage(driver,wait,actions);
        contactUsPage=new ContactUsPage(driver,wait,actions);
        myAccount=new MyAccountPage(driver,wait,actions);
        cartPage=new CartPage(driver,wait,actions);
        waitTime();

    }
    @AfterMethod
    public void quit(){
        waitTime();
        driver.quit();
    }
}
