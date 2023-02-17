package com.example.mvvm.api;

import com.example.mvvm.model.ResponseConverter;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {


    @GET("convert?")
    Call<ResponseConverter> getConvertResponse(
            @Query("to") String to,
            @Query("from") String from,
            @Query("amount") String amount,
            @Header("apikey") String apikey


    );
}
