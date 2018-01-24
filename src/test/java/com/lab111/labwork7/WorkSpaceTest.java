package com.lab111.labwork7;

import com.lab111.labwork7.instrument.Instrument;
import com.lab111.labwork7.instrument.Pencil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class WorkSpaceTest {

    private static WorkSpace workSpace;
    private static Instrument defaultInstrument;

    private static final String DEFAULT_COLOR = "black(default)";

    private static final String TEST_COLOR = "red";
    private static final int TEST_COORD_X = 5;
    private static final int TEST_COORD_Y = 5;

    @Before
    public void setUp() throws Exception {
        defaultInstrument = new Pencil();
        workSpace = new WorkSpaceImpl(defaultInstrument, DEFAULT_COLOR);
    }

    @Test
    public void click() throws Exception {
        workSpace.click(TEST_COORD_X, TEST_COORD_Y);

        Coord coord = new Coord(TEST_COORD_X, TEST_COORD_Y);
        assertEquals(DEFAULT_COLOR, workSpace.showAllPoints().get(coord));
    }

    @Test
    public void setCurrentInstrumentNull() throws Exception {
        workSpace.setCurrentInstrument(null);
        assertEquals(defaultInstrument, workSpace.getCurrentInstrument());
    }

    @Test
    public void getCurrentInstrument() throws Exception {
        assertEquals(defaultInstrument, workSpace.getCurrentInstrument());
    }

    @Test
    public void setCurrentColorNull() throws Exception {
        workSpace.setCurrentColor(null);
        assertEquals(DEFAULT_COLOR, workSpace.getCurrentColor());
    }

    @Test
    public void getCurrentColor() throws Exception {
        assertEquals(DEFAULT_COLOR, workSpace.getCurrentColor());
    }

    @Test
    public void showAllPoints() throws Exception {
        workSpace.setCurrentColor(TEST_COLOR);
        workSpace.click(TEST_COORD_X, TEST_COORD_Y);

        Coord coord = new Coord(TEST_COORD_X, TEST_COORD_Y);
        assertEquals(TEST_COLOR, workSpace.showAllPoints().get(coord));
        assertEquals(1, workSpace.showAllPoints().size());
    }

    @Test
    public void clearWorkSpace() throws Exception {
        workSpace.click(TEST_COORD_X, TEST_COORD_Y);
        assertEquals(1, workSpace.showAllPoints().size());

        Coord coord = new Coord(TEST_COORD_X, TEST_COORD_Y);
        Map<Coord, String> deletedMap = workSpace.clearWorkSpace();

        assertEquals(DEFAULT_COLOR, deletedMap.get(coord));
        assertEquals(0, workSpace.showAllPoints().size());
    }

}