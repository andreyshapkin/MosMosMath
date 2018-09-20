package com.example.agshapki.mosmos;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

interface MainActivityInterface {
    void updateGui();
    void updateResultsGui();
}

public class MainActivity extends Activity implements MainActivityInterface {

    private static final String TAG = "MainActivity";

    MathProblemVisualizer mathProblemVisualizer =  new MathProblemVisualizer();

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor sharedPreferencesEditor;

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
        fragmentMap.put(MathProblemVisualizer.GuiViewType.FRACTION_COMPLEX,new FragmentMathFractionComplex());
        fragmentMap.put(MathProblemVisualizer.GuiViewType.LCM, new FragmentMathLCM());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferencesEditor = sharedPreferences.edit();

        Log.d(TAG, "onCreate: main activity started");

        textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        textViewStats = (TextView) findViewById(R.id.textViewStats);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        // starting with empty fragment to avoid initialization issues
        fragmentTransaction.add(R.id.mathProblemFrame, new FragmentEmpty());

        Log.d(TAG, "onCreate: loading numPad frame");
        FragmentNumPad fragmentNumpad = new FragmentNumPad();
        fragmentNumpad.activityInterface = this;
        fragmentNumpad.controlInterface = mathProblemVisualizer;
        fragmentTransaction.add(R.id.numPadFrame, fragmentNumpad);

        fragmentTransaction.commit();

        Log.d(TAG, "onCreate: updating gui with task");
        updateGui();
    }

    private void popMessage(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSelectMathProblem:
                startMenuActivity();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    static final int REQUEST_MENU_ACTIVITY = 1;  // The request code

    private void startMenuActivity() {
        Log.d(TAG, "startMenuActivity: starting menu activity");
        Intent intent = new Intent(this, MenuSelectMathProblemsActivity.class);
        startActivityForResult(intent, REQUEST_MENU_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult: ");
        // returned from menu activity
        if (requestCode==REQUEST_MENU_ACTIVITY && resultCode==RESULT_OK) {
            Log.d(TAG, "onActivityResult: returned from menu select activity, regenerate task");
            mathProblemVisualizer.regenerateMathProblem();
            updateGui();
        }
    }

    @Override
    public void updateGui() {
        Log.d(TAG, "updateGui");

        textViewStats.setText(mathProblemVisualizer.visualizeStats());

        MathVisualizerBase problemVisualizer = mathProblemVisualizer.visualizeMathProblem();
        textViewDescription.setText(problemVisualizer.description);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        // FIXME - remove this dependency
        Log.d(TAG, "updateGui: loading fragment " + problemVisualizer.guiViewType.toString());
        FragmentMathBase fragment = fragmentMap.get(problemVisualizer.guiViewType);
        fragment.updateGui();
        fragmentTransaction.replace(R.id.mathProblemFrame, fragment);
        fragmentTransaction.commit();
        activeFragment = fragment;

        showPopMessage();
    }

    // for performance, only to re-draw
    @Override
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
