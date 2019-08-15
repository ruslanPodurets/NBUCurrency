package com.fun.nbucurrency.modules.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.fun.nbucurrency.entry.CurrencyInfo;
import com.fun.nbucurrency.modules.common.FusedRepository;
import com.fun.nbucurrency.modules.common.ICurrencyRepository;
import com.fun.nbucurrency.modules.common.IRepository;

import java.util.Calendar;
import java.util.Date;

public class MainModel {

    private ICurrencyRepository fusedRepository = new FusedRepository();
    @Nullable
    private RefreshCallback refreshCallback;

    public MainModel(@Nullable RefreshCallback refreshCallback) {
        this.refreshCallback = refreshCallback;
    }

    @NonNull
    private Date date = Calendar.getInstance().getTime();
    @NonNull
    private String currencyCode = "USD";

    @Nullable
    private CurrencyInfo currencyInfo;
    @Nullable
    private String error;

    public void applyDate(@NonNull Date date) {
        this.date = date;
    }

    public void applyCurrencyCode(@NonNull String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getData() {
        if (currencyInfo != null) {
            return currencyInfo.getName() + " " + currencyInfo.getRate();
        }
        return error;
    }

    void loadCurrencyByDate() {
        fusedRepository.loadCurrencyByDate(date, currencyCode, currencyInfoCallback);
    }

    private final IRepository.Callback<CurrencyInfo> currencyInfoCallback =
            new IRepository.Callback<CurrencyInfo>() {
                @Override
                public void onResult(CurrencyInfo result) {
                    currencyInfo = result;
                    error = null;
                    if (refreshCallback != null) {
                        refreshCallback.onReadyToRefresh();
                    }
                }

                @Override
                public void onError(String error) {
                    MainModel.this.error = error;
                    if (refreshCallback != null) {
                        refreshCallback.onReadyToRefresh();
                    }
                }
            };


    interface RefreshCallback {
        void onReadyToRefresh();
    }
}
