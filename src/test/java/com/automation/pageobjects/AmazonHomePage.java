package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends BasePage {

    public AmazonHomePage(WebDriver pDriver) {
        super(pDriver);
        driver.get("https://www.amazon.com");
    }

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchInput;

    @FindBy(css = "#nav-search .nav-search-submit .nav-input")
    private WebElement searchButton;

    public AmazonResultsPage performSearch(String keyword){
        searchInput.sendKeys(keyword);
        searchButton.click();
        return new AmazonResultsPage(getDriver());
    }
}
