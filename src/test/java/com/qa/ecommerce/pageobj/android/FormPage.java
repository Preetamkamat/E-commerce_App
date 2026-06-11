package com.qa.ecommerce.pageobj.android;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.util.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class FormPage extends AndroidActions {
    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement btnLetsShop;

    @AndroidFindBy(xpath = "//android.widget.Toast")
    private WebElement toasterMessage;

    public void setNameField(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void clickBtnLetsShop() {
        btnLetsShop.click();
    }

    public String getToasterMessage() {
        return toasterMessage.getAttribute("name");
    }
}
