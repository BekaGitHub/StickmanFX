package de.dfki.common.agent;

import de.dfki.common.LogFormatter;
import de.dfki.common.enums.Gender;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickmanSwing.animationlogic.listener.AnimationListener;
import javafx.scene.layout.Pane;

import java.awt.Dimension;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

/**
 * Created by EmpaT on 27.07.2017.
 */
public abstract class Agent extends Pane implements IAgent
{
    public Gender.TYPE mType = Gender.TYPE.FEMALE;
    public String mName = "Agent";
    public float mScale = 1.0f;
    public static Dimension mDefaultSize = new Dimension(300, 800);
    public static Dimension mSize = new Dimension(mDefaultSize);
    public Semaphore mAnimationLaunchControl = new Semaphore(1);
    public final List<AnimationListener> mAnimationListeners = new CopyOnWriteArrayList<AnimationListener>();

    public StageRoom stageRoom;
    public long mID = 0;

    public final Logger mLogger = Logger.getAnonymousLogger();

    @Override
    public String getName()
    {
        return this.mName;
    }

    @Override
    public void setName(String name)
    {
        this.mName = name;
    }

    public void init()
    {
        this.setPrefHeight(mSize.height);
        this.setPrefWidth(mSize.width);
        this.setMinHeight(mSize.height);
        this.setMinWidth(mSize.width);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new LogFormatter());

        mLogger.addHandler(ch);
        mLogger.setUseParentHandlers(false);
    }
}
