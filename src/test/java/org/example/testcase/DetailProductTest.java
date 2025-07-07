package org.example.testcase;

import org.example.bases.BaseSetup;
import org.example.pages.DetaiProduct;
import org.example.pages.LoginPage;
import org.example.pages.SwagPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DetailProductTest extends BaseSetup {

    SwagPage swagPage;
    DetaiProduct detailProduct;
   @BeforeMethod
    public void initLogin(){
        LoginPage loginPage = new LoginPage(driver);
       swagPage = loginPage.loginFuntion("standard_user", "secret_sauce");
    }

    @Test
    public void verifyAddToCard(){
        detailProduct = new DetaiProduct(driver);
        swagPage.clickTitleProduct(5);
        detailProduct.clickBtnAddToCard();
        swagPage.clickIconCart();
    }

}
