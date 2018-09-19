package com.example.agshapki.mosmos;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MathProblemVisualizer {

    private static final String TAG = "MathProblemVisualizer";

    // Fragments needs access to it, otherwise need to pass it to the Fragments somehow
    private static MathProblemVisualizer _static_entry = null;
    static MathProblemVisualizer getInstance() {
        if (_static_entry == null) {throw new NullPointerException();}
        return _static_entry;
    }

    public MenuSelectMathProblemsVisualizer menuMathProblems = new MenuSelectMathProblemsVisualizer();

    public enum GuiViewType {
        INVALID,
        SIMPLE,
        LCM,
        FRACTION_EXTRACT_WHOLE,
        FRACTION_SIMPLE,
        FRACTION;
    }

    // top level description
    String description;

    // textView widgets control
    GuiViewType guiViewType = GuiViewType.INVALID;
    List<String> contentList = new ArrayList<String>();
    public int colorText = 0;
    public int highlightText = 0;

    // pop message to show in the gui
    String popMessage = "";

    MainMathClass mainMathClass = new MainMathClass();

    MathProblemVisualizer() {
        Log.d(TAG, "MathProblemVisualizer: constructor");

        if (_static_entry != null) {
            Log.d(TAG, "MathProblemVisualizer: ERROR: already has instance of MathProblemVisualizer");
            throw new AssertionError();
        } else {
            _static_entry = this;
        }

        startNewProblem();
    }

    public String visualizePopMessage() {
        String result = popMessage;
        popMessage = "";
        return result;
    }

    public String visualizeStats() {
        return "Total: " + String.valueOf(mainMathClass.stats.getTotal())
                + " right: " + String.valueOf(mainMathClass.stats.getRight())
                + " wrong: " + String.valueOf(mainMathClass.stats.getWrong());
    }

    public void visualizeMathProblem() {
        visualizeMathProblem(mainMathClass.currentMathProblem);
    }

    public void visualizeMathProblem(MathProblem problem) {
        Log.d(TAG, "visualizeMathProblem: visualizing " + problem.getString());

        contentList.clear();
        // FIXME - find a better way
        if (problem.operationType.toString().startsWith("FRACT_EXTRACT")) {
            visualizeMathFractionExtractWhole(problem);
        } else if (problem.operationType.toString().startsWith("FRACT_SIMPLE")) {
            visualizeMathFractionSimple(problem);
        } else if (problem.operationType.toString().startsWith("FRACT")) {
            visualizeMathFraction(problem);
        } else if (problem.operationType.toString().startsWith("LCM")) {
            visualizeLCM(problem);
        } else {
            visualizeMathSimple(problem);
        }
        Log.d(TAG, "visualizeMathProblem: visualize: " + toString());
    }

    public String toString() {
        String s = "visualizer: ";
        s += "cSize=" + contentList.size();
        s += "[";
        for (int i=0;i<contentList.size();i++) {
            s += "<" + contentList.get(i) + "> ";
        }
        s += "]";
        return s;
    }


    private void visualizeMathSimple(MathProblem problem) {
        Log.d(TAG, "visualizeMathSimple: ");

        guiViewType = GuiViewType.SIMPLE;

        description = "Solve this math problem! "; // + problem.operationType.getString() + " " + String.valueOf(problem.result.get(0));

        contentList.add(String.valueOf(problem.operands.get(0)));
        contentList.add(getOperationTypeString(problem.operationType));
        contentList.add(String.valueOf(problem.operands.get(1)));
        contentList.add("=");

        if (problem.userAnswer.size() > 0) {
            contentList.add(String.valueOf(problem.userAnswer.get(0)));
        } else {
            contentList.add("?");
        }
    }

    private void visualizeMathFractionExtractWhole(MathProblem problem) {
        Log.d(TAG, "visualizeMathFractionExtractWhole: ");
        guiViewType = GuiViewType.FRACTION_EXTRACT_WHOLE;

        description = "Extract Whole number, do not simplify fraction! ";
        contentList.add(String.valueOf(problem.operands.get(0)));
        contentList.add(String.valueOf(problem.operands.get(1)));

        for (int i=0;i<3;i++) {
            if (i < problem.userAnswer.size()) {
                contentList.add(String.valueOf(problem.userAnswer.get(i)));
            } else {
                contentList.add("?");
            }
        }

        colorText = 1 << (2 + problem.userAnswerIndex);
        highlightText = 0x7 << 2;

    }

    private void visualizeMathFractionSimple(MathProblem problem) {
        Log.d(TAG, "visualizeMathFractionSimple: ");
        guiViewType = GuiViewType.FRACTION_SIMPLE;

        description = "Solve it, do not simplify fraction! ";
        contentList.add(String.valueOf(problem.operands.get(0)));
        contentList.add(String.valueOf(problem.operands.get(1)));
        contentList.add(getOperationTypeString(problem.operationType));
        contentList.add(String.valueOf(problem.operands.get(2)));
        contentList.add(String.valueOf(problem.operands.get(3)));

        for (int i=0;i<2;i++) {
            if (i < problem.userAnswer.size()) {
                contentList.add(String.valueOf(problem.userAnswer.get(i)));
            } else {
                contentList.add("?");
            }
        }

        colorText = 1 << (5 + problem.userAnswerIndex);
        highlightText = 0x3 << 5;

    }

    private void visualizeMathFraction(MathProblem problem) {
        Log.d(TAG, "visualizeMathFraction: ");
        guiViewType = GuiViewType.FRACTION;

        description = "Solve this math problem! "; // + problem.operationType.getString() + " " + String.valueOf(problem.result.get(0));

        contentList.add(String.valueOf(problem.operands.get(0)));
        contentList.add(String.valueOf(problem.operands.get(1)));
        contentList.add(String.valueOf(problem.operands.get(2)));
        contentList.add(getOperationTypeString(problem.operationType));
        contentList.add(String.valueOf(problem.operands.get(3)));
        contentList.add(String.valueOf(problem.operands.get(4)));
        contentList.add(String.valueOf(problem.operands.get(5)));

        for (int i=0;i<3;i++) {
            if (i < problem.userAnswer.size()) {
                contentList.add(String.valueOf(problem.userAnswer.get(i)));
            } else {
                contentList.add("?");
            }
        }

        colorText = 1 << (7 + problem.userAnswerIndex);
        highlightText = 0x7 << 7;
    }

    private void visualizeLCM(MathProblem problem) {
        Log.d(TAG, "visualizeLCM: ");

        guiViewType = GuiViewType.LCM;

        description = "Find LCM of the numbers";

        contentList.add(String.valueOf(problem.operands.get(0)));
        contentList.add(String.valueOf(problem.operands.get(1)));
        if (problem.operands.size()>2) {
            contentList.add(String.valueOf(problem.operands.get(2)));
        } else {
            contentList.add(" ");
        }
        if (problem.userAnswer.size()>0) {
            contentList.add(String.valueOf(problem.userAnswer.get(0)));
        } else {
            contentList.add("?");
        }
    }

    public String getOperationTypeString(MathGenerator.OperationType operationType) {
        String operationTypeString = operationType.toString();

        if (operationTypeString.contains("ADD")) {
            return "+";
        }
        if (operationTypeString.contains("SUB")) {
            return "-";
        }
        if (operationTypeString.contains("MULT")) {
            return "*";
        }
        if (operationTypeString.contains("DIV")) {
            return "/";
        }
        return "ERROR";
    }

    public void startNewProblem() {
        Log.d(TAG, "startNewProblem: starting new problem");
        mainMathClass.generate();
        visualizeMathProblem();
    }

    public void HandleNumPad(Integer number) {
        Log.d(TAG, "HandleNumPad: inserted number " + String.valueOf(number));
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

    public void HandleNextButton() {
        mainMathClass.nextUserAnswer();
        visualizeMathProblem();
    }
}
