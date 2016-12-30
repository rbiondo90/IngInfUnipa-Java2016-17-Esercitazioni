/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipa.community.robertobiondo.prg.n12.es07;

import java.util.Objects;

/**
 *
 * @author Roberto Biondo
 */
public class ToDoTask implements Comparable<ToDoTask> {

    private String description;
    private int priority;

    public ToDoTask(String description, int priority) throws IllegalArgumentException {
        this.setDescription(description);
        this.setPriority(priority);
    }

    public void setPriority(int priority) throws IllegalArgumentException{
        if (priority < 1 || priority > 9) {
            throw new IllegalArgumentException("Priority must be an integer between 1 and 9!");
        }
        this.priority = priority;
    }

    public void setDescription(String description) throws IllegalArgumentException {
        if (Objects.isNull(description) || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty!");
        }
        this.description = description;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return this.getDescription() + "(" + this.getPriority() + ")";
    }

    @Override
    public int compareTo(ToDoTask t) {
        if (this.getPriority() > t.getPriority()) {
            return -1;
        }
        if (this.getPriority() < t.getPriority()) {
            return 1;
        }
        return t.getDescription().compareTo(this.getDescription());
    }

}
