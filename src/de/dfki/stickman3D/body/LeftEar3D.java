/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import de.dfki.common.part.Part3D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;

import java.awt.*;
import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public class LeftEar3D extends PartStickman3D
{
    public LeftEar3D.SHAPE mShape = LeftEar3D.SHAPE.DEFAULT;
    private Head3D mHead;

    private MeshView mLeftEarMesh;
    private PhongMaterial material;

//    private Image image;

    private double initOpacity;

    public LeftEar3D(Part3D head)
    {
        mHead = (Head3D) head;
        mSize = new Dimension(mLength, mLength);
        initOpacity = 1.0;

        ColModelImporter importer = new ColModelImporter();
        mColor = Color.rgb(242, 227, 217, initOpacity);

        URL url = getClass().getClassLoader().getResource("BodyParts/Stickman3D/leftEar.dae");

        URL imageUrl = getClass().getClassLoader().getResource("Images/difuseMap1.png");
        Image image = new Image(imageUrl.toExternalForm());

        importer.read(url);
        mLeftEarMesh = (MeshView) importer.getImport()[0];

        material = new PhongMaterial();
        material.setDiffuseColor(mColor);
        material.setDiffuseMap(image);
        mLeftEarMesh.setMaterial(material);

        mStart = mHead.getLeftEyebrowPostion();

        init();

        mHead.getChildren().add(mLeftEarMesh);
    }

    @Override
    public void init()
    {
        super.init();
        mLeftEarMesh.setTranslateX(mStart.x + 53);
        mLeftEarMesh.setTranslateY(mStart.y + 102);
        mLeftEarMesh.setTranslateZ(-2);
    }

    @Override
    public void setShape(String s)
    {
        SHAPE shape = LeftEar3D.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : LeftEar3D.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = LeftEar3D.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {

        switch (mShape)
        {
            case FADEIN:
                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), 0.0);
                    update();
                    mLeftEarMesh.setVisible(false);
                } else if (mColor.getOpacity() != 0.0)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
                            mColor.getOpacity() - initOpacity / 19);
                    update();
                }
                break;

            case FADEOUT:
                mLeftEarMesh.setVisible(true);

                if (step == 2)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), initOpacity);
                    update();
                } else if (mColor.getOpacity() <= initOpacity)
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
                            mColor.getOpacity() + initOpacity / 19);
                    update();
                }
                break;
        }
    }

    @Override
    public void update()
    {
        material.setDiffuseColor(mColor);
//        material.setDiffuseMap(image);
        mLeftEarMesh.setMaterial(material);
    }

    @Override
    protected void recordColor()
    {
        if (mHead.getStickman().setCharacterInvisible == false)
            mColorRecorder = mColor;
    }

    public enum SHAPE
    {
        DEFAULT, FADEIN, FADEOUT
    }
}
