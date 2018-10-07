package com.example.agshapki.mosmos;

class MathProblemMultiplication {
    public static void generate_mult_generic(MathProblem mathProblem, int op1, int op2) {
        int result = op1 * op2;
        mathProblem.operands.add(op1);
        mathProblem.operands.add(op2);
        mathProblem.result.add(result);
    }
}

class MathProblemMultUnder5 extends MathProblem {
    @Override
    public String getDescription() {return "Multiplication under 5";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(2,5);
        int op2 = random_in_range(2,10);
        MathProblemMultiplication.generate_mult_generic(this, op1, op2);
    }
}

class MathProblemMult1Dig extends MathProblem {
    @Override
    public String getDescription() {return "Multiplication under 10";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(2,10);
        int op2 = random_in_range(2,10);
        MathProblemMultiplication.generate_mult_generic(this, op1, op2);
    }
}

class MathProblemMult1DigTens extends MathProblem {
    @Override
    public String getDescription() {return "Multiplication by tens";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(2,10);
        int op2 = random_in_range(2,10) * 10;
        MathProblemMultiplication.generate_mult_generic(this, op1, op2);
    }
}

class MathProblemMult1DigBy20 extends MathProblem {
    @Override
    public String getDescription() {return "Multiplication by 10-s";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(2,10);
        int op2 = random_in_range(11,20);
        MathProblemMultiplication.generate_mult_generic(this, op1, op2);
    }
}

class MathProblemMult1DigBy30 extends MathProblem {
    @Override
    public String getDescription() {return "Multiplication by 20-s";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(2,10);
        int op2 = random_in_range(21,30);
        MathProblemMultiplication.generate_mult_generic(this, op1, op2);
    }
}


