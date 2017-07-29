package de.dfki.common.agent;


import de.dfki.common.enums.Gender;
import de.dfki.common.part.Part3D;

import java.awt.*;

/**
 * Created by EmpaT on 28.07.2017.
 */
public abstract class Agent3D extends Agent
{
    public boolean isFullScreen = false;
    public double stageHeight;

    public Part3D mHead;

    public Agent3D(String name, Gender.TYPE gender)
    {
        mName = name;
        mType = gender;
    }

    public Agent3D(String name, Gender.TYPE gender, float scale, Dimension size)
    {
        this(name, gender);
        mScale = scale;
        mSize = size;
    }

    public Agent3D(String name, Gender.TYPE gender, float scale, double height)
    {
        this(name, gender);
        mScale = scale;
        stageHeight = height;
    }

}
