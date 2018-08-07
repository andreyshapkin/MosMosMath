package com.example.agshapki.mosmos;

import android.app.Activity;
import android.os.Bundle;
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
    List<TextView> mathProblemTextViewList = new ArrayList<TextView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popMessage("main activity has started");

        textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        textViewStats = (TextView) findViewById(R.id.textViewStats);

        mathProblemTextViewList.add((TextView) findViewById(R.id.textViewProblem0));
        mathProblemTextViewList.add((TextView) findViewById(R.id.textViewProblem1));
        mathProblemTextViewList.add((TextView) findViewById(R.id.textViewProblem2));
        mathProblemTextViewList.add((TextView) findViewById(R.id.textViewProblem3));
        mathProblemTextViewList.add((TextView) findViewById(R.id.textViewProblem4));

        updateGui();
    }

    private void popMessage(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void NumPadClick(android.view.View view) {
        //popMessage("NumPad clicked");
        Integer number = -1;
        boolean enter = false;
        boolean cancel = false;
        switch (view.getId()) {
            case R.id.buttonNumPad0: number = 0; break;
            case R.id.buttonNumPad1: number = 1; break;
            case R.id.buttonNumPad2: number = 2; break;
            case R.id.buttonNumPad3: number = 3; break;
            case R.id.buttonNumPad4: number = 4; break;
            case R.id.buttonNumPad5: number = 5; break;
            case R.id.buttonNumPad6: number = 6; break;
            case R.id.buttonNumPad7: number = 7; break;
            case R.id.buttonNumPad8: number = 8; break;
            case R.id.buttonNumPad9: number = 9; break;
            case R.id.buttonNumPadEnter: enter = true; break;
            case R.id.buttonNumPadCancel: cancel = true; break;
            default:
                popMessage("ERROR: NumPadClick: no handler for button");
        }

        if (number>=0) {
            mathProblemVisualizer.HandleNumPad(number);
            updateGui();
        }
        if (cancel) {
            mathProblemVisualizer.HandleCancelButton();
            updateGui();
        }
        if (enter) {
            mathProblemVisualizer.HandleEnterButton();
            updateGui();
        }
    }


    private void updateGui() {
        textViewStats.setText(mathProblemVisualizer.visualizeStats());

        mathProblemVisualizer.visualizeMathProblem();

        textViewDescription.setText(mathProblemVisualizer.description);

        for (int i=0;i<mathProblemTextViewList.size();i++) {
            mathProblemTextViewList.get(i).setText(mathProblemVisualizer.contentList.get(i));
        }

        String popMessageStr = mathProblemVisualizer.visualizePopMessage();
        if (!popMessageStr.isEmpty()){
            popMessage(popMessageStr);
        }
    }

}
