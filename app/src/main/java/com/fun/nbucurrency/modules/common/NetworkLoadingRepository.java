package com.fun.nbucurrency.modules.common;

import androidx.annotation.NonNull;
import com.fun.nbucurrency.entry.CurrencyInfo;
import com.fun.nbucurrency.network.INetworkProvider;
import com.fun.nbucurrency.network.RetrofitNetworkProvider;

import java.util.Date;

public class NetworkLoadingRepository extends StackRepository implements ICurrencyRepository {

    private INetworkProvider networkProvider = new RetrofitNetworkProvider();

    @Override
    public void loadCurrencyByDate(@NonNull Date date, @NonNull String code,
                            @NonNull IRepository.Callback<CurrencyInfo> currencyInfoCallback) {
        final Integer taskId = networkProvider.
                loadCurrencyByDate(date, code, new INetworkProvider.NetworkCallback<CurrencyInfo>() {
                    @Override
                    public void onSuccess(@NonNull Integer taskId, CurrencyInfo data) {
                        IRepository.Callback<CurrencyInfo> currencyInfoCallback = getCallback(taskId);
                        removeTask(taskId);
                        currencyInfoCallback.onResult(data);
                    }

                    @Override
                    public void onError(@NonNull Integer taskId, String error, int code) {
                        IRepository.Callback<CurrencyInfo> currencyInfoCallback = getCallback(taskId);
                        removeTask(taskId);
                        currencyInfoCallback.onError(error);
                    }
                });
        addTask(taskId, currencyInfoCallback);
    }


}
