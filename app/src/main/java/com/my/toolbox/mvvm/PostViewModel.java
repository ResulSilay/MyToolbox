package com.my.toolbox.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PostViewModel extends ViewModel {

    private MutableLiveData<String> postModelMutableLiveData;

    public MutableLiveData<String> getPosts(){
        postModelMutableLiveData = new MutableLiveData<>();
        return postModelMutableLiveData;
    }
}
