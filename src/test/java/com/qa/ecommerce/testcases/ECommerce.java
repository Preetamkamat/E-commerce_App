package com.qa.ecommerce.testcases;

import com.qa.ecommerce.base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ECommerce extends BaseTest {
    @Test(priority = 2)
    public void fillForm_TC1() {
        scrollGestureAction("India");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Preetam");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        //toast message
        String ActualToastMessage = driver.findElement(AppiumBy.xpath("//android.widget.Toast")).getText();
        Assert.assertEquals(ActualToastMessage, "Please enter your name");
    }

    @Test(priority = 1)
    public void toastMessage_TC2() {
        scrollGestureAction("India");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        //toast message
        String actualToastMessage = driver.findElement(AppiumBy.xpath("//android.widget.Toast")).getAttribute("name");
        Assert.assertEquals(actualToastMessage, "Please enter your name");
    }

    @Test(priority = 1)
    public void SearchProductList_TC3() {
        scrollGestureAction("India");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Preetam");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        //toast message
        WebElement scrollableElement = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"Jordan 6 Rings\"))"));
        List<WebElement> productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
        System.out.println(productCount.size());
        int productSize = productCount.size();
        for (int i = 0; i < productSize; i++) {
            if (productCount.get(i).getText().equalsIgnoreCase("Jordan 6 Rings")) {
                productCount.get(i).click();
            }
        }
    }
}
