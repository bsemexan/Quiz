package com.example.android.quiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view){

        EditText answerField = (EditText) findViewById(R.id.text_thoughts);
        Editable answerEditable = answerField.getText();
        String answer = answerEditable.toString();

        CheckBox kKuanCheckbox = (CheckBox) findViewById(R.id.kkuan);
        boolean kKuan = kKuanCheckbox.isChecked();

        CheckBox kKawalCheckbox = (CheckBox) findViewById(R.id.kkawal);
        boolean kKawal = kKawalCheckbox.isChecked();

        CheckBox fujiCheckbox = (CheckBox) findViewById(R.id.lfujiwara);
        boolean lFuji = fujiCheckbox.isChecked();

        RadioButton selectJava = (RadioButton) findViewById(R.id.java);
        boolean yesJava = selectJava.isChecked();

        RadioButton openSourceAndroid = (RadioButton) findViewById(R.id.true_correct);
        boolean openAndroid = openSourceAndroid.isChecked();

        int score = calculateScore(kKuan, kKawal,lFuji, yesJava, openAndroid) + fillerAnswer(answer);

        String result = "Your score is " + score + " out of 4";
        displayResult(result);

    }

    private int calculateScore(boolean kKuan,boolean kKawal, boolean lFuji, boolean yesJava, boolean openAndroid){
        int baseScore = 0;
        if(kKuan || kKawal || lFuji){
            baseScore = baseScore + 1;
        } else {
            baseScore = baseScore;
        }

        if(yesJava){
            baseScore = baseScore + 1;
        } else {
            baseScore = baseScore;
        }

        if(openAndroid){
            baseScore = baseScore + 1;
        } else {
            baseScore = baseScore;

        }
        return baseScore;
    }

    private int fillerAnswer(String answer){
        int baseScore = 0;
        if (answer.equals("1")){
            baseScore = baseScore + 1;
        } else if(answer.equals("2")) {
            baseScore = baseScore + 1;
        } else if(answer.equals("3")) {
            baseScore = baseScore + 1;
        }  else if(answer.equals("4")) {
            baseScore = baseScore + 1;
        } else if(answer.equals("5")) {
            baseScore = baseScore + 1;
        } else{
            baseScore = baseScore;
        }
        return baseScore;
    }
    public void displayResult(String message){


        //get text from button
        TextView result = (TextView) findViewById(R.id.result);
        Context context = getApplicationContext();

        //make toast and show it
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }

}
