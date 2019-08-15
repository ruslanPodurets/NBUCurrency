package com.fun.nbucurrency.network;

import com.fun.nbucurrency.entry.CurrencyInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface IRetrofitClient {

    @GET("NBUStatService/v1/statdirectory/exchange?json")
    Call<List<CurrencyInfo>> loadCurrencyByDate(@Query("valcode") String currencyCode, @Query("date") String date);
}
