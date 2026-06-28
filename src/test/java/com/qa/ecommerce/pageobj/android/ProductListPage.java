package com.qa.ecommerce.pageobj.android;

import com.qa.ecommerce.util.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListPage extends AndroidActions {
    AndroidDriver driver;

    public ProductListPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private List<WebElement> productsName;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart[")
    private WebElement productAddToCartButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement addToCartIcon;

    public List<WebElement> getProductName() {
        List<WebElement> getProductNameText = productsName;
        return getProductNameText;
    }

    public int getProductListSize() {
        return productsName.size();
    }

    public void clickOnAddToCartIcon() {
        addToCartIcon.click();
    }

    public void clickOnTheAddToCartButton() {
        productAddToCartButton.click();
    }

}
