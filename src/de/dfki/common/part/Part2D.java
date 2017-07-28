package de.dfki.common.part;

import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by EmpaT on 27.07.2017.
 */
public abstract class Part2D extends Part
{
    public int mDefaultTranslation = 0;
    public double mTranslation = mDefaultTranslation;
    public double mToTranslation = mDefaultTranslation;
    public double mTranslationStep = 0.0f;
    public double mRotation = mDefaultRotation;
    public double mToDegree = mDefaultRotation;
    public double mRotationStep = 0.0f;
    public float mColoropacity = 1.0f;

    public Color mColorRest = Color.rgb(0, 0, 0);
    public float mColoropacityRest = 1.0f;

    public List<Path> mGraphicPaths = Collections.synchronizedList(new ArrayList());
    public BasicStroke mStroke = new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);



}
