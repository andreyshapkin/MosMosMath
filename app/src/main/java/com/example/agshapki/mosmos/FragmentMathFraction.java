package com.example.agshapki.mosmos;


import android.app.Fragment;
import android.util.Log;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMathFraction extends FragmentMathBase {
    private static final String TAG = "FragmentMathFraction";

    public FragmentMathFraction() {
        Log.d(TAG, "FragmentMathFraction: constructor");

        fragment_layout_id = R.layout.fragment_math_fraction;

        widgetIDs.add(R.id.mathFractionText0);
        widgetIDs.add(R.id.mathFractionText1);
        widgetIDs.add(R.id.mathFractionText2);
        widgetIDs.add(R.id.mathFractionText3);
        widgetIDs.add(R.id.mathFractionText4);
        widgetIDs.add(R.id.mathFractionText5);
        widgetIDs.add(R.id.mathFractionText6);
        widgetIDs.add(R.id.mathFractionText7);
        widgetIDs.add(R.id.mathFractionText8);
        widgetIDs.add(R.id.mathFractionText9);
    }
}
