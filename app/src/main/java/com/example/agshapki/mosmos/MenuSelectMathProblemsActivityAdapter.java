package com.example.agshapki.mosmos;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MenuSelectMathProblemsActivityAdapter extends RecyclerView.Adapter<MenuSelectMathProblemsActivityAdapter.MenuSelectProblemActivityHolder> {
    private static final String TAG = "MathProblemsAdapter";

    @Override
    public MenuSelectProblemActivityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: inflating activity");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_select_math_problems_item, parent, false);
        return new MenuSelectProblemActivityHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuSelectProblemActivityHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called " + String.valueOf(position));

        holder.textDescription.setText("Description " + String.valueOf(position));
        holder.textDescription.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: description clicked " + String.valueOf(position));
            }
        });

        holder.switchEn.setChecked(true);
        holder.switchEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: switch state changed " + String.valueOf(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return 5;
    }

    class MenuSelectProblemActivityHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "MenuSelectProblemActivityHolder";

        TextView textDescription;
        Switch switchEn;

        public MenuSelectProblemActivityHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "MenuSelectProblemActivityHolder: costructor");
            textDescription = (TextView)itemView.findViewById(R.id.menuSelectMathDescription);
            switchEn =  (Switch) itemView.findViewById(R.id.menuSelectMathSwitch);
        }
    }
}
