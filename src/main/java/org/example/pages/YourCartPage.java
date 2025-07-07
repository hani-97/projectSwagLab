package org.example.pages;

import org.example.bases.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YourCartPage extends CommonAction {

    private By listTitlePro = By.className("inventory_item_name");
    private By listProCart = By.className("cart_item");
    private By btn_remove = By.cssSelector("button.cart_button");
    private By btn_Checkout = By.xpath("//button[@id='checkout']");


    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleProduct(int index) {
        List<WebElement> listTitle = driver.findElements(listTitlePro);
        WebElement title = listTitle.get(index);
        return title.getText();
    }

    public boolean verifyisEmpty() {
        List<WebElement> listProCarts = driver.findElements(listProCart);
        return listProCarts.isEmpty();
    }

    public void removeProCart(int index) {
        List<WebElement> btnProCarts = driver.findElements(btn_remove);
        if (!btnProCarts.isEmpty()) {
            WebElement btnPro = btnProCarts.get(index);
            btnPro.click();
        }
    }

    public void clickBtnCheckoutCart(){
        actionClick(btn_Checkout);
    }



}
