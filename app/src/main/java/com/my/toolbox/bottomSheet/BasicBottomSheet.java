package com.my.toolbox.bottomSheet;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.my.toolbox.listener.UserListener;

public class BasicBottomSheet extends BottomSheetDialogFragment {

    private UserListener userListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userListener.push();
    }

    private void setUserListener(UserListener userListener) {
        this.userListener = userListener;
    }

    public static BasicBottomSheet showBasicBottomSheet(FragmentManager fragmentManager, UserListener userListener) {
        BasicBottomSheet basicBottomSheet = new BasicBottomSheet();
        basicBottomSheet.setUserListener(userListener);

        Bundle bundle = new Bundle();
        bundle.putString("name", "Resul");
        basicBottomSheet.setArguments(bundle);

        basicBottomSheet.show(fragmentManager, BasicBottomSheet.class.getName());

        return basicBottomSheet;
    }
}
