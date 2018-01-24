package com.lab111.labwork7;

import com.lab111.labwork7.instrument.Instrument;

import java.util.HashMap;
import java.util.Map;

import static com.lab111.labwork7.utils.Validator.*;

/**
 * Simple implementation of WorkSpace interface.
 *
 * @author Alexey Zolkin
 * @version 1.0
 *
 * @see WorkSpace
 */
public class WorkSpaceImpl implements WorkSpace {

    private Instrument currentInstrument;
    private String currentColor;

    private Map<Coord, String> pointMap;

    public WorkSpaceImpl(Instrument currentInstrument, String currentColor) {
        if (currentInstrument == null || currentColor == null) {
            throw new NullPointerException("currentInstrument or currentColor is null");
        }

        this.currentInstrument = currentInstrument;
        this.currentColor = currentColor;

        pointMap = new HashMap<>();
    }

    /**
     * Serves logic of mouse click on direct screen point.
     * Should be also followed with logic of current Instrument instance.
     *
     * @param x abscissa of cursor.
     * @param y ordinate of cursor.
     * @see Instrument
     */
    @Override
    public void click(int x, int y) {
        if (!coordsAreValid(x, y)) {
            System.out.printf("WorkSpace: Error! Coords (%d;%d) are not valid for this Workspace!\n", x, y);
            return;
        }
        currentInstrument.use(x, y, this);
    }

    /**
     * Serves logic of selecting instrument.
     *
     * @param instrument ref to new current instrument.
     */
    @Override
    public void setCurrentInstrument(Instrument instrument) {
        if (instrument == null) {
            System.out.printf("WorkSpace: Error! New instrument is null and will not replace old one (%s)!\n",
                    currentInstrument);
            return;
        }
        this.currentInstrument = instrument;
    }

    /**
     * Shows current instrument.
     *
     * @return ref to current instrument.
     */
    @Override
    public Instrument getCurrentInstrument() {
        return currentInstrument;
    }

    /**
     * Serves logic of selecting color.
     *
     * @param color ref to new current color.
     */
    @Override
    public void setCurrentColor(String color) {
        if (color == null) {
            System.out.printf("WorkSpace: Error! New color is null and will not replace old one (%s)!\n",
                    currentColor);
            return;
        }
        this.currentColor = color;
    }

    /**
     * Shows current color.
     *
     * @return ref to current color.
     */
    @Override
    public String getCurrentColor() {
        return currentColor;
    }

    /**
     * Shows all placed in current workspace points.
     *
     * @return Map of pairs: point's coordinates and its color.
     * @see Map
     * @see Coord
     */
    @Override
    public Map<Coord, String> showAllPoints() {
        return pointMap;
    }

    /**
     * Clears this WorkSpace (its points' Map).
     *
     * @return removed points' Map of pairs: point's coordinates and its color.
     * @see Map
     * @see Coord
     */
    @Override
    public Map<Coord, String> clearWorkSpace() {
        Map<Coord, String> oldPointMap = pointMap;
        pointMap = new HashMap<>();

        System.out.println("WorkSpace: Workspace was successfully cleared!");
        return oldPointMap;
    }

    /**
     * Shows workspace info.
     *
     * @return String text of info.
     */
    @Override
    public String showInfo() {
        return String.format(" *** Workspace info *** " +
                        "\n\tWorkspace hash: %d "+
                        "\n\tCurrent instrument: %s "+
                        "\n\tCurrent color: \"%s\"" +
                        "\n *** \n",
                this.hashCode(),
                this.currentInstrument.toString(),
                this.currentColor);
    }
}
