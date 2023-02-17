package com.example.mvvm.rmvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.model.ResponseConverter;

public class ConverterViewModel extends ViewModel {


    public LiveData<ResponseConverter> responseVMLD;


    public void getConvertDataVM(String from, String to, String amount) {
        Repository repository = new Repository();

        repository.getConvertDataREPO(to, from, amount);
        responseVMLD = repository.responseVMLD;


    }
}
