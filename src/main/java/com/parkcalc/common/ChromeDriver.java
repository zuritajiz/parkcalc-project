package com.parkcalc.common;

import org.openqa.selenium.WebDriver;

public class ChromeDriver {
    public void chromeDriver() {
        String driverPath = System.getProperty("user.dir") + "/src/main/resources/webdrivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver chromeDriver = new org.openqa.selenium.chrome.ChromeDriver();
        chromeDriver.manage().window().maximize();
    }
}

