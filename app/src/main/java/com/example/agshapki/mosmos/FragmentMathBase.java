package com.example.agshapki.mosmos;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMathBase extends Fragment {

//    public MathProblemVisualizer mathProblemVisualizer;
    public int fragment_layout_id = -1;
    public ArrayList<Integer> widgetIDs = new ArrayList<>();

    private ArrayList<TextView> mathProblemTextViewList = new ArrayList<>();
    private static final String TAG = "FragmentMathBase";

    public FragmentMathBase() {
        // Required empty public constructor
    }

    // virtual function
    public void initFragment() {
        throw new AssertionError("fragment is not initialized " + this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: creating fraction fragment");

        initFragment();

        // Inflate the layout for this fragment
        View view = inflater.inflate(fragment_layout_id, container, false);

        mathProblemTextViewList.clear();
        Log.d(TAG, "onCreateView: initializing text widgets");
        for (int ind=0;ind < widgetIDs.size();ind++) {
            TextView textView = (TextView) view.findViewById(widgetIDs.get(ind).intValue());
            if (textView==null) {
                throw new NullPointerException("no textview found with the ID");
            }
            Log.d(TAG, "onCreateView: adding widget id " + String.valueOf(widgetIDs.get(ind).intValue()) + " textView=" + textView);
            mathProblemTextViewList.add(textView);
        }

        updateGui();

        return view;
    }

    public void updateGui () {
        Log.d(TAG, "updateGui: start");

        if (mathProblemTextViewList.size()==0) {
            return;
        }
        MathProblemVisualizer mathProblemVisualizer = MathProblemVisualizer.getInstance();

        if ((mathProblemTextViewList.size() != mathProblemVisualizer.contentList.size())) {
            Log.d(TAG, "updateGui: ERROR: visualizer is out of sync on size " + mathProblemTextViewList.size() + " " + mathProblemVisualizer.contentList.size());
            throw new AssertionError();
        }

        for (int i=0;i<mathProblemTextViewList.size();i++) {

            TextView textView = mathProblemTextViewList.get(i);
            Log.d(TAG, "updateGui: ind=" + String.valueOf(i) + " updating text view " + textView);
            textView.setText(mathProblemVisualizer.contentList.get(i));

            clearColor(textView);
            if ( (mathProblemVisualizer.highlightText & (1<<i)) != 0 ) {
                highlightColor(textView);
            }
            if ( (mathProblemVisualizer.colorText & (1<<i)) != 0 ) {
                setColor(textView);
            }
        }
    }

    void setColor(TextView textView) {
        textView.setBackgroundColor(Color.YELLOW);
    }
    void highlightColor(TextView textView) {
        textView.setBackgroundColor(Color.LTGRAY);
    }
    void clearColor(TextView textView) {
        textView.setBackgroundColor(Color.TRANSPARENT);
    }
}
