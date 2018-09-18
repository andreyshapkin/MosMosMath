package com.example.agshapki.mosmos;

import android.util.Log;

public class MainMathClass {
    private static final String TAG = "MainMathClass";

    MathDayStats stats = new MathDayStats();
    MathGenerator mathGenerator = new MathGenerator();
    MathProblem currentMathProblem;


    MainMathClass() {
        Log.d(TAG, "MainMathClass: constructor");
    }

    void generate() {
        Log.d(TAG, "generate: generating new problem");
        currentMathProblem = mathGenerator.generate();
    }
    
    /////////////////////////////////////////////////////////////////////
    // handlers for numpad

    public void AddDigitToResult(Integer number) {
        currentMathProblem.AddDigitToResult(number);
    }

    boolean checkResult() {
        boolean checkedBefore = currentMathProblem.resultChecked;
        boolean checkResult = currentMathProblem.checkResult();
        if (!checkedBefore) {
            if (checkResult) {
                stats.incRight();
            } else {
                stats.incWrong();
            }
            stats.incTotal();
        }
        return checkResult;
    }

    void clearResult() {
        currentMathProblem.clearAllResults();
    }

    void nextUserAnswer() {
        currentMathProblem.incrementAnswerIndex();
    }

    // End of handlers for numpad
    /////////////////////////////////////////////////////////////////////
    

}
