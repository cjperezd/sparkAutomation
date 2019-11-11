package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AmazonArticlePage extends BasePage {

    public AmazonArticlePage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "#quantityRelocate_feature_div .a-dropdown-container #quantity")
    private WebElement quantityDropdown;

    private Select selectQuantityDropdown = new Select(quantityDropdown);

    @FindBy(css = "#add-to-cart-button")
    private WebElement addToCartButton;

    public void setQuantity(String value) {
        selectQuantityDropdown.selectByValue(value);
    }

    public void addToCart() {
        addToCartButton.click();
    }
}
