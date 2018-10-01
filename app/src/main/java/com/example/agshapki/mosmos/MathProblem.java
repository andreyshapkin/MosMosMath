package com.example.agshapki.mosmos;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract public class MathProblem {
    private static final String TAG = "MathProblem";
    public static Random random = new Random();

    public MathGenerator.OperationType operationType = MathGenerator.OperationType.INVALID;
    public List<Integer> operands = new ArrayList<Integer>();
    public List<Integer> result = new ArrayList<Integer>();

    public boolean resultChecked = false;
    public List<Integer> userAnswer = new ArrayList<Integer>();
    int userAnswerIndex = 0;

    public final String getString() {
        String s = "math problem:";
        s += " type=" + operationType.toString();
        s += " ops=[" + arrayToString(operands) + "]";
        s += " res=[" + arrayToString(result) + "]";
        s += " usr=[" + arrayToString(userAnswer) + "]";
        s += " usr_idx=" + String.valueOf(userAnswerIndex);
        return s;
    }
    private final String arrayToString(List<Integer> list) {
        String s = "";
        for (int i=0;i<list.size();i++) {
            s += String.valueOf(i) + ":" + String.valueOf(list.get(i)) + " ";
        }
        return s;
    }

    public final void AddDigitToResult(Integer number) {
        while (userAnswerIndex >= userAnswer.size()) {
            userAnswer.add(0);
        }
        if (userAnswer.get(userAnswerIndex) < 1000) {
            userAnswer.set(userAnswerIndex, userAnswer.get(userAnswerIndex) * 10 + number);
        }
        Log.d(TAG, "AddDigitToResult: userIndex=" + String.valueOf(userAnswerIndex) + " userAnswer" + arrayToString(userAnswer));
    }

    public final void incrementAnswerIndex() {
        userAnswerIndex ++;
        if (userAnswerIndex >= result.size()) {
            userAnswerIndex = 0;
        }
        Log.d(TAG, "incrementResultIndex: userAnswerIndex=" + String.valueOf(userAnswerIndex));
    }

    public final void clearAll() {
        Log.d(TAG, "clearAll: cleared");
        operands.clear();
        result.clear();
        resultChecked = false;
        userAnswer.clear();
        userAnswerIndex = 0;
    }

    public final void clearAllResults() {
        Log.d(TAG, "clearAllResults: cleared");
        userAnswer.clear();
        userAnswerIndex = 0;
    }

    public boolean checkResult() {
        resultChecked = true;
        Log.d(TAG, "checkResult: checking: " + getString());

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

    public final void generate() {
        Log.d(TAG, "generate: generating new math problem");
        clearAll();
        generateMe();
        Log.d(TAG, "generate: generated new math problem " + getString());
    }
    public final void generate(MathGenerator.OperationType opType) {
        this.operationType = opType;
        generate();
    }

    abstract public void generateMe();
    abstract public String getDescription();
    public String getDetails() {throw new AssertionError("getDetails is not implemented for " + this);}

}