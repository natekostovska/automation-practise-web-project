package com.automationpractise.pages;

import com.automationpractise.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.automationpractise.staticvariables.StaticVariables.*;

public class CartPage extends Methods {
    public CartPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    By emptyCart = By.cssSelector("span.ajax_cart_no_product");
    By emptyCartMessage = By.cssSelector("p.alert.alert-warning");
    By cart = By.cssSelector("div.shopping_cart>a");
    By quantityWanted = By.id("quantity_wanted");
    By more = By.xpath("//*[contains(text(),'More')]");
    By productImage = By.xpath("//*[contains(@class,\"product_img_link\")]/*");
    By addToCartButtonMore=By.xpath("//*[contains(@name,\"Submit\")]");
    By addToCart = By.xpath("//*[contains(text(),'Add to cart')]");
    By size = By.tagName("option");
    By color = By.xpath("//*[contains(@id,'color_1')]");
    By wishlist = By.partialLinkText("Add to wishli");
    By inStock = By.cssSelector("span.available-now");
    By successfullyAddedProductText = By.cssSelector("h2:nth-child(2)");
    By continueProceed = By.xpath("//*[contains(@class,\"-medium\")][@title]/*");
    By continueProceedShoppingCart=By.cssSelector("p.cart_navigation>a");
    By proceedAddresses =By.cssSelector("p.cart_navigation>button");
    By deleteProduct = By.xpath("//*[contains(@class,\"icon-trash\")]");
    By termsOfService = By.id("uniform-cgv");
    By errorTextForShipping = By.cssSelector("p.fancybox-error");
    By closingError = By.xpath("//*[contains(@class,\"fancybox-close\")]");
    By payingMethod = By.xpath("//*[contains(@class,\"payment_module\")]/*");
    By paymentSuccessMessage = By.cssSelector("p.alert");
    By checkOutButton=By.id("button_order_cart");


    public String getEmptyTextForCart() {
        return getText(emptyCart);
    }

    public String getMessageForEmptyCart() {
        return getText(emptyCartMessage);
    }

    public void clickCart() {
        javaExecutorScrollIntoView(cart);
        click(cart);
    }

    public void hoverOverCart() {
        javaExecutorScrollIntoView(cart);
        moveToElement(cart);
    }

    public void hoverOverImage(int i){
        javaExecutorScrollIntoView(productImage);
        moveToElementByIndex(productImage,i);
    }


    public void clickMoreForProduct(int i) {
        hoverOverImage(i);
        javaExecutorScrollIntoView(more);
        click(more);
    }
    public void clickAddItemToCart() {
        javaExecutorScrollIntoView(addToCartButtonMore);
        click(addToCartButtonMore);
    }
    public void clickAddItemsToCart(int i){
        hoverOverImage(i);
        javaExecutorScrollIntoView(addToCart);
        clickWithIndex(addToCart,i);
    }

    public void enterWantedQuantityOfAProduct(String quantity) {
        javaExecutorScrollIntoView(quantityWanted);
        clear(quantityWanted);
        sendKeysEnter(quantityWanted, quantity);
    }

    public void selectProductSize(String enterSize) {
        int i=arrayListToInt(SIZE_OF_PRODUCT,enterSize);
       clickWithIndex(size,i);
    }

    public void clickToChooseColorForTheProduct(int i) {
        clickActionsWithIndex(color, i);
    }

    public String getInStockText() {
        return getText(inStock);
    }

    public void clickContinueShoppingOrProceedToCheckout(String chooseAction) {
        int i = arrayListToInt(CONTINUE_PROCEED, chooseAction);
        clickActionsWithIndex(continueProceed, i);
    }
    public void clickContinueProceedButtons(String chooseAction){
        int i = arrayListToInt(CONTINUE_PROCEED, chooseAction);
        clickActionsWithIndex(continueProceedShoppingCart, i);
    }

    public String getSuccessAddItemText() {
        return getText(successfullyAddedProductText);
    }

    public void clickProductForAWishlist() {
        clickActions(wishlist);
    }

    public void clickAndChooseProductToBeDeleted(int i) {
        clickActionsWithIndex(deleteProduct, i);
    }

    public void clickCheckboxForTermsOfService() {
        javaExecutorScrollIntoView(termsOfService);
        click(termsOfService);
    }

    public String getErrorTextForTermsOfService() {
        return getText(errorTextForShipping);
    }

    public void closeErrorTextForShipping() {
        click(closingError);
    }

    public void clickToChooseAPayingMethod(String payment) {
        int i = arrayListToInt(PAYMENT_METHOD, payment);
        clickActionsWithIndex(payingMethod, i);
    }

    public String getTextForSuccessfulOrder() {
        return getText(paymentSuccessMessage);
    }

    public void clickCheckOutButton(){
        hoverOverCart();
        javaExecutorScrollIntoView(checkOutButton);
        click(checkOutButton);
    }
    public void clickProceedForAddresses(){
        javaExecutorScrollIntoView(proceedAddresses);
        click(proceedAddresses);
    }

}
