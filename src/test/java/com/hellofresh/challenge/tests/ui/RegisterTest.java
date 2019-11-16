package com.hellofresh.challenge.tests.ui;

import com.hellofresh.challenge.base.BaseUITest;
import com.hellofresh.challenge.tests.dto.PersonInfo;
import com.hellofresh.challenge.tests.pages.AuthenticationPage;
import com.hellofresh.challenge.tests.pages.CreateAccountPage;
import com.hellofresh.challenge.tests.pages.HomePage;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test()
    public void SignInNewCustomer() {
        AuthenticationPage authenticationPage = homePage.signIn();
        PersonInfo personInfo = PersonInfo.newInstance();
        CreateAccountPage createAccountPage = authenticationPage.createLogin(personInfo.Email);
        Assert.assertEquals(personInfo.Email, createAccountPage.getCurrentEmailAddress());

        createAccountPage.registerUser(personInfo);
    }
}
