package com.fun.nbucurrency.modules.common;

import androidx.annotation.NonNull;
import com.fun.nbucurrency.entry.CurrencyInfo;

import java.util.Date;

public class FusedRepository extends StackRepository implements ICurrencyRepository {

    private ICurrencyRepository networkRepository = new NetworkLoadingRepository();

    @Override
    public void loadCurrencyByDate(@NonNull Date date, @NonNull String code,
                                   @NonNull IRepository.Callback<CurrencyInfo> currencyInfoCallback) {
        networkRepository.loadCurrencyByDate(date, code, currencyInfoCallback);
    }
}
