package com.fun.nbucurrency.modules.common;

import androidx.annotation.NonNull;
import com.fun.nbucurrency.entry.CurrencyInfo;

import java.util.Date;

public interface ICurrencyRepository {


   void loadCurrencyByDate(@NonNull Date date, @NonNull String code,
                                            @NonNull IRepository.Callback<CurrencyInfo> currencyInfoCallback);
}
