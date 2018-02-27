package com.example.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Declare variables.
    int score = 0;
    RadioGroup RG1;
    RadioGroup RG2;
    RadioGroup RG3;
    RadioGroup RG5;
    CheckBox CB2;
    CheckBox CB3;
    CheckBox CB4;
    CheckBox CB1;
    EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RG1 = findViewById(R.id.RadioGroup1);
        RG2 = findViewById(R.id.RadioGroup2);
        RG3 = findViewById(R.id.RGroup3);
        RG5 = findViewById(R.id.RGroup5);

        CB2 = findViewById(R.id.second_checkbox);
        CB3 = findViewById(R.id.third_checkbox);
        CB4 = findViewById(R.id.fourth_checkbox);
        CB1 = findViewById(R.id.first_checkbox);
        answer = findViewById(R.id.answerText);
    }

    //Before the app is about to "die", we have the score in the bundle using this method
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Score1", score);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt("Score1");
    }

    // display score for each question
    public void showResult(View view) {

        CheckBox secondCheckbox = findViewById(R.id.second_checkbox);
        CheckBox thirdCheckbox = findViewById(R.id.third_checkbox);

        CheckBox checkBox1 = findViewById(R.id.fourth_checkbox);
        checkBox1.setChecked(false);

        CheckBox checkBox = findViewById(R.id.first_checkbox);
        checkBox.setChecked(false);

        boolean secondAnswer2 = secondCheckbox.isChecked();
        boolean secondAnswer3 = thirdCheckbox.isChecked();

        RadioButton Sahara = findViewById(R.id.sahara_radiobutton);
        boolean isSahara = Sahara.isChecked();

        RadioButton China = findViewById(R.id.china_radiobutton);
        boolean isChina = China.isChecked();

        RadioButton Mount_Everest = findViewById(R.id.me_radiobutton);
        boolean isMount_Everest = Mount_Everest.isChecked();


        RadioButton Vatican = findViewById(R.id.vatican_radiobutton);
        boolean isVatican = Vatican.isChecked();

        EditText answer = findViewById(R.id.answerText);
        String textAnswer = answer.getText().toString().trim().toLowerCase();

        int score = calculateScore(textAnswer, secondAnswer2, secondAnswer3, isSahara, isChina, isMount_Everest, isVatican);

        displayScore(score);
    }

    // Check if the answers are correct and add 1 point for each correct answer
    public int calculateScore(String answer, boolean secondAnswer2, boolean secondAnswer3, boolean isSahara, boolean isChina, boolean isMount_Everest, boolean isVatican) {

        int score = 0;

        if (secondAnswer3 && secondAnswer2 && !CB1.isChecked() && !CB4.isChecked()) {
            score = score + 1;
        }

        if (isSahara) {
            score = score + 1;
        }

        if (isChina) {
            score = score + 1;
        }

        if (isMount_Everest) {
            score = score + 1;
        }

        if (isVatican) {
            score = score + 1;
        }

        if (answer.equalsIgnoreCase("nile")) {
            score = score + 1;
        }
        return score;
    }

    //Display Toast message with points.
    public void displayScore(int score) {

        if (score == 0) {
            Toast.makeText(this, "You score is 0 points! You can do better! Try again!", Toast.LENGTH_LONG).show();
        } else if (score >= 4) {
            Toast.makeText(this, "You are great! Your score is: " + score + "/6.", Toast.LENGTH_LONG).show();
        } else if (score <= 3) {
            Toast.makeText(this, "You score is " + score + "/6. You can do better! Try again!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "You need to answer at least the first question!", Toast.LENGTH_LONG).show();
        }
    }

    //Resets the score of the quiz to 0.
    //Clears all RadioGroups and CheckBoxes.
    public void resetScore(View v) {
        RadioGroup radioGroup = RG1;
        radioGroup.clearCheck();

        RadioGroup radioGroup2 = findViewById(R.id.RadioGroup2);
        radioGroup2.clearCheck();

        RadioGroup radioGroup5 = findViewById(R.id.RGroup5);
        radioGroup5.clearCheck();

        RadioGroup radioGroup3 = findViewById(R.id.RGroup3);
        radioGroup3.clearCheck();

        answer.setText(null);

        CheckBox checkBox = findViewById(R.id.first_checkbox);
        checkBox.setChecked(false);

        CheckBox checkBox1 = findViewById(R.id.second_checkbox);
        checkBox1.setChecked(false);

        CheckBox checkBox2 = findViewById(R.id.third_checkbox);
        checkBox2.setChecked(false);

        CheckBox checkBox3 = findViewById(R.id.fourth_checkbox);
        checkBox3.setChecked(false);
    }
}