package com.lab111.labwork6;

/**
 * Graphic interface element's layout model.
 *
 * @author Alexey Zolkin
 * @version 1.0
 */
public class Layout {

    private int x;
    private int y;
    private int length;
    private int height;

    public Layout() {
    }

    public Layout(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Layout(int x, int y, int length, int height) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Checks if proposed coords matches area of layout.
     *
     * @param x proposed X coord.
     * @param y proposed Y coord.
     * @return true, if proposed coords matches area and false, if they doesn't.
     */
    public boolean matches(int x, int y) {
        return x >= this.x && x < this.x + this.length &&
                y >= this.y && y < this.y + this.height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Layout layout = (Layout) o;

        if (x != layout.x) return false;
        if (y != layout.y) return false;
        if (length != layout.length) return false;
        return height == layout.height;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + length;
        result = 31 * result + height;
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", length=" + length +
                ", height=" + height +
                '}';
    }
}
