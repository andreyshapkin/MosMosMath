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
        int RWhole = random.nextInt(10) + 1;
        int Aden = random.nextInt(9) + 2;
        int Rnum = random.nextInt(Aden - 1) + 1;
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
        int den = random.nextInt(18) + 3;
        int An = random.nextInt(den - 2) + 1;
        int Ad = den;
        int Bn = random.nextInt(20 - An) + 1;
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
        int den = random.nextInt(18) + 3;
        int An = random.nextInt(den - 1) + 1;
        int Ad = den;
        int Bn = random.nextInt(An - 1 ) + 1;
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
        int den = random.nextInt(18) + 3;
        int Ah = random.nextInt(10) + 1;
        int An = random.nextInt(den - 2) + 1;
        int Ad = den;
        int Bh = random.nextInt(10) + 1;
        int Bn = random.nextInt(den - An - 1) + 1;
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
        int den = random.nextInt(16) + 5;
        int Ah = random.nextInt(16) + 5;
        int An = random.nextInt(den - 3) + 2;
        int Ad = den;
        int Bh = random.nextInt(Ah - 1) + 1;
        int Bn = random.nextInt(An - 1) + 1;
        int Bd = den;
        int Rh = Ah - Bh;
        int Rn = An - Bn;
        int Rd = den;

        MathProblemFraction.generateFractionProblem(this, Ah, An, Ad, Bh, Bn, Bd, Rh, Rn, Rd);
    }
}



