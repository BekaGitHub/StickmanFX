package de.dfki.common.part;

import de.dfki.common.animationlogic.Animator;
import de.dfki.stickman3D.animationlogic.Animator3D;
import javafx.application.Platform;

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

    public void set_X_Translation(int length)
    {
        mXTranslationStep = (double) length / Animator3D.sMAX_ANIM_STEPS;
    }

    public void set_Y_Translation(int length)
    {
        mYTranslationStep = (double) length / Animator.sMAX_ANIM_STEPS;
    }

    public void set_Z_Translation(int length)
    {
        mZTranslationStep = (double) length / Animator.sMAX_ANIM_STEPS;
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
        mXRotationStep = (double) degree / Animator.sMAX_ANIM_STEPS;
    }

    public void set_Y_Rotation(int degree)
    {
        mYRotationStep = (double) degree / Animator.sMAX_ANIM_STEPS;
    }

    public void set_Z_Rotation(int degree)
    {
        mZRotationStep = (double) degree / Animator.sMAX_ANIM_STEPS;
    }

    public void setTilt(int degree)
    {
        mToDegreeX = mXRotation + degree;
        mXRotationStep = (double) degree / Animator.sMAX_ANIM_STEPS;
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
}
