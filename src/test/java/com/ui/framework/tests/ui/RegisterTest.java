package com.ui.framework.tests.ui;

import com.ui.framework.base.BaseUITest;
import com.ui.framework.listners.Retry;
import com.ui.framework.tests.dto.PersonInfo;
import com.ui.framework.tests.pages.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegisterTest extends BaseUITest {
    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        homePage = new HomePage(wd).navigateTo();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        homePage.navigateTo();
    }

    @AfterClass()
    public void afterTests() {
        wd.quit();
    }

    @Test(retryAnalyzer = Retry.class)
    public void SignInNewCustomer() {
        AuthenticationPage authenticationPage = homePage.signIn();
        PersonInfo personInfo = PersonInfo.newInstance();
        CreateAccountPage createAccountPage = authenticationPage.createLogin(personInfo.Email);

        MyAccountPage myAccountPage = createAccountPage.registerUser(personInfo);

        assertThat(createAccountPage.getCurrentURL().contains("?controller=my-account"));
        assertThat(myAccountPage.getUserName()).isEqualTo(personInfo.FirstName +" "+personInfo.LastName);
        assertThat(myAccountPage.isLogoutLinkAvailable());

        myAccountPage.logoutSession();
    }

//    @Test()
//    public void SignInExistingCustomer(){
//
//        String existingUserEmail = "hf_challenge_123456@hf123456.com";
//        String existingUserPassword = "12345678";
//
//        AuthenticationPage authenticationPage = homePage.signIn();
//
//        MyAccountPage myAccountPage = authenticationPage.existingUserLogin(existingUserEmail, existingUserPassword);
//
//        assertThat(myAccountPage.getCurrentURL().contains("?controller=my-account"));
//        assertThat(myAccountPage.getUserName()).isEqualTo("JUAN PEREZ");
//        assertThat(myAccountPage.isLogoutLinkAvailable());
//
//        myAccountPage.logoutSession();
//    }
//
//    @Test()
//    public void checkoutTest(){
//
//        String existingUserEmail = "hf_challenge_123456@hf123456.com";
//        String existingUserPassword = "12345678";
//
//        AuthenticationPage authenticationPage = homePage.signIn();
//        MyAccountPage myAccountPage = authenticationPage.existingUserLogin(existingUserEmail, existingUserPassword);
//        WomenFashionPage women = myAccountPage.gotoMenu("Women");
//
//        women.gotoLink("Faded Short Sleeve T-shirts");
//    }
}
