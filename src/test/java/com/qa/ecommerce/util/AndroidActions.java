package com.qa.ecommerce.util;

import com.google.common.collect.ImmutableMap;
import com.qa.ecommerce.base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import java.util.Map;

public class AndroidActions extends BaseTest {
    public AndroidActions(AndroidDriver driver) {

        this.driver = driver;
    }

    public void longPressAction(WebElement elementId) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) elementId).getId(), "duration", 2000
        ));
    }

    public void swipeAction(WebElement elementId, String direction) {
        Assert.assertNotNull(((RemoteWebElement) elementId).getId());
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) elementId).getId(),
                "direction", direction, "percent", 0.75
        ));
    }

    public void dragGestureAction(WebElement elementId, int x, int y) {
        Assert.assertNotNull(((RemoteWebElement) elementId).getId());
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) elementId).getId(),
                "endX", x, "endY", y
        ));
    }

    public void startActivityApp(String activity) {
        driver.executeScript("mobile: startActivity", Map.of(
                "intent", activity
        ));
    }

    public void scrollGestureAction(String setTextForScrollGesture) {
        WebElement scrollableElement = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"" + setTextForScrollGesture + "\"))"
        ));

        // Optional: Usually you want to click it after scrolling to it
        scrollableElement.click();
    }
}
