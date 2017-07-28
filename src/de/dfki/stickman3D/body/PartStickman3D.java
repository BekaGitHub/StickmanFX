/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.body;

import de.dfki.common.animationlogic.Animator;
import de.dfki.common.part.Part3D;
import de.dfki.stickman3D.animationlogic.Animator3D;
import javafx.application.Platform;
import javafx.scene.transform.Affine;

/**
 * @author Beka Aptsiauri
 */
public abstract class PartStickman3D extends Part3D
{
    public double mXRotatationRecorder;
    public double mYRotatationRecorder;
    public double mZRotatationRecorder;

    public void init()
    {
        mColorRecorder = mColor;
        mXRotatationRecorder = mXRotation;
        mYRotatationRecorder = mYRotation;
        mZRotatationRecorder = mZRotation;
        super.init();
    }

    @Override
    public void resetRotation()
    {
    }

    public void update()
    {
        recordColor();
    }

    protected void recordColor()
    {

    }

    public void rotatePerlinNoise(double mWobble, int x, int y)
    {
        Affine af = new Affine();
        // Out put perlin noise
        af.appendRotation(Math.toRadians(mWobble), x, y);
        this.getTransforms().clear();
        this.getTransforms().add(af);
    }
}
