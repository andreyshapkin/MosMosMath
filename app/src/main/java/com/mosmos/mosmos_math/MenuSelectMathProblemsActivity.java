package com.mosmos.mosmos_math;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MenuSelectMathProblemsActivity extends Activity  {
    private static final String TAG = "MenuSelectMathProblemsA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_select_math_problems);

        Log.d(TAG, "onCreate: creating adapter");

        // returning code to parent activity
        Intent data = new Intent();
        data.putExtra("result", 0);
        setResult(RESULT_OK, data);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.menuSelectProblemList);
        recyclerView.setAdapter(new MenuSelectMathProblemsActivityAdapter(MathProblemVisualizer.getInstance().menuMathProblems));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
