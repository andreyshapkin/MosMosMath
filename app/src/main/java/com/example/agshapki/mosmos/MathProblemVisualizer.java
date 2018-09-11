package com.example.agshapki.mosmos;

import java.util.ArrayList;
import java.util.List;

public class MathProblemVisualizer {
    String description;
    List<String> contentList = new ArrayList<String>();
    MainMathClass mainMathClass = new MainMathClass();

    String popMessage = "";

    MathProblemVisualizer() {

        for (int i=0; i<5; i++) {
            contentList.add("");
        }

        startNewProblem();
    }

    public String visualizePopMessage() {
        String result = popMessage;
        popMessage = "";
        return result;
    }

    public String visualizeStats() {
        return "Total: " + String.valueOf(mainMathClass.stats.total)
                + " right: " + String.valueOf(mainMathClass.stats.right)
                + " wrong: " + String.valueOf(mainMathClass.stats.wrong);
    }

    public void visualizeMathProblem() {
        visualizeMathProblem(mainMathClass.currentMathProblem);
    }

    public void visualizeMathProblem(MathProblem problem) {
        description = "Solve this math problem! "; // + problem.operationType.toString() + " " + String.valueOf(problem.result.get(0));
        if (problem.userAnswer.size()>0) {
            description += " " + String.valueOf(problem.userAnswer.get(0));
        }

        String operationTypeChar = getOperationTypeString(problem.operationType);

        contentList.set(0,String.valueOf(problem.operands.get(0)));
        contentList.set(1,operationTypeChar);
        contentList.set(2,String.valueOf(problem.operands.get(1)));
        contentList.set(3,"=");

        String userAnswerText = "?";
        if (problem.userAnswer.size() > 0) {
            userAnswerText = String.valueOf(problem.userAnswer.get(0));
        }
        contentList.set(4,userAnswerText);
    }

    public String getOperationTypeString(MainMathClass.OperationType operationType) {
        String operationTypeString = operationType.toString();

        if (operationTypeString.startsWith("ADD")) {
            return "+";
        }
        if (operationTypeString.startsWith("SUB")) {
            return "-";
        }
        if (operationTypeString.startsWith("MULT")) {
            return "*";
        }
        if (operationTypeString.startsWith("DIV")) {
            return "/";
        }
        return "ERROR";
    }

    public void startNewProblem() {
        mainMathClass.generate();
        visualizeMathProblem();
    }

    public void HandleNumPad(Integer number) {
        mainMathClass.AddDigitToResult(number);
        visualizeMathProblem();
    }

    public void HandleCancelButton() {
        mainMathClass.clearResult();
        visualizeMathProblem();
    }

    public void HandleEnterButton() {
        if (mainMathClass.checkResult()) {
            popMessage = "Good Job!!!";
            startNewProblem();
        } else {
            popMessage = "Ooopsy, try again!!!";
        }

    }
}
