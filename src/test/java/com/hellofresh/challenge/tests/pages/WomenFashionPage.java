package com.hellofresh.challenge.tests.pages;

import com.hellofresh.challenge.base.BasePage;
import com.hellofresh.challenge.driver.WebUtils;
import org.openqa.selenium.WebDriver;

public class WomenFashionPage extends BasePage<WomenFashionPage> {

    public WomenFashionPage(WebDriver driver) {
        super(driver, true);
    }

    public String getURL() {
        return "?id_category=3&controller=category";
    }

    public void gotoLink(String menuName){
        WebUtils.navigateTo(wd, menuName);
    }
}


