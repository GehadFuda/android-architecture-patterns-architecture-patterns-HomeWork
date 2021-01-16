package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class NumberViewModel extends ViewModel {

    public MutableLiveData<NumberModel> numbersMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Integer> mulNumbersMutableLiveData = new MutableLiveData<>();

    // get value for first time
    public void getFirstNumberFtomDataBase() {
        numbersMutableLiveData.setValue(getNumbersFromDataBase());
    }

    public void mulNumbers() {
        mulNumbersMutableLiveData.setValue(getNumbersFromDataBase().getFirstNum() * getNumbersFromDataBase().getSecondNum());
    }

    //get values from database
    private NumberModel getNumbersFromDataBase() {
        return new DataBase().getNumbers();
    }
}
