package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NumberView {

    TextView plusResultTextView;
    Button plusButton;

    NumberPresenter presenter;
    DataBase dataBase = new DataBase();
    @BindView(R.id.div_button)
    Button divButton;
    @BindView(R.id.div_result_textView)
    TextView divResultTextView;
    @BindView(R.id.mul_button)
    Button mulButton;
    @BindView(R.id.mul_result_textView)
    TextView mulResultTextView;
    NumbrtViewModel numbrtViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        plusResultTextView = findViewById(R.id.plus_result_textView);
        plusButton = findViewById(R.id.plus_button);
        plusButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);

        presenter = new NumberPresenter(this);

        numbrtViewModel = new ViewModelProvider(this).get(NumbrtViewModel.class);
        numbrtViewModel.mulNumbersMutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mulResultTextView.setText(integer);
            }
        });

    }

    public void addNumbers() {
        plusResultTextView.setText(String.valueOf(dataBase.getNumbers().getFirstNum()
                + dataBase.getNumbers().getSecondNum()));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.plus_button) {
            addNumbers();
        }
        if (v.getId() == R.id.div_button) {
            presenter.divNumbers();
        }
        if (v.getId() == R.id.div_button) {
            numbrtViewModel.mulNumbers();
        }
    }

    @Override
    public void onGetDivNumbers(int divResult) {
        divResultTextView.setText(String.valueOf(divResult));
    }
}
