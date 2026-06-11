package com.qa.ecommerce.testcases;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.pageobj.android.FormPage;
import com.qa.ecommerce.pageobj.android.ProductList;
import com.qa.ecommerce.pageobj.android.ProductListPage;
import com.qa.ecommerce.util.AndroidActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ECommerce extends BaseTest {


    @Test(priority = 2)
    public void fillForm_TC1() {
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollGestureAction("India");
        FormPage formPage = new FormPage(driver);
        formPage.setNameField("Preetam");
        formPage.clickBtnLetsShop();
    }

    @Test(priority = 1)
    public void toastMessage_TC2() {
        FormPage formPage = new FormPage(driver);
        formPage.clickBtnLetsShop();
        //toast message
        String actualToastMessage = formPage.getToasterMessage();
        Assert.assertEquals(actualToastMessage, "Please enter your name");
    }

    @Test(priority = 2)
    public void SearchProductList_TC3() {
        AndroidActions androidActions = new AndroidActions(driver);
        androidActions.scrollGestureAction("Argentina");
        FormPage formPage = new FormPage(driver);
        formPage.setNameField("Preetam");
        formPage.clickBtnLetsShop();
        ProductListPage productNameList = new ProductListPage(driver);

        int productList = productNameList.getProductListSize();
        for (int i = 0; i < productList; i++) {
            String getProductNameText = productNameList.getProductName().get(i).getText();
            if (getProductNameText.equalsIgnoreCase("Jordan 6 Rings")) {
                productNameList.getProductName(i).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title"), "Cart"));
        WebElement cartProductElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/productName")));
        String productAddedToCart = cartProductElement.getText();
        Assert.assertEquals(productAddedToCart, "Jordan 6 Rings");
    }
}
