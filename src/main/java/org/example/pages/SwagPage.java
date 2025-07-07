package org.example.pages;

import org.example.utils.WaitUtils;
import org.example.bases.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SwagPage extends CommonAction {
    private WaitUtils waitHelper;
    private WebElement product;
    private By icon_menu = By.xpath("//button[@id='react-burger-menu-btn']");
    private By all_item_menu = By.xpath("//a[@id='inventory_sidebar_link']");
    private By about_menu = By.xpath("//a[@id='about_sidebar_link']");
    private By logout_menu = By.xpath("//a[@id='logout_sidebar_link']");
    private By reset_menu = By.linkText("Reset App State");
    private By icon_cart = By.xpath("//a[@class='shopping_cart_link']");
    private By productItems = By.className("inventory_item");
    private By list_title_pro = By.cssSelector(".inventory_item_name");
    private By img_product = By.className("inventory_item_img");
    private By info_product = By.className("inventory_item_label");
    private By price_product = By.className("inventory_item_price");
    private By btn_add = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private By popup_menu = By.xpath("//div[@class='bm-menu']");
private By list_btn_addToCart = By.cssSelector("button.btn_inventory");

    public SwagPage(WebDriver driver) {
        super(driver);
    }

    public void clickIconMenu() {
        actionClick(icon_menu);
    }

    public void clickAllItems() {
        actionClick(all_item_menu);
    }

    public void clickAbout() {
        actionClick(about_menu);
    }

    public void clickLogout() {
        actionClick(logout_menu);
    }

    public boolean verifyMenuDisplay() {
        return isElementDisplay(popup_menu, icon_menu, all_item_menu, about_menu, logout_menu);
    }

    public void closeAlert() {
        Assert.assertTrue(isDisplayAlert(), "Không có alert");
    }

    // Kiểm tra tồn tại các thành phần của 1 sản phẩm

    public boolean isDisplayProduct() {
        List<WebElement> products = driver.findElements(productItems);
        for (WebElement product : products) {
            if (!isElementDisplay(img_product, info_product, price_product, btn_add)) {
                return false;
            }
        }
        return true;
    }

    public void clickIconCart() {
        actionClick(icon_cart);
    }

    public void clickTitleProduct(int index) {
        List<WebElement> listTitle = driver.findElements(list_title_pro);
        WebElement title1 = listTitle.get(index);
        actionClick(title1);
    }

    public void clickImgProduct(int index) {
        List<WebElement> listImg = driver.findElements(img_product);
        WebElement imgProduct = listImg.get(index);
        actionClick(imgProduct);

    }

    public void clickBtnAddToCart(int index){
        List<WebElement> list_btnAdd = driver.findElements(list_btn_addToCart);
        WebElement btn_add = list_btnAdd.get(index);
        actionClick(btn_add);
    }

    public String getTitleProduct(int index){
        List<WebElement> listTitleProductPage = driver.findElements(list_title_pro);
        WebElement titleProductPage = listTitleProductPage.get(index);
        return titleProductPage.getText();
    }
    // add nhiều sản phầm vào giỏ hàng
    public void addProductsToCart(){
        List<WebElement> listBtnAdd = driver.findElements(list_btn_addToCart);
        for(WebElement item : listBtnAdd){
            item.click();
        }
    }

    public int getsoluongtitle(){
        List<WebElement> listTitleProductPage = driver.findElements(list_title_pro);
        return listTitleProductPage.size();
    }

}

//    public void clickProImg(int index) {
//        List<WebElement> listImgProduct = driver.findElements(img_product);
//        listImgProduct.get(index).click();
//    }
//
//    public void clickProTitle(int index) {
//        List<WebElement> listTitleProduct = driver.findElements(title_link);
//        listTitleProduct.get(index).click();
//    }
//    public void nagivateDetailProduct(){
//        List<WebElement> products = driver.findElements(productItems);
//            for( int i =0; i < products.size(); i++){
//                clickProImg(i);
//                Assert.assertTrue(driver.getCurrentUrl().contains("inventory-item.html?id="), "fail");
//                driver.navigate().back();
//                clickProTitle(i);
//                Assert.assertTrue(driver.getCurrentUrl().contains("inventory-item.html?id="), "fail");
//                driver.navigate().back();
//            }
//        }
//    }


//    public boolean verifyMenu_AllItems(){
//        return isElementDisplay(all_item_menu);
//   }
//
//    public boolean verifyMenu_AboutDisplay(){
//        return isElementDisplay(about_menu);
//    }
//    public boolean verifyMenu_LogoutDisplay(){
//        return isElementDisplay(logout_menu);
//    }
//}
