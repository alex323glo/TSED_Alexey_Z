package com.lab111.labwork7.utils;

/**
 * Static validation utils container.
 *
 * @author Alexey Zolkin.
 * @version 1.0
 */
public class Validator {
    /**
     * Validates coordinates (abscissa and ordinate) in
     * case of screen surface: each of them must be not less
     * then 0.
     *
     * @param x abscissa of cursor.
     * @param y ordinate of cursor.
     * @return true, if coords are valid and false, if they are not.
     */
    public static boolean coordsAreValid(int x, int y) {
        return x >= 0 && y >= 0;
    }
}
