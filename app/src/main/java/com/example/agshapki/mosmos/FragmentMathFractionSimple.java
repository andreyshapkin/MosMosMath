package com.example.agshapki.mosmos;


import android.app.Fragment;
import android.util.Log;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMathFractionSimple extends FragmentMathBase {
    private static final String TAG = "FragmentMathFractionComplex";

    public FragmentMathFractionSimple() {
        Log.d(TAG, "FragmentMathFractionComplex: constructor");

        fragment_layout_id = R.layout.fragment_math_fraction_simple;

        widgetIDs.add(R.id.mathFractionSText0);
        widgetIDs.add(R.id.mathFractionSText1);
        widgetIDs.add(R.id.mathFractionSText2);
        widgetIDs.add(R.id.mathFractionSText3);
        widgetIDs.add(R.id.mathFractionSText4);
        widgetIDs.add(R.id.mathFractionSText5);
        widgetIDs.add(R.id.mathFractionSText6);
    }
}
