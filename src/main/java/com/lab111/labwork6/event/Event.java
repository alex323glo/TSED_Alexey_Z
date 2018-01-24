package com.lab111.labwork6.event;

import com.lab111.labwork6.element.Element;

/**
 * Simple event model.
 *
 * @author Alexey Zolkin
 * @version 1.0
 */
public abstract class Event {

    protected int x;
    protected int y;

    public Event() {
    }

    public Event(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Executes events logic.
     *
     * @param handler Element, which handles this event instance.
     *
     * @see Element
     */
    public abstract void execute(Element handler);
}
