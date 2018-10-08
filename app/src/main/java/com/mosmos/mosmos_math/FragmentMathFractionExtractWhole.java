package com.mosmos.mosmos_math;


import android.app.Fragment;
import android.util.Log;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMathFractionExtractWhole extends FragmentMathBase {
    private static final String TAG = "FragmentMathFractionComplex";

    @Override
    public void initFragment() {
        Log.d(TAG, "FragmentMathFractionComplex: constructor");

        fragment_layout_id = R.layout.fragment_math_fraction_extract_whole;

        widgetIDs.add(R.id.mathFractionEHText0);
        widgetIDs.add(R.id.mathFractionEHText1);
        widgetIDs.add(R.id.mathFractionEHText2);
        widgetIDs.add(R.id.mathFractionEHText3);
        widgetIDs.add(R.id.mathFractionEHText4);
    }
}
