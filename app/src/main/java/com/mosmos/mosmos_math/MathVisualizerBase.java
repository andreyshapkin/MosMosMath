package com.mosmos.mosmos_math;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

abstract class MathVisualizerBase {

    private static final String TAG = "MathVisualizerBase";
    MathProblemVisualizer.GuiViewType guiViewType;

    public String description;

    public List<String> contentList = new ArrayList<String>();
    public int colorText = 0;
    public int highlightText = 0;

    public String getString() {
        String s = "visualizer: ";
        s += "cSize=" + contentList.size();
        s += "[";
        for (int i=0;i<contentList.size();i++) {
            s += "<" + contentList.get(i) + "> ";
        }
        s += "]";
        return s;
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
            //return "*";
            return "\u00D7";
        }
        if (operationTypeString.contains("DIV")) {
            //return "/";
            return "\u00F7";
        }
        return "ERROR";
    }

    public void visualize(MathProblem problem, MathProblemVisualizer.GuiViewType guiViewType) {
        this.guiViewType = guiViewType;
        contentList.clear();
        visualizeMe(problem);
        Log.d(TAG, "visualize: " + guiViewType.toString() + " " + getString());
    }
    public abstract void visualizeMe(MathProblem problem);
}
