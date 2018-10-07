package com.example.agshapki.mosmos;

class MathProblemFraction {
    static public void generateFractionSimpleProblem(MathProblem mathProblem, int an, int ad, int bn, int bd, int rn, int rd) {
        mathProblem.operands.add(an);
        mathProblem.operands.add(ad);
        mathProblem.operands.add(bn);
        mathProblem.operands.add(bd);
        mathProblem.result.add(rn);
        mathProblem.result.add(rd);
    }

    static public void generateFractionProblem(MathProblem mathProblem, int ah, int an, int ad, int bh, int bn, int bd, int rh, int rn, int rd) {
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
}

class MathProblemFractExtractWhole extends MathProblem {
    @Override
    public String getDescription() {return "Fraction extract whole";}

    @Override
    public void generateMe() {
        int RWhole = random_in_range(1,10);
        int Aden = random_in_range(2,10);
        int Rnum = random_in_range(1,Aden - 1);
        int Anum = RWhole * Aden + Rnum;

        operands.add(Anum);
        operands.add(Aden);
        result.add(RWhole);
        result.add(Rnum);
        result.add(Aden);
    }
}

class MathProblemFractSimpleAddSameDen extends MathProblem {
    @Override
    public String getDescription() {return "Fraction simple add same den.";}

    @Override
    public void generateMe() {
        int den = random_in_range(3,20);
        int An = random_in_range(1, den - 2);
        int Ad = den;
        int Bn = random_in_range(1, den - An - 1);
        int Bd = den;
        int Rn = An + Bn;
        int Rd = den;

        MathProblemFraction.generateFractionSimpleProblem(this, An, Ad, Bn, Bd, Rn, Rd);
    }
}

class MathProblemFractSimpleSubSameDen extends MathProblem {
    @Override
    public String getDescription() {return "Fraction simple sub same den.";}

    @Override
    public void generateMe() {
        int den = random_in_range(3,20);
        int An = random_in_range(2,den - 1);
        int Ad = den;
        int Bn = random_in_range(1,An - 1 );
        int Bd = den;
        int Rn = An - Bn;
        int Rd = den;

        MathProblemFraction.generateFractionSimpleProblem(this, An, Ad, Bn, Bd, Rn, Rd);
    }
}

class MathProblemFractAddSameDen extends MathProblem {
    @Override
    public String getDescription() {return "Fraction add same den.";}

    @Override
    public void generateMe() {
        int den = random_in_range(3,20);
        int Ah = random_in_range(1,10);
        int An = random_in_range(1, den - 2);
        int Ad = den;
        int Bh = random_in_range(1,10);
        int Bn = random_in_range(1,den - An - 1);
        int Bd = den;
        int Rh = Ah + Bh;
        int Rn = An + Bn;
        int Rd = den;

        MathProblemFraction.generateFractionProblem(this, Ah, An, Ad, Bh, Bn, Bd, Rh, Rn, Rd);
    }
}

class MathProblemFractSubSameDen extends MathProblem {
    @Override
    public String getDescription() {return "Fraction sub same den.";}

    @Override
    public void generateMe() {
        int den = random_in_range(5,20);
        int Ah = random_in_range(5,20);
        int An = random_in_range(2, den - 3);
        int Ad = den;
        int Bh = random_in_range(1, Ah - 1);
        int Bn = random_in_range(1, An -1);
        int Bd = den;
        int Rh = Ah - Bh;
        int Rn = An - Bn;
        int Rd = den;

        MathProblemFraction.generateFractionProblem(this, Ah, An, Ad, Bh, Bn, Bd, Rh, Rn, Rd);
    }
}



