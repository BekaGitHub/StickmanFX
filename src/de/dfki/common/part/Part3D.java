package de.dfki.common.part;

/**
 * Created by EmpaT on 27.07.2017.
 */
public abstract class Part3D extends Part
{
    public double mXTranslation = 0;
    public double mYTranslation = 0;
    public double mZTranslation = 0;

    public double mXTranslationStep = 0.0f;
    public double mYTranslationStep = 0.0f;
    public double mZTranslationStep = 0.0f;

    public double mXRotation = mDefaultRotation;
    public double mYRotation = mDefaultRotation;
    public double mZRotation = mDefaultRotation;
    public double mToDegreeX = mDefaultRotation;

    public double mXRotationStep = 0.0f;
    public double mYRotationStep = 0.0f;
    public double mZRotationStep = 0.0f;
}
