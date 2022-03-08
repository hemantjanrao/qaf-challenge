package com.ui.framework.base;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public abstract class BasePage<T extends BasePage> {
    protected WebDriver wd;
    String appsUrl = System.getProperty("appsUrl");
    protected final Logger log = getLogger(lookup().lookupClass());

    public abstract String getURL();

    public BasePage(WebDriver driver) {
        this(driver, false);
    }
    public BasePage(WebDriver driver, boolean waitForLoad) {
        wd = driver;
        PageFactory.initElements(wd, this);
    }

    public void acceptAlertIfPresent(WebDriver wd) {
        try {
            wd.switchTo().alert().accept();
        } catch (NoAlertPresentException ignored) {
            // TODO: handle exception
        }
    }

    public T navigateTo() {
        log.info(String.format("Navigating to url - '%s'", getURL()));
        //String url = PropertyUtils.getsAppUrl() + getURL();
        String url = System.getProperty("appsUrl") + getURL();
        if (wd.getCurrentUrl().equals(url)) {
            wd.navigate().refresh();
        }
        wd.get(url);
        acceptAlertIfPresent(wd);
        return (T) this;
    }

    public String getCurrentURL(){
        return wd.getCurrentUrl();
    }
}
