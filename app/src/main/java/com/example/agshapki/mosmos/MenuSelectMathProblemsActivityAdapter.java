package com.example.agshapki.mosmos;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MenuSelectMathProblemsActivityAdapter extends RecyclerView.Adapter<MenuSelectMathProblemsActivityAdapter.MenuSelectProblemActivityHolder> {
    private static final String TAG = "MathProblemsAdapter";
    private MenuSelectMathProblemsVisualizerInterface control;
    private Context context;

    public MenuSelectMathProblemsActivityAdapter(MenuSelectMathProblemsVisualizerInterface control) {
        this.control = control;
    }

    @Override
    public MenuSelectProblemActivityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: inflating activity");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_select_math_problems_item, parent, false);
        this.context = parent.getContext();
        return new MenuSelectProblemActivityHolder(view);
    }

    @Override
    public void onBindViewHolder(final MenuSelectProblemActivityHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called " + String.valueOf(position));

        holder.textDescription.setText(control.getDescription(position));
        holder.textDescription.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: description clicked " + String.valueOf(position));
            }
        });

        holder.switchEn.setChecked(control.getSwitchState(position));
        holder.switchEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: switch state changed " + String.valueOf(position));
                control.setSwitchState(position, holder.switchEn.isChecked());
            }
        });
        if ((position&1) ==0) {
            //holder.layout.setBackgroundColor(Color.parseColor("#65b480"));
            holder.layout.setBackgroundColor(ContextCompat.getColor(this.context, R.color.ProblemSelect1));
        } else {
            //holder.layout.setBackgroundColor(Color.parseColor("#4dc676"));
            holder.layout.setBackgroundColor(ContextCompat.getColor(this.context, R.color.ProblemSelect2));
        }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return control.getItemCount();
    }

    class MenuSelectProblemActivityHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "MenuSelectProblem";

        TextView textDescription;
        Switch switchEn;
        LinearLayout layout;

        public MenuSelectProblemActivityHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "MenuSelectProblemActivityHolder: constructor");
            textDescription = (TextView)itemView.findViewById(R.id.menuSelectMathDescription);
            switchEn =  (Switch) itemView.findViewById(R.id.menuSelectMathSwitch);
            layout = (LinearLayout) itemView.findViewById(R.id.menuSelectMathLayout);
        }
    }
}
