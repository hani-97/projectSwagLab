package org.example.pages;

import org.example.bases.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetaiProduct extends CommonAction {
    private By titleDetail = By.xpath("//div[@class='inventory_details_name large_size']");
private By btn_Add = By.xpath("//button[@id='add-to-cart']");

    public DetaiProduct(WebDriver driver) {
        super(driver);
    }
    public String getTitleProduct(){
        return driver.findElement(titleDetail).getText();
    }
    public void clickBtnAddToCard(){
        actionClick(btn_Add);
    }
}
