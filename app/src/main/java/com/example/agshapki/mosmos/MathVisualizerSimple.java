package com.example.agshapki.mosmos;

class MathVisualizerSimple extends MathVisualizerBase {
    @Override
    public void visualizeMe(MathProblem problem) {
        description = "Solve this math problem! "; // + problem.operationType.getString() + " " + String.valueOf(problem.result.get(0));

        contentList.add(String.valueOf(problem.operands.get(0)));
        contentList.add(getOperationTypeString(problem.operationType));
        contentList.add(String.valueOf(problem.operands.get(1)));
        contentList.add("=");

        if (problem.userAnswer.size() > 0) {
            contentList.add(String.valueOf(problem.userAnswer.get(0)));
        } else {
            contentList.add("?");
        }
    }
}

class MathVisualizerLCM extends MathVisualizerBase {
    @Override
    public void visualizeMe(MathProblem problem) {
        description = "Find LCM of the numbers";

        contentList.add(String.valueOf(problem.operands.get(0)));
        contentList.add(String.valueOf(problem.operands.get(1)));
        if (problem.operands.size()>2) {
            contentList.add(String.valueOf(problem.operands.get(2)));
        } else {
            contentList.add(" ");
        }
        if (problem.userAnswer.size()>0) {
            contentList.add(String.valueOf(problem.userAnswer.get(0)));
        } else {
            contentList.add("?");
        }
    }
}

class MathVisualizerFractionExtractWhole extends MathVisualizerBase {
    @Override
    public void visualizeMe(MathProblem problem) {
        description = "Extract Whole number, do not simplify fraction! ";
        contentList.add(String.valueOf(problem.operands.get(0)));
        contentList.add(String.valueOf(problem.operands.get(1)));

        for (int i=0;i<3;i++) {
            if (i < problem.userAnswer.size()) {
                contentList.add(String.valueOf(problem.userAnswer.get(i)));
            } else {
                contentList.add("?");
            }
        }

        colorText = 1 << (2 + problem.userAnswerIndex);
        highlightText = 0x7 << 2;
    }
}

class MathVisualizerFractionSimple extends MathVisualizerBase {
    @Override
    public void visualizeMe(MathProblem problem) {
        description = "Solve it, do not simplify fraction! ";
        contentList.add(String.valueOf(problem.operands.get(0)));
        contentList.add(String.valueOf(problem.operands.get(1)));
        contentList.add(getOperationTypeString(problem.operationType));
        contentList.add(String.valueOf(problem.operands.get(2)));
        contentList.add(String.valueOf(problem.operands.get(3)));

        for (int i=0;i<2;i++) {
            if (i < problem.userAnswer.size()) {
                contentList.add(String.valueOf(problem.userAnswer.get(i)));
            } else {
                contentList.add("?");
            }
        }

        colorText = 1 << (5 + problem.userAnswerIndex);
        highlightText = 0x3 << 5;
    }
}

class MathVisualizerFractionComplex extends MathVisualizerBase {
    @Override
    public void visualizeMe(MathProblem problem) {
        description = "Solve this math problem! ";

        contentList.add(String.valueOf(problem.operands.get(0)));
        contentList.add(String.valueOf(problem.operands.get(1)));
        contentList.add(String.valueOf(problem.operands.get(2)));
        contentList.add(getOperationTypeString(problem.operationType));
        contentList.add(String.valueOf(problem.operands.get(3)));
        contentList.add(String.valueOf(problem.operands.get(4)));
        contentList.add(String.valueOf(problem.operands.get(5)));

        for (int i=0;i<3;i++) {
            if (i < problem.userAnswer.size()) {
                contentList.add(String.valueOf(problem.userAnswer.get(i)));
            } else {
                contentList.add("?");
            }
        }

        colorText = 1 << (7 + problem.userAnswerIndex);
        highlightText = 0x7 << 7;

    }
}
