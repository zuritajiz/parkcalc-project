package com.parkcalc.utils;

import com.parkcalc.tests.ShortTermTest;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {
    public static WebDriver driver;

    public WebUtils(WebDriver driver)  {
        ShortTermTest.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public WebElement waitForElement(By element, long timeout) {
        WebElement myElement = null;

        try {
            myElement = new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException toe) {}

        return myElement;
    }

    public WebElement waitForElement(By element) {
        return waitForElement(element, 10);
    }
}
