package com.example.agshapki.mosmos;

import java.util.ArrayList;
import java.util.List;

public class MathProblem {
    public MainMathClass.OperationType operationType = MainMathClass.OperationType.INVALID;
    public List<Integer> operands = new ArrayList<Integer>();
    public List<Integer> result = new ArrayList<Integer>();

    public List<Integer> userAnswer = new ArrayList<Integer>();
    public boolean resultChecked = false;

    public boolean checkResult() {
        resultChecked = true;

        if (userAnswer.size() == 0) {
            return false;
        }
        if (result.get(0).equals(userAnswer.get(0))) {
            return true;
        }
        return false;
    }

}