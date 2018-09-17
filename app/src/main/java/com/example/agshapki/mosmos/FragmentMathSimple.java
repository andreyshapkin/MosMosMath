package com.example.agshapki.mosmos;


import android.os.Bundle;
import android.app.Fragment;
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
public class FragmentMathSimple extends FragmentMathBase {
    private static final String TAG = "FragmentMathSimple";

    public FragmentMathSimple() {
        Log.d(TAG, "FragmentMathSimple: constructor");

        fragment_layout_id = R.layout.fragment_math_simple;

        widgetIDs.add(R.id.mathSimpleText0);
        widgetIDs.add(R.id.mathSimpleText1);
        widgetIDs.add(R.id.mathSimpleText2);
        widgetIDs.add(R.id.mathSimpleText3);
        widgetIDs.add(R.id.mathSimpleText4);
    }
}
