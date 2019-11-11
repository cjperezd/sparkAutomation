package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonCartPage extends BasePage {

    public AmazonCartPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "[name='quantity']")
    private List<WebElement> quantityDropdown;

    @FindBy(css = ".sc-subtotal #sc-subtotal-amount-activecart .sc-price")
    private WebElement subtotalActiveCart;

    @FindBy(css = ".sc-subtotal #sc-subtotal-amount-buybox .sc-price")
    private WebElement subtotalBuybox;

    public String getQuantity(int dropdownIndex) {
        Select selectQuantityDropdown = new Select(quantityDropdown.get(dropdownIndex));
        return selectQuantityDropdown.getFirstSelectedOption().getAttribute("value");
    }

    public void setQuantity(int dropdownIndex, String value) {
        Select selectQuantityDropdown = new Select(quantityDropdown.get(dropdownIndex));
        selectQuantityDropdown.selectByValue(value);
    }

    public String getActiveCartPrice() {
        return subtotalActiveCart.getText();
    }

    public String getBuyBoxPrice() {
        return subtotalBuybox.getText();
    }
}
