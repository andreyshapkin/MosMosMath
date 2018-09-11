package com.example.agshapki.mosmos;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    MathProblemVisualizer mathProblemVisualizer;
    MainActivity() {
        mathProblemVisualizer = new MathProblemVisualizer();
    }

    TextView textViewDescription;
    TextView textViewStats;

    FragmentNumPad fragmentNumpad;
    FragmentMathSimple fragmentMathSimple;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: main activity started");

        textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        textViewStats = (TextView) findViewById(R.id.textViewStats);

        Log.d(TAG, "onCreate: getting fragment transaction");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        Log.d(TAG, "onCreate: loading math problem frame");

        fragmentMathSimple = new FragmentMathSimple();
        fragmentMathSimple.mathProblemVisualizer = mathProblemVisualizer;
        fragmentTransaction.add(R.id.mathProblemFrame, fragmentMathSimple);

        Log.d(TAG, "onCreate: loading numPad frame");

        fragmentNumpad = new FragmentNumPad();
        fragmentNumpad.mainActivity = this;
        fragmentTransaction.add(R.id.numPadFrame, fragmentNumpad);

        Log.d(TAG, "onCreate: committing frames");

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

        fragmentMathSimple.updateGui();

        String popMessageStr = mathProblemVisualizer.visualizePopMessage();
        if (!popMessageStr.isEmpty()){
            popMessage(popMessageStr);
        }
    }

}
