package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonNavigationModule extends BasePage {

    public AmazonNavigationModule(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "#nav-tools #nav-cart")
    public WebElement cartButton;

    public AmazonCartPage goToCart() {
        cartButton.click();
        return new AmazonCartPage(getDriver());
    }
}
