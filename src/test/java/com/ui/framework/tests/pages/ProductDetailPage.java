package com.ui.framework.tests.pages;

import com.ui.framework.base.BasePage;
import com.ui.framework.driver.WebUtils;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage<ProductDetailPage> {

    public ProductDetailPage(WebDriver driver) {
        super(driver, true);
    }

    public String getURL() {
        return "?id_category=3&controller=category";
    }

    public void gotoLink(String menuName){
        WebUtils.navigateTo(wd, menuName);
    }
}


