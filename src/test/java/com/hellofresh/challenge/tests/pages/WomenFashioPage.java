package com.hellofresh.challenge.tests.pages;

import com.hellofresh.challenge.base.BasePage;
import com.hellofresh.challenge.driver.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenFashioPage extends BasePage<WomenFashioPage> {

    public WomenFashioPage(WebDriver driver) {
        super(driver, true);
    }

    public String getURL() {
        return "?id_category=3&controller=category";
    }

    @FindBy(css = "a.account>span")
    private WebElement lblMyAccount;

    @FindBy(css = "a.logout")
    private WebElement linkLogout;

    public String getUserName(){
        return WebUtils.getTextValue(wd, lblMyAccount);
    }

    public boolean isLogoutLinkAvailable(){
        return WebUtils.isElementDisplayed(linkLogout);
    }

    public void logoutSession(){
        WebUtils.clickWithWaitForElement(wd, linkLogout);
    }

    public void gotoLink(String menuName){
        WebUtils.navigateTo(wd, menuName);
    }


}


