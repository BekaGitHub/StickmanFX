package de.dfki.stickman3D.body;

import de.dfki.common.agent.Agent3D;
import javafx.scene.paint.Color;

import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class FemaleHair3D extends Hair3D
{


    public FemaleHair3D(Agent3D agent3D)
    {
        super(agent3D);
        mColor = Color.rgb(240, 212, 0, 1);
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/femaleHair.stl");

        initializeHair(url);
        agent3D.mHead.getChildren().add(hairMeshView);

        init();

        calculate(0);
    }

    @Override
    public void init()
    {
        super.init();
        int mZTranslate = 16;
        hairMeshView.setTranslateX(mHalfWidth - 60);
        hairMeshView.setTranslateY(mHalfHeight - 57);
        hairMeshView.setTranslateZ(mZTranslate);
    }
}
