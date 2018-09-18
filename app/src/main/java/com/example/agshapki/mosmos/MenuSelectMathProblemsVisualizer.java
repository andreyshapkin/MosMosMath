package com.example.agshapki.mosmos;

import android.util.Log;

public class MenuSelectMathProblemsVisualizer implements MenuSelectMathProblemsVisualizerInterface {

    private static final String TAG = "MenuSelectMathProblemsV";

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public String getDescription(int position) {
        return "Description " + String.valueOf(position);
    }

    @Override
    public String getDetailedDescription(int position) {
        return "Detailed description " + String.valueOf(position);
    }

    @Override
    public boolean getSwitchState(int position) {
        return (position & 1) == 0;
    }

    @Override
    public void setSwitchState(int position, boolean state) {
        Log.d(TAG, "setSwitchState: swtich state changed " + String.valueOf(position) + " state=" + String.valueOf(state));
    }
}
