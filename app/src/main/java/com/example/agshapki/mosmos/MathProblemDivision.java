package com.example.agshapki.mosmos;

class MathProblemDivision {
    public static void generate_div_generic(MathProblem mathProblem, int op2, int result) {
        int op1 = op2 * result;
        mathProblem.operands.add(op1);
        mathProblem.operands.add(op2);
        mathProblem.result.add(result);
    }
}

class MathProblemDiv1Dig extends MathProblem {
    @Override
    public String getDescription() {return "Division 1 digit";}

    @Override
    public void generateMe() {
        int op2 = random.nextInt(9) + 2;
        int result = random.nextInt(9) + 2;
        MathProblemDivision.generate_div_generic(this, op2, result);
    }
}

class MathProblemDiv2DigSimple extends MathProblem {
    @Override
    public String getDescription() {return "Division 2 digit simple";}

    @Override
    public void generateMe() {
        int op2 = random.nextInt(9) + 2;
        int result = (random.nextInt(9) + 2) * 10;
        MathProblemDivision.generate_div_generic(this, op2, result);
    }
}

class MathProblemDiv2DigUnder20 extends MathProblem {
    @Override
    public String getDescription() {return "Division by 10s";}

    @Override
    public void generateMe() {
        int op2 = random.nextInt(9) + 2;
        int result = random.nextInt(10) + 11;
        MathProblemDivision.generate_div_generic(this, op2, result);
    }
}

class MathProblemDiv2DigUnder30 extends MathProblem {
    @Override
    public String getDescription() {return "Division by 20s";}

    @Override
    public void generateMe() {
        int op2 = random.nextInt(9) + 2;
        int result = random.nextInt(10) + 21;
        MathProblemDivision.generate_div_generic(this, op2, result);
    }
}


