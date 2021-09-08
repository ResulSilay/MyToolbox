package com.my.toolbox.variable;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.my.toolbox.model.UserModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.sql.DriverManager.println;

public class VariableDefinitions {

    public VariableDefinitions() {

        int sum = 0;

        String name = "Resul";

        ArrayList<String> nameList = new ArrayList<>();

        ArrayList<UserModel> userArray = new ArrayList<>();

        List<UserModel> userList = new ArrayList<>();

        HashMap<Integer, String> users = new HashMap<>();

        MutableLiveData<UserModel> userModelMutableLiveData = new MutableLiveData<>();
        userModelMutableLiveData.postValue(new UserModel("", "", new UserModel.AddressModel("", "")));

        userModelMutableLiveData.observe((LifecycleOwner) this, userModel -> {

        });

        int[] intsArray = new int[10];
        int[] intsArray2 = new int[]{1, 2, 3, 4, 5};

        String[] stringsArray = new String[]{"a", "b", "c"};

        do {
            println("");
        } while (true);

        for (UserModel item : userArray) {
            println(item.getName());
        }

        while (sum > 0) {
            println("merhaba");
        }

    }
}
