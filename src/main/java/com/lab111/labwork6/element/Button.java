package com.lab111.labwork6.element;

import com.lab111.labwork6.event.Event;
import com.lab111.labwork6.Layout;

/**
 * Button model. An implementation of Element abstraction.
 *
 * @author Alexey Zolkin
 * @version 1.0
 *
 * @see Element
 */
public class Button extends Element {

    public Button(Layout layout) {
        super(layout);
    }

    public Button(Layout layout, String name) {
        super(layout, name);
    }

    /**
     * Handles proposed event object.
     *
     * @param event target event object.
     * @see Event
     */
    @Override
    public void handle(Event event) {
        if (layout.matches(event.getX(), event.getY())) {
            System.out.printf("Button \"%s\" (%d) was selected!\n", name, this.hashCode());
            event.execute(this);
        }
    }

    @Override
    public String toString() {
        return "Button{" +
                "layout=" + layout +
                ", name='" + name + '\'' +
                '}';
    }
}
