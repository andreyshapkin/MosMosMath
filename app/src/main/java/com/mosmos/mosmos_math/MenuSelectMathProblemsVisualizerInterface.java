package com.mosmos.mosmos_math;

interface MenuSelectMathProblemsVisualizerInterface {
    public int getItemCount();
    public String getDescription(int position);
    public String getDetailedDescription(int position);
    public boolean getSwitchState(int position);
    public void setSwitchState(int position, boolean state);
}
