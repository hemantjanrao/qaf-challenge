package com.hellofresh.challenge.tests.pages;

import com.hellofresh.challenge.base.BasePage;
import com.hellofresh.challenge.driver.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage<AuthenticationPage> {

    public AuthenticationPage(WebDriver driver) {
        super(driver, true);
    }

    public String getURL() {
        return "?controller=authentication&back=my-account";
    }

    @FindBy(id = "email_create")
    private WebElement inputEmailCreate;

    @FindBy(id = "SubmitCreate")
    private WebElement btnCreateAccount;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "passwd")
    private WebElement inputPasswd;

    @FindBy(linkText = "Forgot your password?")
    private WebElement linkForgotPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement btnSubmitLogin;

    public CreateAccountPage createLogin(String email){

        WebUtils.fill(inputEmailCreate, email);
        WebUtils.clickWithWaitForElement(wd, btnCreateAccount);

        WebUtils.waitForPageLoad(wd);

        return PageFactory.initElements(wd, CreateAccountPage.class);

    }

}


