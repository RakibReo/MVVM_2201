package com.example.mvvm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import com.example.mvvm.api.ApiService;
import com.example.mvvm.databinding.FragmentFirstBinding;
import com.example.mvvm.model.ResponseConverter;
import com.example.mvvm.retrofit.MyRetrofit;
import com.example.mvvm.rmvvm.ConverterViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FirstFragment extends Fragment {


    ConverterViewModel viewModel;
    private FragmentFirstBinding binding;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentFirstBinding.inflate(inflater, container, false);


        viewModel = ViewModelProviders.of(this).get(ConverterViewModel.class);

        viewModel.getConvertDataVM("BDT", "USD", "500");

        viewModel.responseVMLD.observe(getViewLifecycleOwner(), observer -> {

            if (observer != null){
                Log.i("TAG", "data : " + observer.getInfo().getRate());
            }


        });



        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.gotoscndBtn.setOnClickListener(v -> {
            Navigation.findNavController(getView()).navigate(R.id.action_firstFragment_to_secondFragment);


    });
    }
}