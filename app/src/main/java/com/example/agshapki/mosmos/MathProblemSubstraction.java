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
    public String getDescription() {return "Substr. under 10";}

    @Override
    public void generateMe() {
        int op1 = random.nextInt(10) + 1;
        int op2 = random.nextInt(op1) + 1;
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

class MathProblemSubUnder20 extends MathProblem {
    @Override
    public String getDescription() {return "Substr. under 20";}

    @Override
    public void generateMe() {
        int op1 = random.nextInt(10) + 10;
        int op2 = random.nextInt(9) + 1;
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

class MathProblemSub2Dig1DigSimp extends MathProblem {
    @Override
    public String getDescription() {return "Substr. 2dig-1dig simple";}

    @Override
    public void generateMe() {
        int op1 = random.nextInt(99) + 1;
        int op2 = random.nextInt((op1 % 10) + 1);
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

class MathProblemSub2Dig1Dig extends MathProblem {
    @Override
    public String getDescription() {return "Substr. 2dig-1dig";}

    @Override
    public void generateMe() {
        int op1 = random.nextInt(90) + 10;
        int op2 = random.nextInt(9) + 1;
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

class MathProblemSubTens extends MathProblem {
    @Override
    public String getDescription() {return "Substr. tens";}

    @Override
    public void generateMe() {
        int op1 = (random.nextInt(9) + 1) * 10;
        int op2 = (random.nextInt(op1/10) + 1) * 10;
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

class MathProblemSub2DigSimple extends MathProblem {
    @Override
    public String getDescription() {return "Substr. 2 digits simple";}

    @Override
    public void generateMe() {
        int op1 = random.nextInt(90) + 10;
        int op2 = (random.nextInt(op1 / 10)) * 10 + random.nextInt((op1 % 10) + 1);
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

class MathProblemSub2Dig extends MathProblem {
    @Override
    public String getDescription() {return "Substr. 2 digits";}

    @Override
    public void generateMe() {
        int op1 = random.nextInt(90) + 10;
        int op2 = random.nextInt(op1) + 1;
        MathProblemSubstraction.generate_sub_generic(this, op1, op2);
    }
}

