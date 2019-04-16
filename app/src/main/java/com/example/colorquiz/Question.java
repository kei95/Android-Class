package com.example.colorquiz;

import android.graphics.Color;

import java.util.Random;

public class Question {
    private  final int [] colors = {Color.BLACK, Color.GRAY,
            Color.GREEN, Color.RED,
            Color.BLUE, Color.CYAN};

    private final String[] colorsStr = {"Black", "Gray",
            "Green", "Red", "Blue", "cyan"};

    private int leftColor;
    private int rightColor;
    private String questionLabel;
    private boolean isRightAnswer;

    public Question() {
        generateQuestion();
    }

    public void generateQuestion() {




        Random rand = new Random();
        int leftRand = rand.nextInt(colors.length);
        leftColor = colors[leftRand];

        int rightRand = rand.nextInt(colors.length);
        while(rightRand == leftRand) {
            rightRand = rand.nextInt(colors.length);
        }
        rightColor = colors[rightRand];

        int[] choices = {leftRand, rightRand};
        int answerRand = rand.nextInt(choices.length);
        isRightAnswer = answerRand != 0;
        int choise = choices[answerRand];
        questionLabel = colorsStr[choise];
    }

    public boolean isRightAnswer() {
        return isRightAnswer;
    }

    public int getLeftColor() {
        return leftColor;
    }

    public int getRightColor() {
        return rightColor;
    }

    public String getQuestionLabel() {
        return questionLabel;
    }


}
