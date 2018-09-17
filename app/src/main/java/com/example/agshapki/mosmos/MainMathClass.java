package com.example.agshapki.mosmos;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainMathClass {
    private static final String TAG = "MainMathClass";

    public class Stats {
        Integer total = 0;
        Integer right = 0;
        Integer wrong = 0;
    }

    Stats stats = new Stats();
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
                stats.right++;
            } else {
                stats.wrong++;
            }
            stats.total++;
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
