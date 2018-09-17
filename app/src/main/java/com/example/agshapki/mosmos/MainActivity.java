package com.example.agshapki.mosmos;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    MathProblemVisualizer mathProblemVisualizer =  new MathProblemVisualizer();

    // widgets of them main activity
    TextView textViewDescription;
    TextView textViewStats;

    Map<MathProblemVisualizer.GuiViewType,FragmentMathBase> fragmentMap = new HashMap<>();
    FragmentMathBase activeFragment;

    MainActivity() {
        Log.d(TAG, "MainActivity: started");
        fragmentMap.put(MathProblemVisualizer.GuiViewType.SIMPLE,new FragmentMathSimple());
        fragmentMap.put(MathProblemVisualizer.GuiViewType.FRACTION_EXTRACT_WHOLE,new FragmentMathFractionExtractWhole());
        fragmentMap.put(MathProblemVisualizer.GuiViewType.FRACTION_SIMPLE,new FragmentMathFractionSimple());
        fragmentMap.put(MathProblemVisualizer.GuiViewType.FRACTION,new FragmentMathFractionComplex());
        fragmentMap.put(MathProblemVisualizer.GuiViewType.LCM, new FragmentMathLCM());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: main activity started");

        textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        textViewStats = (TextView) findViewById(R.id.textViewStats);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        // starting with empty fragment to avoid initialization issues
        fragmentTransaction.add(R.id.mathProblemFrame, new FragmentEmpty());

        Log.d(TAG, "onCreate: loading numPad frame");
        FragmentNumPad fragmentNumpad = new FragmentNumPad();
        fragmentNumpad.mainActivity = this;
        fragmentTransaction.add(R.id.numPadFrame, fragmentNumpad);

        fragmentTransaction.commit();

        Log.d(TAG, "onCreate: updating gui with task");
        updateGui();
    }

    private void popMessage(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void updateGui() {
        Log.d(TAG, "updateGui");

        textViewStats.setText(mathProblemVisualizer.visualizeStats());

        mathProblemVisualizer.visualizeMathProblem();

        textViewDescription.setText(mathProblemVisualizer.description);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        // FIXME - remove this dependency
        Log.d(TAG, "updateGui: loading fragment " + mathProblemVisualizer.guiViewType.toString());
        FragmentMathBase fragment = fragmentMap.get(mathProblemVisualizer.guiViewType);
        fragment.updateGui();
        fragmentTransaction.replace(R.id.mathProblemFrame, fragment);
        fragmentTransaction.commit();
        activeFragment = fragment;

        showPopMessage();
    }

    // for performance, only to re-draw
    public void updateResultsGui() {
        Log.d(TAG, "updateResultsGui");

        mathProblemVisualizer.visualizeMathProblem();
        activeFragment.updateGui();

        showPopMessage();
    }

    private void showPopMessage() {
        String popMessageStr = mathProblemVisualizer.visualizePopMessage();
        if (!popMessageStr.isEmpty()){
            popMessage(popMessageStr);
        }
    }

}
