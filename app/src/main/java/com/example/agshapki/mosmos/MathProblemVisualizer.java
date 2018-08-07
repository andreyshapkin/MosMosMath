package com.example.agshapki.mosmos;

import java.util.ArrayList;
import java.util.List;

public class MathProblemVisualizer {
    String description;
    List<String> contentList = new ArrayList<String>();
    MainMathClass mainMathClass = new MainMathClass();

    String popMessage = "";

    MathProblemVisualizer(MainMathClass mainMathClass) {

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
        MathProblem problem = mainMathClass.currentMathProblem;
        description = "Solve this add problem";

        contentList.set(0,String.valueOf(problem.operands.get(0)));
        contentList.set(1,"+");
        contentList.set(2,String.valueOf(problem.operands.get(1)));
        contentList.set(3,"=");

        String userAnswerText = "?";
        if (problem.userAnswer.size() > 0) {
            userAnswerText = String.valueOf(problem.userAnswer.get(0));
        }
        contentList.set(4,userAnswerText);
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
        boolean userCorrect = mainMathClass.checkResult();
        if (userCorrect) {
            popMessage = "Good Job!!!";
            startNewProblem();
        } else {
            popMessage = "Ooopsy, try again!!!";
        }

    }
}
