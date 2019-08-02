package com.parkcalc.tests;


import com.parkcalc.pages.ParkCalcPage;
import com.parkcalc.utils.WebUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LongTermTestDDHHMM {

    public static WebDriver driver = WebUtils.getDriver();
    private ParkCalcPage parkCalcPage;


    @BeforeTest
    public void setup() {
        String driverPath = System.getProperty("user.dir") + "/src/main/resources/webdrivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://adam.goucher.ca/parkcalc");

    }

    @Test(dataProvider = "ParkCalcProvider")
    public void LongTermCorrectDays(String entryTime, String entryDate, String leavingTime,
                                       String leavingDate, String totalCost) {

        parkCalcPage = new ParkCalcPage(driver);

        parkCalcPage.clickParkingLotDropdown();
//        parkCalcPage.selectParkingLotDropdownOption("Long-Term Garage Parking");

        parkCalcPage.fillEntryTimeInput(entryTime);
//        parkCalcPage.selectEntryTimeDayPeriod("PM");
        parkCalcPage.fillEntryDateInput(entryDate);

        parkCalcPage.fillLeavingTimeInput(leavingTime);
//        parkCalcPage.selectLeavingTimeDayPeriod("PM");
        parkCalcPage.fillLeavingDateInput(leavingDate);

        parkCalcPage.clickCalculateButton();

        //Verify amount
        String costRow = parkCalcPage.getCostResumeRow().getText();

        Assertions.assertThat(costRow).contains(totalCost);
    }

    @AfterTest
    public void endSession() {
        parkCalcPage.endDriver(driver);
    }

    @DataProvider(name="ParkCalcProvider")
    public Object[][] parkCalcProvider() {
            return new Object[][]
                    {
                            { "12:00", "11/11/2019", "12:00", "11/11/2020", "366 Days, 0 Hours, 0 Minutes" },
                    };
    }
}
