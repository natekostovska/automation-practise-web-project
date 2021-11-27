package com.automationpractise.pages;

import com.automationpractise.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.automationpractise.staticvariables.StaticVariables.HOME_PAGE_MENU_ITEMS;
import static com.automationpractise.staticvariables.StaticVariables.HOME_SUBMENU_ITEMS;

public class HomePage extends Methods {

    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions){
        super(driver,wait,actions);
    }

    By signIn = By.className("login");
    By contactUs=By.linkText("Contact us");
    By search=By.cssSelector("#search_query_top");
    By account=By.className("account");
    By menuItems=By.cssSelector("div#block_top_menu>ul>li");
    By submenuItem=By.xpath("//*[contains(@class,\"first-in-line-xs\")]/li/a");

    public void clickSignIn(){
        click(signIn);
    }
    public void clickContactUs(){
        click(contactUs);
    }
    public void searchItems(String searchItem){
        sendKeysEnter(search,searchItem);
    }

    public void clickWhenLoggedIn(){
        click(account);
    }
    public void hoverOverMenuItem(String menu){
        javaExecutorScrollIntoView(menuItems);
        int i=arrayListToInt(HOME_PAGE_MENU_ITEMS,menu);
        moveToElementByIndex(menuItems,i);
    }
    public void clickMenuItem(String menu){
        javaExecutorScrollIntoView(menuItems);
        int i=arrayListToInt(HOME_PAGE_MENU_ITEMS,menu);
        clickWithIndex(menuItems,i);
    }
    public void clickToChooseSubmenuItem(String menu,String submenu){
        hoverOverMenuItem(menu);
        int i=arrayListToInt(HOME_SUBMENU_ITEMS,submenu);
        moveToElementByIndex(submenuItem,i);
        clickWithIndex(submenuItem,i);
    }
}

