package com.my.toolbox.bottomSheet;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.my.toolbox.listener.UserListener;

import static com.my.toolbox.bottomSheet.BasicBottomSheet.showBasicBottomSheet;
import static java.sql.DriverManager.println;

public class SheetActivity extends AppCompatActivity implements UserListener {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showBasicBottomSheet(getSupportFragmentManager(), this);
    }

    @Override
    public void push() {
        println("push...");
    }
}
