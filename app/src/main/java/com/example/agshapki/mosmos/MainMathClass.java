package com.example.agshapki.mosmos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainMathClass {

    public enum OperationType {
        INVALID,
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
        DIV_1DIGxUNDER30;
    }

    public class Stats {
        Integer total = 0;
        Integer right = 0;
        Integer wrong = 0;
    }

    private Random random = new Random();

    MathProblem currentMathProblem;

    Stats stats = new Stats();

    List<OperationType> listOfPossibleOpTypes = new ArrayList<OperationType>();

    MainMathClass() {
        //listOfPossibleOpTypes.add(OperationType.ADD_2DIG);
        for (OperationType type : OperationType.values()) {
            if (type != OperationType.INVALID) {
                listOfPossibleOpTypes.add(type);
            }
        }
    }

    void generate() {
        OperationType operationType = listOfPossibleOpTypes.get(random.nextInt(listOfPossibleOpTypes.size()));
        currentMathProblem = generate_math_problem(operationType);
    }

    // FIXME - move this logic to MathProblem???
    public void AddDigitToResult(Integer number) {
        List<Integer> userAnswer = currentMathProblem.userAnswer;
        if (userAnswer.size() == 0) {
            userAnswer.add(0);
        }
        if (userAnswer.get(0) < 1000) {
            userAnswer.set(0, userAnswer.get(0) * 10 + number);
        }
    }

    boolean checkResult() {
        boolean checkedBefore = currentMathProblem.resultChecked;
        boolean checkResult = currentMathProblem.checkResult();
        if (!checkedBefore) {
            if (checkResult) {
                stats.right++;
            } else {
                stats.wrong++;
            }
            stats.total++;
        }
        return checkResult;
    }

    void clearResult() {
        currentMathProblem.userAnswer.clear();
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
            int op2 = random.nextInt(19) + 2;
            generate_mult_generic(mathProblem, op1, op2);
        } else if (operationType == OperationType.MULT_1DIGxUNDER30) {
            int op1 = random.nextInt(9) + 2;
            int op2 = random.nextInt(29) + 2;
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
            int result = random.nextInt(19) + 2;
            generate_div_generic(mathProblem, op2, result);
        } else if (operationType == OperationType.DIV_1DIGxUNDER30) {
            int op2 = random.nextInt(9) + 2;
            int result = random.nextInt(29) + 2;
            generate_div_generic(mathProblem, op2, result);
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
}
