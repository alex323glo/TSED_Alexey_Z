package com.lab111.labwork6;

import com.lab111.labwork6.element.Button;
import com.lab111.labwork6.element.Panel;
import com.lab111.labwork6.event.Event;
import com.lab111.labwork6.event.MouseMove;

public class MainDemonstration {

    private static Event event;

    public static void main(String[] args) {
        Panel mainFramePanel = new Panel(new Layout(0, 0, 50, 90), "Main Frame");
        mainFramePanel
                .add(new Panel(new Layout(0, 0, 50, 20), "Panel_1")
                        .add(new Button(new Layout( 0, 0, 50, 10), "Button_1"))
                        .add(new Button(new Layout(0, 10, 50, 10), "Button_2"))
                )
                .add(new Panel(new Layout(0, 20, 50, 20), "Panel_2")
                        .add(new Button(new Layout(0, 20, 50, 10), "Button_3"))
                        .add(new Button(new Layout(0, 30, 50, 10), "Button_4"))
                )
                .add(new Panel(new Layout(0, 40, 50, 50), "Panel_3")
                        .add(new Panel(new Layout(0, 40, 50, 50), "Panel_4")
                                .add(new Button(new Layout(0, 40, 50, 50), "Button_4"))
                        )
                );

        event = new MouseMove();

        for (int i = 5; i < 50; i+=10) {
            event.setX(i);
            event.setY(i);

            mainFramePanel.handle(event);

            System.out.println("\n--------------------------------------\n");
        }
    }

}
