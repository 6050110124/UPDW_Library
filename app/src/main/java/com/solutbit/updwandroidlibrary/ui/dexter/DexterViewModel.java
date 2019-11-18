package com.solutbit.updwandroidlibrary.ui.dexter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DexterViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DexterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}