package com.example.agshapki.mosmos;

class MathProblemLCM {
    static public int getLCM(int op1, int op2, int op3) {
        return getLCM(op1,getLCM(op2,op3));
    }

    static public int getLCM(int op1, int op2) {
        int result = op1*op2;
        for (int i = op1*op2/2; i >= Math.min(op1,op2); i--) {
            if ( (i%op1)==0 && (i%op2)==0) {
                result = i;
            }
        }
        return result;
    }
}

class MathProblemLCM2Dig extends MathProblem {
    @Override
    public String getDescription() {return "LCM of 2 numbers";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(2,10);
        int op2 = random_in_range(2,10);
        int res = MathProblemLCM.getLCM(op1, op2);
        operands.add(op1);
        operands.add(op2);
        result.add(res);
    }
}

class MathProblemLCM3Dig extends MathProblem {
    @Override
    public String getDescription() {return "LCM of 3 numbers";}

    @Override
    public void generateMe() {
        int op1 = random_in_range(2,10);
        int op2 = random_in_range(2,10);
        int op3 = random_in_range(2,10);
        int res = MathProblemLCM.getLCM(op1, op2, op3);
        operands.add(op1);
        operands.add(op2);
        operands.add(op3);
        result.add(res);
    }
}

