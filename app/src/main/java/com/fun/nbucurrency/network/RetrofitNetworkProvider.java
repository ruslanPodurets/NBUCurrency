package com.fun.nbucurrency.network;

import androidx.annotation.NonNull;
import com.fun.nbucurrency.entry.CurrencyInfo;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class RetrofitNetworkProvider implements INetworkProvider {

    private static final String BASE_URL = "https://bank.gov.ua/";

    @NonNull
    private final IRetrofitClient retrofitClient;
    private final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);

    public RetrofitNetworkProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        retrofitClient = retrofit.create(IRetrofitClient.class);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @NotNull
    @Override
    public Integer loadCurrencyByDate(@NonNull Date date, @NonNull final String code,
                                      @NonNull final INetworkProvider.NetworkCallback<CurrencyInfo> callback) {
        final Integer taskId = code.hashCode() + date.hashCode();
        String dateText = format.format(date);
        retrofitClient.loadCurrencyByDate(code, dateText).enqueue(new Callback<List<CurrencyInfo>>() {
            @Override
            public void onResponse(@NotNull Call<List<CurrencyInfo>> call, @NotNull Response<List<CurrencyInfo>> response) {
                if (response.isSuccessful()) {
                    List<CurrencyInfo> info = response.body();
                    if (info != null && info.size() > 0) {
                        callback.onSuccess(taskId, info.get(0));
                        return;
                    }
                }
                callback.onError(taskId, response.message(), response.code());
            }

            @Override
            public void onFailure(@NotNull Call<List<CurrencyInfo>> call, @NotNull Throwable t) {
                callback.onError(taskId, t.getMessage(), -1);
            }
        });
        return taskId;
    }
}
