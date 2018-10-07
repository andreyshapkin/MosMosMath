package com.example.agshapki.mosmos;

class MathProblemSubstraction {

    public static void generate_sub_generic(MathProblem mathProblem, int op1, int op2) {
        int result = op1 - op2;
        mathProblem.operands.add(op1);
        mathProblem.operands.add(op2);
        mathProblem.result.add(result);
    }
}

class MathProblemSubUnder10 extends MathProblem {
    @Override
    public String getDescription() {return "Subtraction under 10";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(1,10);
        int op2 = random_in_range(1,op1);
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

class MathProblemSubUnder20 extends MathProblem {
    @Override
    public String getDescription() {return "Subtraction under 20";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(10,19);
        int op2 = random_in_range(1,9);
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

class MathProblemSub2Dig1DigSimp extends MathProblem {
    @Override
    public String getDescription() {return "Subtraction 2 dig 1 dig simple";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(1,99);
        int op2 = random_in_range(0,op1%10);
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

class MathProblemSub2Dig1Dig extends MathProblem {
    @Override
    public String getDescription() {return "Subtraction 2 dig 1 digit";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(10, 99);
        int op2 = random_in_range(1, 9);
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

class MathProblemSubTens extends MathProblem {
    @Override
    public String getDescription() {return "Subtraction tens";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(1,9) * 10;
        int op2 = random_in_range(1, op1/10) * 10;
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

class MathProblemSub2DigSimple extends MathProblem {
    @Override
    public String getDescription() {return "Subtraction 2 digits simple";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(10,99);
        int op2 = random_in_range(0,op1 / 10) * 10 + random_in_range(0,op1 % 10);
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

class MathProblemSub2Dig extends MathProblem {
    @Override
    public String getDescription() {return "Subtraction 2 digits";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(10,99);
        int op2 = random_in_range(1,op1 - 1);
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

