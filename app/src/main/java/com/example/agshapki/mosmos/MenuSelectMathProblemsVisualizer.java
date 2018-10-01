package com.example.agshapki.mosmos;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuSelectMathProblemsVisualizer implements MenuSelectMathProblemsVisualizerInterface {

    private static final String TAG = "MenuSelectMathProblemsV";

    private ArrayList<MathGenerator.OperationType> listOfTypes = new ArrayList<>();

    MathProblemOperationTypeInterface preferenceObj;

    public MenuSelectMathProblemsVisualizer(MathProblemOperationTypeInterface preferenceObj) {
        this.preferenceObj = preferenceObj;
    }

    public void buildListOfOperationTypes() {
        if (listOfTypes.size()>0) {
            return;
        }
        Log.d(TAG, "buildListOfOperationTypes: building list of op types");
        for (MathGenerator.OperationType operationType: MathGenerator.OperationType.values() ) {
            if (operationType != MathGenerator.OperationType.INVALID) {
                listOfTypes.add(operationType);
            }
        }
    }

    public MathGenerator.OperationType getOperationType(int position) {
        return listOfTypes.get(position);
    }

    private MathProblem getMathProblem(int position) {
        MathGenerator.OperationType operationType = getOperationType(position);
        return operationType.mathProblem;
    }

    @Override
    public int getItemCount() {
        buildListOfOperationTypes();
        return listOfTypes.size();
    }

    @Override
    public String getDescription(int position) {
        buildListOfOperationTypes();
        return getMathProblem(position).getDescription();
    }

    @Override
    public String getDetailedDescription(int position) {
        buildListOfOperationTypes();
        return getMathProblem(position).getDetails();
    }

    @Override
    public boolean getSwitchState(int position) {
        return preferenceObj.getOperationTypeEnable(getOperationType(position));
    }

    @Override
    public void setSwitchState(int position, boolean state) {
        Log.d(TAG, "setSwitchState: swtich state changed " + String.valueOf(position) + " state=" + String.valueOf(state));
        preferenceObj.setOperationTypeEnable(getOperationType(position), state);
    }
}
