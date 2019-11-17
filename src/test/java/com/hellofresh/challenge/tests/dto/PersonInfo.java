package com.hellofresh.challenge.tests.dto;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

public class PersonInfo {

    public String Gender;

    public String CustomerFirstName;

    public String Email;

    public String Password;

    public int Day;

    public int Month;

    public String Year;

    public boolean NewsLetter;

    public boolean SpecialOffers;

    public String FirstName;

    public String LastName;

    public String Company;

    public String Address1;

    public String Address2;

    public String City;

    public String State;

    public String PostCode;

    public String Country;

    public String AdditionalInformation;

    public String HomePhone;

    public String MobilePhone;

    public String Alias;

    public static PersonInfo newInstance(){
        PersonInfo PersonInfo = new PersonInfo();
        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        PersonInfo.Gender = person.getSex().toString();
        PersonInfo.CustomerFirstName = person.getFirstName();
        PersonInfo.Email = person.getEmail();
        PersonInfo.Password = person.getPassword();
        PersonInfo.Day = fairy.baseProducer().randomBetween(1, 28);
        PersonInfo.Month = fairy.baseProducer().randomBetween(1, 11);
        PersonInfo.Year = "1988";
        PersonInfo.NewsLetter = true;
        PersonInfo.SpecialOffers = true;
        PersonInfo.FirstName = person.getFirstName();
        PersonInfo.LastName = person.getLastName();
        PersonInfo.Company = person.getCompany().toString();
        PersonInfo.Address1 = person.getAddress().getAddressLine1();
        PersonInfo.Address2 = person.getAddress().getAddressLine2();
        PersonInfo.City = person.getAddress().getCity();
        PersonInfo.State = "Alabama";
        PersonInfo.PostCode = person.getAddress().getPostalCode();
        PersonInfo.Country = "United States";
        PersonInfo.AdditionalInformation = fairy.textProducer().randomString(20);
        PersonInfo.HomePhone = person.getTelephoneNumber();
        PersonInfo.MobilePhone = person.getTelephoneNumber();
        PersonInfo.Alias = fairy.textProducer().randomString(10);

        return PersonInfo;
    }
}
