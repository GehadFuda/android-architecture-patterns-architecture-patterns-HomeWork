package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NumberView {

    NumberViewModel numberViewModel;
    NumberPresenter presenter;
    DataBase dataBase = new DataBase();
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        numberViewModel = ViewModelProviders.of(this).get(NumberViewModel.class);
        binding.setViewModel(numberViewModel);
        binding.setLifecycleOwner(this);

        presenter = new NumberPresenter(this);

        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumbers();
            }
        });

        binding.divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.divNumbers();
            }
        });
    }

    public void addNumbers() {
        binding.plusResultTextView.setText(String.valueOf(dataBase.getNumbers().getFirstNum()
                + dataBase.getNumbers().getSecondNum()));
    }

    @Override
    public void onGetDivNumbers(int divResult) {
        binding.divResultTextView.setText(String.valueOf(divResult));
    }
}
