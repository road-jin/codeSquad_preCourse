package org.codesquad.stack;

import java.util.EmptyStackException;

public class StackImpl implements Stack {

    private final String[] stack;
    private int length;

    public StackImpl(int size) {
        this.stack = new String[size];
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public int capacity() {
        return this.stack.length - length();
    }

    @Override
    public String pop() {
        if (length() < 1) {
            throw new EmptyStackException();
        }

        String pop = this.stack[length() - 1];
        this.length--;
        return pop;
    }

    @Override
    public boolean push(String val) {
        if (capacity() > 0) {
            this.stack[length()] = val;
            this.length++;
            return true;
        }

        return false;
    }
}
