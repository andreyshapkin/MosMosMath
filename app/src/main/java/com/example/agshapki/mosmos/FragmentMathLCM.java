package com.example.agshapki.mosmos;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMathLCM extends FragmentMathBase {

    private static final String TAG = "FragmentMathLCM";

    @Override
    public void initFragment() {
        Log.d(TAG, "FragmentMathLCM: constructor");
        fragment_layout_id = R.layout.fragment_math_lcm;

        widgetIDs.add(R.id.mathLcmText1);
        widgetIDs.add(R.id.mathLcmText2);
        widgetIDs.add(R.id.mathLcmText3);
        widgetIDs.add(R.id.mathLcmText4);
    }

}
