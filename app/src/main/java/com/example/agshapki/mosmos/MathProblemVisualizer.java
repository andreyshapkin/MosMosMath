package com.example.agshapki.mosmos;

import android.util.Log;

public class MathProblemVisualizer implements NumPadControlInterface {

    private static final String TAG = "MathProblemVisualizer";

    public enum GuiViewType {
        INVALID                     (null,null),
        SIMPLE                      (new MathVisualizerSimple()                 , new FragmentMathSimple()),
        LCM                         (new MathVisualizerLCM()                    , new FragmentMathLCM()),
        FRACTION_EXTRACT_WHOLE      (new MathVisualizerFractionExtractWhole()   , new FragmentMathFractionExtractWhole()),
        FRACTION_SIMPLE             (new MathVisualizerFractionSimple()         , new FragmentMathFractionSimple()),
        FRACTION_COMPLEX            (new MathVisualizerFractionComplex()        , new FragmentMathFractionComplex());

        public MathVisualizerBase problemVisualizer;
        public FragmentMathBase fragmentMath;

        GuiViewType(MathVisualizerBase problemVisualizer, FragmentMathBase fragmentMath) {
            Log.d(TAG, "GuiViewType: creating new  instance " + this.toString());
            this.problemVisualizer = problemVisualizer;
            this.fragmentMath = fragmentMath;
        }
    }


    // Fragments needs access to it, otherwise need to pass it to the Fragments somehow
    private static MathProblemVisualizer _static_entry = null;
    static MathProblemVisualizer getInstance() {
        if (_static_entry == null) {throw new NullPointerException();}
        return _static_entry;
    }

    MathDayStats stats = new MathDayStats();
    SoundMaker soundMaker = new SoundMaker();
    MathGenerator mathGenerator = new MathGenerator();
    MathProblem currentMathProblem;

    MenuSelectMathProblemsVisualizer menuMathProblems = new MenuSelectMathProblemsVisualizer(mathGenerator);

    // pop message to show in the gui
    String popMessage = "";

    MathProblemVisualizer() {
        Log.d(TAG, "MathProblemVisualizer: constructor");

        if (_static_entry != null) {
            Log.d(TAG, "MathProblemVisualizer: ERROR: already has instance of MathProblemVisualizer");
            throw new AssertionError();
        } else {
            _static_entry = this;
        }
    }

    public String visualizePopMessage() {
        String result = popMessage;
        popMessage = "";
        return result;
    }

    public String visualizeStats() {
        return "Total: " + String.valueOf(stats.getTotal())
                + " right: " + String.valueOf(stats.getRight())
                + " wrong: " + String.valueOf(stats.getWrong());
    }

    public MathVisualizerBase visualizeMathProblem() {
        if (currentMathProblem == null) {
            regenerateMathProblem();
        }
        return visualizeMathProblem(currentMathProblem);
    }

    public MathVisualizerBase visualizeMathProblem(MathProblem problem) {
        Log.d(TAG, "visualizeMathProblem: visualizing " + problem.getString());

        GuiViewType guiViewType = problem.operationType.viewType;
        MathVisualizerBase problemVisualizer = guiViewType.problemVisualizer;
        problemVisualizer.visualize(problem, guiViewType);

        return problemVisualizer;
    }


    public void startNewProblem() {
        Log.d(TAG, "startNewProblem: starting new problem");
        currentMathProblem = mathGenerator.generate();
    }

    public void regenerateMathProblem() {
        Log.d(TAG, "restartProblemGeneration: regenerating list and problem");
        mathGenerator.buildListOfMathProblems();
        startNewProblem();
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

    @Override
    public void HandleNumPad(Integer number) {
        Log.d(TAG, "HandleNumPad: inserted number " + String.valueOf(number));
        currentMathProblem.AddDigitToResult(number);
        visualizeMathProblem();
    }

    @Override
    public void HandleCancelButton() {
        currentMathProblem.clearAllResults();
        visualizeMathProblem();
    }

    @Override
    public void HandleEnterButton() {
        if (checkResult()) {
            popMessage = "Good Job!!!";
            soundMaker.playGood();
            startNewProblem();
        } else {
            soundMaker.playBad();
            popMessage = "Ooopsy, try again!!!";
        }
    }

    @Override
    public void HandleNextButton() {
        currentMathProblem.incrementAnswerIndex();
        visualizeMathProblem();
    }

}
