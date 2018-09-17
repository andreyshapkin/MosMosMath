package com.example.agshapki.mosmos;


import android.app.Fragment;
import android.util.Log;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMathFractionComplex extends FragmentMathBase {
    private static final String TAG = "FragmentMathFractionComplex";

    @Override
    public void initFragment() {
        Log.d(TAG, "initFragment:");

        fragment_layout_id = R.layout.fragment_math_fraction_complex;

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
