package com.parkcalc.pages;


import com.parkcalc.utils.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ParkCalcPage {
    public WebDriver driver = WebUtils.getDriver();
    private WebUtils webUtils = new WebUtils(driver);

    //Parking Lot Dropdown elements
    private By parkingLotDropdown = By.id("Lot");
    private By parkingLotDropdownOptions = By.id("Lot > option");

    //Entry Date and Time elements
    private By entryTimeInput = By.id("EntryTime");
    private By entryTimeRadioButtons = By.cssSelector("input[name=\"EntryTimeAMPM\"]");
    private By entryDateInput = By.id("EntryDate");

    //Leaving Date and Time elements
    private By leavingTimeInput = By.id("ExitTime");
    private By leavingTimeRadioButtons = By.cssSelector("input[name=\"ExitTimeAMPM\"]");
    private By leavingDateInput = By.id("ExitDate");

    //Main table elements
    private By mainTableRows = By.cssSelector("table > tbody > tr");
    private By costResumeRow = By.cssSelector("table > tbody > tr:nth-child(4)");

    //Calculate button element
    private By calculateButton = By.cssSelector("input[type=submit]");

    private WebElement parkingLotDropdown() {
        return webUtils.waitForElement(parkingLotDropdown);
    }

    private WebElement entryTimeInput() {
        return webUtils.waitForElement(entryTimeInput);
    }

    private WebElement entryDateInput() {
        return webUtils.waitForElement(entryDateInput);
    }

    private WebElement leavingTimeInput() {
        return webUtils.waitForElement(leavingTimeInput);
    }

    private WebElement leavingDateInput() {
        return webUtils.waitForElement(leavingDateInput);
    }

    private WebElement costResumeRow() {
        return webUtils.waitForElement(costResumeRow);
    }

    private WebElement calculateButton() {
        return webUtils.waitForElement(calculateButton);
    }


    public ParkCalcPage(WebDriver driver) {
        webUtils.driver = driver;
    }

    public void endDriver(WebDriver driver) {
//        webUtils.driver.close();
        webUtils.driver.quit();
    }

    /**
     *
     * Elements actions
     *
     */

    //Click on Parking Lot dropdown
    public void clickParkingLotDropdown() {
        parkingLotDropdown().click();
    }

    //Select Parking Lot dropdown option
    public void selectParkingLotDropdownOption(String dropdown_option) {
        List<WebElement> options = driver.findElements(parkingLotDropdownOptions);
        for (WebElement option : options) {
            if (option.getText().equals(dropdown_option)) {
                option.click();
                break;
            }
        }
    }

    //Fill Entry Time input field
    public void fillEntryTimeInput(String value) {
        entryTimeInput().clear();
        entryTimeInput().sendKeys(value);
    }

    //Select Entry Time day period
    public void selectEntryTimeDayPeriod(String period) {
        List<WebElement> options = driver.findElements(entryTimeRadioButtons);
        for (WebElement option : options) {
            if (option.getText().equals(period)) {
                option.click();
                break;
            }
        }
    }

    //Fill Entry Date input field
    public void fillEntryDateInput(String value) {
        entryDateInput().clear();
        entryDateInput().sendKeys(value);
    }

    //Fill Leaving Time input field
    public void fillLeavingTimeInput(String value) {
        leavingTimeInput().clear();
        leavingTimeInput().sendKeys(value);
    }

    //Select Leaving Time day period
    public void selectLeavingTimeDayPeriod(String period) {
        List<WebElement> options = driver.findElements(leavingTimeRadioButtons);
        for (WebElement option : options) {
            if (option.getText().equals(period)) {
                option.click();
                break;
            }
        }
    }

    //Fill Leaving Date input field
    public void fillLeavingDateInput(String value) {
        leavingDateInput().clear();
        leavingDateInput().sendKeys(value);
    }

    //Click on Calculate button
    public void clickCalculateButton() {
        calculateButton().click();
    }

    //Get Main Table rows
    public List<WebElement> getMainTableRows() {
        List<WebElement> rows = driver.findElements(mainTableRows);
        return rows;
    }

    //Get Main Table row that contains text
    public WebElement rowWithText(String text) {
        WebElement matchingRow = null;
        List <WebElement> rows = getMainTableRows();
        for (WebElement row : rows) {
            if (row.getText().contains(text)) {
                matchingRow = row;
            }
        }
        return matchingRow;
    }

    public WebElement getCostResumeRow() {
        return costResumeRow();
    }
}
