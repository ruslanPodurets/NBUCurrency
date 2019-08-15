package com.fun.nbucurrency.network;

import androidx.annotation.NonNull;
import com.fun.nbucurrency.entry.CurrencyInfo;

import java.util.Date;

public interface INetworkProvider {

    @NonNull
    Integer loadCurrencyByDate(@NonNull Date date, @NonNull String code,
                            @NonNull INetworkProvider.NetworkCallback<CurrencyInfo> callback);

    interface NetworkCallback<T> {

        void onSuccess(@NonNull Integer taskId, T data);

        void onError(@NonNull Integer taskId, String error, int code);

    }

}
