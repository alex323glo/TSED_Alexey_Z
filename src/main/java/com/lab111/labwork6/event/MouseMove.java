package com.lab111.labwork6.event;

import com.lab111.labwork6.element.Element;

/**
 * Mouse move event model. An implementation of Event abstraction.
 *
 * @author Alexey Zolkin
 * @version 1.0
 *
 * @see Event
 */
public class MouseMove extends Event {

    public MouseMove() {
    }

    public MouseMove(int x, int y) {
        super(x, y);
    }

    /**
     * Executes events logic.
     *
     * @param handler Element, which handles this event instance.
     * @see Element
     */
    @Override
    public void execute(Element handler) {
        System.out.printf(" * Mouse move event is handled at (%d;%d) by Element (%s).\n",
                x, y, handler);
    }
}
