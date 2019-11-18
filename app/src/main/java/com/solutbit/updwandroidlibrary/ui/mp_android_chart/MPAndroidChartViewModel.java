package com.solutbit.updwandroidlibrary.ui.mp_android_chart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MPAndroidChartViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MPAndroidChartViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}