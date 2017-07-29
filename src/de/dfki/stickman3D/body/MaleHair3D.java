package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import de.dfki.common.agent.Agent3D;
import de.dfki.stickman3D.Stickman3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class MaleHair3D extends Hair3D
{

    public MaleHair3D(Agent3D agent3D)
    {
        super(agent3D);
        mColor = Color.rgb(97, 58, 0, 1);
        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/maleHair.stl");

        initializeHair(url);
        agent3D.mHead.getChildren().add(hairMeshView);

        init();

        calculate(0);
    }

    @Override
    public void init()
    {
        super.init();
        int mZTranslate = 3;
        hairMeshView.setTranslateX(mHalfWidth - 60);
        hairMeshView.setTranslateY(mHalfHeight - 52);
        hairMeshView.setTranslateZ(mZTranslate);
    }
}
