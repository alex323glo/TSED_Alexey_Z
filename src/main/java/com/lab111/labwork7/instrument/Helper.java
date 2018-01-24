package com.lab111.labwork7.instrument;

import com.lab111.labwork7.Coord;
import com.lab111.labwork7.WorkSpace;

import java.util.Map;

/**
 * Helper instrument class. An implementation of Instrument.
 *
 * @author Alexey Zolkin
 * @version 1.0
 *
 * @see Instrument
 */
public class Helper implements Instrument {
    /**
     * Carries out logic of usage of this instrument.
     *
     * @param x         X coordinate of cursor.
     * @param y         Y coordinate of cursor.
     * @param workSpace target workspace, whe this instrument is used.
     * @see WorkSpace
     */
    @Override
    public void use(int x, int y, WorkSpace workSpace) {
        Map<Coord, String> pointMap = workSpace.showAllPoints();
        Coord coord = new Coord(x, y);

        if (pointMap.containsKey(coord)) {
            System.out.printf("Helper: Point info: \n\tcoords: (%d;%d) \n\tcolor: \"%s\"\n",
                    x, y, pointMap.get(coord));
        } else {
            System.out.printf("Helper: Point (%d;%d) is transparent yet.\n", x, y);
        }
    }

    @Override
    public String toString() {
        return "Helper{hash=" + this.hashCode() + "}";
    }
}
