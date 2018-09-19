package com.example.agshapki.mosmos;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

class MathGenerator {

    public enum OperationType {
        ADD_SUM_UNDER10             (new MathProblemSumUnder10(),       MathProblemVisualizer.GuiViewType.SIMPLE),
        ADD_1DIG                    (new MathProblemSumMax1Dig(),       MathProblemVisualizer.GuiViewType.SIMPLE),
        ADD_TENS                    (new MathProblemSumTens(),          MathProblemVisualizer.GuiViewType.SIMPLE),
        ADD_2DIG_1DIG               (new MathProblemSum2Dig1Dig(),      MathProblemVisualizer.GuiViewType.SIMPLE),
        ADD_2DIG_ROUND_2DIG         (new MathProblemSum2DigRound2Dig(), MathProblemVisualizer.GuiViewType.SIMPLE),
        ADD_SUM_UNDER100            (new MathProblemSumUnder100(),      MathProblemVisualizer.GuiViewType.SIMPLE),
        ADD_2DIG                    (new MathProblemSum2Dig(),          MathProblemVisualizer.GuiViewType.SIMPLE),

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

        LCM_2DIG                    (new MathProblemLCM2(),             MathProblemVisualizer.GuiViewType.LCM),
        LCM_3DIG                    (new MathProblemLCM3(),             MathProblemVisualizer.GuiViewType.LCM),

        FRACT_EXTRACT_WHOLE         (new MathProblemFractExtractWhole(),        MathProblemVisualizer.GuiViewType.FRACTION_EXTRACT_WHOLE),

        FRACT_SIMPLE_ADD_SAME_DEN   (new MathProblemFractSimpleAddSameDen(),    MathProblemVisualizer.GuiViewType.FRACTION_SIMPLE),
        FRACT_SIMPLE_SUB_SAME_DEN   (new MathProblemFractSimpleSubSameDen(),    MathProblemVisualizer.GuiViewType.FRACTION_SIMPLE),

        FRACT_ADD_SAME_DEN          (new MathProblemFractAddSameDen(),          MathProblemVisualizer.GuiViewType.FRACTION),
        FRACT_SUB_SAME_DEN          (new MathProblemFractSubSameDen(),          MathProblemVisualizer.GuiViewType.FRACTION),

        INVALID                     (null, null);

        public final MathProblem mathProblem;
        public final MathProblemVisualizer.GuiViewType viewType;

        OperationType(MathProblem mathProblem, MathProblemVisualizer.GuiViewType viewType) {
            this.mathProblem = mathProblem;
            this.viewType = viewType;
        }
    }

    private static final String TAG = "MathGenerator";

    private Random random = new Random();
    ArrayList<OperationType> listOfPossibleOpTypes = new ArrayList<OperationType>();


    public MathGenerator() {
        for (OperationType type : OperationType.values()) {
            if (type != OperationType.INVALID) {
                listOfPossibleOpTypes.add(type);
            }
        }
        //listOfPossibleOpTypes.add(OperationType.ADD_1DIG);
        //listOfPossibleOpTypes.add(OperationType.LCM_3DIG);
        //listOfPossibleOpTypes.add(OperationType.FRACT_EXTRACT_WHOLE);
        //listOfPossibleOpTypes.add(OperationType.FRACT_SIMPLE_ADD_SAME_DEN);
        //listOfPossibleOpTypes.add(OperationType.FRACT_SIMPLE_SUB_SAME_DEN);
        //listOfPossibleOpTypes.add(OperationType.FRACT_ADD_SAME_DEN);
        //listOfPossibleOpTypes.add(OperationType.FRACT_SUB_SAME_DEN);
    }

    MathProblem generate() {
        Log.d(TAG, "generate: generating new problem");
        OperationType operationType = listOfPossibleOpTypes.get(random.nextInt(listOfPossibleOpTypes.size()));
        MathProblem mathProblem = generateMathProblem(operationType);
        Log.d(TAG, "generate: generated problem " + mathProblem.getString());
        return mathProblem;
    }

    MathProblem generateMathProblem(OperationType operationType) {
        MathProblem mathProblem = operationType.mathProblem;
        mathProblem.generate(operationType);
        return mathProblem;
    }

}
