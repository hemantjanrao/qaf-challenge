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

        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        String personEmailAddress = person.getEmail();
        CreateAccountPage createAccountPage = authenticationPage.createLogin(personEmailAddress);
        PersonInfo PersonInfo = new PersonInfo();

        PersonInfo.Gender = person.getSex().toString();
        PersonInfo.CustomerFirstName = person.getFirstName();
        PersonInfo.Email = personEmailAddress;
        PersonInfo.Password = person.getPassword();
        PersonInfo.Day = 06;
        PersonInfo.Month = "October";
        PersonInfo.Year = 1988;
        PersonInfo.NewsLetter = true;
        PersonInfo.SpecialOffers = true;
        PersonInfo.FirstName = person.getFirstName();
        PersonInfo.LastName = person.getLastName();
        PersonInfo.Company = person.getCompany().toString();
        PersonInfo.Address1 = person.getAddress().getAddressLine1();
        PersonInfo.Address2 = person.getAddress().getAddressLine2();
        PersonInfo.City = person.getAddress().getCity();
        PersonInfo.State = "Albama";
        PersonInfo.PostCode = person.getAddress().getPostalCode();
        PersonInfo.Country = "United States";
        PersonInfo.AdditionalInformation = fairy.textProducer().randomString(20);
        PersonInfo.HomePhone = person.getTelephoneNumber();
        PersonInfo.MobilePhone = person.getTelephoneNumber();
        PersonInfo.Alias = fairy.textProducer().randomString(10);

        Assert.assertEquals(personEmailAddress, createAccountPage.getCurrentEmailAddress());

        createAccountPage.registerUser(PersonInfo);



    }
}
