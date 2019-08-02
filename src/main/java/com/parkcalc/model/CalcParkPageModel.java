package com.parkcalc.model;

public class CalcParkPageModel {

    private String entryTimeInput, entryDateInput;
    private String leavingTimeInput, leavingDateInput;
    private String totalCost;

    public CalcParkPageModel(String entryTimeInput, String entryDateInput, String leavingTimeInput,
                             String leavingDateInput, String totalCost) {
        this.entryTimeInput = entryTimeInput;
        this.entryDateInput = entryDateInput;
        this.leavingTimeInput = leavingTimeInput;
        this.leavingDateInput = leavingDateInput;
        this.totalCost = totalCost;
    }

    public String getEntryTimeInput() {
        return entryTimeInput;
    }

    public String getEntryDateInput() {
        return entryDateInput;
    }

    public String getLeavingTimeInput() {
        return leavingTimeInput;
    }

    public String getLeavingDateInput() {
        return leavingDateInput;
    }

    public String getTotalCost() {
        return totalCost;
    }
}
