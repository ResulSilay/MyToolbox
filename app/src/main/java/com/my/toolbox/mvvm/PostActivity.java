package com.my.toolbox.mvvm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PostViewModel postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        postViewModel.getPosts().observe(this, s -> {

        });
    }
}
