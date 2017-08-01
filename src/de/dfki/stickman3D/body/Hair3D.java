package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import de.dfki.common.agent.Agent3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.net.URL;

/**
 * Created by EmpaT on 29.07.2017.
 */
public abstract class Hair3D extends PartStickman3D
{
    public SHAPE mShape = SHAPE.DEFAULT;
    protected int mHalfHeight;
    protected int mHalfWidth;
    protected MeshView hairMeshView;
    protected PhongMaterial material;
    public Hair3D(Agent3D agent3D)
    {
        mSize = new Dimension(120, 100);
        mHalfHeight = mSize.height / 2;
        mHalfWidth = mSize.width / 2;
    }

    @Override
    public void setShape(String s)
    {
        SHAPE shape = SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        Rotate rx = new Rotate(mXRotation, Rotate.X_AXIS);
        Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
        Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

        hairMeshView.getTransforms().clear();
        hairMeshView.getTransforms().addAll(rx, ry, rz);

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    hairMeshView.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() - 0.052);
                    update();
                }
                break;

            case FADEOUT:
                hairMeshView.setVisible(true);

                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 1.0);
                    update();
                } else if (mColor.getOpacity() != 1.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), mColor.getOpacity() + 0.052);
                    update();
                }
                break;
        }
    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
        hairMeshView.setMaterial(material);
    }

    @Override
    public MeshView getMeshView()
    {
        return hairMeshView;
    }

    protected void initializeHair(URL hairURL)
    {
        StlMeshImporter importer = new StlMeshImporter();
        importer.read(hairURL);
        TriangleMesh hairTriangleMesh = importer.getImport();
        hairMeshView = new MeshView(hairTriangleMesh);
        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        hairMeshView.setMaterial(material);
        hairMeshView.setRotationAxis(Rotate.X_AXIS);
        hairMeshView.setRotate(-90);
    }

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }
}
