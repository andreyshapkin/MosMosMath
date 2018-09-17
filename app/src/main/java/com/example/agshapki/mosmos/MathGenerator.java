package com.example.agshapki.mosmos;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

class MathGenerator {

    public enum OperationType {
        ADD_SUM_UNDER10,
        ADD_1DIG,
        ADD_SUM_UNDER100,
        ADD_2DIG,
        ADD_2DIG_1DIG,
        ADD_2DIG_ROUND_2DIG,
        ADD_TENS,

        SUB_1DIG,
        SUB_2DIG_1DIG_DONT_CROSS,
        SUB_2DIG_1DIG,
        SUB_TENS,
        SUB_2DIG_2DIG_DONT_CROSS,
        SUB_2DIG_2DIG,

        MULT_1DIG,
        MULT_1DIG_2DIG_ROUND,
        MULT_1DIGxUNDER20,
        MULT_1DIGxUNDER30,

        DIV_1DIG,
        DIV_1DIG_2DIG_ROUND,
        DIV_1DIGxUNDER20,
        DIV_1DIGxUNDER30,

        LCM_2DIG,
        LCM_3DIG,

        FRACT_EXTRACT_WHOLE,

        FRACT_SIMPLE_ADD_SAME_DEN,
        FRACT_SIMPLE_SUB_SAME_DEN,

        FRACT_ADD_SAME_DEN,
        FRACT_SUB_SAME_DEN,

        INVALID;
    }

    private static final String TAG = "MathGenerator";

    private Random random = new Random();
    ArrayList<OperationType> listOfPossibleOpTypes = new ArrayList<OperationType>();


    public MathGenerator() {
//        for (OperationType type : OperationType.values()) {
//            if (type != OperationType.INVALID) {
//                listOfPossibleOpTypes.add(type);
//            }
//        }
        //listOfPossibleOpTypes.add(OperationType.ADD_1DIG);
        //listOfPossibleOpTypes.add(OperationType.LCM_3DIG);
        //listOfPossibleOpTypes.add(OperationType.FRACT_EXTRACT_WHOLE);
        //listOfPossibleOpTypes.add(OperationType.FRACT_SIMPLE_ADD_SAME_DEN);
        //listOfPossibleOpTypes.add(OperationType.FRACT_SIMPLE_SUB_SAME_DEN);
        //listOfPossibleOpTypes.add(OperationType.FRACT_ADD_SAME_DEN);
        listOfPossibleOpTypes.add(OperationType.FRACT_SUB_SAME_DEN);
    }

    MathProblem generate() {
        Log.d(TAG, "generate: generating new problem");
        OperationType operationType = listOfPossibleOpTypes.get(random.nextInt(listOfPossibleOpTypes.size()));
        MathProblem mathProblem = generate_math_problem(operationType);
        Log.d(TAG, "generate: generated problem " + mathProblem.toString());
        return mathProblem;
    }


    MathProblem generate_math_problem(OperationType operationType) {
        MathProblem mathProblem = new MathProblem();

        mathProblem.operands.clear();
        mathProblem.operationType = operationType;

        // ADDS
        if (operationType == OperationType.ADD_SUM_UNDER10) {
            generate_add_max_sum(mathProblem, 10);
        } else if (operationType == OperationType.ADD_1DIG) {
            generate_add_max_op(mathProblem, 9);
        } else if (operationType == OperationType.ADD_SUM_UNDER100) {
            generate_add_max_sum(mathProblem, 100);
        } else if (operationType == OperationType.ADD_2DIG) {
            generate_add_max_op(mathProblem, 99);
        } else if (operationType == OperationType.ADD_2DIG_1DIG) {
            int op1 = random.nextInt(90) + 10;
            int op2 = random.nextInt(Math.min(9,100-op1)) + 1;
            generate_add_generic(mathProblem, op1, op2);
        } else if (operationType == OperationType.ADD_2DIG_ROUND_2DIG) {
            int op1 = (random.nextInt(9) + 1) * 10;
            int op2 = random.nextInt(100 - op1) + 1;
            generate_add_generic(mathProblem, op1, op2);
        } else if (operationType == OperationType.ADD_TENS) {
            int op1 = (random.nextInt(9) + 1) * 10;
            int op2 = (random.nextInt(9) + 1) * 10;
            generate_add_generic(mathProblem, op1, op2);


        } else if (operationType == OperationType.SUB_1DIG) {
            generate_sub_max_sum(mathProblem, 10);
        } else if (operationType == OperationType.SUB_2DIG_1DIG_DONT_CROSS) {
            int op1 = random.nextInt(99) + 1;
            int op2 = random.nextInt((op1 % 10) + 1);
            generate_sub_generic(mathProblem, op1, op2);
        } else if (operationType == OperationType.SUB_2DIG_1DIG) {
            int op1 = random.nextInt(90) + 10;
            int op2 = random.nextInt(9) + 1;
            generate_sub_generic(mathProblem, op1, op2);
        } else if (operationType == OperationType.SUB_TENS) {
            int op1 = (random.nextInt(9) + 1) * 10;
            int op2 = (random.nextInt(op1/10) + 1) * 10;
            generate_sub_generic(mathProblem, op1, op2);
        } else if (operationType == OperationType.SUB_2DIG_2DIG_DONT_CROSS) {
            int op1 = random.nextInt(90) + 10;
            int op2 = (random.nextInt(op1 / 10)) * 10 + random.nextInt((op1 % 10) + 1);
            generate_sub_generic(mathProblem, op1, op2);
        } else if (operationType == OperationType.SUB_2DIG_2DIG) {
            int op1 = random.nextInt(90) + 10;
            int op2 = random.nextInt(op1) + 1;
            generate_sub_generic(mathProblem, op1, op2);


        } else if (operationType == OperationType.MULT_1DIG) {
            int op1 = random.nextInt(9) + 2;
            int op2 = random.nextInt(9) + 2;
            generate_mult_generic(mathProblem, op1, op2);
        } else if (operationType == OperationType.MULT_1DIG_2DIG_ROUND) {
            int op1 = random.nextInt(9) + 2;
            int op2 = (random.nextInt(9) + 2) * 10;
            generate_mult_generic(mathProblem, op1, op2);
        } else if (operationType == OperationType.MULT_1DIGxUNDER20) {
            int op1 = random.nextInt(9) + 2;
            int op2 = random.nextInt(10) + 11;
            generate_mult_generic(mathProblem, op1, op2);
        } else if (operationType == OperationType.MULT_1DIGxUNDER30) {
            int op1 = random.nextInt(9) + 2;
            int op2 = random.nextInt(10) + 21;
            generate_mult_generic(mathProblem, op1, op2);


        } else if (operationType == OperationType.DIV_1DIG) {
            int op2 = random.nextInt(9) + 2;
            int result = random.nextInt(9) + 2;
            generate_div_generic(mathProblem, op2, result);
        } else if (operationType == OperationType.DIV_1DIG_2DIG_ROUND) {
            int op2 = random.nextInt(9) + 2;
            int result = (random.nextInt(9) + 2) * 10;
            generate_div_generic(mathProblem, op2, result);
        } else if (operationType == OperationType.DIV_1DIGxUNDER20) {
            int op2 = random.nextInt(9) + 2;
            int result = random.nextInt(10) + 11;
            generate_div_generic(mathProblem, op2, result);
        } else if (operationType == OperationType.DIV_1DIGxUNDER30) {
            int op2 = random.nextInt(9) + 2;
            int result = random.nextInt(10) + 21;
            generate_div_generic(mathProblem, op2, result);


        } else if (operationType == OperationType.LCM_2DIG) {
            int op1 = random.nextInt(9) + 2;
            int op2 = random.nextInt(9) + 2;
            int result = getLCM(op1, op2);
            mathProblem.operands.add(op1);
            mathProblem.operands.add(op2);
            mathProblem.result.add(result);
        } else if (operationType == OperationType.LCM_3DIG) {
            int op1 = random.nextInt(9) + 2;
            int op2 = random.nextInt(9) + 2;
            int op3 = random.nextInt(9) + 2;
            int result = getLCM(op1, op2, op3);
            mathProblem.operands.add(op1);
            mathProblem.operands.add(op2);
            mathProblem.operands.add(op3);
            mathProblem.result.add(result);


        } else if (operationType == OperationType.FRACT_EXTRACT_WHOLE) {
            int RWhole = random.nextInt(10) + 1;
            int Aden = random.nextInt(9) + 2;
            int Rnum = random.nextInt(Aden - 1) + 1;
            int Anum = RWhole * Aden + Rnum;

            mathProblem.operands.add(Anum);
            mathProblem.operands.add(Aden);
            mathProblem.result.add(RWhole);
            mathProblem.result.add(Rnum);
            mathProblem.result.add(Aden);

        } else if (operationType == OperationType.FRACT_SIMPLE_ADD_SAME_DEN) {
            int den = random.nextInt(18) + 3;
            int An = random.nextInt(den - 2) + 1;
            int Ad = den;
            int Bn = random.nextInt(20 - An) + 1;
            int Bd = den;
            int Rn = An + Bn;
            int Rd = den;

            generateFractionSimpleProblem(mathProblem, An, Ad, Bn, Bd, Rn, Rd);
        } else if (operationType == OperationType.FRACT_SIMPLE_SUB_SAME_DEN) {
            int den = random.nextInt(18) + 3;
            int An = random.nextInt(den - 1) + 1;
            int Ad = den;
            int Bn = random.nextInt(An - 1 ) + 1;
            int Bd = den;
            int Rn = An - Bn;
            int Rd = den;

            generateFractionSimpleProblem(mathProblem, An, Ad, Bn, Bd, Rn, Rd);


        } else if (operationType == OperationType.FRACT_ADD_SAME_DEN) {
            int den = random.nextInt(18) + 3;
            int Ah = random.nextInt(10) + 1;
            int An = random.nextInt(den - 2) + 1;
            int Ad = den;
            int Bh = random.nextInt(10) + 1;
            int Bn = random.nextInt(den - An - 1) + 1;
            int Bd = den;
            int Rh = Ah + Bh;
            int Rn = An + Bn;
            int Rd = den;

            generateFractionProblem(mathProblem, Ah, An, Ad, Bh, Bn, Bd, Rh, Rn, Rd);
        } else if (operationType == OperationType.FRACT_SUB_SAME_DEN) {
            int den = random.nextInt(16) + 5;
            int Ah = random.nextInt(16) + 5;
            int An = random.nextInt(den - 3) + 2;
            int Ad = den;
            int Bh = random.nextInt(Ah - 1) + 1;
            int Bn = random.nextInt(An - 1) + 1;
            int Bd = den;
            int Rh = Ah - Bh;
            int Rn = An - Bn;
            int Rd = den;

            generateFractionProblem(mathProblem, Ah, An, Ad, Bh, Bn, Bd, Rh, Rn, Rd);

        } else {
            throw new AssertionError("unknown type to generate " + operationType.toString());
        }

        return mathProblem;
    }

    private void generate_mult_generic(MathProblem mathProblem, int op1, int op2) {
        int result = op1 * op2;
        mathProblem.operands.add(op1);
        mathProblem.operands.add(op2);
        mathProblem.result.add(result);
    }

    private void generate_div_generic(MathProblem mathProblem, int op2, int result) {
        int op1 = op2 * result;
        mathProblem.operands.add(op1);
        mathProblem.operands.add(op2);
        mathProblem.result.add(result);
    }

    private void generate_add_max_op(MathProblem mathProblem, int max_op) {
        int op1 = random.nextInt(max_op) + 1;
        int op2 = random.nextInt(max_op) + 1;
        generate_add_generic(mathProblem, op1, op2);
    }

    private void generate_add_max_sum(MathProblem mathProblem, int max_sum) {
        int op1 = random.nextInt(max_sum - 1) + 1;
        int op2 = random.nextInt(max_sum - op1) + 1;
        generate_add_generic(mathProblem, op1, op2);
    }

    private void generate_add_generic(MathProblem mathProblem, int op1, int op2) {
        int result = op1 + op2;
        mathProblem.operands.add(op1);
        mathProblem.operands.add(op2);
        mathProblem.result.add(result);
    }

    private void generate_sub_max_sum(MathProblem mathProblem, int max_sum) {
        int op1 = random.nextInt(max_sum-1) + 1;
        int op2 = random.nextInt(op1) + 1;
        generate_sub_generic(mathProblem, op1, op2);
    }

    private void generate_sub_generic(MathProblem mathProblem, int op1, int op2) {
        int result = op1 - op2;
        mathProblem.operands.add(op1);
        mathProblem.operands.add(op2);
        mathProblem.result.add(result);
    }

    private void generateFractionSimpleProblem(MathProblem mathProblem, int an, int ad, int bn, int bd, int rn, int rd) {
        mathProblem.operands.add(an);
        mathProblem.operands.add(ad);
        mathProblem.operands.add(bn);
        mathProblem.operands.add(bd);
        mathProblem.result.add(rn);
        mathProblem.result.add(rd);
    }

    private void generateFractionProblem(MathProblem mathProblem, int ah, int an, int ad, int bh, int bn, int bd, int rh, int rn, int rd) {
        mathProblem.operands.add(ah);
        mathProblem.operands.add(an);
        mathProblem.operands.add(ad);
        mathProblem.operands.add(bh);
        mathProblem.operands.add(bn);
        mathProblem.operands.add(bd);
        mathProblem.result.add(rh);
        mathProblem.result.add(rn);
        mathProblem.result.add(rd);
    }

    public int getLCM(int op1, int op2, int op3) {
        return getLCM(op1,getLCM(op2,op3));
    }
    public int getLCM(int op1, int op2) {
        int result = op1*op2;
        for (int i = op1*op2/2; i >= Math.min(op1,op2); i--) {
            if ( (i%op1)==0 && (i%op2)==0) {
                result = i;
            }
        }
        return result;
    }

}
