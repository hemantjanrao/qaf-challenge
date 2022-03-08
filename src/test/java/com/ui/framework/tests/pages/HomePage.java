package com.ui.framework.tests.pages;

import com.ui.framework.base.BasePage;
import com.ui.framework.driver.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage extends BasePage<HomePage> {

    By linkLogin = By.cssSelector("a.login");
    By inputSearchQuery = By.id("search_query_top");
    By btnSubmitSearch = By.name("submit_search");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getURL() {
        return "/";
    }

    public AuthenticationPage signIn(){
        WebUtils.clickWithWaitForElement(wd, linkLogin, Duration.ofMillis(5000));

        WebUtils.waitForPageLoad(wd);
        return PageFactory.initElements(wd, AuthenticationPage.class);
    }
}


