package com.example.agshapki.mosmos;

class MathProblemAddition {
    public static void generate_add_generic(MathProblem mathProblem, int op1, int op2) {
        int result = op1 + op2;
        mathProblem.operands.add(op1);
        mathProblem.operands.add(op2);
        mathProblem.result.add(result);
    }

    public static void generate_add_max_sum(MathProblem mathProblem, int max_sum) {
        int op1 = mathProblem.random.nextInt(max_sum - 1) + 1;
        int op2 = mathProblem.random.nextInt(max_sum - op1) + 1;
        generate_add_generic(mathProblem, op1, op2);
    }

    public static void generate_add_max_op(MathProblem mathProblem, int max_op) {
        int op1 = mathProblem.random.nextInt(max_op) + 1;
        int op2 = mathProblem.random.nextInt(max_op) + 1;
        generate_add_generic(mathProblem, op1, op2);
    }
}

class MathProblemSumUnder10 extends MathProblem {
    @Override
    public String getDescription() {return "Addition sum up to 10";}

    @Override
    public void generateMe() {
        MathProblemAddition.generate_add_max_sum(this, 10);
    }
}

class MathProblemSumMax1Dig extends MathProblem {
    @Override
    public String getDescription() {return "Addition single digit";}

    @Override
    public void generateMe() {
        MathProblemAddition.generate_add_max_op(this, 9);
    }
}

class MathProblemSumUnder100 extends MathProblem {
    @Override
    public String getDescription() {return "Addition sum up to 100";}

    @Override
    public void generateMe() {
        MathProblemAddition.generate_add_max_sum(this, 100);
    }
}

class MathProblemSum2Dig extends MathProblem {
    @Override
    public String getDescription() {return "Addition 2 digit";}

    @Override
    public void generateMe() {
        MathProblemAddition.generate_add_max_op(this, 99);
    }
}

class MathProblemSum2Dig1Dig extends MathProblem {
    @Override
    public String getDescription() {return "Addition 2d plus 1d";}

    @Override
    public void generateMe() {
        int op1 = random.nextInt(90) + 10;
        int op2 = random.nextInt(Math.min(9,100-op1)) + 1;
        MathProblemAddition.generate_add_generic(this, op1, op2);
    }
}

class MathProblemSum2DigRound2Dig extends MathProblem {
    @Override
    public String getDescription() {return "Addition 2d plus tens";}

    @Override
    public void generateMe() {
        int op1 = (random.nextInt(9) + 1) * 10;
        int op2 = random.nextInt(100 - op1) + 1;
        MathProblemAddition.generate_add_generic(this, op1, op2);
    }
}

class MathProblemSumTens extends MathProblem {
    @Override
    public String getDescription() {return "Addition tens";}

    @Override
    public void generateMe() {
        int op1 = (random.nextInt(9) + 1) * 10;
        int op2 = (random.nextInt(9) + 1) * 10;
        MathProblemAddition.generate_add_generic(this, op1, op2);
    }
}

