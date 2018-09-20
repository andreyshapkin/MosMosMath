package com.example.agshapki.mosmos;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNumPad extends Fragment implements View.OnClickListener {

    MainActivityInterface activityInterface;
    NumPadControlInterface controlInterface;

    private static final String TAG = "NumPad";

    public FragmentNumPad() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numpad, container, false);

        ((Button) view.findViewById(R.id.buttonNumPad0)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.buttonNumPad1)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.buttonNumPad2)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.buttonNumPad3)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.buttonNumPad4)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.buttonNumPad5)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.buttonNumPad6)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.buttonNumPad7)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.buttonNumPad8)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.buttonNumPad9)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.buttonNumPadEnter)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.buttonNumPadCancel)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.buttonNumPadNext)).setOnClickListener(this);

        return view;
    }

    private void popMessage(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "NumPadClick: clicked NumPad " + String.valueOf(view.getId()));
        //popMessage("NumPad clicked");

        Integer number = -1;
        boolean enter = false;
        boolean cancel = false;
        boolean next = false;
        switch (view.getId()) {
            case R.id.buttonNumPad0: number = 0; break;
            case R.id.buttonNumPad1: number = 1; break;
            case R.id.buttonNumPad2: number = 2; break;
            case R.id.buttonNumPad3: number = 3; break;
            case R.id.buttonNumPad4: number = 4; break;
            case R.id.buttonNumPad5: number = 5; break;
            case R.id.buttonNumPad6: number = 6; break;
            case R.id.buttonNumPad7: number = 7; break;
            case R.id.buttonNumPad8: number = 8; break;
            case R.id.buttonNumPad9: number = 9; break;
            case R.id.buttonNumPadEnter: enter = true; break;
            case R.id.buttonNumPadCancel: cancel = true; break;
            case R.id.buttonNumPadNext: next = true; break;
            default:
                popMessage("ERROR: NumPadClick: no handler for button");
        }
        Log.d(TAG, "onClick: NumPad pressed number=" + String.valueOf(number)
                + " enter=" + String.valueOf(enter)
                + " cancel=" + String.valueOf(cancel)
                + " next=" + String.valueOf(next)
        );

        if (number>=0) {
            Log.d(TAG, "onClick: numpad" + String.valueOf(number));
            controlInterface.HandleNumPad(number);
            activityInterface.updateResultsGui();
        }
        if (cancel) {
            Log.d(TAG, "onClick: cancel button");
            controlInterface.HandleCancelButton();
            activityInterface.updateResultsGui();
        }
        if (next) {
            Log.d(TAG, "onClick: next button");
            controlInterface.HandleNextButton();
            activityInterface.updateResultsGui();
        }
        if (enter) {
            Log.d(TAG, "onClick: enter button");
            controlInterface.HandleEnterButton();
            activityInterface.updateGui();
        }
    }

}
