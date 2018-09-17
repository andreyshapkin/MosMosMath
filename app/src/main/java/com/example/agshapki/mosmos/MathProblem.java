package com.example.agshapki.mosmos;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MathProblem {
    public MathGenerator.OperationType operationType = MathGenerator.OperationType.INVALID;
    public List<Integer> operands = new ArrayList<Integer>();
    public List<Integer> result = new ArrayList<Integer>();

    private static final String TAG = "MathProblem";

    public boolean resultChecked = false;
    public List<Integer> userAnswer = new ArrayList<Integer>();
    int userAnswerIndex = 0;

    public String toString() {
        String s = "math problem:";
        s += " type=" + operationType.toString();
        s += " ops=[" + arrayToString(operands) + "]";
        s += " res=[" + arrayToString(result) + "]";
        s += " usr=[" + arrayToString(userAnswer) + "]";
        s += " usr_idx=" + String.valueOf(userAnswerIndex);
        return s;
    }
    private String arrayToString(List<Integer> list) {
        String s = "";
        for (int i=0;i<list.size();i++) {
            s += String.valueOf(i) + ":" + String.valueOf(list.get(i)) + " ";
        }
        return s;
    }

    public void AddDigitToResult(Integer number) {
        while (userAnswerIndex >= userAnswer.size()) {
            userAnswer.add(0);
        }
        if (userAnswer.get(userAnswerIndex) < 1000) {
            userAnswer.set(userAnswerIndex, userAnswer.get(userAnswerIndex) * 10 + number);
        }
        Log.d(TAG, "AddDigitToResult: userIndex=" + String.valueOf(userAnswerIndex) + " userAnswer" + arrayToString(userAnswer));
    }

    public void incrementAnswerIndex() {
        userAnswerIndex ++;
        if (userAnswerIndex >= result.size()) {
            userAnswerIndex = 0;
        }
        Log.d(TAG, "incrementResultIndex: userAnswerIndex=" + String.valueOf(userAnswerIndex));
    }

    public void clearAllResults() {
        Log.d(TAG, "clearAllResults: cleared");
        userAnswer.clear();
        userAnswerIndex = 0;
    }

    public boolean checkResult() {
        resultChecked = true;
        Log.d(TAG, "checkResult: checking: " + toString());

        if (userAnswer.size() != result.size()) {
            Log.d(TAG, "checkResult: size does not match: false");
            return false;
        }
        for (int i = 0; i < result.size();i++) {
            if ( ! result.get(i).equals(userAnswer.get(i)) ) {
                Log.d(TAG, "checkResult: answer does no match: false");
                return false;
            }
        }
        Log.d(TAG, "checkResult: true");
        return true;
    }

}