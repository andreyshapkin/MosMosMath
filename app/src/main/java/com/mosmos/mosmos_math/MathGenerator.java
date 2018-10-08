package com.mosmos.mosmos_math;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

interface MathProblemOperationTypeInterface {
    boolean getOperationTypeEnable(MathGenerator.OperationType operationType);
    void setOperationTypeEnable(MathGenerator.OperationType operationType, boolean enable);
}

interface NumPadControlInterface {
    void HandleNumPad(Integer number);
    void HandleCancelButton();
    void HandleEnterButton();
    void HandleNextButton();
}

class MathGenerator implements MathProblemOperationTypeInterface {

    public enum OperationType {
        ADD_SUM_UNDER10             (new MathProblemAddUnder10(),       MathProblemVisualizer.GuiViewType.SIMPLE),
        ADD_1DIG                    (new MathProblemAddMax1Dig(),       MathProblemVisualizer.GuiViewType.SIMPLE),
        ADD_TENS                    (new MathProblemAddTens(),          MathProblemVisualizer.GuiViewType.SIMPLE),
        ADD_2DIG_1DIG               (new MathProblemAdd2Dig1Dig(),      MathProblemVisualizer.GuiViewType.SIMPLE),
        ADD_2DIG_ROUND_2DIG         (new MathProblemAdd2DigRound2Dig(), MathProblemVisualizer.GuiViewType.SIMPLE),
        ADD_SUM_UNDER100            (new MathProblemAddUnder100(),      MathProblemVisualizer.GuiViewType.SIMPLE),
        ADD_2DIG                    (new MathProblemAdd2Dig(),          MathProblemVisualizer.GuiViewType.SIMPLE),

        SUB_1DIG                    (new MathProblemSubUnder10(),       MathProblemVisualizer.GuiViewType.SIMPLE),
        SUB_UNDER20                 (new MathProblemSubUnder20(),       MathProblemVisualizer.GuiViewType.SIMPLE),
        SUB_2DIG_1DIG_DONT_CROSS    (new MathProblemSub2Dig1DigSimp(),  MathProblemVisualizer.GuiViewType.SIMPLE),
        SUB_2DIG_1DIG               (new MathProblemSub2Dig1Dig(),      MathProblemVisualizer.GuiViewType.SIMPLE),
        SUB_TENS                    (new MathProblemSubTens(),          MathProblemVisualizer.GuiViewType.SIMPLE),
        SUB_2DIG_2DIG_DONT_CROSS    (new MathProblemSub2DigSimple(),    MathProblemVisualizer.GuiViewType.SIMPLE),
        SUB_2DIG_2DIG               (new MathProblemSub2Dig(),          MathProblemVisualizer.GuiViewType.SIMPLE),

        MULT_1DIGxUNDER5            (new MathProblemMultUnder5(),       MathProblemVisualizer.GuiViewType.SIMPLE),
        MULT_1DIG                   (new MathProblemMult1Dig(),         MathProblemVisualizer.GuiViewType.SIMPLE),
        MULT_1DIG_2DIG_ROUND        (new MathProblemMult1DigTens(),     MathProblemVisualizer.GuiViewType.SIMPLE),
        MULT_1DIGxUNDER20           (new MathProblemMult1DigBy20(),     MathProblemVisualizer.GuiViewType.SIMPLE),
        MULT_1DIGxUNDER30           (new MathProblemMult1DigBy30(),     MathProblemVisualizer.GuiViewType.SIMPLE),

        DIV_1DIG                    (new MathProblemDiv1Dig(),          MathProblemVisualizer.GuiViewType.SIMPLE),
        DIV_1DIG_2DIG_ROUND         (new MathProblemDiv2DigSimple(),    MathProblemVisualizer.GuiViewType.SIMPLE),
        DIV_1DIGxUNDER20            (new MathProblemDiv2DigUnder20(),   MathProblemVisualizer.GuiViewType.SIMPLE),
        DIV_1DIGxUNDER30            (new MathProblemDiv2DigUnder30(),   MathProblemVisualizer.GuiViewType.SIMPLE),

        LCM_2DIG                    (new MathProblemLCM2Dig(),             MathProblemVisualizer.GuiViewType.LCM),
        LCM_3DIG                    (new MathProblemLCM3Dig(),             MathProblemVisualizer.GuiViewType.LCM),

        FRACT_EXTRACT_WHOLE         (new MathProblemFractExtractWhole(),        MathProblemVisualizer.GuiViewType.FRACTION_EXTRACT_WHOLE),

        FRACT_SIMPLE_ADD_SAME_DEN   (new MathProblemFractSimpleAddSameDen(),    MathProblemVisualizer.GuiViewType.FRACTION_SIMPLE),
        FRACT_SIMPLE_SUB_SAME_DEN   (new MathProblemFractSimpleSubSameDen(),    MathProblemVisualizer.GuiViewType.FRACTION_SIMPLE),

        FRACT_ADD_SAME_DEN          (new MathProblemFractAddSameDen(),          MathProblemVisualizer.GuiViewType.FRACTION_COMPLEX),
        FRACT_SUB_SAME_DEN          (new MathProblemFractSubSameDen(),          MathProblemVisualizer.GuiViewType.FRACTION_COMPLEX),

        INVALID                     (null, null);

        public final MathProblem mathProblem;
        public final MathProblemVisualizer.GuiViewType viewType;

        OperationType(MathProblem mathProblem, MathProblemVisualizer.GuiViewType viewType) {
            this.mathProblem = mathProblem;
            this.viewType = viewType;
        }
    }

    private static final String TAG = "MathGenerator";

    private SharedPreferences getSharedPreferences() {return MainActivity.sharedPreferences;}
    private SharedPreferences.Editor getSharedPreferencesEditor() {return MainActivity.sharedPreferencesEditor;}

    private Random random = new Random();
    ArrayList<OperationType> listOfPossibleOpTypes = new ArrayList<OperationType>();
    private final boolean debugListOfPossibleOpTypes = false;

    public MathGenerator() {
        //debugListOfPossibleOpTypes = true;
        //listOfPossibleOpTypes.add(OperationType.ADD_1DIG);
        //listOfPossibleOpTypes.add(OperationType.LCM_3DIG);
        //listOfPossibleOpTypes.add(OperationType.FRACT_EXTRACT_WHOLE);
        //listOfPossibleOpTypes.add(OperationType.FRACT_SIMPLE_ADD_SAME_DEN);
        //listOfPossibleOpTypes.add(OperationType.FRACT_SIMPLE_SUB_SAME_DEN);
        //listOfPossibleOpTypes.add(OperationType.FRACT_ADD_SAME_DEN);
        //listOfPossibleOpTypes.add(OperationType.FRACT_SUB_SAME_DEN);
    }

    ////////////////////////////////////////////////////////////////////////
    // Should be it's own class?

    // placeholder
    private String user = "user";
    private static final String key = "SELECT_PROBLEM";
    private String getKey(MathGenerator.OperationType type) {return key + "_" + user + type.toString();}

    @Override
    public boolean getOperationTypeEnable(MathGenerator.OperationType operationType) {
        boolean enable = getSharedPreferences().getBoolean(getKey(operationType), false);
        Log.d(TAG, "getOperationTypeEnable: operationType=" + operationType.toString() + " enable=" + String.valueOf(enable));
        return enable;
    }

    @Override
    public void setOperationTypeEnable(MathGenerator.OperationType operationType, boolean enable) {
        getSharedPreferencesEditor().putBoolean(getKey(operationType),enable);
        getSharedPreferencesEditor().commit();
        Log.d(TAG, "setOperationTypeEnable: setting operationType=" + operationType.toString() + " enable=" + String.valueOf(enable));
    }

    ////////////////////////////////////////////////////////////////////////

    public void buildListOfMathProblems () {
        Log.d(TAG, "buildListOfMathProblems: starting");
        if (debugListOfPossibleOpTypes) {
            Log.d(TAG, "buildListOfMathProblems: debug mode - returning");
            return;
        }
        listOfPossibleOpTypes.clear();
        for (OperationType type : OperationType.values()) {
            if (type != OperationType.INVALID) {
                if (getOperationTypeEnable(type)) {
                    Log.d(TAG, "buildListOfMathProblems: adding " + type.toString());
                    listOfPossibleOpTypes.add(type);
                }
            }
        }
        if (listOfPossibleOpTypes.size()==0) {
            listOfPossibleOpTypes.add(OperationType.ADD_SUM_UNDER10);
        }
    }

    public MathProblem generate() {
        Log.d(TAG, "generate: generating new problem");
        OperationType operationType = listOfPossibleOpTypes.get(random.nextInt(listOfPossibleOpTypes.size()));
        MathProblem mathProblem = generateMathProblem(operationType);
        Log.d(TAG, "generate: generated problem " + mathProblem.getString());
        return mathProblem;
    }

    public MathProblem generateMathProblem(OperationType operationType) {
        MathProblem mathProblem = operationType.mathProblem;
        mathProblem.generate(operationType);
        return mathProblem;
    }

}
