package com.example.agshapki.mosmos;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMathSimple extends Fragment {
    MathProblemVisualizer mathProblemVisualizer;

    public FragmentMathSimple() {
        // Required empty public constructor
    }

    List<TextView> mathProblemTextViewList = new ArrayList<TextView>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_math_simple, container, false);

        mathProblemTextViewList.add((TextView) view.findViewById(R.id.textViewProblem0));
        mathProblemTextViewList.add((TextView) view.findViewById(R.id.textViewProblem1));
        mathProblemTextViewList.add((TextView) view.findViewById(R.id.textViewProblem2));
        mathProblemTextViewList.add((TextView) view.findViewById(R.id.textViewProblem3));
        mathProblemTextViewList.add((TextView) view.findViewById(R.id.textViewProblem4));

        // without this call text is not printed until first click happens - some Frame bug
        // it's a little dangerous though - math problem has to be ready to be displayed
        updateGui();

        return view;
    }

    void updateGui () {
        for (int i=0;i<mathProblemTextViewList.size();i++) {
            mathProblemTextViewList.get(i).setText(mathProblemVisualizer.contentList.get(i));
        }
    }

}
