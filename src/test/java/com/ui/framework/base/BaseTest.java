package com.ui.framework.base;

import com.ui.framework.listners.CustomListener;
import com.ui.framework.utils.PropertyUtils;
import org.slf4j.Logger;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

@Listeners({CustomListener.class})
public class BaseTest {

    protected static final Logger log = getLogger(lookup().lookupClass());

    @BeforeSuite
    public void setUpEnvironment(){
        try {
            switch (PropertyUtils.getEnvironment()) {

                case "smoke":
                    System.setProperty("appsUrl", PropertyUtils.getSmokeURL());
                    log.info("Setting up SMOKE environment");
                    break;
                case "stage":
                    System.setProperty("appsUrl", PropertyUtils.getStageURL());
                    log.info("Setting up STAGING environment");
                    break;
                default:
                    System.out.println("Please provide correct environment name eg. dev, staging or local");
            }
        } catch (Exception ex){
            log.error("Setting up environment failed, Please check property file");
        }
    }

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
