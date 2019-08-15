package com.fun.nbucurrency.entry;

import com.google.gson.annotations.SerializedName;

public class CurrencyInfo {

    @SerializedName("txt")
    private String name;
    @SerializedName("rate")
    private String rate;
    @SerializedName("cc")
    private String currencyCodeName;
    @SerializedName("exchangedate")
    private String exchangeDate;
    @SerializedName("r030")
    private String currencyCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCurrencyCodeName() {
        return currencyCodeName;
    }

    public void setCurrencyCodeName(String currencyCodeName) {
        this.currencyCodeName = currencyCodeName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
