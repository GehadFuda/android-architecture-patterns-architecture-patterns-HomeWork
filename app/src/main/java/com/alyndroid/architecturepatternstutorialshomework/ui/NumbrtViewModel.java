package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class NumbrtViewModel extends ViewModel {

    MutableLiveData<Integer> mulNumbersMutableLiveData = new MutableLiveData<>();

    public void mulNumbers() {
        int mulResult = getNumbersFromDataBase().getFirstNum() * getNumbersFromDataBase().getSecondNum();
        mulNumbersMutableLiveData.setValue(mulResult);
    }

    private NumberModel getNumbersFromDataBase() {
        return new DataBase().getNumbers();
    }
}
