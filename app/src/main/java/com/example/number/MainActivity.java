package com.example.number;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;


    int guess;
    boolean finished;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);
        //генерация случайного числа
        guess = (int)(Math.random()*100);
        finished = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void onMyButtonClick (View view) {
        Toast.makeText(this, "Выход", Toast.LENGTH_SHORT).show();
        finish();
        System.exit(0);
    }


    public void onClick(View view) {
        if (etInput.getText().length() == 0)
            tvInfo.setText("Вы еще не ввели число!");

        else if (!finished){
            int value = Integer.parseInt(etInput.getText().toString());
            if (value >= 101)
                tvInfo.setText(getResources().getString(R.string.error));
            if (value > guess &&  value <=100)
                tvInfo.setText(getResources().getString(R.string.ahead));
            if (value < guess)
                tvInfo.setText(getResources().getString(R.string.behind));
            if (value == guess) {
                tvInfo.setText(getResources().getString(R.string.hit));
                bControl.setText(getResources().getString(R.string.play_more));
                finished = true; } }
        else {
            guess = (int)(Math.random()*100);
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            finished = false;
        }

        etInput.setText(""); }




}

