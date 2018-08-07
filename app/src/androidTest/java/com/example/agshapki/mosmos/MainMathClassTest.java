package com.example.agshapki.mosmos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainMathClassTest {
    MainMathClass mainMathClass = new MainMathClass();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testEnum() {
        MainMathClass.OperationType operationType = MainMathClass.OperationType.ADD_1DIG;
        String operationTypeString = operationType.toString();
        assertEquals("ADD_1DIG", operationTypeString);
    }

    @Test
    public void generate_math_problem_ADD_MISC() {
        for (int i = 0; i<100; i++) {
            MathProblem mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.ADD_SUM_UNDER10);
            assertInRange(mathProblem.result.get(0), 1, 10);
            assertGenericAdd(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.ADD_1DIG);
            assertInRange(mathProblem.operands.get(0), 1, 9);
            assertInRange(mathProblem.operands.get(1), 1, 9);
            assertGenericAdd(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.ADD_SUM_UNDER100);
            assertInRange(mathProblem.result.get(0), 1, 100);
            assertGenericAdd(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.ADD_2DIG);
            assertInRange(mathProblem.operands.get(0), 1, 99);
            assertInRange(mathProblem.operands.get(1), 1, 99);
            assertGenericAdd(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.ADD_2DIG_1DIG);
            assertInRange(mathProblem.operands.get(0), 1, 99);
            assertInRange(mathProblem.operands.get(1), 1, 9);
            assertGenericAdd(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.ADD_2DIG_ROUND_2DIG);
            assertTrue((mathProblem.operands.get(0) % 10) == 0 );
            assertInRange(mathProblem.operands.get(1), 1, 99);
            assertGenericAdd(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.ADD_TENS);
            assertTrue((mathProblem.operands.get(0) % 10) == 0 );
            assertTrue((mathProblem.operands.get(1) % 10) == 0 );
            assertInRange(mathProblem.operands.get(0), 1, 99);
            assertInRange(mathProblem.operands.get(1), 1, 99);
            assertGenericAdd(mathProblem);
        }
    }

    @Test
    public void generate_math_problem_SUB_MISC() {
        for (int i = 0; i < 100; i++) {
            MathProblem mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.SUB_1DIG);
            assertInRange(mathProblem.operands.get(0), 1, 9);
            assertInRange(mathProblem.operands.get(1), 1, 9);
            assertGenericSub(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.SUB_2DIG_1DIG_DONT_CROSS);
            assertInRange(mathProblem.operands.get(0), 1, 99);
            assertInRange(mathProblem.operands.get(1), 0, 9);
            assertTrue( (mathProblem.operands.get(0) % 10) >= (mathProblem.operands.get(1) % 10));
            assertGenericSub(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.SUB_2DIG_1DIG);
            assertInRange(mathProblem.operands.get(0), 1, 99);
            assertInRange(mathProblem.operands.get(1), 0, 9);
            assertGenericSub(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.SUB_TENS);
            assertInRange(mathProblem.operands.get(0), 10, 100);
            assertInRange(mathProblem.operands.get(1), 10, 100);
            assertTrue((mathProblem.operands.get(0) % 10) == 0);
            assertTrue((mathProblem.operands.get(1) % 10) == 0);
            assertGenericSub(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.SUB_2DIG_2DIG_DONT_CROSS);
            assertInRange(mathProblem.operands.get(0), 10, 100);
            assertInRange(mathProblem.operands.get(1), 0, 99);
            assertTrue( (mathProblem.operands.get(0) % 10) >= (mathProblem.operands.get(1) % 10));
            assertGenericSub(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.SUB_2DIG_2DIG);
            assertInRange(mathProblem.operands.get(0), 10, 99);
            assertInRange(mathProblem.operands.get(1), 1, 99);
            assertGenericSub(mathProblem);
        }
    }

    @Test
    public void generate_math_problem_MULT_MISC() {
        for (int i = 0; i < 100; i++) {
            MathProblem mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.MULT_1DIG);
            assertInRange(mathProblem.operands.get(0), 1, 10);
            assertInRange(mathProblem.operands.get(1), 1, 10);
            assertGenericMult(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.MULT_1DIG_2DIG_ROUND);
            assertInRange(mathProblem.operands.get(0), 1, 10);
            assertInRange(mathProblem.operands.get(1), 10, 100);
            assertTrue( (mathProblem.operands.get(1) % 10) == 0);
            assertGenericMult(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.MULT_1DIGxUNDER20);
            assertInRange(mathProblem.operands.get(0), 1, 10);
            assertInRange(mathProblem.operands.get(1), 1, 20);
            assertGenericMult(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.MULT_1DIGxUNDER30);
            assertInRange(mathProblem.operands.get(0), 1, 10);
            assertInRange(mathProblem.operands.get(1), 1, 30);
            assertGenericMult(mathProblem);
        }
    }

    @Test
    public void generate_math_problem_DIV_MISC() {
        for (int i = 0; i < 100; i++) {
            MathProblem mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.DIV_1DIG);
            assertInRange(mathProblem.operands.get(1), 1, 10);
            assertInRange(mathProblem.result.get(0), 1, 10);
            assertGenericDiv(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.DIV_1DIG_2DIG_ROUND);
            assertInRange(mathProblem.operands.get(1), 1, 10);
            assertInRange(mathProblem.result.get(0), 10, 100);
            assertGenericDiv(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.DIV_1DIGxUNDER20);
            assertInRange(mathProblem.operands.get(1), 1, 10);
            assertInRange(mathProblem.result.get(0), 1, 20);
            assertGenericDiv(mathProblem);

            mathProblem = mainMathClass.generate_math_problem(MainMathClass.OperationType.DIV_1DIGxUNDER30);
            assertInRange(mathProblem.operands.get(1), 1, 10);
            assertInRange(mathProblem.result.get(0), 1, 30);
            assertGenericDiv(mathProblem);
        }
    }

    private void assertGenericDiv(MathProblem mathProblem) {
        assertTrue(mathProblem.operands.size() == 2);
        assertTrue(mathProblem.result.size() == 1);
        assertTrue(mathProblem.operands.get(0) == (mathProblem.operands.get(1) * mathProblem.result.get(0)));
        assertTrue(mathProblem.operands.get(0) > 0);
        assertTrue(mathProblem.operands.get(1) > 0);
        assertTrue(mathProblem.result.get(0) > 0);
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
}