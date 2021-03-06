package de.dfki.reeti.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthTREE
{

    public static Polygon modifyUpperLip(Polygon currentUpperLipPolygon, float step)
    {
        if (step == 20 || step == 0)
        {
            currentUpperLipPolygon.getPoints().clear();
            currentUpperLipPolygon.getPoints().addAll(
                    // x 	y 
                    3.0, 0.0, // Point 0
                    5.5, -3.0, // Point 1
                    11.0, -7.0, // Point 2
                    16.0, -8.0, // Point 3
                    21.0, -7.0, // Point 4
                    26.5, -3.0, // Point 5
                    29.0, 0.0, // Point 6
                    25.0, 0.0, // Point 7
                    21.0, -4.0, // Point 8
                    16.0, -5.0, // Point 9
                    11.0, -4.0, // Point 10
                    7.0, 0.0 // Point 11
            );
        }
        return currentUpperLipPolygon;
    }

    public static Polygon modifyDownLip(Polygon currentDownLipPolygon, float step)
    {

        if (step == 20 || step == 0)
        {
            currentDownLipPolygon.getPoints().clear();
            currentDownLipPolygon.getPoints().addAll(
                    // x 	y 
                    3.0, 0.0, // Point 0
                    5.5, 3.0, // Point 1
                    11.0, 7.0, // Point 2
                    16.0, 8.0, // Point 3
                    21.0, 7.0, // Point 4
                    26.5, 3.0, // Point 5
                    29.0, 0.0, // Point 6
                    25.0, 0.0, // Point 7
                    21.0, 4.0, // Point 8
                    16.0, 5.0, // Point 9
                    11.0, 4.0, // Point 10
                    7.0, 0.0 // Point 11
            );
        }
        return currentDownLipPolygon;
    }

}
