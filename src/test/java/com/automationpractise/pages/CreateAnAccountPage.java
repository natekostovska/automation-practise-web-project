package com.automationpractise.pages;

import com.automationpractise.methods.Methods;
import com.automationpractise.staticvariables.StaticVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateAnAccountPage extends Methods {

    public CreateAnAccountPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    By genders = By.className("radio");
    By firstName = By.cssSelector("#customer_firstname");
    By lastName = By.id("customer_lastname");
    By email = By.id("email");
    By pass = By.id("passwd");
    By days = By.xpath("//*[@id=\"days\"]/*");
    By months = By.xpath("//*[@id=\"months\"]/*");
    By years = By.xpath("//*[@id=\"years\"]/*");
    By newsletter = By.xpath("//*[contains(@id,\"uniform-newsletter\")]");
    By offers = By.xpath("//*[contains(@id,\"uniform-optin\")]");
    By firstNameAddress = By.cssSelector("#firstname");
    By lastNameAddress = By.cssSelector("#lastname");
    By company = By.id("company");
    By address = By.cssSelector("#address1");
    By address2 = By.cssSelector("#address2");
    By city = By.id("city");
    By state = By.cssSelector("select#id_state>option");
    By zip = By.id("postcode");
    By country = By.xpath("//*[contains(@id,\"id_country\")]/option");
    By additionalInfo = By.cssSelector("#other");
    By homePhone = By.cssSelector("#phone");
    By mobilePhone = By.id("phone_mobile");
    By aliasAddress = By.id("alias");
    By registerButton = By.id("submitAccount");

    public void chooseGender(String gender) {
        int i = arrayListToInt(StaticVariables.GENDER, gender);
        clickActionsWithIndex(genders, i);
    }

    public void enterFirstName(String firstname) {
        sendKeys(firstName, firstname);
    }

    public void enterLastName(String lastname) {
        sendKeys(lastName, lastname);
    }

    public void checkIfEmailFieldIsNotEmpty() {
        if (getEmptyAttribute(email, "value")) {
            System.out.println("Input field is empty");
        } else {
            String store = getAttribute(email, "value");
            System.out.println("Email field: " + store);
        }
    }

    public void enterPasswordForNewUser(String password) {
        if (password.length() >= 5) {
            sendKeys(pass, password);
        } else {
            System.out.println("Password should have more then 5 characters");
        }
    }

    public void selectDays(int day) {
        clickWithIndex(days, day);
    }

    public void selectMonths(int month) {
        clickWithIndex(months, month);
    }

    public void selectYears(String year) {
        List<WebElement> list = elements(years);
        for (int i = 0; i < list.size() - 1; i++) {
            if (getContainsAttribute(years, i, "value", year)) {
                clickWithIndex(years, i);
                break;
            }
        }
    }

    public void clickNewsletter() {
        click(newsletter);
    }

    public void clickOffers() {
        clickActions(offers);
    }

    public String getFirstNameForAddress() {
        return getText(firstNameAddress);
    }

    public String getLastNameForAddress() {
        return getText(lastNameAddress);
    }

    public String getFirstName() {
        return getText(firstName);
    }

    public String getLastName() {
        return getText(lastName);
    }

    public void enterNameOfCompany(String companyName) {
        javaExecutorScrollIntoView(company);
        sendKeys(company, companyName);
    }

    public void enterAddress1(String address1) {
        sendKeys(address, address1);
    }

    public void enterAddress2(String secondAddress) {
        sendKeys(address2, secondAddress);
    }

    public void enterCity(String cityName) {
        sendKeys(city, cityName);
    }

    public void selectState(int stateName) {
        clickWithIndex(state, stateName);
    }

    public void enterZipcode(String zipCode) {
        if (zipCode.length() < 5)
            System.out.println("Zip code should have format 00000");
        else
            sendKeys(zip, zipCode);
    }

    public void selectCountry(int countryName) {
        clickWithIndex(country, countryName);
    }

    public void enterAddInfo(String addInfo) {
        sendKeys(additionalInfo, addInfo);
    }

    public void enterHomePhone(String homeNumber) {
        sendKeys(homePhone, homeNumber);
    }

    public void enterMobilePhone(String mobileNumber) {
        javaExecutorScrollIntoView(mobilePhone);
        sendKeys(mobilePhone, mobileNumber);
    }

    public void assignAliasAddress(String alias) {
        javaExecutorScrollIntoView(aliasAddress);
        clear(aliasAddress);
        if (alias.length() <= 32) {
            sendKeys(aliasAddress, alias);
        } else
            System.out.println("Alias name is too long, max 32 characters");
    }

    public void clickRegisterButton() {
        clickActions(registerButton);
    }

}
