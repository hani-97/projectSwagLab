package org.example.testcase;

import org.example.bases.BaseSetup;
import org.example.pages.LoginPage;
import org.example.pages.SwagPage;
import org.example.pages.YourCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YourCartTest extends BaseSetup {
    SwagPage swagPage;
    YourCartPage yourCartPage;

    @BeforeMethod
    public void loginWithValidCredentials_showSusscess() {
        LoginPage loginPage = new LoginPage(driver);
        swagPage = loginPage.loginFuntion("standard_user", "secret_sauce");
    }

    @Test
    public void verifyProductAdded(){
        yourCartPage = new YourCartPage(driver);
        swagPage.clickBtnAddToCart(0);
        swagPage.clickIconCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"), "false");
        Assert.assertTrue(yourCartPage.getTitleProduct(0).contains("Sauce Labs Backpack"),"false" );
        //System.out.println(yourCartPage.getTitleProduct(0));
    }
    @Test
    public void removeCart(){
        yourCartPage = new YourCartPage(driver);
        swagPage.addProductsToCart();
        swagPage.clickIconCart();
        yourCartPage.removeProCart(2);
    }
}
