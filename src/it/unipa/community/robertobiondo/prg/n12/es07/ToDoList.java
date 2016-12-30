/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n12.es07;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Roberto Biondo
 */
public class ToDoList {

    Queue<ToDoTask> toDoList = new PriorityQueue<>();

    public boolean add(String task, int priority) throws IllegalArgumentException {
        return this.toDoList.add(new ToDoTask(task, priority));
    }

    public String next() {
        try {
            return this.toDoList.remove().getDescription();
        } catch (NoSuchElementException | NullPointerException ex) {
            return "Nothing to do!";
        }
    }
}
