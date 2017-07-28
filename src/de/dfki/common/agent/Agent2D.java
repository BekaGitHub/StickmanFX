package de.dfki.common.agent;

import de.dfki.common.enums.Gender;
import javafx.scene.control.Label;

import java.awt.*;

/**
 * Created by EmpaT on 28.07.2017.
 */
public abstract class Agent2D extends Agent
{
    public Label agentNameLabel;
    public boolean mShowName = true;
    public boolean faceOnly = false;

    public Agent2D(String name, Gender.TYPE gender)
    {
        mName = name;
        mType = gender;
    }

    public Agent2D(String name, Gender.TYPE gender, float scale)
    {
        this(name, gender);
        mScale = scale;
    }

    public Agent2D(String name, Gender.TYPE gender, float scale, Dimension size)
    {
        this(name, gender, scale);
        mSize = size;
    }

    public Agent2D(String name, Gender.TYPE gender, float scale, boolean faceOnly)
    {
        this(name, gender, scale);
        this.faceOnly = faceOnly;
    }

    public Agent2D(String name, Gender.TYPE gender, float scale, Dimension size, boolean faceOnly)
    {
        this(name, gender, scale, size);
        this.faceOnly = faceOnly;
    }
}
