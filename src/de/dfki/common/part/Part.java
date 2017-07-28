package de.dfki.common.part;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;

import java.awt.Point;
import java.awt.Dimension;

/**
 * Created by EmpaT on 27.07.2017.
 */
public abstract class Part extends Pane
{
    public Dimension mSize = new Dimension(10, 10);
    public Point mStart = new Point(0, 0);
    public Point mEnd = new Point(0, 0);
    public Point mDefaultRotationPoint = new Point(0, 0);
    public int mDefaultRotation = 0;
    public int mLength = 0;
    public int mShapeAnimationStep = 0;
    public Color mColor = Color.rgb(0, 0, 0);
    public Color mColorRecorder;

    public void init()
    {
        this.setPrefHeight(mSize.height);
        this.setPrefWidth(mSize.width);
        calculate(0);
    }

    public abstract void calculate(int step);
    public abstract void resetRotation();
    public abstract void setShape(String s);

    public synchronized void calculateShape(int step)
    {
        mShapeAnimationStep = step;
        Platform.runLater(() -> calculate(step));
    }

    public void resetShape()
    {
        mShapeAnimationStep = 0;
    }
}
