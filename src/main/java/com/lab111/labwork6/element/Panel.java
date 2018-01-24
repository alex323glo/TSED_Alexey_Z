package com.lab111.labwork6.element;

import com.lab111.labwork6.event.Event;
import com.lab111.labwork6.Layout;

import java.util.ArrayList;
import java.util.List;

/**
 * Panel model. An implementation of Element abstraction.
 *
 * @author Alexey Zolkin
 * @version 1.0
 *
 * @see Element
 */
public class Panel extends Element {

    private List<Element> elements;

    public Panel(Layout layout) {
        super(layout);
        elements = new ArrayList<>();
    }

    public Panel(Layout layout, String name) {
        super(layout, name);
        elements = new ArrayList<>();
    }

    /**
     * Adds single Element to this composite (Panel).
     *
     * @param element new Element.
     * @return ref to this Panel instance.
     *
     * @see Element
     */
    public Panel add(Element element) {
        if (element == null) {
            throw new NullPointerException("proposed element is null");
        }
        elements.add(element);
        return this;
    }

    /**
     * Shows List of all Elements, aggregated into this composite (Panel).
     *
     * @return List of Elements.
     *
     * @see List
     * @see Element
     */
    public List<Element> getAllElements() {
        return elements;
    }

    /**
     * Handles proposed event object.
     *
     * @param event target event object.
     * @see Event
     */
    @Override
    public void handle(Event event) {
        if (event == null) {
            throw new NullPointerException("event is null");
        }

        if (layout.matches(event.getX(), event.getY())) {
            System.out.printf("Redirecting from Panel \"%s\" (%d)...\n", name, this.hashCode());
            for (Element element: elements) {
                element.handle(event);
            }
        }
    }

    @Override
    public String toString() {
        return "Panel{" +
                "layout=" + layout +
                ", name='" + name + '\'' +
                '}';
    }
}
