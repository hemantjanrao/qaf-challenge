package com.ui.framework.tests.pages;

import com.ui.framework.base.BasePage;
import com.ui.framework.driver.WebUtils;
import org.openqa.selenium.By;
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

    private By linkLogout = By.cssSelector("a.logout");

    public String getUserName(){
        return WebUtils.getTextValue(wd, lblMyAccount);
    }

    public boolean isLogoutLinkAvailable(){
        return WebUtils.isElementDisplayed(wd, linkLogout);
    }

    public void logoutSession(){
        WebUtils.clickWithWaitForElement(wd, linkLogout);
    }

    public WomenFashionPage gotoMenu(String menuName){
        WebUtils.navigateTo(wd, menuName);

        return PageFactory.initElements(wd, WomenFashionPage.class);
    }
}


