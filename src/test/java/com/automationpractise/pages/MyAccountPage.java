package com.automationpractise.pages;

import com.automationpractise.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.automationpractise.staticvariables.StaticVariables.MY_ACCOUNT_PAGE_ITEMS;

public class MyAccountPage extends Methods {

    public MyAccountPage(WebDriver driver, WebDriverWait wait, Actions actions){
        super(driver,wait,actions);
    }

    By subtitle= By.className("info-account");
    By menuItems=By.cssSelector("ul.myaccount-link-list>li>a");
    By clickHomeButton=By.xpath("//*[contains(@title,\"Home\")]");
    By invoicePDF=By.xpath("//*[contains(@title,\"Invoice\")]");
    By detailsOrder=By.xpath("//*[contains(@href,\"javascript:showOrder\")]");


    public String getWelcomeToAccountText(){
        return getText(subtitle);
    }
    public void clickOnOneOfTheItemsForMyAccount(String menuItem){
    int i=arrayListToInt(MY_ACCOUNT_PAGE_ITEMS,menuItem);
    clickWithIndex(menuItems,i);
    }
    public void chooseHomeButtonToClick(int homeButton){
        javaExecutorScrollIntoView(clickHomeButton);
        clickWithIndex(clickHomeButton,homeButton);
    }
    public void chooseToDownloadPDFInvoiceForAnOrder(int PDF){
        clickWithIndex(invoicePDF,PDF);
    }
    public void clickToSeeOrdersDetails(int details){
        clickActionsWithIndex(detailsOrder,details);
    }

}
