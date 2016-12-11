/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n09.n05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author Roberto Biondo
 */
public class Stack<T> {

    private final ArrayList<T> stack;
    private final int size;
    private int index;

    public Stack(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Stack size cannot be negative!");
        }
        stack = new ArrayList<>();
        this.size = capacity;
        this.index = 0;
    }

    public Stack() {
        this(100);
    }

    public int getSize() {
        return this.size;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isEmpty() {
        return this.getIndex() == 0;
    }

    public boolean isFull() {
        return this.getIndex() == this.getSize();
    }

    public void push(T element) throws StackException {
        if (!this.isFull()) {
            this.stack.add(this.getIndex(), element);
            this.index++;
        } else {
            throw new StackException("Stack is full, cannot push any element!");
        }
    }

    public T pop() throws StackException {
        if (!this.isEmpty()) {
            T element = this.stack.remove(this.getIndex() - 1);
            this.index--;
            return element;
        } else {
            throw new StackException("There are no elements to pop, stack is empty!");
        }
    }

    public T peek() throws StackException {
        if (!this.isEmpty()) {
            return this.stack.get(this.getIndex() - 1);
        } else {
            throw new StackException("There are no elements to peek, stack is empty!");
        }
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Empty stack";
        }
        int counter = this.getIndex() - 1;
        ListIterator<T> stackIterator = this.stack.listIterator(this.getIndex());
        StringBuilder s = new StringBuilder("");
        while (stackIterator.hasPrevious()) {
            s.append("\n").append(counter--).append(": ").append(stackIterator.previous());
        }
        return s.toString();
    }
}
