package com.example.agshapki.mosmos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathProblemVisualizerTest {
    //MathProblemVisualizer vis = new MathProblemVisualizer();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void getOperationTypeString() {
//        assertEquals("+",vis.getOperationTypeString(MathGenerator.OperationType.ADD_2DIG_ROUND_2DIG));
//        assertEquals("-",vis.getOperationTypeString(MathGenerator.OperationType.SUB_2DIG_1DIG_DONT_CROSS));
//        assertEquals("*",vis.getOperationTypeString(MathGenerator.OperationType.MULT_1DIGxUNDER20));
//        assertEquals("/",vis.getOperationTypeString(MathGenerator.OperationType.DIV_1DIGxUNDER30));
//    }
//
//    @Test
//    public void visualizeMathProblem() {
//        MathProblem mathProblem = new MathProblemSumMax1Dig();
//        mathProblem.operationType = MathGenerator.OperationType.ADD_1DIG;
//        mathProblem.operands.add(1);
//        mathProblem.operands.add(2);
//        mathProblem.result.add(3);
//
//        vis.visualizeMathProblem(mathProblem);
//
//        assertEquals("1", vis.contentList.get(0));
//        assertEquals("+", vis.contentList.get(1));
//        assertEquals("2", vis.contentList.get(2));
//        assertEquals("=", vis.contentList.get(3));
//        assertEquals("?", vis.contentList.get(4));
//
//        mathProblem.userAnswer.add(5);
//        vis.visualizeMathProblem(mathProblem);
//
//        assertEquals("5", vis.contentList.get(4));
//
//        mathProblem = new MathProblemMult1Dig();
//        mathProblem.operationType = MathGenerator.OperationType.MULT_1DIG;
//        mathProblem.operands.add(2);
//        mathProblem.operands.add(3);
//        mathProblem.result.add(6);
//        vis.visualizeMathProblem(mathProblem);
//        assertEquals("2", vis.contentList.get(0));
//        assertEquals("*", vis.contentList.get(1));
//        assertEquals("3", vis.contentList.get(2));
//        assertEquals("=", vis.contentList.get(3));
//        assertEquals("?", vis.contentList.get(4));
//    }
//
//    @Test
//    public void HandleEnterButton() {
//        MathProblem mathProblem = new MathProblemMult1Dig();
//        mathProblem.operationType = MathGenerator.OperationType.MULT_1DIG;
//        mathProblem.operands.add(2);
//        mathProblem.operands.add(3);
//        mathProblem.result.add(6);
//        mathProblem.userAnswer.add(6);
//
//        vis.mainMathClass.currentMathProblem = mathProblem;
//        vis.HandleEnterButton();
//
//        assertEquals("Good Job!!!", vis.visualizePopMessage());
//        assertEquals("", vis.visualizePopMessage());
//
//        mathProblem.userAnswer.clear();
//        mathProblem.userAnswer.add(5);
//
//        vis.HandleEnterButton();
//        assertEquals("Ooopsy, try again!!!", vis.visualizePopMessage());
//    }
}