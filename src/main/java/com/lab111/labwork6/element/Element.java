package com.lab111.labwork6.element;

import com.lab111.labwork6.event.Event;
import com.lab111.labwork6.Layout;

/**
 * Graphic interface element abstract model.
 *
 * @author Alexey Zolkin
 * @version 1.0
 */
public abstract class Element {

    protected Layout layout;
    protected String name;

    protected Element(Layout layout) {
        this.layout = layout;
    }

    protected Element(Layout layout, String name) {
        this.layout = layout;
        this.name = name;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Handles proposed event object.
     *
     * @param event target event object.
     *
     * @see Event
     */
    public abstract void handle(Event event);

}
