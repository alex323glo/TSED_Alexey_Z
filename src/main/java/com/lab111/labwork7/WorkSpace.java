package com.lab111.labwork7;

import com.lab111.labwork7.instrument.Instrument;

import java.util.Map;

/**
 * General interface for painting Workspace.
 *
 * @author Alexey Zolkin
 * @version 1.0
 */
public interface WorkSpace {

    /**
     * Serves logic of mouse click on direct screen point.
     * Should be also followed with logic of current Instrument instance.
     *
     * @param x abscissa of cursor.
     * @param y ordinate of cursor.
     *
     * @see Instrument
     */
    void click(int x, int y);

    /**
     * Serves logic of selecting instrument.
     *
     * @param instrument ref to new current instrument.
     */
    void setCurrentInstrument(Instrument instrument);

    /**
     * Shows current instrument.
     *
     * @return ref to current instrument.
     */
    Instrument getCurrentInstrument();

    /**
     * Serves logic of selecting color.
     *
     * @param color ref to new current color.
     */
    void setCurrentColor(String color);

    /**
     * Shows current color.
     *
     * @return ref to current color.
     */
    String getCurrentColor();

    /**
     * Shows all placed in current workspace points.
     *
     * @return Map of pairs: point's coordinates and its color.
     *
     * @see Map
     * @see Coord
     */
    Map<Coord, String> showAllPoints();

    /**
     * Clears this WorkSpace (its points' Map).
     *
     * @return removed points' Map of pairs: point's coordinates and its color.
     *
     * @see Map
     * @see Coord
     */
    Map<Coord, String> clearWorkSpace();

    /**
     * Shows workspace info.
     *
     * @return String text of info.
     */
    String showInfo();
}
