package com.hellofresh.challenge.tests.ui;

import com.hellofresh.challenge.base.BaseUITest;
import com.hellofresh.challenge.tests.pages.HomePage;
import io.qameta.allure.Description;
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
    @Description("Send data with different data sets mentioned in data provider")
    public void TestContactUsTestWithMultipleData() {
     homePage.signIn();
     System.out.println("URL"+ homePage.getCurrentURL());
    }
}
