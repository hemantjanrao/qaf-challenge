package com.hellofresh.challenge.tests.pages;

import com.hellofresh.challenge.base.BasePage;
import com.hellofresh.challenge.driver.WebUtils;
import com.hellofresh.challenge.tests.dto.PersonInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage<CreateAccountPage> {

    public CreateAccountPage(WebDriver driver) {
        super(driver, true);
    }

    public String getURL() {
        return "/index.php?controller=authentication&back=my-account#account-creation";
    }

    @FindBy(id = "id_gender1")
    private WebElement inputMr;

    @FindBy(id = "id_gender2")
    private WebElement inputMrs;

    @FindBy(id = "customer_firstname")
    private WebElement inputCustomerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement inputCustomerLastName;

    @FindBy(css = "div.account_creation input[id='email']")
    private WebElement inputEmail;

    @FindBy(id = "passwd")
    private WebElement inputPassword;

    @FindBy(id = "days")
    private WebElement selectDay;

    @FindBy(id = "months")
    private WebElement selectMonth;

    @FindBy(id = "years")
    private WebElement selectYear;

    @FindBy(id = "newsletter")
    private WebElement inputNewsLetter;

    @FindBy(id = "optin")
    private WebElement inputOption;

    @FindBy(id = "firstname")
    private WebElement inputFirstname;

    @FindBy(id = "lastname")
    private WebElement inputLastname;

    @FindBy(id = "company")
    private WebElement inputCompany;

    @FindBy(id = "address1")
    private WebElement inputAddress1;

    @FindBy(id = "address2")
    private WebElement inputAddress2;

    @FindBy(id = "city")
    private WebElement inputCity;

    @FindBy(id = "id_state")
    private WebElement selectState;

    @FindBy(id = "postcode")
    private WebElement inputPostCode;

    @FindBy(id = "id_country")
    private WebElement selectCountry;

    @FindBy(id = "other")
    private WebElement inputAdditionalInformation;

    @FindBy(id = "phone")
    private WebElement inputHomePhone;

    @FindBy(id = "phone_mobile")
    private WebElement inputMobilePhone;

    @FindBy(id = "alias")
    private WebElement inputAlias;

    @FindBy(id = "submitAccount")
    private WebElement btnRegister;

    public String getCurrentEmailAddress(){
        return inputEmail.getAttribute("value");
    }

    public MyAccountPage registerUser(PersonInfo personInfo){

        MyAccountPage myAccountPage = null;
        try {
            if (personInfo.Gender.equalsIgnoreCase("FEMALE")) {
                WebUtils.clickWithWaitForElement(wd, inputMrs);
            } else {
                WebUtils.clickWithWaitForElement(wd, inputMr);
            }

                WebUtils.fill(inputCustomerFirstName, personInfo.FirstName);
                WebUtils.fill(inputCustomerLastName, personInfo.LastName);
                WebUtils.fill(inputEmail, personInfo.Email);
                WebUtils.fill(inputPassword, personInfo.Password);
                WebUtils.selectByValue(wd, selectDay, String.valueOf(personInfo.Day));
                WebUtils.selectByIndex(wd, selectMonth, personInfo.Month);
                WebUtils.selectByValue(wd, selectYear, personInfo.Year);
                if(personInfo.NewsLetter) {
                    WebUtils.clickWithWaitForElement(wd, inputNewsLetter);
                }
                if(personInfo.SpecialOffers) {
                    WebUtils.clickWithWaitForElement(wd, inputOption);
                }

                WebUtils.fill(inputFirstname, personInfo.FirstName);
                WebUtils.fill(inputLastname, personInfo.LastName);
                WebUtils.fill(inputCompany, personInfo.Company);
                WebUtils.fill(inputAddress1, personInfo.Address1);
                WebUtils.fill(inputAddress2, personInfo.Address2);
                WebUtils.fill(inputCity, personInfo.City);
                WebUtils.selectByText(wd, selectState, personInfo.State);
                WebUtils.fill(inputPostCode, personInfo.PostCode);
                WebUtils.selectByText(wd, selectCountry, "United States");
                WebUtils.fill(inputAdditionalInformation, personInfo.AdditionalInformation);
                WebUtils.fill(inputHomePhone, personInfo.HomePhone);
                WebUtils.fill(inputMobilePhone, personInfo.MobilePhone);
                WebUtils.fill(inputAlias, personInfo.Alias);

                WebUtils.clickWithWaitForElement(wd, btnRegister);

                myAccountPage = PageFactory.initElements(wd, MyAccountPage.class);


            } catch (Exception ex) {
            ex.printStackTrace();
        }
        return myAccountPage;
    }

}


