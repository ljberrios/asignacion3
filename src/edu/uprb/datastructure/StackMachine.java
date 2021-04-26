/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */


package edu.uprb.datastructure;

/**
 * Represents a stack machine. A stack machine is a type of computer
 * which most of its instructions operate using a stack.
 *
 * @author Luis J. Berríos Negrón
 */
public class StackMachine {

    /**
     * The elements stored in the stack.
     */
    private double[] data;
    /**
     * The element stored at the top of the stack.
     */
    private int top;
    /**
     * The element stored just before the top of the stack.
     */
    private int second;

    /**
     * Construct a stack machine with an initial capacity of 10.
     */
    public StackMachine() {
        data = new double[10];
        top = -1;
        second = -2;
    }

    /**
     * Push an element to the top of the stack.
     *
     * @param num The element to push
     */
    public void push(double num) {
        ensureCapacity();
        top++;
        second++;
        data[top] = num;
    }

    /**
     * Ensure the stack has enough capacity by doubling
     * said capacity if necessary.
     */
    private void ensureCapacity() {
        if (top == data.length - 1) {
            int newSize = data.length * 2;
            double[] temp = new double[newSize];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
    }

    /**
     * Remove the element at the top of stack and return it.
     *
     * @return The element that was at the top of the stack
     */
    public double pop() {
        checkIsEmpty();
        double num = data[top];
        top--;
        return num;
    }

    /**
     * Return the element at the top of the stack
     * without removing it.
     *
     * @return The element at the top of the stack
     */
    public double peek() {
        checkIsEmpty();
        return data[top];
    }

    /**
     * Check if there's an element at the top of the stack.
     * If there isn't, then the stack is empty.
     *
     * @return {@code true} if the stack is empty,
     * {@code false} if otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Add the top two elements of the stack and place the
     * result at the top of the stack.
     */
    public void add() {
        checkIsEmpty();
        checkEnoughElements();
        double result = data[top] + data[second];
        push(result);
    }

    /**
     * Subtract the top two elements of the stack (top - second)
     * and place the result at the top of the stack.
     */
    public void sub() {
        checkEnoughElements();
        double result = data[top] - data[second];
        push(result);
    }

    /**
     * Multiply the top two elements of the stack
     * and place the result at the top of the stack.
     */
    public void mult() {
        checkEnoughElements();
        double result = data[top] * data[second];
        push(result);
    }

    /**
     * Divide the top element of the stack by the second element
     * (top / second) and place the result at the top of the stack.
     */
    public void div() {
        checkEnoughElements();
        double result = data[top] / data[second];
        push(result);
    }

    /**
     * Raise the second element of the stack to the power of the
     * top element and place the result at the top of the stack.
     */
    public void pow() {
        checkEnoughElements();
        double result = Math.pow(data[second], data[top]);
        push(result);
    }

    /**
     * Check if the stack contains two elements or more.
     * If not, throw a {@link NotEnoughElementsException}.
     */
    private void checkEnoughElements() {
        if (second < 0) {
            throw new NotEnoughElementsException(
                    "need at least two elements in the stack");
        }
    }

    /**
     * Check if the stack is empty.
     * If it is, throw a {@link NotEnoughElementsException}.
     */
    private void checkIsEmpty() {
        if (isEmpty()) {
            throw new NotEnoughElementsException(
                    "need at least two elements in the stack");
        }
    }

    /**
     * Get the amount of elements stored in the stack.
     *
     * @return The amount of elements stored in the stack
     */
    public int size() {
        return top + 1;
    }

    /**
     * Get the string representation of the stack.
     *
     * @return The string representation of the stack
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = top; i >= 0; i--) {
            builder.append(data[i]);
            if (i != 0) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * Used when the stack doesn't contain the required amount of elements.
     */
    private static class NotEnoughElementsException extends RuntimeException {
        public NotEnoughElementsException() {}

        public NotEnoughElementsException(String msg) {
            super(msg);
        }
    }

}
