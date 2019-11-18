package com.solutbit.updwandroidlibrary.ui.fresco;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FrescoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FrescoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}