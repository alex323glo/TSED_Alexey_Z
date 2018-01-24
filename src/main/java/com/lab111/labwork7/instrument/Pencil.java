package com.lab111.labwork7.instrument;

import com.lab111.labwork7.Coord;
import com.lab111.labwork7.WorkSpace;

import java.util.Map;

/**
 * Pencil instrument class. An implementation of Instrument.
 *
 * @author Alexey Zolkin
 * @version 1.0
 *
 * @see Instrument
 */
public class Pencil implements Instrument {
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
            System.out.printf("Pencil: Point (%d;%d) was repainted from \"%s\" to \"%s\".\n",
                    x, y, pointMap.get(coord), workSpace.getCurrentColor());
        } else {
            System.out.printf("Pencil: New point: (%d;%d), color: %s.\n", x, y, workSpace.getCurrentColor());
        }

        pointMap.put(coord, workSpace.getCurrentColor());
    }

    @Override
    public String toString() {
        return "Pencil{hash=" + this.hashCode() + "}";
    }
}
