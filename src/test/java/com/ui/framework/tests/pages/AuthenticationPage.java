package com.ui.framework.tests.pages;

import com.ui.framework.base.BasePage;
import com.ui.framework.driver.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage<AuthenticationPage> {

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public String getURL() {
        return "?controller=authentication&back=my-account";
    }


    private By inputEmailCreate = By.id("email_create");
    private By btnCreateAccount = By.id("SubmitCreate");
    private By inputEmail = By.id("email");
    private By inputPasswd = By.id("passwd");
    private By linkForgotPassword = By.linkText("Forgot your password?");
    private By btnSubmitLogin = By.id("SubmitLogin");

    public CreateAccountPage createLogin(String email){

        WebUtils.fill(wd, inputEmailCreate, email);
        WebUtils.clickWithWaitForElement(wd, btnCreateAccount);

        WebUtils.waitForPageLoad(wd);

        return PageFactory.initElements(wd, CreateAccountPage.class);
    }

    public MyAccountPage existingUserLogin(String userEmail, String userPassword){
        WebUtils.fill(wd, inputEmail, userEmail);
        WebUtils.fill(wd,inputPasswd, userPassword);
        WebUtils.clickWithWaitForElement(wd, btnSubmitLogin);

        return PageFactory.initElements(wd, MyAccountPage.class);
    }
}


