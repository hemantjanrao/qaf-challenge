package com.hellofresh.challenge.base;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {
    protected Logger log = Logger.getLogger(getClass());


    @BeforeClass(alwaysRun = true)
    public void baseTestBeforeClass() {
        log.info("Starting the Before class of 'Base Test'");

    }

    @AfterClass(alwaysRun = true)
    public void baseTestAfterClass() {
        log.info("Starting the After class of 'Base Test'");
    }


    @BeforeMethod(alwaysRun = true)
    public void logStartMethod(Method testMethod) {
        log.info("Starting tests method '" + testMethod.getName() + "'");
    }


    @AfterMethod(alwaysRun = true)
    public void logEndMethod(Method testMethod) {
        log.info("Ending tests method '" + testMethod.getName() + "'");
    }


}
