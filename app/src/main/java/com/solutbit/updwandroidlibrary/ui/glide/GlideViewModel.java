package com.solutbit.updwandroidlibrary.ui.glide;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GlideViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GlideViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}