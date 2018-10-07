package com.example.agshapki.mosmos;

import android.util.Log;

import org.junit.Test;

import static com.example.agshapki.mosmos.MathGenerator.OperationType;
import static org.junit.Assert.*;

public class MathGeneratorTest {

    MathGenerator mathGenerator = new MathGenerator();
    private static final String TAG = "MathGeneratorTest";

    @Test
    public void test_generate_range() {
        MathProblem mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.ADD_SUM_UNDER10);
        assertInRange(mathProblem.random_in_range(0,2),0, 2);
        assertInRange(mathProblem.random_in_range(2,4),2, 4);
    }

    @Test
    public void test_addition_all() {
        for (int i = 0; i < 100; i++) {
            MathProblem mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.ADD_SUM_UNDER10);
            assertInRange(mathProblem.result.get(0), 1, 10);
            assertGenericAdd(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.ADD_1DIG);
            assertInRange(mathProblem.operands.get(0), 1, 9);
            assertInRange(mathProblem.operands.get(1), 1, 9);
            assertGenericAdd(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.ADD_SUM_UNDER100);
            assertInRange(mathProblem.result.get(0), 1, 100);
            assertGenericAdd(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.ADD_2DIG);
            assertInRange(mathProblem.operands.get(0), 1, 99);
            assertInRange(mathProblem.operands.get(1), 1, 99);
            assertGenericAdd(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.ADD_2DIG_1DIG);
            assertInRange(mathProblem.operands.get(0), 1, 99);
            assertInRange(mathProblem.operands.get(1), 1, 9);
            assertGenericAdd(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.ADD_2DIG_ROUND_2DIG);
            assertTrue((mathProblem.operands.get(0) % 10) == 0);
            assertInRange(mathProblem.operands.get(1), 1, 99);
            assertGenericAdd(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.ADD_TENS);
            assertTrue((mathProblem.operands.get(0) % 10) == 0);
            assertTrue((mathProblem.operands.get(1) % 10) == 0);
            assertInRange(mathProblem.operands.get(0), 1, 99);
            assertInRange(mathProblem.operands.get(1), 1, 99);
            assertGenericAdd(mathProblem);
        }
    }

    @Test
    public void test_substruction_all() {
        for (int i = 0; i < 100; i++) {
            MathProblem mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.SUB_1DIG);
            assertInRange(mathProblem.operands.get(0), 1, 10);
            assertInRange(mathProblem.operands.get(1), 0, 10);
            assertGenericSub(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(OperationType.SUB_UNDER20);
            assertInRange(mathProblem.operands.get(0), 10, 19);
            assertInRange(mathProblem.operands.get(1), 1, 9);
            assertGenericSub(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.SUB_2DIG_1DIG_DONT_CROSS);
            assertInRange(mathProblem.operands.get(0), 1, 99);
            assertInRange(mathProblem.operands.get(1), 0, 9);
            assertTrue((mathProblem.operands.get(0) % 10) >= (mathProblem.operands.get(1) % 10));
            assertGenericSub(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.SUB_2DIG_1DIG);
            assertInRange(mathProblem.operands.get(0), 1, 99);
            assertInRange(mathProblem.operands.get(1), 0, 9);
            assertGenericSub(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.SUB_TENS);
            assertInRange(mathProblem.operands.get(0), 10, 100);
            assertInRange(mathProblem.operands.get(1), 10, 100);
            assertTrue((mathProblem.operands.get(0) % 10) == 0);
            assertTrue((mathProblem.operands.get(1) % 10) == 0);
            assertGenericSub(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.SUB_2DIG_2DIG_DONT_CROSS);
            assertInRange(mathProblem.operands.get(0), 10, 100);
            assertInRange(mathProblem.operands.get(1), 0, 99);
            assertTrue((mathProblem.operands.get(0) % 10) >= (mathProblem.operands.get(1) % 10));
            assertGenericSub(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.SUB_2DIG_2DIG);
            assertInRange(mathProblem.operands.get(0), 10, 99);
            assertInRange(mathProblem.operands.get(1), 1, 99);
            assertGenericSub(mathProblem);
        }
    }

    @Test
    public void test_multiplication_all() {
        for (int i = 0; i < 100; i++) {
            MathProblem mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.MULT_1DIGxUNDER5);
            assertInRange(mathProblem.operands.get(0), 1, 5);
            assertInRange(mathProblem.operands.get(1), 1, 10);
            assertGenericMult(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.MULT_1DIG);
            assertInRange(mathProblem.operands.get(0), 1, 10);
            assertInRange(mathProblem.operands.get(1), 1, 10);
            assertGenericMult(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.MULT_1DIG_2DIG_ROUND);
            assertInRange(mathProblem.operands.get(0), 1, 10);
            assertInRange(mathProblem.operands.get(1), 10, 100);
            assertTrue((mathProblem.operands.get(1) % 10) == 0);
            assertGenericMult(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.MULT_1DIGxUNDER20);
            assertInRange(mathProblem.operands.get(0), 1, 10);
            assertInRange(mathProblem.operands.get(1), 11, 20);
            assertGenericMult(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.MULT_1DIGxUNDER30);
            assertInRange(mathProblem.operands.get(0), 1, 10);
            assertInRange(mathProblem.operands.get(1), 21, 30);
            assertGenericMult(mathProblem);
        }
    }

    @Test
    public void test_division_all() {
        for (int i = 0; i < 100; i++) {
            MathProblem mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.DIV_1DIG);
            assertInRange(mathProblem.operands.get(1), 1, 10);
            assertInRange(mathProblem.result.get(0), 1, 10);
            assertGenericDiv(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.DIV_1DIG_2DIG_ROUND);
            assertInRange(mathProblem.operands.get(1), 1, 10);
            assertInRange(mathProblem.result.get(0), 10, 100);
            assertGenericDiv(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.DIV_1DIGxUNDER20);
            assertInRange(mathProblem.operands.get(1), 1, 10);
            assertInRange(mathProblem.result.get(0), 11, 20);
            assertGenericDiv(mathProblem);

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.DIV_1DIGxUNDER30);
            assertInRange(mathProblem.operands.get(1), 1, 10);
            assertInRange(mathProblem.result.get(0), 21, 30);
            assertGenericDiv(mathProblem);
        }
    }


    @Test
    public void test_enum() {
        MathGenerator.OperationType operationType = OperationType.ADD_SUM_UNDER10;
        Log.d(TAG, "test_enum: operationType " + operationType.toString());
        Log.d(TAG, "test_enum: mathproblem " + operationType.mathProblem);
        Log.d(TAG, "test_enum: view " + operationType.viewType);
        MathProblem mathProblem = operationType.mathProblem;
        mathProblem.generate(operationType);
    }

    private void assertInRange(Integer value, int min, int max) {
        assertTrue(value >= min);
        assertTrue(value <= max);
    }

    private void assertGenericAdd(MathProblem mathProblem) {
        assertTrue(mathProblem.operands.size() == 2);
        assertTrue(mathProblem.result.size() == 1);
        assertTrue(mathProblem.result.get(0) == (mathProblem.operands.get(0) + mathProblem.operands.get(1)));
    }

    private void assertGenericSub(MathProblem mathProblem) {
        assertTrue(mathProblem.operands.size() == 2);
        assertTrue(mathProblem.operands.get(0) >= mathProblem.operands.get(1));
        assertTrue(mathProblem.result.size() == 1);
        assertTrue(mathProblem.result.get(0) == (mathProblem.operands.get(0) - mathProblem.operands.get(1)));
        assertTrue(mathProblem.result.get(0) >= 0);
    }

    private void assertGenericMult(MathProblem mathProblem) {
        assertTrue(mathProblem.operands.size() == 2);
        assertTrue(mathProblem.result.size() == 1);
        assertTrue(mathProblem.result.get(0) == (mathProblem.operands.get(0) * mathProblem.operands.get(1)));
        assertTrue(mathProblem.operands.get(0) > 0);
        assertTrue(mathProblem.operands.get(1) > 0);
        assertTrue(mathProblem.result.get(0) > 0);
    }

    private void assertGenericDiv(MathProblem mathProblem) {
        assertTrue(mathProblem.operands.size() == 2);
        assertTrue(mathProblem.result.size() == 1);
        assertTrue(mathProblem.operands.get(0) == (mathProblem.operands.get(1) * mathProblem.result.get(0)));
        assertTrue(mathProblem.operands.get(0) > 0);
        assertTrue(mathProblem.operands.get(1) > 0);
        assertTrue(mathProblem.result.get(0) > 0);
    }


        @Test
    public void testGenerateLCM() {
        assertEquals(12, MathProblemLCM.getLCM(3, 4));
        assertEquals(12, MathProblemLCM.getLCM(6, 4));
        assertEquals(4, MathProblemLCM.getLCM(2, 4));
        assertEquals(8, MathProblemLCM.getLCM(4, 8));
        assertEquals(12, MathProblemLCM.getLCM(2, 3, 4));
        assertEquals(12, MathProblemLCM.getLCM(6, 3, 4));
        assertEquals(30, MathProblemLCM.getLCM(2, 3, 5));
    }

    @Test
    public void testFraction() {
        for (int i = 0; i < 100; i++) {
            MathProblem mathProblem = mathGenerator.generateMathProblem(OperationType.FRACT_EXTRACT_WHOLE);
            assertInRange(mathProblem.result.get(0), 1, 10);

            mathProblem = mathGenerator.generateMathProblem(OperationType.FRACT_SIMPLE_ADD_SAME_DEN);
            assertInRange(mathProblem.operands.get(0), 1, 20);
            assertInRange(mathProblem.operands.get(1), 1, 20);
            assertTrue(mathProblem.result.get(0) < mathProblem.result.get(1));

            mathProblem = mathGenerator.generateMathProblem(OperationType.FRACT_SIMPLE_SUB_SAME_DEN);
            assertInRange(mathProblem.operands.get(0), 1, 20);
            assertInRange(mathProblem.operands.get(1), 1, 20);
            assertTrue(mathProblem.result.get(0) < mathProblem.result.get(1));

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.FRACT_ADD_SAME_DEN);
            assertInRange(mathProblem.operands.get(1), 1, 20);
            assertInRange(mathProblem.operands.get(2), 1, 20);
            assertTrue(mathProblem.result.get(1) < mathProblem.result.get(2));

            mathProblem = mathGenerator.generateMathProblem(MathGenerator.OperationType.FRACT_SUB_SAME_DEN);
            assertInRange(mathProblem.operands.get(1), 1, 20);
            assertInRange(mathProblem.operands.get(2), 1, 20);
            assertTrue(mathProblem.result.get(1) < mathProblem.result.get(2));

        }
    }




}