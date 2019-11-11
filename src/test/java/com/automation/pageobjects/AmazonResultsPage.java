package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AmazonResultsPage extends BasePage {

    public AmazonResultsPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = ".s-result-list [cel_widget_id='SEARCH_RESULTS-SEARCH_RESULTS'] img")
    private List<WebElement> resultItems;

    public AmazonArticlePage selectFirstResult(){
        resultItems.get(0).click();
        return new AmazonArticlePage(getDriver());
    }

}
