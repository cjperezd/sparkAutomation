package com.automation.uitests;

import com.automation.PageData;
import com.automation.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTests extends BaseTest {

    AmazonHomePage home;
    AmazonResultsPage results;
    AmazonArticlePage article;
    AmazonNavigationModule navigation;
    AmazonCartPage cart;

    @BeforeMethod(alwaysRun = true)
    public void loadPage() {
        home = new AmazonHomePage(myDriver.getDriver());
        navigation = new AmazonNavigationModule(myDriver.getDriver());
        data = new PageData(AmazonTests.class.getSimpleName());
    }

    //This test and the second one could be wrapped in one and executed twice via DataProvider feature
    //...but I wanted to use my cool PageData feature to retrieve data from a Json file.
    @Test
    public void addHatForMen_Correct() {
        results = home.performSearch(data.get("searchValueForMen").toString());
        article = results.selectFirstResult();
        String quantityToSet = data.get("quantityForMenValue").toString();
        article.setQuantity(quantityToSet);
        article.addToCart();
        cart = navigation.goToCart();
        Assert.assertEquals(cart.getQuantity(0), quantityToSet);
        Assert.assertEquals(cart.getActiveCartPrice(), cart.getBuyBoxPrice());
    }

    @Test(priority = 1)
    public void addHatForWomen_Correct() {
        results = home.performSearch(data.get("searchValueForWomen").toString());
        article = results.selectFirstResult();
        String quantityToSet = data.get("quantityForWomenValue").toString();
        article.addToCart();
        cart = navigation.goToCart();
        Assert.assertEquals(cart.getQuantity(0), quantityToSet);
        Assert.assertEquals(cart.getActiveCartPrice(), cart.getBuyBoxPrice());
    }

    @Test(priority = 2)
    public void updateHatForMenQuantity_Correct() {
        cart = navigation.goToCart();
        String quantityToUpdate = data.get("quantityToUpdateForMen").toString();
        cart.setQuantity(1, quantityToUpdate);
        Assert.assertEquals(cart.getQuantity(1), quantityToUpdate);
        Assert.assertEquals(cart.getActiveCartPrice(), cart.getBuyBoxPrice());
    }

}
