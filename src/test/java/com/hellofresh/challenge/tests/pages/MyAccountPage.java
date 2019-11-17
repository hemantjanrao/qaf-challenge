package com.hellofresh.challenge.tests.pages;

import com.hellofresh.challenge.base.BasePage;
import com.hellofresh.challenge.driver.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage<MyAccountPage> {

    public MyAccountPage(WebDriver driver) {
        super(driver, true);
    }

    public String getURL() {
        return "?controller=my-account";
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

    public WomenFashioPage gotoMenu(String menuName){
        WebUtils.navigateTo(wd, menuName);

        return PageFactory.initElements(wd, WomenFashioPage.class);
    }
}


