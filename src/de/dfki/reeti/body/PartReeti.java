/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import de.dfki.common.part.Part;
import de.dfki.common.part.Part3D;
import de.dfki.reeti.animationlogic.AnimatorReeti;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import java.awt.*;
import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public abstract class PartReeti extends Part3D
{
    private static PhongMaterial material = null;

    public void init()
    {
        super.init();
    }

    public void set_X_Translation(int length)
    {
        mXTranslationStep = (double) length / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public void set_Y_Translation(int length)
    {
        mYTranslationStep = (double) length / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public void set_Z_Translation(int length)
    {
        mZTranslationStep = (double) length / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public synchronized void calculate_X_Translation(int step)
    {
        mXTranslation += mXTranslationStep;
        mXTranslation = Math.round(mXTranslation * 1000d) / 1000d;

        Platform.runLater(() -> calculate(step));
    }

    public synchronized void calculate_Y_Translation(int step)
    {
        mYTranslation += mYTranslationStep;
        mYTranslation = Math.round(mYTranslation * 1000d) / 1000d;

        Platform.runLater(() -> calculate(step));
    }

    public synchronized void calculate_Z_Translation(int step)
    {
        mZTranslation += mZTranslationStep;
        mZTranslation = Math.round(mZTranslation * 1000d) / 1000d;

        Platform.runLater(() -> calculate(step));
    }

    public void resetTranslation()
    {
        mXTranslationStep = 0.0d;
        mYTranslationStep = 0.0d;
        mZTranslationStep = 0.0d;
    }

    public void setDefaulRotation(int degree)
    {
        mDefaultRotation = degree;
        mXRotation = mDefaultRotation;
        mYRotation = mDefaultRotation;
        mZRotation = mDefaultRotation;

        mToDegreeX = mDefaultRotation;
        mXRotationStep = 0.0f;
    }

    public void set_X_Rotation(int degree)
    {
        mToDegreeX = mXRotation + degree;
        mXRotationStep = (double) degree / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public void set_Y_Rotation(int degree)
    {
        mYRotationStep = (double) degree / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public void set_Z_Rotation(int degree)
    {
        mZRotationStep = (double) degree / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public void setTilt(int degree)
    {
        mToDegreeX = mXRotation + degree;
        mXRotationStep = (double) degree / AnimatorReeti.sMAX_ANIM_STEPS;
    }

    public synchronized void calculate_X_Rotation(int step)
    {
        mXRotation += mXRotationStep;
        mXRotation = (double) Math.round(mXRotation * 1000d) / 1000d;

        Platform.runLater(() -> calculate(step));
    }

    public synchronized void calculate_Y_Rotation(int step)
    {
        mYRotation += mYRotationStep;
        mYRotation = (double) Math.round(mYRotation * 1000d) / 1000d;

        Platform.runLater(() -> calculate(step));
    }

    public synchronized void calculate_Z_Rotation(int step)
    {
        mZRotation += mZRotationStep;
        mZRotation = (double) Math.round(mZRotation * 1000d) / 1000d;

        Platform.runLater(() -> calculate(step));

    }

    public void resetRotation()
    {
//        mTranslationStep = 0.0d;
    }

    public void reset_X_Rotation()
    {
        mXRotation += mXRotationStep;
        Platform.runLater(() -> calculate(1));
        mXRotationStep = 0;
    }

    public void reset_Y_Rotation()
    {
        mYRotation += mYRotationStep;
        Platform.runLater(() -> calculate(1));
        mYRotationStep = 0;
    }

    public void reset_Z_Rotation()
    {
        mZRotation += mZRotationStep;
        Platform.runLater(() -> calculate(1));
        mZRotationStep = 0;
    }

    public void setShape(String s)
    {
        // place code for setting shape
    }

    public synchronized void calculateShape(int step)
    {
        mShapeAnimationStep = step;

        Platform.runLater(() -> calculate(step));
    }

    public void resetShape()
    {
        mShapeAnimationStep = 0;
    }

    public void clearChildren(PartReeti bodyPartFX)
    {
        bodyPartFX.getChildren().clear();
    }

    protected PhongMaterial getMaterial()
    {
        if (material == null)
        {
            URL imageUrl = getClass().getClassLoader().getResource("Images/difuseMap2.png");
            javafx.scene.image.Image image = new javafx.scene.image.Image(imageUrl.toExternalForm());
            material = new PhongMaterial();
            material.setDiffuseColor(mColor);
            material.setDiffuseMap(image);
            material.setSelfIlluminationMap(image);
        }
        return material;
    }


}
