package com.lab111.labwork7;

import com.lab111.labwork7.instrument.Helper;
import com.lab111.labwork7.instrument.Instrument;
import com.lab111.labwork7.instrument.Pencil;
import com.lab111.labwork7.instrument.Rubber;



public class MainDemonstration {

    public static void main(String[] args) {

        Instrument pencil = new Pencil();
        Instrument rubber = new Rubber();
        Instrument helper = new Helper();
        String defaultColor = "black";

        WorkSpace workSpace = new WorkSpaceImpl(helper, defaultColor);
        System.out.println(workSpace.showInfo());
        /* will print:
           " *** Workspace info ***
	            Workspace hash: 1173230247
	            Current instrument: Helper{hash=856419764}
	            Current color: "black"
             *** "
         */

        workSpace.setCurrentColor(null);        // will print: "WorkSpace: Error! ..."
        workSpace.setCurrentInstrument(null);   // will print: "WorkSpace: Error! ..."

        workSpace.setCurrentColor("red");
        workSpace.setCurrentInstrument(pencil);
        workSpace.click(10, 10);        // will print: "Pencil: New point: ..."

        workSpace.setCurrentColor("white");
        workSpace.click(10, 10);        // will print "Pencil: Point (10;10) was repainted ..."

        workSpace.setCurrentInstrument(helper);
        workSpace.click(10, 10);
        /* will print:
                " Helper: Point info:
	                 coords: (10;10)
	                 color: "white" "
         */

        workSpace.setCurrentInstrument(rubber);
        workSpace.click(10, 10);        // will print "Rubber: Point (10;10) was made transparent."

        workSpace.click(10, 10);        // will print "Rubber: Can't remove point ..."


    }

}
