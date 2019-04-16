package com.example.colorquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "MainActivity";
    private int score = 0;
    private TextView scoreTV;
    private TextView questionTV;
    private Button leftButton;
    private Button rightButton;
    private boolean isRightAnswer;

    private void generateQuestion () {
        Question question = new Question();
        leftButton.setBackgroundColor(question.getLeftColor());
        rightButton.setBackgroundColor(question.getRightColor());
        questionTV.setText(question.getQuestionLabel());
        isRightAnswer = question.isRightAnswer();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTV = findViewById(R.id.scoreTV);
        scoreTV.setText("Score: " + score);
        leftButton = findViewById(R.id.left);
        rightButton = findViewById(R.id.right);
        questionTV = findViewById(R.id.questionTV);
        generateQuestion();
    }

    public void ButtonTapped(View view) {
        Button btn = (Button) view;

        if(btn.getId() == R.id.left){
            if(isRightAnswer){
                score--;
                scoreTV.setText("Score: " + score);
                toast("Wrong!");
            } else {
                score++;
                scoreTV.setText("Score: " + score);
                toast("Right!");
            }
        }else{
            if(isRightAnswer){
                score++;
                scoreTV.setText("Score: " + score);
                toast("Right!");
            } else {
                score--;
                scoreTV.setText("Score: " + score);
                toast("Wrong!");
            }
        }
        generateQuestion();
    }
    private void toast (String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }}
