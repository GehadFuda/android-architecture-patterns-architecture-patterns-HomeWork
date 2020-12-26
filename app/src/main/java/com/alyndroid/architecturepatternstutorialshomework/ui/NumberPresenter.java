package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class NumberPresenter {
    NumberView view;

    public NumberPresenter(NumberView view) {
        this.view = view;
    }

    public NumberModel getNumbersFromDataBase() {
        return new  DataBase().getNumbers();
    }

    public void divNumbers() {
        view.onGetDivNumbers(getNumbersFromDataBase().getFirstNum() / getNumbersFromDataBase().getSecondNum());
    }
}