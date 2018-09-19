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
    public String getDescription() {return "Mult. under 5";}

    @Override
    public void generateMe() {
        int op1 = random.nextInt(4) + 2;
        int op2 = random.nextInt(9) + 2;
        MathProblemMultiplication.generate_mult_generic(this, op1, op2);
    }
}

class MathProblemMult1Dig extends MathProblem {
    @Override
    public String getDescription() {return "Mult. 1 digit";}

    @Override
    public void generateMe() {
        int op1 = random.nextInt(9) + 2;
        int op2 = random.nextInt(9) + 2;
        MathProblemMultiplication.generate_mult_generic(this, op1, op2);
    }
}

class MathProblemMult1DigTens extends MathProblem {
    @Override
    public String getDescription() {return "Mult. by tens";}

    @Override
    public void generateMe() {
        int op1 = random.nextInt(9) + 2;
        int op2 = (random.nextInt(9) + 2) * 10;
        MathProblemMultiplication.generate_mult_generic(this, op1, op2);
    }
}

class MathProblemMult1DigBy20 extends MathProblem {
    @Override
    public String getDescription() {return "Mult. by 10s";}

    @Override
    public void generateMe() {
        int op1 = random.nextInt(9) + 2;
        int op2 = random.nextInt(10) + 11;
        MathProblemMultiplication.generate_mult_generic(this, op1, op2);
    }
}

class MathProblemMult1DigBy30 extends MathProblem {
    @Override
    public String getDescription() {return "Mult. by 20s";}

    @Override
    public void generateMe() {
        int op1 = random.nextInt(9) + 2;
        int op2 = random.nextInt(10) + 21;
        MathProblemMultiplication.generate_mult_generic(this, op1, op2);
    }
}


