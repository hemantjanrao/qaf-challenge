package com.ui.framework.tests.pages;

import com.ui.framework.base.BasePage;
import com.ui.framework.driver.WebUtils;
import com.ui.framework.tests.dto.PersonInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage<CreateAccountPage> {

    public CreateAccountPage(WebDriver driver) {
        super(driver, true);
    }

    public String getURL() {
        return "/index.php?controller=authentication&back=my-account#account-creation";
    }

    private By inputMr = By.id("id_gender1");
    private By inputMrs = By.id("id_gender2");
    private By inputCustomerFirstName = By.id("customer_firstname");
    private By inputCustomerLastName = By.id("customer_lastname");
    private By inputEmail = By.cssSelector("div.account_creation input[id='email']");
    private By inputPassword = By.id("passwd");
    private By selectDay = By.id("days");
    private By selectMonth = By.id("months");
    private By selectYear = By.id("years");
    private By inputNewsLetter = By.cssSelector("label[for='newsletter']");
    private By inputOption = By.cssSelector("label[for='optin']");
    private By inputFirstname = By.id("firstname");
    private By inputLastname = By.id("lastname");
    private By inputCompany = By.id("company");
    private By inputAddress1 = By.id("address1");
    private By inputAddress2 = By.id("address2");
    private By inputCity = By.id("city");
    private By selectState = By.id("id_state");
    private By inputPostCode = By.id("postcode");
    private By selectCountry = By.id("id_country");
    private By inputAdditionalInformation = By.id("other");
    private By inputHomePhone = By.id("phone");
    private By inputMobilePhone = By.id("phone_mobile");
    private By inputAlias = By.id("alias");
    private By btnRegister = By.id("submitAccount");

    /*//public String getCurrentEmailAddress(){
        return inputEmail.getAttribute("value");
    }*/

    public MyAccountPage registerUser(PersonInfo personInfo){

        MyAccountPage myAccountPage = null;
        try {
            if (personInfo.Gender.equalsIgnoreCase("FEMALE")) {
                WebUtils.clickWithWaitForElement(wd, inputMrs);
            } else {
                WebUtils.clickWithWaitForElement(wd, inputMr);
            }

                WebUtils.fill(wd, inputCustomerFirstName, personInfo.FirstName);
                WebUtils.fill(wd, inputCustomerLastName, personInfo.LastName);
                WebUtils.fill(wd, inputEmail, personInfo.Email);
                WebUtils.fill(wd, inputPassword, personInfo.Password);
                WebUtils.selectByValue(wd, selectDay, String.valueOf(personInfo.Day));
                WebUtils.selectByIndex(wd, selectMonth, personInfo.Month);
                WebUtils.selectByValue(wd, selectYear, personInfo.Year);
                if(personInfo.NewsLetter) {
                    WebUtils.clickWithWaitForElement(wd, inputNewsLetter);
                }
                if(personInfo.SpecialOffers) {
                    WebUtils.clickWithWaitForElement(wd, inputOption);
                }

                WebUtils.fill(wd, inputFirstname, personInfo.FirstName);
                WebUtils.fill(wd, inputLastname, personInfo.LastName);
                WebUtils.fill(wd, inputCompany, personInfo.Company);
                WebUtils.fill(wd,inputAddress1, personInfo.Address1);
                WebUtils.fill(wd,inputAddress2, personInfo.Address2);
                WebUtils.fill(wd,inputCity, personInfo.City);
                WebUtils.selectByText(wd, selectState, personInfo.State);
                WebUtils.fill(wd,inputPostCode, personInfo.PostCode);
                WebUtils.selectByText(wd, selectCountry, "United States");
                WebUtils.fill(wd,inputAdditionalInformation, personInfo.AdditionalInformation);
                WebUtils.fill(wd,inputHomePhone, personInfo.HomePhone);
                WebUtils.fill(wd,inputMobilePhone, personInfo.MobilePhone);
                WebUtils.fill(wd,inputAlias, personInfo.Alias);

                WebUtils.clickWithWaitForElement(wd, btnRegister);

                myAccountPage = PageFactory.initElements(wd, MyAccountPage.class);

            } catch (Exception ex) {
            ex.printStackTrace();
        }
        return myAccountPage;
    }

}


