package com.qa.ecommerce.pageobj.android;

import com.qa.ecommerce.util.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartListPage extends AndroidActions {
    AndroidDriver driver;

    public CartListPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement toolbarTitle;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private WebElement productNameOnCartList;


    public String getTitleOfCartPage() {
        return toolbarTitle.getText();
    }

    public String getProductNameOnCartList() {
        return productNameOnCartList.getText();
    }
}
