package com.example.mvvm.rmvvm;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm.Utils;
import com.example.mvvm.api.ApiService;
import com.example.mvvm.model.ResponseConverter;
import com.example.mvvm.retrofit.MyRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    public MutableLiveData<ResponseConverter> responseVMLD = new MutableLiveData<>();

    public void getConvertDataREPO(String from, String to, String amount) {


        ApiService apiService = MyRetrofit.getRetrofit().create(ApiService.class);
        Call<ResponseConverter> response = apiService.getConvertResponse(to, from, amount, Utils.apiKey);

        response.enqueue(new Callback<ResponseConverter>() {
            @Override
            public void onResponse(Call<ResponseConverter> call, Response<ResponseConverter> response) {

                Log.i("TAG", "onResponse: " + response.code());


                if (response.isSuccessful()) {
                    Log.i("TAG", "onResponse: " + response.body().getInfo().getRate());


                    responseVMLD.postValue(response.body());
                }


            }

            @Override
            public void onFailure(Call<ResponseConverter> call, Throwable t) {
                Log.i("TAG", "onResponse: " + t.getMessage());
            }
        });




    }


}
