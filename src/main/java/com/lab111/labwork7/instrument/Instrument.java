package com.lab111.labwork7.instrument;

import com.lab111.labwork7.WorkSpace;

/**
 * General interface for Drawing instruments.
 *
 * @author Alexey Zolkin
 * @version 1.0
 */
public interface Instrument {

    /**
     * Carries out logic of usage of this instrument.
     *
     * @param x X coordinate of cursor.
     * @param y Y coordinate of cursor.
     * @param workSpace target workspace, whe this instrument is used.
     *
     * @see WorkSpace
     */
    void use(int x, int y, WorkSpace workSpace);

}
