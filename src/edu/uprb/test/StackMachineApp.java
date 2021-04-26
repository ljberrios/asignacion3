/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */


package edu.uprb.test;

import edu.uprb.datastructure.StackMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test case for the {@link StackMachine} class.
 *
 * @author Luis J. Berríos Negrón
 */
public class StackMachineApp {

    /**
     * Reference to class under test.
     */
    private StackMachine stack;

    /**
     * Creates a non-empty stack for testing.
     */
    @BeforeEach
    public void setUp() {
        stack = new StackMachine();
        stack.push(3.0);
        stack.push(7.0);
        stack.push(1.3);
    }

    /**
     * Tests that a non-empty stack has the expected string representation.
     */
    @Test
    public void testToStringForNonEmptyStack() {
        assertEquals("[1.3, 7.0, 3.0]", stack.toString());
    }

    /**
     * Tests that a non-empty stack has the expected size.
     */
    @Test
    public void testSizeForNonEmptyStack() {
        assertEquals(3, stack.size());
    }

    /**
     * Tests that a non-empty stack has the expected status.
     */
    @Test
    public void testIsEmptyForNonEmptyStack() {
        assertFalse(stack.isEmpty());
    }

    /**
     * Tests that a non-empty stack has the expected top element.
     */
    @Test
    public void testPeekForNonEmptyStack() {
        assertEquals(1.3, stack.peek());
    }

    /**
     * Tests that an element can be popped from a non-empty stack.
     */
    @Test
    public void testPopForNonEmptyStack() {
        assertEquals(1.3, stack.pop());
        assertEquals("[7.0, 3.0]", stack.toString());
        assertEquals(2, stack.size());
    }

    /**
     * Tests that the addition of the top element and the second element
     * is computed and stored as expected.
     */
    @Test
    public void testAdditionForNonEmptyStack() {
        stack.add();
        assertEquals(1.3 + 7.0, stack.peek());
    }

    /**
     * Tests that the subtraction of the top element and the second element
     * (top - second) is computed and stored as expected.
     */
    @Test
    public void testSubtractionForNonEmptyStack() {
        stack.sub();
        assertEquals(1.3 - 7.0, stack.peek());
    }

    /**
     * Tests that the multiplication of the top element and the
     * second element is computed and stored as expected.
     */
    @Test
    public void testMultiplicationForNonEmptyStack() {
        stack.mult();
        assertEquals(1.3 * 7.0, stack.peek());
    }

    /**
     * Tests that the division of the top element and the
     * second element (top / second) is computed and stored as expected.
     */
    @Test
    public void testDivisionForNonEmptyStack() {
        stack.div();
        assertEquals(1.3 / 7.0, stack.peek());
    }

    /**
     * Tests that raising the second element to the power
     * of the top element is computed and stored as expected.
     */
    @Test
    public void testPowerForNonEmptyStack() {
        stack.pow();
        assertEquals(Math.pow(7.0, 1.3), stack.peek());
    }

}
