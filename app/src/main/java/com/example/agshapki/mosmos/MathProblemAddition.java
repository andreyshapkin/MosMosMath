package com.example.agshapki.mosmos;

class MathProblemAddition {
    public static void generate_add_generic(MathProblem mathProblem, int op1, int op2) {
        int result = op1 + op2;
        mathProblem.operands.add(op1);
        mathProblem.operands.add(op2);
        mathProblem.result.add(result);
    }

    public static void generate_add_max_sum(MathProblem mathProblem, int max_sum) {
        int op1 = mathProblem.random_in_range(1, max_sum - 2);
        int op2 = mathProblem.random_in_range(1,max_sum - op1);
        generate_add_generic(mathProblem, op1, op2);
    }

    public static void generate_add_max_op(MathProblem mathProblem, int max_op) {
        int op1 = mathProblem.random_in_range(1,max_op);
        int op2 = mathProblem.random_in_range(1,max_op);
        generate_add_generic(mathProblem, op1, op2);
    }
}

class MathProblemAddUnder10 extends MathProblem {
    @Override
    public String getDescription() {return "Addition up to 10";}

    @Override
    public void generateMe() {
        MathProblemAddition.generate_add_max_sum(this, 10);
    }
}

class MathProblemAddMax1Dig extends MathProblem {
    @Override
    public String getDescription() {return "Addition 1 digit";}

    @Override
    public void generateMe() {
        MathProblemAddition.generate_add_max_op(this, 9);
    }
}

class MathProblemAddUnder100 extends MathProblem {
    @Override
    public String getDescription() {return "Addition up to 100";}

    @Override
    public void generateMe() {
        MathProblemAddition.generate_add_max_sum(this, 100);
    }
}

class MathProblemAdd2Dig extends MathProblem {
    @Override
    public String getDescription() {return "Addition 2 digit";}

    @Override
    public void generateMe() {
        MathProblemAddition.generate_add_max_op(this, 99);
    }
}

class MathProblemAdd2Dig1Dig extends MathProblem {
    @Override
    public String getDescription() {return "Addition 2 digit simple";}

    @Override
    public void generateMe() {
        int op1 = random_in_range (10,99);
        int op2 = random_in_range(1,Math.min(9,100-op1));
        MathProblemAddition.generate_add_generic(this, op1, op2);
    }
}

class MathProblemAdd2DigRound2Dig extends MathProblem {
    @Override
    public String getDescription() {return "Addition 2 digit plus tens";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(1,9) * 10;
        int op2 = random_in_range(1, 100 - op1);
        MathProblemAddition.generate_add_generic(this, op1, op2);
    }
}

class MathProblemAddTens extends MathProblem {
    @Override
    public String getDescription() {return "Addition 2 digit tens";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(1,9) * 10;
        int op2 = random_in_range(1,9) * 10;
        MathProblemAddition.generate_add_generic(this, op1, op2);
    }
}

